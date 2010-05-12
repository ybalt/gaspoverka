package gaspoverka.db;

import gaspoverka.data.*;
import org.hsqldb.jdbc.jdbcDataSource;
import java.sql.*;
import java.util.*;

public class CountersDB {

    private Counters device;
    private Connection conn;

    public CountersDB(Counters counter) {
        this.device = counter;
    }

    public CountersDB() {
    }

    public Vector getList() {
        connect();
        Statement stat;
        ResultSet res = null;
        Vector vector = new Vector();
        try {
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT "
                    + "TYPE "
                    + "FROM COUNTERS ORDER BY TYPE ASC";
            res = stat.executeQuery(query);
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
        return vector;
    }

    public Vector getTable() {
        connect();
        Statement stat;
        ResultSet res = null;
        Vector vector = new Vector();
        try {
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT "
                    + "TYPE, CHANNEL, UD, PL, IC "
                    + "FROM COUNTERS ORDER BY TYPE ASC";
            res = stat.executeQuery(query);
            fin();
            res.beforeFirst();
            while (res.next()) {
                Vector row = new Vector();
                row.add(res.getString(1));
                row.add(res.getInt(2));
                row.add(res.getDouble(3));
                row.add(res.getDouble(4));
                row.add(res.getDouble(5));
                vector.add(row);
            }
            if (vector.size() == 0) {
                Vector row = new Vector();
                row.add(new Object());
                row.add(new Object());
                row.add(new Object());
                row.add(new Object());
                row.add(new Object());
                vector.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vector;

    }

    public void save() {
        connect();
        int result;
        try {
            PreparedStatement saveDev = conn.prepareStatement("INSERT INTO COUNTERS "
                    + "(TYPE, CHANNEL, UD, PL, IC) "
                    + "VALUES (?,?,?,?,?)");
            saveDev.setString(1, device.getType());
            saveDev.setInt(2, device.getChannel());
            saveDev.setDouble(3, device.getUD());
            saveDev.setDouble(4, device.getPL());
            saveDev.setDouble(5, device.getIC());
            result = saveDev.executeUpdate();
            if (result == 0) {
                conn.rollback();
                return;
            }
            saveDev.close();

            PreparedStatement saveKP = conn.prepareStatement("INSERT INTO KP "
                    + "(TYPE, NUMBER, VALUEL, VALUEH, ERROR) "
                    + "VALUES (?,?,?,?,?)");
            for (int i = 0; i < device.getKP().getNum(); i++) {
                saveKP.setString(1, device.getType());
                saveKP.setInt(2, device.getKP().getKP(i));
                saveKP.setDouble(3, device.getKP().getValueL(i));
                saveKP.setDouble(4, device.getKP().getValueH(i));
                saveKP.setDouble(5, device.getKP().getError(i));
                result = saveKP.executeUpdate();
                if (result == 0) {
                    conn.rollback();
                    return;
                }

            }
            saveKP.close();

            PreparedStatement saveMR = conn.prepareStatement("INSERT INTO MR "
                    + "(TYPE, NUMBER, MRH, MRL, ERROR) "
                    + "VALUES (?,?,?,?,?)");
            for (int i = 0; i < device.getMR().getNum(); i++) {
                saveMR.setString(1, device.getType());
                saveMR.setInt(2, device.getMR().getNumber(i));
                saveMR.setDouble(3, device.getMR().getMRH(i));
                saveMR.setDouble(4, device.getMR().getMRL(i));
                saveMR.setDouble(5, device.getMR().getError(i));
                result = saveMR.executeUpdate();
                if (result == 0) {
                    conn.rollback();
                    return;
                }
            }
            saveMR.close();
            conn.commit();
            fin();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void load(String type) {
        connect();
        ResultSet resultCounter;
        ResultSet resultKP;
        ResultSet resultMR;
        try {
            PreparedStatement loadDev = conn.prepareStatement("SELECT "
                    + "TYPE, CHANNEL, UD, PL, IC "
                    + "FROM COUNTERS WHERE TYPE = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            System.out.println(type);
            loadDev.setString(1, type);

            resultCounter = loadDev.executeQuery();
            resultCounter.beforeFirst();
            if (!resultCounter.next()) {
                System.out.printf("counter not found \n", type);
                return;
            }

            device.setType(resultCounter.getString(1));
            device.setChannel(resultCounter.getInt(2));
            device.setUD(resultCounter.getDouble(3));
            device.setPL(resultCounter.getDouble(4));
            device.setIC(resultCounter.getInt(5));

            PreparedStatement loadKP = conn.prepareStatement("SELECT "
                    + "NUMBER, VALUEL, VALUEH, ERROR "
                    + "FROM KP WHERE TYPE = ? ORDER BY NUMBER ASC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadKP.setString(1, type);
            resultKP = loadKP.executeQuery();
            if (!resultKP.next()) {
                System.out.println("kp not found");
                return;
            }
            resultKP.last();
            resultKP.beforeFirst();
            int i = 0;
            while (resultKP.next()) {
                i++;
            }
            device.getKP().setNum(i);
            i = 0;
            resultKP.beforeFirst();
            while (resultKP.next()) {
                device.getKP().setKP(i, resultKP.getInt(1), resultKP.getDouble(2), resultKP.getDouble(3), resultKP.getDouble(4));
                i++;
            }

            PreparedStatement loadMR = conn.prepareStatement("SELECT "
                    + "NUMBER, MRH, MRL, ERROR "
                    + "FROM MR WHERE TYPE = ? ORDER BY NUMBER ASC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadMR.setString(1, type);
            resultMR = loadMR.executeQuery();
            if (!resultMR.next()) {
                System.out.println("mr not found");
                return;
            }
            resultMR.last();
            resultMR.beforeFirst();
            i = 0;
            while (resultMR.next()) {
                i++;
            }
            device.getMR().setNum(i);
            resultMR.beforeFirst();
            i = 0;
            while (resultMR.next()) {
                device.getMR().setMR(i, resultMR.getInt(1), resultMR.getDouble(2), resultMR.getDouble(3), resultMR.getDouble(4));
                i++;
            }
            fin();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void delete(String type) {
        connect();
        int result;
        try {
            PreparedStatement delDev = conn.prepareStatement("DELETE FROM COUNTERS "
                    + "WHERE TYPE = ?");

            delDev.setString(1, device.getType());
            result = delDev.executeUpdate();
            delDev.close();

            PreparedStatement delKP = conn.prepareStatement("DELETE FROM KP "
                    + "WHERE TYPE = ?");
            delKP.setString(1, device.getType());
            result = delKP.executeUpdate();
            delKP.close();

            PreparedStatement delMR = conn.prepareStatement("DELETE FROM MR "
                    + "WHERE TYPE = ?");
            delMR.setString(1, device.getMR().getType());
            result = delMR.executeUpdate();
            delMR.close();
            conn.commit();
            fin();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update() {
        connect();
        int result;
        try {
            PreparedStatement updateDev = conn.prepareStatement("UPDATE COUNTERS"
                    + "SET CHANNEL=?, UD=?, PL=?, IC=? "
                    + "WHERE TYPE=?");

            updateDev.setInt(1, device.getChannel());
            updateDev.setDouble(2, device.getUD());
            updateDev.setDouble(3, device.getPL());
            updateDev.setDouble(4, device.getIC());
            updateDev.setString(5, device.getType());
            result = updateDev.executeUpdate();
            if (result == 0) {
                conn.rollback();
                return;
            }
            updateDev.close();

            PreparedStatement updateKP = conn.prepareStatement("UPDATE KP "
                    + "SET KP=?, VALUEL=?, VALUEH=?, ERROR=? "
                    + "WHERE TYPE=?");
            for (int i = 1; i <= device.getKP().getNum(); i++) {
                updateKP.setInt(1, device.getKP().getKP(i));
                updateKP.setDouble(2, device.getKP().getValueL(i));
                updateKP.setDouble(3, device.getKP().getValueH(i));
                updateKP.setDouble(4, device.getKP().getError(i));
                updateKP.setString(5, device.getType());
                result = updateKP.executeUpdate();
                if (result == 0) {
                    conn.rollback();
                    return;
                }

            }
            updateKP.close();

            PreparedStatement saveMR = conn.prepareStatement("UPDATE MR "
                    + "SET NUMBER=?, MRH=?, MRL=?, ERROR=? "
                    + "WHERE TYPE=?");
            for (int i = 1; i <= device.getMR().getNum(); i++) {
                saveMR.setString(1, device.getMR().getType());
                saveMR.setInt(2, device.getMR().getNumber(i));
                saveMR.setDouble(3, device.getMR().getMRH(i));
                saveMR.setDouble(4, device.getMR().getMRL(i));
                saveMR.setDouble(5, device.getMR().getError(i));
                result = saveMR.executeUpdate();
                if (result == 0) {
                    conn.rollback();
                    return;
                }
            }
            saveMR.close();
            conn.commit();
            fin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connect() {
        String db_name = ".//db//arch";
        try {
            jdbcDataSource dataSource = new jdbcDataSource();
            dataSource.setDatabase("jdbc:hsqldb:" + db_name);
            conn = dataSource.getConnection("sa", "");
            conn.setAutoCommit(false);
            System.out.println("Connect");
        } catch (SQLException ex2) {
            ex2.printStackTrace();

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
        }

    }
}

