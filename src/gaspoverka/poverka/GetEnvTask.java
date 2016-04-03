package gaspoverka.poverka;

import com.icpdas.comm.Comm;
import com.icpdas.comm.IoBuf;
import javax.swing.JTextField;

public class GetEnvTask{

    IoBuf buf;
    Comm comm;
    Poverka pov;
    JTextField Ptext;


    public GetEnvTask(Poverka pov, final JTextField Ptext) {
        comm = new Comm();
        buf = new IoBuf();
        this.pov = pov;
        this.Ptext = Ptext;
    }

    
    public void get() {
        try {
            int rev = -1;
            rev = comm.open(1, 115200, Comm.DATABITS_8, Comm.PARITY_NONE, Comm.STOPBITS_1);
            if (rev == 0) {
                buf.dwBuf[0] = 1;           //port
                buf.dwBuf[1] = 1;
                buf.dwBuf[2] = 0x7017;
                buf.dwBuf[3] = 1;      //check sums
                buf.dwBuf[4] = 100;     //Timeout
                buf.dwBuf[5] = 0;
                buf.dwBuf[6] = 0;      //Enable String Debug

                buf.szSend = "#01" + String.valueOf(pov.P.getAdress()[1]);
                rev = comm.getSendReceiveCmd(buf);
                pov.P.setRawResults(Double.parseDouble(buf.szReceive.substring(1, 7)), 0);

                Ptext.setText(String.valueOf(pov.P.getResult(true)));
                comm.close(1);
            }
        } catch (Exception e) {
            comm.close(1);
           
        }
    }
}
