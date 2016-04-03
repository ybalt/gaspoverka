package gaspoverka.poverka;

import gaspoverka.calibration.Calibration;
import gaspoverka.memDB;
import gaspoverka.util.Channel;
import gaspoverka.util.Config;
import gaspoverka.util.Dev;
import gaspoverka.util.Log;
import gaspoverka.util.RoundFactory;
import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class Poverka {

    memDB db = memDB.getInstance();
    public static Log log = Log.getInstance();
    private String db_name = " POV_RESULT ";
    private Connection conn;
    //izmerenie info
    private long PovNum;
    private String DevNum;
    private String Owner;
    private String Exec;
    Date povDate;
    double Tenv, Penv;
    //data info
    ArrayList<PoverkaPoint> data;
    //devices
    Dev Count;
    Dev Ref;
    //Channels
    Channel R;
    Channel RT; //reference
    Channel RP;
    Channel C;
    Channel CT; //counter
    Channel CP;
    Channel T; //environment
    Channel P;
    Calibration PD; //delta
    boolean isDeltaT;
    //stuff
    Config config = Config.getInstance();
    povTM tm;
    int row;
    public JTextField Ttext, Ptext;
    public static Thread thread;
    public static GetEnvTask taskGetEnv;
    //JLabel sb;
    PoverkaFrame frame;
    RoundFactory rf = RoundFactory.getInstance();

    public Poverka() {
        data = new ArrayList<PoverkaPoint>();
        P = new Channel(41);
        T = new Channel(5);

    }


    // <editor-fold defaultstate="collapsed" desc="get&set">
    public boolean getIsDeltaT() {
        return isDeltaT;
    }

    public void setIsDeltaT(boolean isDeltaT) {
        this.isDeltaT = isDeltaT;
    }

    public Channel getC() {
        return C;
    }

    public Channel getCP() {
        return CP;
    }

    public Channel getCT() {
        return CT;
    }

    public Channel getR() {
        return R;
    }

    public Channel getRP() {
        return RP;
    }

    public Channel getRT() {
        return RT;
    }

    public AbstractTableModel getTm() {
        return tm;
    }

    public void setTm(povTM tm) {
        this.tm = tm;
    }

    public ArrayList<PoverkaPoint> getData() {
        return data;
    }

    public String getDevNum() {
        return DevNum;
    }

    public void setDevNum(String DevNum) {
        this.DevNum = DevNum;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }

    public long getPovNum() {
        return PovNum;
    }

    public void setPovNum(long PovNum) {
        this.PovNum = PovNum;
    }

    public String getType() {
        if (Count != null) {
            return Count.getType();
        } else {
            return new String();
        }
    }

    public String getDiam() {
        if (Count != null) {
            return String.valueOf(Count.getUD());
        } else {
            return new String();
        }
    }

    public String getDiap() {
        if (Count != null) {
            String L = String.valueOf(Count.MR.get(0).getVL());
            String H = String.valueOf(Count.MR.get(Count.MR.size() - 1).getVH());
            //String H = String.valueOf(Count.MR.get(0).getVH());
            return "(" + L + " - " + H + ")m3/ч";
        } else {
            return new String();
        }
    }

    public void setType(String type) {
        if (Count == null) {
            this.Count = new Dev();
            Count.setType(type);
        }
    }

    public double getDErr(int num) {
        int KP = ((data.get(num).getMeasureNum()) - 1 / 3) + 1;
        double res = 0;
        int count = 0;
        /*
        for (int i = KP * 3; i < (KP + 1) * 3; i++) {
        if (data.get(i) != null) {
        if (data.get(i).getErr() != 0) {
        res = res + data.get(i).getErr();
        count = count + 1;
        }
        }
        }*/
        if (count != 0) {
            return res / count;
        } else {
            return 0;
        }
    }

    public Dev getCount() {
        return Count;
    }

    public void setCount(Dev Count) {
        this.Count = Count;
        C = new Channel(Count.getChannel());
        CT = new Channel(Count.getChannel() * 10 + 2);
        CP = new Channel(Count.getChannel() * 10 + 1);
    }

    public Dev getRef() {
        return Ref;
    }

    public void setRef(Dev Ref) {
        this.Ref = Ref;
        R = new Channel(Ref.getChannel());
        RT = new Channel(Ref.getChannel() * 10 + 2);
        RP = new Channel(Ref.getChannel() * 10 + 1);
        if (Ref.getChannel() == 1 || Ref.getChannel() == 2) {
            PD = new Calibration(Ref.getChannel() * 10 + 5);
            PD.loadCalibrationData();
        }
    }

    public String getExec() {
        return Exec;
    }

    public void setExec(String Exec) {
        this.Exec = Exec;
    }

    public Date getNow() {
        return povDate;
    }

    public void setNow(Date now) {
        this.povDate = now;
    }

    public Channel getP() {
        return P;
    }

    public void setP(Channel P) {
        this.P = P;
    }

    public Channel getT() {
        return T;
    }

    public void setT(Channel T) {
        this.T = T;
    }

    public double getPenv() {
        return Penv;
    }

    public void setPenv(double Penv) {
        this.Penv = Penv;
    }

    public double getTenv() {
        return Tenv;
    }

    public void setTenv(double Tenv) {
        this.Tenv = Tenv;
    }

    // </editor-fold>
    public void delReport(long num) {
        int result;
        try {
            connect();
            //del at first
            PreparedStatement delData = conn.prepareStatement("DELETE FROM " + db_name
                    + "WHERE POVNUM=?");

            delData.setLong(1, num);
            result = delData.executeUpdate();
            delData.close();
            if (result == 0) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                return;
            }
        } catch (Exception e) {
            try {
                conn.rollback();
                //fin();
                JOptionPane.showMessageDialog(null, "Ошибка записи - база данных возвращена в исходное состояние");
                return;
            } catch (Exception ej) {
                //fin();
                JOptionPane.showMessageDialog(null, "Ошибка записи - состояние базы данных неизвестно. Обартитесь к разработчику");
                return;
            }
        }
        try {
            conn.commit();
            db.write();
            JOptionPane.showMessageDialog(null, "Запись в базу произведена");
        } catch (Exception exc) {
            exc.printStackTrace();
            //fin();
        }
    }

    public void saveResult(boolean isDeltaT) {
        int result;

        try {
            connect();
            //del at first
            PreparedStatement delData = conn.prepareStatement("DELETE FROM " + db_name
                    + "WHERE POVNUM=?");

            delData.setLong(1, this.getPovNum());
            result = delData.executeUpdate();
            delData.close();
            //save
            PreparedStatement saveData = conn.prepareStatement("INSERT INTO " + db_name
                    + "(TYPE, POVNUM, DEVNUM, OWNER, EXECUTOR, DATE, CHANNEL, MNUM, RV, CV, RT, RP, CT, CP, CVP, RVP, ET, EP, ISDELTA) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            povDate = new java.sql.Date(System.currentTimeMillis());

            if (!data.isEmpty()) {
                for (int i = 0; i < data.size(); i++) {


                    saveData.setString(1, this.getType());
                    saveData.setLong(2, this.getPovNum());
                    saveData.setString(3, this.getDevNum());
                    saveData.setString(4, this.getOwner());
                    saveData.setString(5, this.getExec());
                    saveData.setDate(6, povDate);

                    saveData.setInt(7, R.getChannel());
                    saveData.setInt(8, data.get(i).getMeasureNum());
                    saveData.setDouble(9, data.get(i).getRG());
                    saveData.setDouble(10, data.get(i).getCG());
                    saveData.setDouble(11, data.get(i).getRT());
                    saveData.setDouble(12, data.get(i).getRP());
                    saveData.setDouble(13, data.get(i).getCT());
                    saveData.setDouble(14, data.get(i).getCP());
                    saveData.setDouble(15, data.get(i).getCV());
                    saveData.setDouble(16, data.get(i).getRV());
                    saveData.setDouble(17, getTenv());
                    saveData.setDouble(18, getPenv());
                    if (isDeltaT == true) {
                        saveData.setInt(19, 1);
                    } else {
                        saveData.setInt(19, 0);
                    }

                    result = saveData.executeUpdate();
                    if (result == 0) {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                        return;
                    }
                }
                saveData.close();
            }
        } catch (Exception ex) {
            try {
                conn.rollback();
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка записи - база данных возвращена в исходное состояние");
                return;
            } catch (Exception ej) {
                ej.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка записи - состояние базы данных неизвестно. Обартитесь к разработчику");
                return;
            }
        }
        try {
            conn.commit();
            db.write();
            JOptionPane.showMessageDialog(null, "Запись в базу произведена");
        } catch (Exception exc) {
            exc.printStackTrace();
            //fin();
        }
    }

    public List<Poverka> getList() {
        List<Poverka> list = new ArrayList<Poverka>();
        ResultSet result;
        try {
            connect();
            final String sql = "SELECT DISTINCT "
                    + "POVNUM, TYPE, DEVNUM, OWNER, EXECUTOR, DATE "
                    + "FROM " + db_name
                    + "ORDER BY POVNUM";
            Statement load = conn.createStatement();
            result = load.executeQuery(sql);
            while (result.next()) {
                Poverka pov = new Poverka();
                pov.setPovNum(result.getLong(1));
                pov.setType(result.getString(2));
                pov.setDevNum(result.getString(3));
                pov.setOwner(result.getString(4));
                pov.setExec(result.getString(5));
                pov.setNow(result.getDate(6));
                list.add(pov);
            }
            //fin();
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }

        return list;
    }

    public void loadResult(long PovNum) {
        ResultSet result;
        try {
            connect();
            PreparedStatement loadInfo = conn.prepareStatement("SELECT DISTINCT "
                    + "POVNUM, TYPE, DEVNUM, OWNER, EXECUTOR, DATE, ET, EP, ISDELTA "
                    + "FROM " + db_name
                    + "WHERE POVNUM=?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadInfo.setLong(1, PovNum);
            result = loadInfo.executeQuery();
            if (result.next()) {
                this.setPovNum(result.getLong(1));
                this.setType(result.getString(2));
                this.setDevNum(result.getString(3));
                this.setOwner(result.getString(4));
                this.setExec(result.getString(5));
                this.setNow(result.getDate(6));
                this.Count.loadDevByType(Count.getType());
                this.setTenv(result.getDouble(7));
                this.setPenv(result.getDouble(8));
                if (result.getInt(9)==0) {setIsDeltaT(false);}
                else {setIsDeltaT(true);}
            }
            loadInfo.close();

            PreparedStatement loadData = conn.prepareStatement("SELECT "
                    + "RV, CV, RP, CP, RT, CT, CVP, RVP, MNUM "
                    + "FROM " + db_name
                    + "WHERE POVNUM=? "
                    + "ORDER BY MNUM",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadData.setLong(1, PovNum);
            result = loadData.executeQuery();
            data.clear();
            while (result.next()) {
                PoverkaPoint pov = new PoverkaPoint();
                pov.setRG(result.getDouble(1));
                pov.setCG(result.getDouble(2));
                pov.setRP(result.getDouble(3));
                pov.setCP(result.getDouble(4));
                pov.setRT(result.getDouble(5));
                pov.setCT(result.getDouble(6));
                pov.setCV(result.getDouble(7));
                pov.setRV(result.getDouble(8));
                pov.setMeasureNum(result.getInt(9));
                data.add(pov);
            }
            loadData.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getLastPovNum() {
        ResultSet result;
        try {
            connect();
            final String sql = "SELECT MAX(POVNUM) "
                    + "FROM " + db_name;
            Statement load = conn.createStatement();
            result = load.executeQuery(sql);
            while (result.next()) {
                return result.getLong(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void startPov(int time, double value, int rtime, int row, PoverkaFrame frame) {
        log.out("poverka start");
        log.out("RefType=" + Ref.getType() + " CountType=" + Count.getType() + " time=" + time);
        this.row = row;
        this.frame = frame;
        thread = new Thread(new PoverkaTask(this, time, value, rtime));
        thread.start();
    }

    public void startIzm(final PoverkaFrame frame) {
        this.frame = frame;
        int refresh = Integer.parseInt(frame.Tmedian.getText());
        thread = new Thread(new IzmerenieTask(this, refresh));
        thread.start();
    }

    public void setDataIzm(double time) {
        double RNoN, RTi = 0, RPi = 0, RV, Rg, Rgy, RVpr, RVy;

        RNoN = (R.getResult(false, 1) - R.getResult(false, 0));

        RPi = (RP.getResult(true, 0) + RP.getResult(true, 1)) / 2;
        RTi = (RT.getResult(true, 0) + RT.getResult(true, 1)) / 2;
        //сырой объем
        RV = RNoN / Ref.getIC();
        //сырой расход
        Rg = (RV / (time / 1000)) * 3600;
        //уточненный объем
        RVy = RNoN / R.getAO(Rg);
        if (RP.getChannel() == 1 || RP.getChannel() == 2) {
            RPi = RPi - R.getResult(RVy, true) / 2;
        }
        //уточненный расход
        Rgy = ((RVy * 3600) / (double) time) * 1000;


        frame.G.setText(String.valueOf(rf.Rounded(Rgy)));
        frame.T.setText(String.valueOf(rf.Rounded(RTi)));
        frame.P.setText(String.valueOf(rf.Rounded(RPi)));
        frame.V.setText(String.valueOf(rf.Rounded(RVy)));
        frame.N.setText(String.valueOf(RNoN));
        frame.A.setText(String.valueOf(rf.Rounded(R.getAO(Rg))));
        frame.time.setText(String.valueOf(time));
    }

    public void setDataPovR(int counter, double time, int mes) {
        double RNoN, RTi = 0, RPi = 0, RV, Rg, Rgy, Pi, RVy;

        RNoN = (R.getResult(false, counter) - R.getResult(false, 0));

        //сырой объем
        RV = RNoN / Ref.getIC();
        //сырой расход
        Rg = ((RV * 3600) / (double) time) * 1000;
        //уточненный объем
        RVy = RNoN / R.getAO(Rg);
        //уточненный расход
        Rgy = ((RVy * 3600) / (double) time) * 1000;


        for (int i = 0; i < counter; i++) {
            if (R.getChannel() == 1 || R.getChannel() == 2) {
                Pi = RP.getResult(true, i) - PD.getCalibrated(Rgy);
                RPi = RPi + Pi;
            } else {
                RPi = RPi + RP.getResult(true, i);
            }
            RTi = RTi + RT.getResult(true, i);
        }
        RPi = RPi / counter;
        RTi = RTi / counter;
        log.out("Refrence data: imp.count=" + RNoN + " V=" + RV + " G=" + Rg + " Vy=" + RVy + " Gy=" + Rgy + " P=" + RPi + " PD=" + PD.getCalibrated(Rgy) + " T=" + RTi);
        tm.setValueAt(Rgy, row + mes, 2);
        tm.setValueAt(RPi, row + mes, 3);
        tm.setValueAt(RTi, row + mes, 4);
        tm.setValueAt(RVy, row + mes, 5);
    }

    public void setDataPovC(int counter, double time, int mes) {
        double CNoN, CTi = 0, CPi = 0, CV, Cg;

        CNoN = (C.getResult(false, counter) - C.getResult(false, 0));

        for (int i = 0; i < counter; i++) {
            CPi = CPi + CP.getResult(true, i);
            CTi = CTi + CT.getResult(true, i);
        }
        CPi = CPi / counter;
        CTi = CTi / counter;

        CV = CNoN / Count.getIC();
        Cg = ((CV * 3600) / (double) time) * 1000;
        //log.out("Refrence data: imp.count=" + CNoN + " V=" + CV + " G=" + Cg + " P=" + CPi + " T=" + CTi);
        if ((C.getResult(false, counter) - C.getResult(false, counter - 1)) >= 1) {
            tm.setValueAt(Cg, row + mes, 6);
            tm.setValueAt(CV, row + mes, 9);
        }
        tm.setValueAt(CPi, row + mes, 7);
        tm.setValueAt(CTi, row + mes, 8);

    }

    public void stop() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
    }

    public void getEnv(final JTextField Ptext, int Pch) {
        P = new Channel(Pch);
        this.Ptext = Ptext;
        taskGetEnv = new GetEnvTask(this, Ptext);
        taskGetEnv.get();
    }

    public void setEnv(final JTextField Ttext, int Tch) {
        T = new Channel(Tch);
        this.Ttext = Ttext;
    }

    private void connect() {
        conn = db.connMem();
    }
}
