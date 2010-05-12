package gaspoverka.db;

import gaspoverka.data.*;
import org.hsqldb.jdbc.jdbcDataSource;
import java.sql.*;
import java.util.*;

public class SensorsDB {

    private Sensors device;
    private Connection conn;

    public SensorsDB(Sensors sens) {
        this.device = sens;
    }

    public SensorsDB() {
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
                    + "FROM SENSORS ORDER BY TYPE ASC";
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
                    + "TYPE, CHANNEL, INFOOUT "
                    + "FROM SENSORS ORDER BY TYPE ASC";
            res = stat.executeQuery(query);
            fin();
            res.beforeFirst();
            while (res.next()) {
                Vector row = new Vector();
                row.add(res.getString(1));
                row.add(res.getInt(2));
                row.add(res.getString(3));
                vector.add(row);
            }
            if (vector.size() == 0) {
                Vector row = new Vector();
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
            PreparedStatement saveDev = conn.prepareStatement("INSERT INTO SENSORS"
                    + "(TYPE, CHANNEL, INFOOUT)"
                    + "VALUES (?,?,?)");
            saveDev.setString(1, device.getType());
            saveDev.setInt(2, device.getChannel());
            saveDev.setString(6, device.getInfoOut());
            result = saveDev.executeUpdate();
            if (result == 0) {
                conn.rollback();
            }
            saveDev.close();

            PreparedStatement saveMR = conn.prepareStatement("INSERT INTO MR"
                    + "(TYPE, NUMBER, MRH, MRL, ERROR) "
                    + "VALUES (?,?,?,?,?)");
            for (int i = 0; i < device.getMR().getNum(); i++) {
                saveMR.setString(1, device.getType());
                saveMR.setInt(2, device.getMR().getNumber(i));
                saveMR.setFloat(3, device.getMR().getMRH(i));
                saveMR.setFloat(4, device.getMR().getMRL(i));
                saveMR.setFloat(5, device.getMR().getError(i));
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
        ResultSet resultSens;
        ResultSet resultMR;

        try {
            PreparedStatement loadDev = conn.prepareStatement("SELECT "
                    + "TYPE, CHANNEL, INFOOUT "
                    + "FROM SENSORS WHERE TYPE = ? ORDER BY TYPE ASC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            loadDev.setString(1, type);

            resultSens = loadDev.executeQuery();
            resultSens.beforeFirst();
            if (!resultSens.next()) {
                System.out.println("sensor not found");
                return;
            }
            device.setType(resultSens.getString(1));
            device.setChannel(resultSens.getInt(2));
            device.setInfoOut(resultSens.getString(3));

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
            int i = 0;
            while (resultMR.next()) {
                i++;
            }
            device.getMR().setNum(i);
            resultMR.beforeFirst();
            i = 0;
            while (resultMR.next()) {
                device.getMR().setMR(i, resultMR.getInt(1), resultMR.getFloat(2), resultMR.getFloat(3), resultMR.getFloat(4));
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
            PreparedStatement delDev = conn.prepareStatement("DELETE FROM SENSORS "
                    + "WHERE TYPE = ?");

            delDev.setString(1, device.getType());
            result = delDev.executeUpdate();
            delDev.close();

            PreparedStatement delMR = conn.prepareStatement("DELETE FROM MR "
                    + "WHERE TYPE = ?");
            delMR.setString(1, device.getType());
            result = delMR.executeUpdate();
            delMR.close();
            conn.commit();
            fin();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update() {
        
    }

    private void connect() {
        String db_name = ".//db//arch";
        try {
            jdbcDataSource dataSource = new jdbcDataSource();
            dataSource.setDatabase("jdbc:hsqldb:" + db_name);
            conn = dataSource.getConnection("sa", "");
            conn.setAutoCommit(false);
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
