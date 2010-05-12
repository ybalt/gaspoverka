package gaspoverka.db;

import gaspoverka.data.*;
import org.hsqldb.jdbc.jdbcDataSource;
import java.sql.*;
import java.util.*;

public class ReferenceDB {

    private Reference device;
    private Connection conn;

    public ReferenceDB(Reference ref) {
        this.device = ref;
    }

    public ReferenceDB() {
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
                    + "FROM REF ORDER BY TYPE ASC";
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
                    + "TYPE, CHANNEL, UD, PL, IC, MIC "
                    + "FROM REF ORDER BY TYPE ASC";
            res = stat.executeQuery(query);
            fin();
            res.beforeFirst();
            while (res.next()) {
                Vector row = new Vector();
                row.add(res.getString(1));
                row.add(res.getInt(2));
                row.add(res.getFloat(3));
                row.add(res.getFloat(4));
                row.add(res.getFloat(5));
                row.add(res.getFloat(6));
                vector.add(row);
            }
            if (vector.size() == 0) {
                Vector row = new Vector();
                row.add(new Object());
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
            PreparedStatement saveDev = conn.prepareStatement("INSERT INTO REF"
                    + "(TYPE, CHANNEL, UD, PL, IC, MIC)"
                    + "VALUES (?,?,?,?,?,?)");

            saveDev.setString(1, device.getType());
            saveDev.setInt(2, device.getChannel());
            saveDev.setFloat(3, device.getUD());
            saveDev.setFloat(4, device.getPL());
            saveDev.setFloat(5, device.getIC());
            saveDev.setFloat(6, device.getMIC());
            result = saveDev.executeUpdate();
            if (result == 0) {
                conn.rollback();
                return;
            }
            saveDev.close();

            PreparedStatement saveMR = conn.prepareStatement("INSERT INTO MR "
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
        ResultSet resultRef;
        ResultSet resultMR;
        try {
            PreparedStatement loadDev = conn.prepareStatement("SELECT "
                    + "TYPE, CHANNEL, UD, PL, IC, MIC "
                    + "FROM REF WHERE TYPE = ?",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            System.out.println(type);
            loadDev.setString(1, type);

            resultRef = loadDev.executeQuery();
            resultRef.beforeFirst();
            if (!resultRef.next()) {
                System.out.printf("ref not found \n", type);
                return;
            }

            device.setType(resultRef.getString(1));
            device.setChannel(resultRef.getInt(2));
            device.setUD(resultRef.getFloat(3));
            device.setPL(resultRef.getFloat(4));
            device.setIC(resultRef.getInt(5));
            device.setMIC(resultRef.getInt(6));

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
            PreparedStatement delDev = conn.prepareStatement("DELETE FROM REF "
                    + "WHERE TYPE = ?");

            delDev.setString(1, device.getType());
            result = delDev.executeUpdate();
            if (result == 0) {
                conn.rollback();
                return;
            }
            delDev.close();

            PreparedStatement delMR = conn.prepareStatement("DELETE * FROM MR "
                    + "WHERE TYPE = ?");
            delMR.setString(1, device.getMR().getType());
            result = delMR.executeUpdate();
            if (result == 0) {
                conn.rollback();
                return;
            }
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
            PreparedStatement updateDev = conn.prepareStatement("UPDATE REF"
                    + "SET CHANNEL=?, UD=?, PL=?, IC=?, MIC=? "
                    + "WHERE TYPE=?");

            updateDev.setInt(1, device.getChannel());
            updateDev.setFloat(2, device.getUD());
            updateDev.setFloat(3, device.getPL());
            updateDev.setFloat(4, device.getIC());
            updateDev.setString(5, device.getType());
            result = updateDev.executeUpdate();
            if (result == 0) {
                conn.rollback();
                return;
            }
            updateDev.close();

            PreparedStatement updateMR = conn.prepareStatement("UPDATE MR "
                    + "SET NUMBER=?, MRH=?, MRL=?, ERROR=? "
                    + "WHERE TYPE=?");
            for (int i = 1; i <= device.getMR().getNum(); i++) {
                updateMR.setString(1, device.getMR().getType());
                updateMR.setInt(2, device.getMR().getNumber(i));
                updateMR.setFloat(3, device.getMR().getMRH(i));
                updateMR.setFloat(4, device.getMR().getMRL(i));
                updateMR.setFloat(5, device.getMR().getError(i));
                result = updateMR.executeUpdate();
                if (result == 0) {
                    conn.rollback();
                    return;
                }
            }
            updateMR.close();
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
