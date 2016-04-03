package gaspoverka.poverka;

import com.icpdas.comm.Comm;
import com.icpdas.comm.IoBuf;
import gaspoverka.util.Log;
import java.awt.Color;
import java.util.Calendar;
import java.util.logging.Logger;

public class PoverkaTask extends Thread {

    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static final int RATE = 100;
    static final int PORT = 1;
    private Poverka poverka;
    IoBuf buf;
    Comm comm;
    int time;
    int vtime;
    int rtime;
    double value;
    int measures;

    public PoverkaTask(Poverka pov, int time, double value, int rtime) {
        this.poverka = pov;
        this.time = time * 1000;
        this.rtime = rtime * 1000;
        this.value = value;
        this.measures = Integer.parseInt(poverka.frame.Measures.getText());
        comm = new Comm();
        buf = new IoBuf();
    }

    @Override
    public void run() {
        long newsec, oldsec, cursec;
        double old;
        comm.open(PORT, 115200, Comm.DATABITS_8, Comm.PARITY_NONE, Comm.STOPBITS_1);
        int counter = 0;
        try {
            if (time != 0 && measures != 0) {
                getEnv();
                for (int i = 0; i < measures; i++) {

                    counter = 0;
                    setC(0);//stop ref
                    setR(0);//stop counter
                    clearC();//clear counter
                    setC(1); //start counter
                    getDDataC(counter);
                    old = poverka.getC().getResult(false);
                    poverka.frame.SB.setText("Ожидание начального импульса");
                    while (old == poverka.getC().getResult(false, 0)) { //wait for first imp
                        Thread.sleep(RATE);
                        getDDataC(counter);
                    }
                    poverka.frame.SB.setText("Импульс получен - начинаем поверку по времени");
                    poverka.frame.startButton.setEnabled(false);
                    poverka.frame.stopButton.setEnabled(true);
                    clearR(); //ref clear
                    setR(1); //start R
                    getDDataR(counter);
                    getADataR(counter);
                    getADataC(counter);
                    getEnv();
                    counter++;
                    oldsec = getCurTime();
                    cursec = getCurTime();
                    while (time - (cursec - oldsec) > 0) {
                        getADataR(counter);
                        getADataC(counter);
                        getDDataR(counter);
                        getDDataC(counter);
                        cursec = getCurTime();
                        getEnv();
                        poverka.frame.SB.setText("Время до завершения: " + ((time / 1000) - ((cursec - oldsec) / 1000)) + " сек");
                        poverka.setDataPovR(counter, (cursec - oldsec), i);
                        poverka.setDataPovC(counter, (cursec - oldsec), i);
                        counter++;
                        Thread.sleep(rtime);
                    }
                    old = poverka.getC().getResult(false, counter - 1);
                    getDDataC(counter);
                    poverka.frame.SB.setText("Время истекло - ожидание финишного импульса");
                    while (old == poverka.getC().getResult(false, counter)) { //wait for last imp
                        Thread.sleep(RATE);
                        getDDataC(counter);
                    }
                    getDDataR(counter);
                    getEnv();
                    newsec = getCurTime();
                    poverka.setDataPovR(counter, (newsec - oldsec), i);
                    poverka.setDataPovC(counter, (newsec - oldsec), i);
                    poverka.frame.SB.setText("Поверка закончена, общее время исполнения: " + ((newsec - oldsec)) + " мсек, импульсов " + (poverka.R.getResult(false, counter) - poverka.R.getResult(false, 0)));
                    poverka.tm.fireTableChanged(null);
                    LOG.info("poverka end with time " + ((newsec - oldsec)));
                }
            }

        } catch (Exception e) {
            super.interrupt();
            LOG.info(e.getLocalizedMessage());
            poverka.frame.SB.setText("Поверка прервана");
            return;
        } finally {
            poverka.frame.startButton.setEnabled(true);
            poverka.frame.stopButton.setEnabled(false);
            comm.close(PORT);
        }

    }

    private void getADataC(int counter) {
        int rev;
        String str;
        try {
            //Analog
            buf.dwBuf[0] = PORT;           //port
            buf.dwBuf[1] = 1;
            buf.dwBuf[2] = 0x7017;
            buf.dwBuf[3] = 1;      //check sums
            buf.dwBuf[4] = 100;     //Timeout
            buf.dwBuf[5] = 0;
            buf.dwBuf[6] = 0;      //Enable String Debug

            buf.szSend = "#0" + poverka.getCP().getAdress()[0] + poverka.getCP().getAdress()[1];
            rev = comm.getSendReceiveCmd(buf);
            poverka.getCP().setRawResults(Double.parseDouble(buf.szReceive.substring(1, 7)), counter);

            buf.szSend = "#0" + poverka.getCT().getAdress()[0] + poverka.getCT().getAdress()[1];
            rev = comm.getSendReceiveCmd(buf);
            poverka.getCT().setRawResults(Double.parseDouble(buf.szReceive.substring(1, 7)), counter);

        } catch (Exception e) {
            poverka.frame.SB.setText("Ошибка получения данных");
            LOG.info(e.getLocalizedMessage());
        }
    }

    private void getDDataC(int counter) {
        int rev;
        String str;
        try {
            //Digital
            buf.dwBuf[0] = PORT;           //port
            buf.dwBuf[1] = 3;
            buf.dwBuf[2] = 0x7080;
            buf.dwBuf[3] = 1;      //check sums
            buf.dwBuf[4] = 100;     //Timeout
            buf.dwBuf[5] = 0;
            buf.dwBuf[6] = 0;      //Enable String Debug

            buf.szSend = "#0" + poverka.getC().getAdress()[0] + poverka.getC().getAdress()[1];
            rev = comm.getSendReceiveCmd(buf);
            poverka.getC().setRawResults(Long.parseLong(buf.szReceive.substring(1, 9), 16), counter);
        } catch (Exception e) {
            poverka.frame.SB.setText("Ошибка получения данных");
            LOG.info(e.getLocalizedMessage());
        }
    }

    private void getADataR(int counter) {
        int rev;
        try {
            //Analog
            buf.dwBuf[0] = PORT;           //port
            buf.dwBuf[1] = 1;
            buf.dwBuf[2] = 0x7017;
            buf.dwBuf[3] = 1;      //check sums
            buf.dwBuf[4] = 100;     //Timeout
            buf.dwBuf[5] = 0;
            buf.dwBuf[6] = 0;      //Enable String Debug

            buf.szSend = "#0" + poverka.getRP().getAdress()[0] + poverka.getRP().getAdress()[1];
            rev = comm.getSendReceiveCmd(buf);
            poverka.getRP().setRawResults(Double.parseDouble(buf.szReceive.substring(1, 7)), counter);

            buf.szSend = "#0" + poverka.getRT().getAdress()[0] + poverka.getRT().getAdress()[1];
            rev = comm.getSendReceiveCmd(buf);
            poverka.getRT().setRawResults(Double.parseDouble(buf.szReceive.substring(1, 7)), counter);

        } catch (Exception e) {
            poverka.frame.SB.setText("Ошибка получения данных");
            LOG.info(e.getLocalizedMessage());
        }
    }

    private void getDDataR(int counter) {
        int rev;
        String str;
        try {
            //Digital
            buf.dwBuf[0] = PORT;           //port
            buf.dwBuf[1] = 3;
            buf.dwBuf[2] = 0x7080;
            buf.dwBuf[3] = 1;      //check sums
            buf.dwBuf[4] = 100;     //Timeout
            buf.dwBuf[5] = 0;
            buf.dwBuf[6] = 0;      //Enable String Debug

            buf.szSend = "#0" + poverka.getR().getAdress()[0] + poverka.getR().getAdress()[1];
            rev = comm.getSendReceiveCmd(buf);
            poverka.getR().setRawResults(Long.parseLong(buf.szReceive.substring(1, 9), 16), counter);
        } catch (Exception e) {
            poverka.frame.SB.setText("Ошибка получения данных");
            LOG.info(e.getLocalizedMessage());
        }
    }

    private void setC(int value) {
        int rev;
        //Digital $AA5NS (address 5 counter (start|stop))
        buf.dwBuf[0] = 1;           //port
        buf.dwBuf[1] = 0x3;
        buf.dwBuf[2] = 0x7080;
        buf.dwBuf[3] = 1;      //check sums
        buf.dwBuf[4] = 100;     //Timeout
        buf.dwBuf[5] = 0;
        buf.dwBuf[6] = 0;      //Enable String Debug
        buf.szSend = "$0" + poverka.getC().getAdress()[0] + "5" + poverka.getC().getAdress()[1] + String.valueOf(value);
        rev = comm.getSendReceiveCmd(buf);
    }

    private void setR(int value) {
        int rev;
        //Digital $AA5NS (address 5 counter (start|stop))
        buf.dwBuf[0] = 1;           //port
        buf.dwBuf[1] = 0x3;
        buf.dwBuf[2] = 0x7080;
        buf.dwBuf[3] = 1;      //check sums
        buf.dwBuf[4] = 100;     //Timeout
        buf.dwBuf[5] = 0;
        buf.dwBuf[6] = 0;      //Enable String Debug
        buf.szSend = "$0" + poverka.getR().getAdress()[0] + "5" + poverka.getR().getAdress()[1] + String.valueOf(value);
        rev = comm.getSendReceiveCmd(buf);
    }

    private void clearC() {
        int rev;
        //Digital $AA6N (address 6 counter)
        buf.dwBuf[0] = 1;           //port
        buf.dwBuf[1] = 0x3;
        buf.dwBuf[2] = 0x7080;
        buf.dwBuf[3] = 1;      //check sums
        buf.dwBuf[4] = 100;     //Timeout
        buf.dwBuf[5] = 0;
        buf.dwBuf[6] = 0;      //Enable String Debug
        buf.szSend = "$0" + poverka.getC().getAdress()[0] + "6" + poverka.getC().getAdress()[1];
        rev = comm.getSendReceiveCmd(buf);
    }

    private void clearR() {
        int rev;
        //Digital $AA6N (address 6 counter)
        buf.dwBuf[0] = 1;           //port
        buf.dwBuf[1] = 0x3;
        buf.dwBuf[2] = 0x7080;
        buf.dwBuf[3] = 1;      //check sums
        buf.dwBuf[4] = 100;     //Timeout
        buf.dwBuf[5] = 0;
        buf.dwBuf[6] = 0;      //Enable String Debug
        buf.szSend = "$0" + poverka.getR().getAdress()[0] + "6" + poverka.getR().getAdress()[1];
        rev = comm.getSendReceiveCmd(buf);

    }

    private void getEnv() {
        int rev;
        try {
            buf.dwBuf[0] = 1;           //port
            buf.dwBuf[1] = 1;
            buf.dwBuf[2] = 0x7017;
            buf.dwBuf[3] = 1;      //check sums
            buf.dwBuf[4] = 100;     //Timeout
            buf.dwBuf[5] = 0;
            buf.dwBuf[6] = 0;      //Enable String Debug

            buf.szSend = "#01" + String.valueOf(poverka.T.getAdress()[1]);
            rev = comm.getSendReceiveCmd(buf);
            poverka.T.setRawResults(Double.parseDouble(buf.szReceive.substring(1, 7)), 0);

            //buf.szSend = "#01" + String.valueOf(poverka.P.getAdress()[1]);
            //rev = comm.getSendReceiveCmd(buf);
            //poverka.P.setRawResults(Double.parseDouble(buf.szReceive.substring(1, 7)), 0);
            poverka.Ttext.setText(String.valueOf(poverka.T.getResult(true)));
            //poverka.Ptext.setText(String.valueOf(poverka.P.getResult(true)));
            if (poverka.T.getResult(true) > 22 && poverka.T.getResult(true) < 18) {
                poverka.Ttext.setBackground(Color.red);
            } else {
                poverka.Ttext.setBackground(Color.WHITE);
            }
            if (Math.abs(poverka.T.getResult(true) - poverka.RT.getResult(true)) > 1) {
                poverka.Ttext.setBackground(Color.red);
            } else {
                poverka.Ttext.setBackground(Color.WHITE);
            }
        } catch (Exception e) {
            poverka.frame.SB.setText("Ошибка получения данных");
            LOG.info(e.getLocalizedMessage());
        }
    }

    private long getCurTime() {
        Calendar cal;
        cal = Calendar.getInstance();
        return cal.getTimeInMillis();
    }
}
