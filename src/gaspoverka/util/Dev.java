package gaspoverka.util;

import gaspoverka.memDB;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Dev {

    private Connection conn;
    memDB db = memDB.getInstance();
    public static Log log = Log.getInstance();
    private String Type;
    private int Channel;
    private int UD;
    private int PL;
    private int IC;
    private int MIC;
    Config config = Config.getInstance();
    public Vector<DevT> MR;
    public Vector<DevT> KP;

    public Dev() {
        this.Type = null;
        this.Channel = 0;
        this.UD = 0;
        this.PL = 0;
        this.IC = 0;
        this.MIC = 0;
        MR = new Vector<DevT>();
        KP = new Vector<DevT>();
    }

    // <editor-fold defaultstate="collapsed" desc="get&set">
    public String getType() {
        return Type;
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

    public int getChannel() {
        return Channel;
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="devManagement">
    public Vector<Dev> getDevTable() {
        Vector<Dev> vector = new Vector<Dev>();
        ResultSet res = null;
        Statement stat;
        try {
            connect();
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT "
                    + "TYPE, CHANNEL, UD, PL, IC, MIC "
                    + "FROM DEV ORDER BY TYPE ASC";
            res = stat.executeQuery(query);

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
            if (vector.isEmpty()) {
                vector.add(new Dev());
            }

        } catch (Exception e) {
        }
        return vector;
    }

    public String[] getDevList() {
        Statement stat;
        ResultSet res = null;
        List<String> list = new ArrayList<String>();

        try {
            connect();
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT "
                    + "TYPE "
                    + "FROM DEV ORDER BY TYPE ASC";
            res = stat.executeQuery(query);
            res.beforeFirst();
            while (res.next()) {
                list.add(res.getString(1));
            }

        } catch (Exception e) {
        }
        String[] str = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            str[i] = list.get(i);
        }
        return str;
    }

    public String[] getRefList() {
        ResultSet res = null;
        List<String> list = new ArrayList<String>();
        try {
            connect();
            PreparedStatement loadDev = conn.prepareStatement("SELECT "
                    + "TYPE "
                    + "FROM DEV WHERE CHANNEL "
                    + "BETWEEN 1 AND 3 "
                    + "ORDER BY TYPE ASC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            res = loadDev.executeQuery();
            res.beforeFirst();

            while (res.next()) {
                list.add(res.getString(1));
            }

        } catch (Exception e) {
        }
        String[] str = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            str[i] = list.get(i);
        }
        return str;
    }

    public String[] getDevListByChannel(int Channel) {
        ResultSet res = null;
        List<String> list = new ArrayList<String>();
        try {
            connect();
            PreparedStatement loadDev = conn.prepareStatement("SELECT "
                    + "TYPE "
                    + "FROM DEV WHERE CHANNEL = ? "
                    + "ORDER BY TYPE ASC ",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadDev.setInt(1, Channel);
            res = loadDev.executeQuery();
            res.beforeFirst();

            while (res.next()) {
                list.add(res.getString(1));
            }

        } catch (Exception e) {
        }
        String[] str = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            str[i] = list.get(i);
        }
        return str;
    }

    public void loadDevByType(String type) {
        try {
            connect();
            PreparedStatement loadDevByType = conn.prepareStatement("SELECT "
                    + "TYPE, CHANNEL, UD, PL, IC, MIC "
                    + "FROM DEV WHERE TYPE = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadDevByType.setString(1, type);
            loadDev(loadDevByType);
        } catch (Exception e) {
        }

    }

    public void loadDevByChannel(int channel) {
        try {
            connect();
            PreparedStatement loadDevByChannel = conn.prepareStatement("SELECT "
                    + "TYPE, CHANNEL, UD, PL, IC, MIC "
                    + "FROM DEV WHERE CHANNEL = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadDevByChannel.setInt(1, channel);
            loadDev(loadDevByChannel);
        } catch (Exception e) {
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
            //chDev = new Channel(this.getChannel());
            //chDevP = new Channel(this.getChannel() * 10 + 1);
            //chDevT = new Channel(this.getChannel() * 10 + 2);
        } catch (Exception e) {
        }

    }

    public void saveDev() {
        int result;

        try {
            connect();

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
            saveDev.setInt(2, getChannel());
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
            if (!this.getKP().isEmpty()) {
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
            if (!this.getMR().isEmpty()) {
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
            try {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Ошибка записи - база данных возвращена в исходное состояние");
                return;
            } catch (Exception ej) {
                JOptionPane.showMessageDialog(null, "Ошибка записи - состояние базы данных неизвестно. Обартитесь к разработчику");
                return;
            }
        }
        try {
            conn.commit();
            db.write();
        } catch (Exception e) {
        }

    }

    public void insertDev() {
        connect();
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
            insertDev.setInt(2, getChannel());
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
            if (!this.getKP().isEmpty()) {
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
            if (!this.getMR().isEmpty()) {
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
            db.write();
        } catch (Exception e) {
        }
    }

    public void delDev() {
        connect();
        int result;
        try {
            PreparedStatement delDev = conn.prepareStatement("DELETE FROM DEV "
                    + "WHERE TYPE = ?");
            log.from().entering(this.Type, "delDev");
            log.out(delDev.toString());
            if (getType() != null) {
                delDev.setString(1, getType());
            } else {
                delDev = conn.prepareStatement("DELETE FROM DEV "
                    + "WHERE TYPE IS NULL");
            }
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
        } catch (Exception e) {
            try {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Ошибка записи - база данных возвращена в исходное состояние");
            } catch (Exception ej) {
                JOptionPane.showMessageDialog(null, "Ошибка записи - состояние базы данных неизвестно. Обартитесь к разработчику");
            }
        }
        try {
            conn.commit();
            db.write();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ошибка записи - невозможно записать изменения");
        }

    }
    // </editor-fold>

    public int[] getAdress() {
        int adress[] = new int[2];
        if (this.Channel != 0 && config != null) {
            String module = config.getConfig().getProperty(String.valueOf(this.Channel), "0");
            adress[0] = Integer.valueOf(module.charAt(0));
            adress[1] = Integer.valueOf(module.charAt(2));
        } else {
            adress[0] = 0;
            adress[1] = 0;
        }
        return adress;
    }

    public int[] getPAdress() {
        int adress[] = new int[2];
        if (this.Channel != 0 && config != null) {
            String module = config.getConfig().getProperty(String.valueOf(this.Channel * 10 + 1), "0");
            adress[0] = Integer.valueOf(module.charAt(0));
            adress[1] = Integer.valueOf(module.charAt(2));
        } else {
            adress[0] = 0;
            adress[1] = 0;
        }
        return adress;
    }

    public int[] getTAdress() {
        int adress[] = new int[2];
        if (this.Channel != 0 && config != null) {
            String module = config.getConfig().getProperty(String.valueOf(this.Channel * 10 + 2), "0");
            adress[0] = Integer.valueOf(module.charAt(0));
            adress[1] = Integer.valueOf(module.charAt(2));
        } else {
            adress[0] = 0;
            adress[1] = 0;
        }
        return adress;
    }

    private void connect() {
        conn = db.connTo();
    }
}
