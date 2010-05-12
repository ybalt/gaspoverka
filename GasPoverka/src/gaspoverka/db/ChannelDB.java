package gaspoverka.db;

import org.hsqldb.jdbc.jdbcDataSource;
import java.sql.*;
import java.util.*;

public class ChannelDB {

    Connection conn;
    String[] devList;

    public void ChannelDB() {
        connect();
        devList = new String[1];
        devList[0] = getDev();
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

    public String getDev() {
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
        return String.valueOf("");
    }
}
