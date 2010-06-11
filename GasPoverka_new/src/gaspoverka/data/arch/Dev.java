package gaspoverka.data.arch;

import org.hsqldb.jdbc.jdbcDataSource;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Dev {

    static String db_name = ".//db//arch";

    private Connection conn;
    private String Type;
    private int Channel;
    private int UD;
    private int PL;
    private int IC;
    private int MIC;
    public Vector<T> MR;
    public Vector<T> KP;

    public Dev() {
        this.Type = null;
        this.Channel = 0;
        this.UD = 0;
        this.PL = 0;
        this.IC = 0;
        this.MIC = 0;
        MR = new Vector<T>();
        KP = new Vector<T>();

    }

    public Dev(String Type) {
        this.Type = null;
        this.Channel = 0;
        this.UD = 0;
        this.PL = 0;
        this.IC = 0;
        this.MIC = 0;
        this.load(Type);
    }

    // <editor-fold defaultstate="collapsed" desc="get&set">
    public int getChannel() {
        return Channel;
    }

    public void setChannel(int Channel) {
        this.Channel = Channel;
    }

    public int getIC() {
        return IC;
    }

    public void setIC(int IC) {
        this.IC = IC;
    }

    public int getMIC() {
        return MIC;
    }

    public void setMIC(int MIC) {
        this.MIC = MIC;
    }

    public int getPL() {
        return PL;
    }

    public void setPL(int PL) {
        this.PL = PL;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getUD() {
        return UD;
    }

    public void setUD(int UD) {
        this.UD = UD;
    }

    public T getKP(int Number) {
        return KP.get(Number);
    }

    public T getMR(int Number) {
        return MR.get(Number);
    }

    public Vector<T> getKP() {
        return KP;
    }

    public Vector<T> getMR() {
        return MR;
    }

    // </editor-fold>
    public Vector<Dev> getDevTable() {
        Vector<Dev> vector = new Vector();
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
            connect();
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
            connect();
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
            connect();
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

    public void load(String type) {
        connect();

        ResultSet resultDev;
        ResultSet resultKP;
        ResultSet resultMR;

        MR.clear();
        KP.clear();

        try {
            PreparedStatement loadDev = conn.prepareStatement("SELECT "
                    + "TYPE, CHANNEL, UD, PL, IC, MIC "
                    + "FROM DEV WHERE TYPE = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            PreparedStatement loadKP = conn.prepareStatement("SELECT "
                    + "NUMBER, VL, VH, ERROR "
                    + "FROM DEV_KP WHERE TYPE = ? ORDER BY NUMBER ASC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            PreparedStatement loadMR = conn.prepareStatement("SELECT "
                    + "NUMBER, VL, VH, ERROR "
                    + "FROM DEV_MR WHERE TYPE = ? ORDER BY NUMBER ASC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            loadDev.setString(1, type);
            loadKP.setString(1, type);
            loadMR.setString(1, type);

            resultDev = loadDev.executeQuery();
            resultDev.beforeFirst();
            resultKP = loadKP.executeQuery();
            resultKP.beforeFirst();
            resultMR = loadMR.executeQuery();
            resultMR.beforeFirst();

            if (!resultDev.next()) {
                System.out.printf("dev not found \n", type);
                return;
            }

            setType(resultDev.getString(1));
            setChannel(resultDev.getInt(2));
            setUD(resultDev.getInt(3));
            setPL(resultDev.getInt(4));
            setIC(resultDev.getInt(5));
            setMIC(resultDev.getInt(6));

            if (resultKP.next()) {
                resultKP.beforeFirst();
                while (resultKP.next()) {
                    T KPT = new T(resultKP.getInt(1));
                    KPT.setVL(resultKP.getDouble(2));
                    KPT.setVH(resultKP.getDouble(3));
                    KPT.setError(resultKP.getDouble(4));
                    this.KP.add(KPT);
                }
            }

            if (resultMR.next()) {
                resultMR.beforeFirst();
                while (resultMR.next()) {
                    T MRT = new T(resultMR.getInt(1));
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

    public void save() {
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
                for (int i = 0; i < this.getMR().size(); i++) {
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

    public void insert() {
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

    public void delete() {
        connect();
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

    private void connect() {
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

