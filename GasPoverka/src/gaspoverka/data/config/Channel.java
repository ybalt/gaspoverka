package gaspoverka.data.config;

import org.hsqldb.jdbc.jdbcDataSource;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Channel {

    static String db_name = ".//db//config";
    private Connection conn;
    private int Channel;
    Vector<Point> calibration_data;
    private double value;

    // <editor-fold defaultstate="collapsed" desc="get&set">
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Vector<Point> getPoints() {
        return calibration_data;
    }

    public int getChannel() {
        return Channel;
    }

    public void setChannel(int Channel) {
        this.Channel = Channel;
    }

    // </editor-fold>
    
    public Channel(int channel) {
        this.Channel = channel;
        calibration_data = new Vector<Point>();
    }

    public Channel() {
        this.Channel = 0;
        calibration_data = new Vector<Point>();
    }

    public void loadCalibrationData(int Channel) {
        ResultSet result = null;

        try {
            connect();
            PreparedStatement loadData = conn.prepareStatement("SELECT "
                    + "POINT, X, Y, YS "
                    + "FROM CALIBRATION "
                    + "WHERE CHANNEL=? ORDER BY POINT ASC",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            loadData.setInt(1, Channel);
            result = loadData.executeQuery();
            fin();
            result.beforeFirst();
            calibration_data.clear();
            while (result.next()) {
                Point point = new Point();
                point.setPoint(result.getInt(1));
                point.setX(result.getDouble(2));
                point.setY(result.getDouble(3));
                point.setYS(result.getDouble(4));
                calibration_data.add(point);
            }
            if (calibration_data.size() == 0) {
                if (Channel == 5
                        || Channel == 7
                        || Channel == 9
                        || Channel == 11) {
                    for (int i = 0; i < 6; i++) {
                        calibration_data.add(new Point(i + 1));
                    }
                }
                if (Channel == 6
                        || Channel == 8
                        || Channel == 10
                        || Channel == 12) {
                    for (int i = 0; i < 5; i++) {
                        calibration_data.add(new Point(i + 1));
                    }
                }
            }
            this.setChannel(Channel);
            calcCalibrationData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void calcCalibrationData() {
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
                    }
                    //
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

    public void saveCalibrationData() {
        int result;

        try {
            connect();
            PreparedStatement delData = conn.prepareStatement("DELETE FROM CALIBRATION "
                    + "WHERE CHANNEL=?");

            delData.setInt(1, this.getChannel());
            result = delData.executeUpdate();
            delData.close();

            PreparedStatement saveData = conn.prepareStatement("INSERT INTO CALIBRATION "
                    + "(CHANNEL, POINT, X, Y, YS) "
                    + "VALUES (?,?,?,?,?)");

            if (this.getPoints().size() != 0) {
                for (int i = 0; i < this.getPoints().size(); i++) {
                    saveData.setInt(1, this.getChannel());
                    saveData.setInt(2, this.getPoints().get(i).getPoint());
                    saveData.setDouble(3, this.getPoints().get(i).getX());
                    saveData.setDouble(4, this.getPoints().get(i).getY());
                    saveData.setDouble(5, this.getPoints().get(i).getYS());
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
