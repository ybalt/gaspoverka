package gaspoverka;


import gaspoverka.calibration.CalibrationData;
import gaspoverka.util.Config;
import gaspoverka.util.DateTime;
import gaspoverka.util.Log;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.swing.JLabel;
import jxl.CellType;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
import jxl.write.WriteException;

public class AttToExcel {

    memDB db = memDB.getInstance();
    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    private static final String TEMPLATEFILE = ".//xls/att.xls";
    private String OUTFILE = ".//";
    
    private static Connection conn;
    private static Workbook template;
    private static WritableWorkbook wb;
    
    static final int[] CHANNELS = {11, 21, 31, 41, 12, 22, 32, 42, 43, 5};
    
    Config config = Config.getInstance();
    final HashMap<Integer, ArrayList> channelPoints;
    final HashMap<Integer, HashMap> channels;
    JLabel sb;

    public AttToExcel(JLabel sb) {
        this.sb = sb;
        channels = new HashMap<Integer, HashMap>();
        channelPoints = new HashMap<Integer, ArrayList>();
    }

    public boolean open() {
        try {
            if (config.getConfig().getProperty("out-dir") != null) {
                OUTFILE = config.getConfig().getProperty("out-dir");
            }
            OUTFILE = OUTFILE + "attestation" + "-" + DateTime.getCurrentTimeStamp()+".xls";
            template = Workbook.getWorkbook(new File(TEMPLATEFILE));
            wb = Workbook.createWorkbook(new File(OUTFILE), template);
        } catch (IOException e) {
            sb.setText("Ошибка " + e.getLocalizedMessage());
            LOG.info(e.getLocalizedMessage());
            return false;
        } catch (BiffException ex) {
            sb.setText("Ошибка " + ex.getLocalizedMessage());
            LOG.info(ex.getLocalizedMessage());
            return false;
        }
        return true;

    }

    public void populate() {
        try {
            sb.setText("Чтение шаблона");
            sb.repaint();
            if (open()) {
                sb.setText("Загрузка данных");
                sb.repaint();
                loadData();
                sb.setText("Формирование отчета");
                sb.repaint();
                fill();
                sb.setText("Сохранение файла в " + OUTFILE);
                sb.repaint();
                save();
            } else {
            }
        } catch (Exception e) {
            LOG.info(e.getLocalizedMessage());
        }
    }

    private void fill() {
        WritableSheet sh;
        WritableCell cell, cell1, cell2, cell3, cell4, cell5, cell6;
        try {
            for (Integer ch: channels.keySet()) {
                    HashMap channel = channels.get(ch);
                    for (Object point_num: channel.keySet()) {
                        CalibrationData point = (CalibrationData) channel.get(point_num);
                    sh = wb.getSheet(getSheetByCh(point.getChannel()));

                    if (sh != null) {
                        int pos = getPointNum(point.getChannel(),point.getValue());
                        cell = sh.getWritableCell(2 + pos, 4);
                        if (cell.getType() == CellType.NUMBER) {
                            Number val = (Number) cell;
                            val.setValue(point.getValue());
                        }
                        for (int n = 0; n < point.getDataCount(); n++) {
                            //get cell
                            cell = sh.getWritableCell(2 + pos, 5 + n);
                            //set cell
                            if (cell.getType() == CellType.NUMBER) {
                                Number val = (Number) cell;
                                val.setValue(point.getDataResult(n));
                            }
                        }
                        //errors
                        cell1 = sh.getWritableCell(2 + pos, 25);
                        cell2 = sh.getWritableCell(2 + pos, 26);
                        cell3 = sh.getWritableCell(2 + pos, 27);
                        cell4 = sh.getWritableCell(2 + pos, 28);
                        cell5 = sh.getWritableCell(2 + pos, 29);
                        if (cell1.getType() == CellType.NUMBER) {
                            Number val = (Number) cell1;
                            val.setValue(point.getMedium());
                        }
                        if (cell2.getType() == CellType.NUMBER) {
                            Number val = (Number) cell2;
                            val.setValue(point.getMSQR());
                        }
                        if (cell3.getType() == CellType.NUMBER) {
                            Number val = (Number) cell3;
                            val.setValue(point.getSysError());
                        }
                        if (cell4.getType() == CellType.NUMBER) {
                            Number val = (Number) cell4;
                            val.setValue(point.getRandError());
                        }
                        if (cell5.getType() == CellType.NUMBER) {
                            Number val = (Number) cell5;
                            val.setValue(point.getRelError());
                        }

                    }
                }
            }
        } catch (Exception e) {
            LOG.info(e.getLocalizedMessage());
        }
    }

    private String getSheetByCh(int ch) {
        switch (ch) {
            case 11:
                return "P2"; //ЛГЕ5 Р
            case 21:
                return "P3"; //ЛГЕ25 Р
            case 31:
                return "P4"; //ЛГЕ250 Р
            case 41:
                return "P5"; //поверяемый счетчик Р
            case 12:
                return "T2"; //ЛГЕ5 Т
            case 22:
                return "T3"; //ЛГЕ25 Т
            case 32:
                return "T4"; //ЛГЕ250 Т
            case 42:
                return "T5"; //поверяемый счетчик Т50
            case 43:
                return "T6"; //поверяемый счетчик Т80
            case 5:
                return "T7"; //окружение Т
            default:
                return null;
        }
    }

    private void getPoints() {
        try {
            ResultSet result;
            PreparedStatement chData = conn.prepareStatement("SELECT DISTINCT VALUE "
                    + "FROM ATT_RESULT "
                    + "WHERE CHANNEL=? ORDER BY VALUE ",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            channelPoints.clear();
            for (int i = 0; i < CHANNELS.length; i++) {
                chData.setInt(1, CHANNELS[i]);
                result = chData.executeQuery();
                ArrayList points = new ArrayList();
                result.beforeFirst();
                while (result.next()) {
                    points.add(result.getDouble(1));
                }
                channelPoints.put(CHANNELS[i], points);
            }
        } catch (Exception e) {
            LOG.info(e.getLocalizedMessage());
        }
    }

    private int getPointNum(int channel, double val) {
        return channelPoints.get(channel).indexOf(val);
    }

    private void save() {
        try {
            wb.write();
            wb.close();
        } catch (IOException e) {
            sb.setText("Ошибка ввода/вывода" + e.getMessage());
        } catch (WriteException e) {
            sb.setText("Ошибка записи" + e.getMessage());
        }
        sb.setText("Сохранено в файл " + OUTFILE);
    }

    private void loadData() {
        try {
            ResultSet result;
            connect();
            getPoints();
            PreparedStatement loadData = conn.prepareStatement("SELECT "
                    + "NUM, RESULT "
                    + "FROM ATT_RESULT "
                    + "WHERE CHANNEL=? AND VALUE=? ORDER BY NUM",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            //load data
            channels.clear();
            for (Integer channel: channelPoints.keySet()) {
                HashMap p = new HashMap();
                for(Object point: channelPoints.get(channel))       {
                    loadData.setInt(1, channel);
                    loadData.setDouble(2, (Double)point);
                    result = loadData.executeQuery();
                    result.beforeFirst();
                    if (result.next()) { 
                        result.beforeFirst();
                        CalibrationData cb = new CalibrationData();
                        cb.setChannel(channel);
                        cb.setValue((Double)point);
                        while (result.next()) { //point number
                            cb.add(1);
                            try {
                                cb.setResult(result.getDouble(2), result.getInt(1));
                            } catch (Exception e)
                            {
                                LOG.info(e.getLocalizedMessage());
                            }
                        }
                        System.out.println("channel " + channel + " point " + point + " numbers " + cb.getDataCount());
                        p.put(point, cb);
                    }
                    channels.put(channel,p);
                }
            }
            LOG.info("loaded " + channels.size() + " channels for attestation");
        } catch (Exception e) {
            LOG.info(e.getLocalizedMessage());
        }
    }

    private void connect() {
        conn = db.connFile();
    }

}
