package gaspoverka.data.config;

import org.hsqldb.jdbc.jdbcDataSource;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Config {
    static String db_name = ".//db//config";
    private Connection conn;
    Properties config;

    public Config()
    {
        config = new Properties();
        load();
    }

    public Properties getConfig() {
        return config;
    }

    public void load(){
        ResultSet result = null;

        try {
            connect();
            PreparedStatement loadData = conn.prepareStatement("SELECT "
                    + "VALUE, FIELD "
                    + "FROM CONFIG ",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            result = loadData.executeQuery();
            fin();
            result.beforeFirst();

            while (result.next()) {
                config.setProperty(result.getString(1), result.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        int result;

        try {
            connect();

            PreparedStatement delData = conn.prepareStatement("DELETE FROM CONFIG");

            result = delData.executeUpdate();
            delData.close();

            PreparedStatement saveData = conn.prepareStatement("INSERT INTO CONFIG "
                    + "(VALUE, FIELD) "
                    + "VALUES (?,?)");

            if (config.size() != 0) {
                for (Enumeration e=config.keys();e.hasMoreElements();) {
                    String prop = e.nextElement().toString();
                    saveData.setString(1, prop);
                    saveData.setString(2, config.getProperty(prop));
                    System.out.println("key " + prop + " value " + config.getProperty(prop));
                    result = saveData.executeUpdate();
                    if (result == 0) {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                        return;
                    }
                }
                saveData.close();
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
