package gaspoverka.poverka;

import com.icpdas.comm.Comm;
import com.icpdas.comm.IoBuf;
import java.awt.Color;
import java.util.Calendar;

public class IzmerenieTask extends Thread {

    static final int RATE = 100;
    static final int PORT = 1;
    private Poverka poverka;
    IoBuf buf;
    Comm comm;
    int time;

    public IzmerenieTask(Poverka pov, int time) {
        this.poverka = pov;
        this.time = time * 1000;
        comm = new Comm();
        buf = new IoBuf();
    }

    @Override
    public void run() {
        Calendar cal;
        long newsec, oldsec;
        int rev = -1;
        rev = comm.open(PORT, 115200, Comm.DATABITS_8, Comm.PARITY_NONE, Comm.STOPBITS_1);
        if (rev != 0) {
            poverka.frame.SB.setText("Ошибка открытия порта");
            super.interrupt();
            return;
        }
        try {
            poverka.frame.SB.setText("Измерение начато");
            while (true) {
                getEnv();
                setCounters(0);//stop
                clearCounters();//clear
                setCounters(1);//start
                cal = Calendar.getInstance();
                oldsec = cal.getTimeInMillis();

                getData(0);
                Thread.sleep(time);
                getData(1);

                cal = Calendar.getInstance();
                newsec = cal.getTimeInMillis();
                poverka.setDataIzm(newsec - oldsec);
            }
        } catch (Exception e) {
            super.interrupt();
            poverka.frame.SB.setText("Измерение прервано");
            comm.close(PORT);
            return;
        } finally {
            comm.close(PORT);
        }


    }

    private void getData(int counter) {
        int rev;
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
        }
    }

    private void setCounters(int value) {
        int rev;
        //Digital $AA5NS (address 5 counter (start|stop))
        try {
            buf.dwBuf[0] = 1;           //port
            buf.dwBuf[1] = 0x3;
            buf.dwBuf[2] = 0x7080;
            buf.dwBuf[3] = 1;      //check sums
            buf.dwBuf[4] = 100;     //Timeout
            buf.dwBuf[5] = 0;
            buf.dwBuf[6] = 0;      //Enable String Debug
            buf.szSend = "$0250" + String.valueOf(value);
            rev = comm.getSendReceiveCmd(buf);
            buf.szSend = "$0251" + String.valueOf(value);
            rev = comm.getSendReceiveCmd(buf);
            buf.szSend = "$0350" + String.valueOf(value);
            rev = comm.getSendReceiveCmd(buf);
            buf.szSend = "$0351" + String.valueOf(value);
            rev = comm.getSendReceiveCmd(buf);
        } catch (Exception e) {
            poverka.frame.SB.setText("Ошибка получения данных");
        }
    }

    private void clearCounters() {
        int rev;
        //Digital $AA6N (address 6 counter)
        try {
        buf.dwBuf[0] = 1;           //port
        buf.dwBuf[1] = 0x3;
        buf.dwBuf[2] = 0x7080;
        buf.dwBuf[3] = 1;      //check sums
        buf.dwBuf[4] = 100;     //Timeout
        buf.dwBuf[5] = 0;
        buf.dwBuf[6] = 0;      //Enable String Debug
        buf.szSend = "$0260";
        rev = comm.getSendReceiveCmd(buf);
        buf.szSend = "$0261";
        rev = comm.getSendReceiveCmd(buf);
        buf.szSend = "$0360";
        rev = comm.getSendReceiveCmd(buf);
        buf.szSend = "$0361";
        rev = comm.getSendReceiveCmd(buf);} catch (Exception e) {
            poverka.frame.SB.setText("Ошибка получения данных");
        }
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
            if (poverka.T.getResult(true)>22 && poverka.T.getResult(true)<18) {
                poverka.Ttext.setBackground(Color.red);
            } else  poverka.Ttext.setBackground(Color.WHITE);
            if (Math.abs(poverka.T.getResult(true)-poverka.RT.getResult(true))>1) {
                poverka.Ttext.setBackground(Color.red);
            } else  poverka.Ttext.setBackground(Color.WHITE);
        } catch (Exception e) {
            poverka.frame.SB.setText("Ошибка получения данных");
        }
    }
}
