package gaspoverka.calibration;

import gaspoverka.memDB;
import gaspoverka.util.Channel;
import gaspoverka.util.Config;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class Attestation {

    //private static final String db_result = ".//db//att_result";
    memDB db = memDB.getInstance();
    private static Connection conn;
    private AbstractTableModel tm;
    private Channel channel;
    private int column;//
    Config config = Config.getInstance();
    private static Thread thread;
    private boolean calibrated;

    // <editor-fold defaultstate="collapsed" desc="get&set">
    public int getCol() {
        return column;
    }

    public boolean isCalibrated() {
        return calibrated;
    }

    public void setCalibrated(boolean calibrated) {
        this.calibrated = calibrated;
    }

    public void setTM(AbstractTableModel tm) {
        this.tm = tm;
    }

    public AbstractTableModel getTm() {
        return tm;
    }

    public Channel getCh() {
        return channel;
    }

    public void setCh(Channel ch) {
        this.channel = ch;
    }

// </editor-fold>

    public Attestation(Channel channel) {
        this.channel = channel;
    }

    public void start(int delay, int time, int col, JLabel sb) {
        this.column = col;
        thread = new Thread(new CalibrationTask(delay, time, this, sb));
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    public void setResult() {
        if (channel != null) {
            for (int i = 0; i < tm.getRowCount(); i++) {
                tm.setValueAt(channel.getResult(calibrated, i), i, column);
            }
        }
    }

    public void setResult(int i) {
        tm.setValueAt(channel.getResult(calibrated, i), i, column);
    }

    public void saveAttestationData(final CalibrationData data) {
        int result;

        try {
            connect();
            try {
                PreparedStatement delData = conn.prepareStatement("DELETE FROM ATT_RESULT "
                        + "WHERE CHANNEL=? and VALUE=?");

                delData.setInt(1, this.getCh().getChannel());
                delData.setDouble(2, data.getValue());
                result = delData.executeUpdate();
                delData.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            PreparedStatement saveData = conn.prepareStatement("INSERT INTO ATT_RESULT "
                    + "(CHANNEL, NUM, VALUE, RESULT) "
                    + "VALUES (?,?,?,?)");

            if (data.getDataCount() != 0) {
                for (int i = 0; i < data.getDataCount(); i++) {
                    saveData.setInt(1, this.getCh().getChannel());
                    saveData.setInt(2, i);
                    saveData.setDouble(3, data.getValue());
                    saveData.setDouble(4, data.getDataResult(i));
                    result = saveData.executeUpdate();
                    if (result == 0) {
                        conn.rollback();
                        JOptionPane.showMessageDialog(null, "Невозможно обновить базу данных");
                        return;
                    }
                }
                saveData.close();
                JOptionPane.showMessageDialog(null, "Данные успешно записаны в базу");
            }
        } catch (Exception e) {
            try {
                conn.rollback();
     
                JOptionPane.showMessageDialog(null, "Ошибка записи - база данных возвращена в исходное состояние");
                return;
            } catch (Exception ej) {
  
                JOptionPane.showMessageDialog(null, "Ошибка записи - состояние базы данных неизвестно");
                return;
            }
        }
        try {
            conn.commit();
            db.write();
        } catch (Exception e) {
            
        }
    }

    private void connect() {
        conn = db.connTo();
    }

    
}
