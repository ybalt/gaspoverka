package gaspoverka.data.arch;

import gaspoverka.data.config.Point;
import org.hsqldb.jdbc.jdbcDataSource;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Dev {

    static private String db_arch = ".//db//arch";
    private Connection conn;

    private String Type;
    private int Channel;
    private int UD;
    private int PL;
    private int IC;
    private int MIC;

    public Vector<DevT> MR;
    public Vector<DevT> KP;
    
    Vector<Point> calibration_dataV;
    Vector<Point> calibration_dataP;
    Vector<Point> calibration_dataT;

    private double valueV;
    private double valueP;
    private double valueT;

    private boolean useCalV;
    private boolean useCalP;
    private boolean useCalT;

    public Dev() {
        initDev();
    }

    public Dev(String Type) {
        initDev();
        this.loadDevByType(Type);
    }

    private void initDev() {
        this.Type = null;
        this.Channel = 0;
        this.UD = 0;
        this.PL = 0;
        this.IC = 0;
        this.MIC = 0;
        MR = new Vector<DevT>();
        KP = new Vector<DevT>();
        calibration_dataV = new Vector<Point>();
        calibration_dataP = new Vector<Point>();
        calibration_dataT = new Vector<Point>();
    }

    // <editor-fold defaultstate="collapsed" desc="get&set">
    public String getType() {
        return Type;
    }

    public int getChannelV() {
        return Channel;
    }

    public int getChannelP() {
        return Channel*10+1;
    }

    public int getChannelT() {
        return Channel*10+2;
    }

    public int getIC() {
        return IC;
    }

    public int getMIC() {
        return MIC;
    }

    public int getPL() {
        return PL;
    }

    public int getUD() {
        return UD;
    }

    public void setChannel(int Channel) {
        this.Channel = Channel;
    }

    public void setIC(int IC) {
        this.IC = IC;
    }

    public void setMIC(int MIC) {
        this.MIC = MIC;
    }

    public void setPL(int PL) {
        this.PL = PL;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setUD(int UD) {
        this.UD = UD;
    }

    public DevT getKP(int Number) {
        return KP.get(Number);
    }

    public DevT getMR(int Number) {
        return MR.get(Number);
    }

    public Vector<DevT> getKP() {
        return KP;
    }

    public Vector<DevT> getMR() {
        return MR;
    }

    public Vector<Point> getCalibration_dataV() {
        return calibration_dataV;
    }

    public Vector<Point> getCalibration_dataP() {
        return calibration_dataP;
    }

    public Vector<Point> getCalibration_dataT() {
        return calibration_dataT;
    }

    public void setCalibration_dataP(Vector<Point> calibration_dataP) {
        this.calibration_dataP = calibration_dataP;
    }

    public void setCalibration_dataT(Vector<Point> calibration_dataT) {
        this.calibration_dataT = calibration_dataT;
    }

    public void setCalibration_dataV(Vector<Point> calibration_dataV) {
        this.calibration_dataV = calibration_dataV;
    }

    public double getValueV() {
        if (useCalV) {
            return calV(valueV); }
        else {
            return valueV;}
    }

    public double getValueP() {
        return valueP;
    }

    public double getValueT() {
        return valueT;
    }

    public void setValueP(double valueP) {
        this.valueP = valueP;
    }

    public void setValueT(double valueT) {
        this.valueT = valueT;
    }

    public void setValueV(double valueV) {
        this.valueV = valueV;
    }

    public void setUseCalP(boolean useCalP) {
        this.useCalP = useCalP;
    }

    public void setUseCalT(boolean useCalT) {
        this.useCalT = useCalT;
    }

    public void setUseCalV(boolean useCalV) {
        this.useCalV = useCalV;
    }

    // </editor-fold>

    public Vector<Dev> getDevTable() {
        Vector<Dev> vector = new Vector();
        ResultSet res = null;
        Statement stat;

        try {
            connect(db_arch);
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT "
                    + "TYPE, CHANNEL, UD, PL, IC, MIC "
                    + "FROM DEV ORDER BY TYPE ASC";
            res = stat.executeQuery(query);
            fin();
            res.beforeFirst();
            while (res.next()) {
                Dev dev = new Dev();
                dev.setType(res.getString(1));
                dev.setChannel(res.getInt(2));
                dev.setUD(res.getInt(3));
                dev.setPL(res.getInt(4));
                dev.setIC(res.getInt(5));
                dev.setMIC(res.getInt(6));
                vector.add(dev);
            }
            if (vector.size() == 0) {
                vector.add(new Dev());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }

    public String[] getDevList() {
        Statement stat;
        ResultSet res = null;
        Vector vector = new Vector();


        try {
            connect(db_arch);
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT "
                    + "TYPE "
                    + "FROM DEV ORDER BY TYPE ASC";
            res = stat.executeQuery(query);
            fin();
            res.beforeFirst();
            while (res.next()) {
                vector.add(res.getString(1));
            }
            if (vector.size() == 0) {
                vector.add(new String(""));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] str = new String[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            str[i] = String.valueOf(vector.get(i));
        }
        return str;
    }

    public String[] getRefList() {
        ResultSet res = null;
        Vector vector = new Vector();

        try {
            connect(db_arch);
            PreparedStatement loadDev = conn.prepareStatement("SELECT "
                    + "TYPE "
                    + "FROM DEV WHERE CHANNEL "
                    + "BETWEEN 1 AND 3",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            res = loadDev.executeQuery();
            fin();
            res.beforeFirst();

            while (res.next()) {
                vector.add(res.getString(1));
            }
            if (vector.size() == 0) {
                vector.add(new Object());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] str = new String[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            str[i] = String.valueOf(vector.get(i));
        }
        return str;
    }

    public String[] getDevListByChannel(int Channel) {
        ResultSet res = null;
        Vector vector = new Vector();

        try {
            connect(db_arch);
            PreparedStatement loadDev = conn.prepareStatement("SELECT "
                    + "TYPE "
                    + "FROM DEV WHERE CHANNEL = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadDev.setInt(1, Channel);
            res = loadDev.executeQuery();
            fin();
            res.beforeFirst();

            while (res.next()) {
                vector.add(res.getString(1));
            }
            if (vector.size() == 0) {
                vector.add(new Object());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] str = new String[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            str[i] = String.valueOf(vector.get(i));
        }
        return str;
    }

    public void loadDevByType(String type) {
        try {
            connect(db_arch);
            PreparedStatement loadDevByType = conn.prepareStatement("SELECT "
                    + "TYPE, CHANNEL, UD, PL, IC, MIC "
                    + "FROM DEV WHERE TYPE = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadDevByType.setString(1, type);
            loadDev(loadDevByType);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadDevByChannel(int channel) {
        try {
            connect(db_arch);
            PreparedStatement loadDevByChannel = conn.prepareStatement("SELECT "
                    + "TYPE, CHANNEL, UD, PL, IC, MIC "
                    + "FROM DEV WHERE CHANNEL = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadDevByChannel.setInt(1, channel);
            loadDev(loadDevByChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDev(PreparedStatement loadDev) {
        //connect(db_arch);

        ResultSet resultDev = null;
        ResultSet resultKP = null;
        ResultSet resultMR = null;

        MR.clear();
        KP.clear();

        try {
            //load device data
            resultDev = loadDev.executeQuery();
            resultDev.beforeFirst();
            if (!resultDev.next()) {
                System.out.printf("dev not found \n");
                return;
            }
            setType(resultDev.getString(1));
            setChannel(resultDev.getInt(2));
            setUD(resultDev.getInt(3));
            setPL(resultDev.getInt(4));
            setIC(resultDev.getInt(5));
            setMIC(resultDev.getInt(6));

            //load device KP
            PreparedStatement loadKP = conn.prepareStatement("SELECT "
                    + "NUMBER, VL, VH, ERROR "
                    + "FROM DEV_KP WHERE TYPE = ? ORDER BY NUMBER ASC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadKP.setString(1, this.getType());
            resultKP = loadKP.executeQuery();
            resultKP.beforeFirst();
            if (resultKP.next()) {
                resultKP.beforeFirst();
                while (resultKP.next()) {
                    DevT KPT = new DevT(resultKP.getInt(1));
                    KPT.setVL(resultKP.getDouble(2));
                    KPT.setVH(resultKP.getDouble(3));
                    KPT.setError(resultKP.getDouble(4));
                    this.KP.add(KPT);
                }
            }

            //load device MR
            PreparedStatement loadMR = conn.prepareStatement("SELECT "
                    + "NUMBER, VL, VH, ERROR "
                    + "FROM DEV_MR WHERE TYPE = ? ORDER BY NUMBER ASC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadMR.setString(1, this.getType());
            resultMR = loadMR.executeQuery();
            resultMR.beforeFirst();
            if (resultMR.next()) {
                resultMR.beforeFirst();
                while (resultMR.next()) {
                    DevT MRT = new DevT(resultMR.getInt(1));
                    MRT.setVL(resultMR.getDouble(2));
                    MRT.setVH(resultMR.getDouble(3));
                    MRT.setError(resultMR.getDouble(4));
                    this.MR.add(MRT);
                }
            }
            fin();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void saveDev() {
        int result;

        try {
            connect(db_arch);

            PreparedStatement delDev = conn.prepareStatement("DELETE FROM DEV "
                    + "WHERE TYPE = ?");

            delDev.setString(1, getType());
            result = delDev.executeUpdate();
            delDev.close();

            PreparedStatement delKP = conn.prepareStatement("DELETE FROM DEV_KP "
                    + "WHERE TYPE = ?");
            delKP.setString(1, getType());
            result = delKP.executeUpdate();
            delKP.close();

            PreparedStatement delMR = conn.prepareStatement("DELETE FROM DEV_MR "
                    + "WHERE TYPE = ?");
            delMR.setString(1, getType());
            result = delMR.executeUpdate();
            delMR.close();

            PreparedStatement saveDev = conn.prepareStatement("INSERT INTO DEV "
                    + "(TYPE, CHANNEL, UD, PL, IC, MIC) "
                    + "VALUES (?,?,?,?,?,?)");
            PreparedStatement saveKP = conn.prepareStatement("INSERT INTO DEV_KP "
                    + "(TYPE, NUMBER, VL, VH, ERROR) "
                    + "VALUES (?,?,?,?,?)");
            PreparedStatement saveMR = conn.prepareStatement("INSERT INTO DEV_MR "
                    + "(TYPE, NUMBER, VL, VH, ERROR) "
                    + "VALUES (?,?,?,?,?)");

            //dev update
            saveDev.setString(1, getType());
            saveDev.setInt(2, getChannelV());
            saveDev.setDouble(3, getUD());
            saveDev.setDouble(4, getPL());
            saveDev.setDouble(5, getIC());
            saveDev.setDouble(6, getMIC());

            result = saveDev.executeUpdate();
            if (result == 0) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                return;
            }
            saveDev.close();
            //KP update
            if (this.getKP().size() != 0) {
                for (int i = 0; i < this.getKP().size(); i++) {
                    saveKP.setString(1, getType());
                    saveKP.setInt(2, getKP(i).getNumber());
                    saveKP.setDouble(3, getKP(i).getVL());
                    saveKP.setDouble(4, getKP(i).getVH());
                    saveKP.setDouble(5, getKP(i).getError());
                    result = saveKP.executeUpdate();
                    if (result == 0) {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                        return;
                    }
                }
                saveKP.close();
            }
            if (this.getMR().size() != 0) {
                for (int i = 0; i
                        < this.getMR().size(); i++) {
                    saveMR.setString(1, getType());
                    saveMR.setInt(2, getMR(i).getNumber());
                    saveMR.setDouble(3, getMR(i).getVL());
                    saveMR.setDouble(4, getMR(i).getVH());
                    saveMR.setDouble(5, getMR(i).getError());
                    result = saveMR.executeUpdate();
                    if (result == 0) {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                        return;
                    }
                }
                saveMR.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
                fin();
                JOptionPane.showMessageDialog(null, "Ошибка записи - база данных возвращена в исходное состояние");
                return;
            } catch (Exception ej) {
                ej.printStackTrace();
                fin();
                JOptionPane.showMessageDialog(null, "Ошибка записи - состояние базы данных неизвестно. Обартитесь к разработчику");
                return;
            }
        }
        try {
            conn.commit();
            fin();
        } catch (Exception e) {
            e.printStackTrace();
            fin();
        }

    }

    public void insertDev() {
        connect(db_arch);
        int result;
        try {
            PreparedStatement insertDev = conn.prepareStatement("INSERT INTO DEV "
                    + "(TYPE, CHANNEL, UD, PL, IC, MIC) "
                    + "VALUES (?,?,?,?,?,?)");
            PreparedStatement insertKP = conn.prepareStatement("INSERT INTO DEV_KP "
                    + "(TYPE, NUMBER, VL, VH, ERROR) "
                    + "VALUES (?,?,?,?,?)");
            PreparedStatement insertMR = conn.prepareStatement("INSERT INTO DEV_MR "
                    + "(TYPE, NUMBER, VL, VH, ERROR) "
                    + "VALUES (?,?,?,?,?)");

            //dev update
            insertDev.setString(1, getType());
            insertDev.setInt(2, getChannelV());
            insertDev.setDouble(3, getUD());
            insertDev.setDouble(4, getPL());
            insertDev.setDouble(5, getIC());
            insertDev.setDouble(6, getMIC());
            insertDev.setString(7, getType());

            result = insertDev.executeUpdate();
            if (result == 0) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                return;
            }
            insertDev.close();
            //KP update
            if (this.getKP().size() != 0) {
                for (int i = 0; i
                        < this.getKP().size(); i++) {
                    insertKP.setString(1, getType());
                    insertKP.setInt(2, getKP(i).getNumber());
                    insertKP.setDouble(3, getKP(i).getVL());
                    insertKP.setDouble(4, getKP(i).getVH());
                    insertKP.setDouble(5, getKP(i).getError());
                    insertKP.setString(6, getType());
                    result = insertKP.executeUpdate();
                    if (result == 0) {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                        return;
                    }
                }
                insertKP.close();
            }
            if (this.getMR().size() != 0) {
                for (int i = 0; i
                        < this.getMR().size(); i++) {
                    insertMR.setString(1, getType());
                    insertMR.setInt(2, getKP(i).getNumber());
                    insertMR.setDouble(3, getKP(i).getVL());
                    insertMR.setDouble(4, getKP(i).getVH());
                    insertMR.setDouble(5, getKP(i).getError());
                    insertMR.setString(6, getType());
                    result = insertMR.executeUpdate();
                    if (result == 0) {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                        return;
                    }
                }
                insertMR.close();
            }
            conn.commit();
            fin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delDev() {
        connect(db_arch);


        int result;


        try {
            PreparedStatement delDev = conn.prepareStatement("DELETE FROM DEV "
                    + "WHERE TYPE = ?");

            delDev.setString(1, getType());
            result = delDev.executeUpdate();
            delDev.close();

            PreparedStatement delKP = conn.prepareStatement("DELETE FROM DEV_KP "
                    + "WHERE TYPE = ?");
            delKP.setString(1, getType());
            result = delKP.executeUpdate();
            delKP.close();

            PreparedStatement delMR = conn.prepareStatement("DELETE FROM DEV_MR "
                    + "WHERE TYPE = ?");
            delMR.setString(1, getType());
            result = delMR.executeUpdate();
            delMR.close();

            //fin();


        } catch (Exception e) {
            e.printStackTrace();


            try {
                conn.rollback();
                fin();
                JOptionPane.showMessageDialog(null, "Ошибка записи - база данных возвращена в исходное состояние");


            } catch (Exception ej) {
                ej.printStackTrace();
                fin();
                JOptionPane.showMessageDialog(null, "Ошибка записи - состояние базы данных неизвестно. Обартитесь к разработчику");


            }
        }
        try {
            conn.commit();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ошибка записи - невозможно записать изменения");
            e.printStackTrace();


        }
        fin();



    }

    public void loadCalibrationData() {
        ResultSet resultCal = null;

        calibration_dataV.clear();
        calibration_dataP.clear();
        calibration_dataT.clear();

        try {
            connect(db_arch);
            //load calibration data
            PreparedStatement loadData = conn.prepareStatement("SELECT "
                    + "POINT, X, Y, YS "
                    + "FROM CAL "
                    + "WHERE CHANNEL=? ORDER BY POINT ASC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            //V
            loadData.setInt(1, this.getChannelV());
            resultCal = loadData.executeQuery();
            resultCal.beforeFirst();
            while (resultCal.next()) {
                Point point = new Point();
                point.setPoint(resultCal.getInt(1));
                point.setX(resultCal.getDouble(2));
                point.setY(resultCal.getDouble(3));
                point.setYS(resultCal.getDouble(4));
                calibration_dataV.add(point);
            }
            //P
            loadData.setInt(1, this.getChannelV() * 10 + 1);
            resultCal = loadData.executeQuery();
            resultCal.beforeFirst();
            while (resultCal.next()) {
                Point point = new Point();
                point.setPoint(resultCal.getInt(1));
                point.setX(resultCal.getDouble(2));
                point.setY(resultCal.getDouble(3));
                point.setYS(resultCal.getDouble(4));
                calibration_dataP.add(point);
            }
            //T
            loadData.setInt(1, this.getChannelV() * 10 + 2);
            resultCal = loadData.executeQuery();
            resultCal.beforeFirst();
            while (resultCal.next()) {
                Point point = new Point();
                point.setPoint(resultCal.getInt(1));
                point.setX(resultCal.getDouble(2));
                point.setY(resultCal.getDouble(3));
                point.setYS(resultCal.getDouble(4));
                calibration_dataT.add(point);
             }
            fin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void calcCalibrationDataRaw(Vector<Point> calibration_data) {
        for (int A = 0; A < calibration_data.size() - 1; A++) {
            int B = A + 1;

            if (calibration_data.get(B).getY() != 0 || calibration_data.get(B).getX() != 0 || calibration_data.get(B).getYS() != 0) {
                try {
                    //y=x*(F1/F4)+(-F2+F3/F4))
                    //y=kx+b
                    double F1 = calibration_data.get(B).getY() - calibration_data.get(A).getY();
                    double F2 = calibration_data.get(A).getX() * calibration_data.get(B).getY();
                    double F3 = calibration_data.get(B).getX() * calibration_data.get(A).getY();
                    double F4 = calibration_data.get(B).getX() - calibration_data.get(A).getX();
                    if (F4 != 0) {
                        calibration_data.get(A).setK1(F1 / F4);
                        calibration_data.get(A).setB1((-F2 + F3) / F4);
                    } //
                    double G1 = calibration_data.get(B).getYS() - calibration_data.get(A).getYS();
                    double G2 = calibration_data.get(A).getY() * calibration_data.get(B).getYS();
                    double G3 = calibration_data.get(B).getY() * calibration_data.get(A).getYS();
                    double G4 = calibration_data.get(B).getY() - calibration_data.get(A).getY();
                    if (G4 != 0) {
                        calibration_data.get(A).setK2(G1 / G4);
                        calibration_data.get(A).setB2((-G2 + G3) / G4);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void calcCalibrationData() {
        calcCalibrationDataRaw(this.getCalibration_dataV());
        calcCalibrationDataRaw(this.getCalibration_dataP());
        calcCalibrationDataRaw(this.getCalibration_dataT());
    }

    public void saveCalibrationData() {
        int result;

        try {
            connect(db_arch);

            //delete exist data
            PreparedStatement delData = conn.prepareStatement("DELETE FROM CAL "
                    + "WHERE CHANNEL=?");

            delData.setInt(1, this.getChannelV());
            result = delData.executeUpdate();
                        
            delData.setInt(1, this.getChannelP());
            result = delData.executeUpdate();
                        
            delData.setInt(1, this.getChannelT());
            result = delData.executeUpdate();

            delData.close();

            //save new one
            PreparedStatement saveData = conn.prepareStatement("INSERT INTO CAL "
                    + "(CHANNEL, POINT, X, Y, YS) "
                    + "VALUES (?,?,?,?,?)");
            //V
            if (this.getCalibration_dataV().size() != 0) {
                for (int i = 0; i < this.getCalibration_dataV().size(); i++) {
                    saveData.setInt(1, this.getChannelV());
                    saveData.setInt(2, this.getCalibration_dataV().get(i).getPoint());
                    saveData.setDouble(3, this.getCalibration_dataV().get(i).getX());
                    saveData.setDouble(4, this.getCalibration_dataV().get(i).getY());
                    saveData.setDouble(5, this.getCalibration_dataV().get(i).getYS());
                    result = saveData.executeUpdate();
                    if (result == 0) {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                        return;
                    }
                }
            }
            //P
            if (this.getCalibration_dataP().size() != 0) {
                for (int i = 0; i < this.getCalibration_dataP().size(); i++) {
                    saveData.setInt(1, this.getChannelP());
                    saveData.setInt(2, this.getCalibration_dataP().get(i).getPoint());
                    saveData.setDouble(3, this.getCalibration_dataP().get(i).getX());
                    saveData.setDouble(4, this.getCalibration_dataP().get(i).getY());
                    saveData.setDouble(5, this.getCalibration_dataP().get(i).getYS());
                    result = saveData.executeUpdate();
                    if (result == 0) {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                        return;
                    }
                }
            }
            //T
            if (this.getCalibration_dataT().size() != 0) {
                for (int i = 0; i < this.getCalibration_dataT().size(); i++) {
                    saveData.setInt(1, this.getChannelT());
                    saveData.setInt(2, this.getCalibration_dataT().get(i).getPoint());
                    saveData.setDouble(3, this.getCalibration_dataT().get(i).getX());
                    saveData.setDouble(4, this.getCalibration_dataT().get(i).getY());
                    saveData.setDouble(5, this.getCalibration_dataT().get(i).getYS());
                    result = saveData.executeUpdate();
                    if (result == 0) {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                        return;
                    }
                }
            }
            saveData.close();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
                fin();
                JOptionPane.showMessageDialog(null, "Ошибка записи - база данных возвращена в исходное состояние");
                return;
            } catch (Exception ej) {
                ej.printStackTrace();
                fin();
                JOptionPane.showMessageDialog(null, "Ошибка записи - состояние базы данных неизвестно. Обартитесь к разработчику");
                return;
            }
        }
        try {
            conn.commit();
            fin();
        } catch (Exception e) {
            e.printStackTrace();
            fin();
        }
    }

    private double calV(double val) {
        if (calibration_dataV!=null)
        {
            return val;
        }
        else return val;
    }

    private void connect(String db_name) {
        jdbcDataSource dataSource = new jdbcDataSource();
        try {
            dataSource.setDatabase("jdbc:hsqldb:" + db_name);
            conn = dataSource.getConnection("sa", "");
            conn.setAutoCommit(false);
            System.out.println("Connected");
        } catch (SQLException ex2) {
            ex2.printStackTrace();
            JOptionPane.showMessageDialog(null, "Невозможно открыть базу данных по адресу " + dataSource.getDatabase());
            System.exit(1);
        }
    }

    private void fin() {
        try {
            Statement st = conn.createStatement();
            st.execute("SHUTDOWN");
            conn.commit();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка закрытия базы данных");
        }
    }
}

