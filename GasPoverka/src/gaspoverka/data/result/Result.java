package gaspoverka.data.result;

import org.hsqldb.jdbc.jdbcDataSource;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Result {
    
    private String db_name = ".//db//result";
    private Connection conn;

    
    private long PovNum;
    Vector<Calculation> data;

    public long getPovNum() {
        return PovNum;
    }

    public void setPovNum(long PovNum) {
        this.PovNum = PovNum;
    }

    public Vector<Calculation> getDataVector() {
        return data;
    }

    public Result() {
        data = new Vector<Calculation>();
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

    private void save() {
        int result;

        try {
            connect();
            PreparedStatement delData = conn.prepareStatement("DELETE FROM RESULT "
                    + "WHERE POVNUM=?");

            delData.setLong(1, this.getPovNum());
            result = delData.executeUpdate();
            delData.close();

            PreparedStatement saveData = conn.prepareStatement("INSERT INTO RESULT "
                    + "(CHANNEL, TYPE, DEVNUM, OWNER, KP, MNUM, CV, V, POVNUM) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)");

            if (data.size()!=0) {
                for (int i = 0; i < data.size(); i++) {
                    saveData.setInt(1, data.get(i).getChannel());
                    saveData.setString(2, data.get(i).getType());
                    saveData.setString(3, data.get(i).getDevNum());
                    saveData.setString(4, data.get(i).getOwner());
                    saveData.setInt(5, data.get(i).getKP());
                    saveData.setInt(6, data.get(i).getMeasureNum());
                    saveData.setDouble(7, data.get(i).getControlValue());
                    saveData.setDouble(8, data.get(i).getMeasuredValue());
                    saveData.setLong(9, this.getPovNum());
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
            ex.printStackTrace();
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
        } catch (Exception exc) {
            exc.printStackTrace();
            fin();
        }
    }

    private void load(long PovNum) {
    }

    public long getLastPovNum() {
        ResultSet result;

        try {
            connect();
            PreparedStatement loadData = conn.prepareStatement("SELECT "
                    + "POVNUM "
                    + "FROM RESULT "
                    + "ORDER BY POVNUM ASC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            result = loadData.executeQuery();
            fin();
            result.beforeFirst();
            if (result.next()) {
                result.last();
                return result.getLong(1);
            }
            else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    public void calc() {}

}
