package gaspoverka.calibration;

import gaspoverka.memDB;
import gaspoverka.util.RoundFactory;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

public class Calibration {

    memDB db = memDB.getInstance();
    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static Connection conn;
    private Vector<CalibrationPoint> points;
    private final double[] A0Points;
    private final int channel;
    RoundFactory rf = RoundFactory.getInstance();

    public Vector<CalibrationPoint> getPoints() {
        return points;
    }

    public double[] getA0Points() {
        return A0Points;
    }

    public int getChannel() {
        return channel;
    }

    public Calibration(int channel) {
        this.channel = channel;
        points = new Vector<CalibrationPoint>();
        A0Points = new double[5];
    }

    public void addCalibrationPoint() {
        int i = 0;
        if (!points.isEmpty()) {
            i = points.lastElement().getPoint();
            points.add(new CalibrationPoint(i + 1));
        } else {
            points.add(new CalibrationPoint(i + 1));
        }
    }

    public void loadCalibrationData() {
        try {
            ResultSet result;
            connect();
            if ((channel == 1) || (channel == 2) || (channel == 3)) {
                PreparedStatement loadData = conn.prepareStatement("SELECT "
                        + "A1, A2, A3, A4, A5 "
                        + "FROM ACALIBRATION "
                        + "WHERE CHANNEL=?",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                loadData.setInt(1, this.channel);
                result = loadData.executeQuery();
                result.beforeFirst();
//                points.clear();
                if (result.next()) {
                    for (int i = 0; i < 5; i++) {
                        A0Points[i] = result.getDouble(i + 1);
                    }
                }
            } else {
                PreparedStatement loadData = conn.prepareStatement("SELECT "
                        + "POINT, X, Y, YS "
                        + "FROM CALIBRATION "
                        + "WHERE CHANNEL=? ORDER BY POINT ASC",
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                loadData.setInt(1, this.channel);
                result = loadData.executeQuery();
                result.beforeFirst();
                points.clear();
                while (result.next()) {
                    CalibrationPoint point = new CalibrationPoint();
                    point.setPoint(result.getInt(1));
                    point.setX(result.getDouble(2));
                    point.setY(result.getDouble(3));
                    point.setYS(result.getDouble(4));
                    points.add(point);
                }
                calcCalibrationData();
            }
        } catch (Exception e) {
            LOG.info(e.getLocalizedMessage());
        }

    }

    public void calcCalibrationData() {
        RoundFactory localrf = new RoundFactory();
        for (int A = 0; A < points.size() - 1; A++) {

            int B = A + 1;
            double K1 = 0, K2 = 0, B1 = 0, B2 = 0;
            String u1, u2;
            if (points.get(B).getY() != 0 || points.get(B).getX() != 0 || points.get(B).getYS() != 0) {
                try {
                    //y=x*(F1/F4)+(-F2+F3/F4))
                    //y=kx+b
                    double F1 = points.get(B).getY() - points.get(A).getY();
                    double F2 = points.get(A).getX() * points.get(B).getY();
                    double F3 = points.get(B).getX() * points.get(A).getY();
                    double F4 = points.get(B).getX() - points.get(A).getX();
                    if (F4 != 0) {
                        K1 = F1 / F4;
                        B1 = (-F2 + F3) / F4;
                    }
                    //
                    double G1 = points.get(B).getYS() - points.get(A).getYS();
                    double G2 = points.get(A).getY() * points.get(B).getYS();
                    double G3 = points.get(B).getY() * points.get(A).getYS();
                    double G4 = points.get(B).getY() - points.get(A).getY();
                    if (G4 != 0) {
                        K2 = G1 / G4;
                        B2 = (-G2 + G3) / G4;
                    }
                    points.get(A).setK1(K1);
                    points.get(A).setB1(B1);
                    points.get(A).setK2(K2);
                    points.get(A).setB2(B2);

                    u1 = new String();
                    u1 += "Y=" + localrf.Rounded(K1) + "*X";
                    if (B1 >= 0) {
                        u1 += "+" + localrf.Rounded(B1);
                    } else {
                        u1 += localrf.Rounded(B1);
                    }
                    u2 = new String();
                    u2 = "Y=" + localrf.Rounded(K2) + "*X";
                    if (B2 >= 0) {
                        u2 += "+" + localrf.Rounded(B2);
                    } else {
                        u2 += localrf.Rounded(B2);
                    }
                    points.get(A).setUr1(u1);
                    points.get(A).setUr2(u2);
                } catch (Exception e) {
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
            LOG.info("delete calibration data on channel " + getChannel());
            delData.setInt(1, this.getChannel());
            delData.executeUpdate();
            delData.close();
            if ((this.channel == 1) || (this.channel == 2) || (this.channel == 3)) {

                PreparedStatement saveData = conn.prepareStatement("INSERT INTO ACALIBRATION "
                        + "(CHANNEL, A1, A2, A3, A4, A5) "
                        + "VALUES (?,?,?,?,?,?)");

                if (A0Points != null) {
                    saveData.setInt(1, this.getChannel());
                    String acal = "";
                    for (int i = 0; i < 5; i++) {
                        saveData.setDouble(i + 2, A0Points[i]);
                        acal = acal + " " + A0Points[i];
                    }
                    LOG.info("save calibration data on channel: " + getChannel() + "with:" + acal);
                    saveData.executeUpdate();
                    saveData.close();
                }
            } else {

                PreparedStatement saveData = conn.prepareStatement("INSERT INTO CALIBRATION "
                        + "(CHANNEL, POINT, X, Y, YS) "
                        + "VALUES (?,?,?,?,?)");

                if (!this.getPoints().isEmpty()) {
                    for (int i = 0; i < this.getPoints().size(); i++) {
                        saveData.setInt(1, this.getChannel());
                        saveData.setInt(2, this.getPoints().get(i).getPoint());
                        saveData.setDouble(3, this.getPoints().get(i).getX());
                        saveData.setDouble(4, this.getPoints().get(i).getY());
                        saveData.setDouble(5, this.getPoints().get(i).getYS());
                        LOG.info("save calibration data on channel " + getChannel() + "with "
                                + "point: " + this.getPoints().get(i).getPoint()
                                + "X: " + this.getPoints().get(i).getX()
                                + "Y: " + this.getPoints().get(i).getY()
                                + "YS: " + this.getPoints().get(i).getYS());
                        result = saveData.executeUpdate();
                        if (result == 0) {
                            conn.rollback();
                            JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                            LOG.info("unable to write to db, rollback");
                            return;
                        }
                    }
                    saveData.close();
                }
            }
        } catch (Exception e) {
            try {
                conn.rollback();
                LOG.info(e.getLocalizedMessage());
                JOptionPane.showMessageDialog(null, "Ошибка записи - база данных возвращена в исходное состояние");
                return;
            } catch (Exception ej) {
                LOG.info(e.getLocalizedMessage());
                JOptionPane.showMessageDialog(null, "Ошибка записи - состояние базы данных неизвестно");
                return;
            }
        }
        try {
            conn.commit();
            db.write();
        } catch (Exception e) {
            LOG.info(e.getLocalizedMessage());
        }

    }

    public double getCalibrated(double val) {
        double value = rf.Rounded(val, 4);
        for (int A = 0; A
                < points.size() - 1; A++) {
            int B = A + 1;
            double k1 = 1;
            double k2 = 1;
            if (A == 0) {
                k1 = -0.5;
            }
            if (B == (points.size() - 1)) {
                k2 = +0.5;
            }
            if (value >= (points.get(A).getY() + k1)
                    && value <= (points.get(B).getY() + k2)) {
                //LOG.info("PDcal: value:" + value + "\n" +
                //        "PDcal: A:" + (points.get(A).getY() + k1) + "\n" +
                //        "PDcal: B:" + (points.get(B).getY() + k2));
                return points.get(A).getK2() * value + points.get(A).getB2();
            }
        }
        return value;
    }

    private void connect() {
        conn = db.connFile();
    }
}
