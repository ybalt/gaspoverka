package gaspoverka.calibration;

import com.icpdas.comm.Comm;
import com.icpdas.comm.IoBuf;
import javax.swing.JLabel;

public class CalibrationTask extends Thread {

    IoBuf buf;
    Comm comm;
    //private Channel channel;
    private Attestation att;
    public int count;
    private int delay, time;
    static final int PORT = 1;
    JLabel sb;

    public CalibrationTask(int delay, int time, Attestation att, final JLabel sb) {
        this.time = time;
        this.delay = delay;
        buf = new IoBuf();
        comm = new Comm();
        this.att = att;
        this.sb = sb;
    }

    @Override
    public synchronized void run() {
        int rev = -1;
        double value = 0;
        rev = comm.open(PORT, 115200, comm.DATABITS_8, comm.PARITY_NONE, comm.STOPBITS_1);
        for (int i = 0; i < att.getTm().getRowCount(); i++) {
            int ost = time;
            value = 0;
            sb.setText("Измерение начато");
            while (ost > 0) {
                try {
                    ost = ost - delay;
                    double val = getData();
                    value = value + val;
                    Thread.sleep(delay);
                } catch (Exception e) {
                    sb.setText("Измерение прервано");
                    super.interrupt();
                    comm.close(1);
                    return;
                }
            }
            value = value / (time / delay);
            att.getCh().setRawResults(value, i);
            att.setResult(i);

        }
        sb.setText("Измерение закончено");
        comm.close(1);
    }

    private double getData() {
        int rev = 0;
        double result;
        // Analog

        buf.dwBuf[0] = PORT;           //port
        buf.dwBuf[1] = att.getCh().getAdress()[0];      //Address
        buf.dwBuf[2] = 0x7017;
        buf.dwBuf[3] = 1;      //check sums
        buf.dwBuf[4] = 100;     //Timeout
        buf.dwBuf[5] = att.getCh().getAdress()[1];
        buf.dwBuf[6] = 0;      //Enable String Debug
        buf.szSend = "#0" + att.getCh().getAdress()[0] + att.getCh().getAdress()[1];
        rev = comm.getSendReceiveCmd(buf);

        if (rev != 0) {
            this.interrupt();
            return 0;
        }
        try {
            if (att.getCh().getChannel() >= 5) {
                result = Double.parseDouble(buf.szReceive.substring(1, 7));
            } else {
                result = (double) Long.parseLong(buf.szReceive.substring(1, 9), 16);
            }
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }
}
