package gaspoverka;

import gaspoverka.calibration.CalibrationData;
import gaspoverka.util.Config;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import jxl.CellType;
import jxl.Workbook;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;

public class AttToExcel {

    memDB db = memDB.getInstance();
    private static final String template_file = ".//xls/att.xls";
    String out_file = ".//";
    private static Connection conn;
    private static Workbook template;
    private static WritableWorkbook wb;
    static int[] Pch = {11, 21, 31, 41};
    static int[] Tch = {12, 22, 32, 42, 43, 5};
    ArrayList<Double> Pval, Tval;
    Vector<CalibrationData> channels;
    Config config = Config.getInstance();
    JLabel sb;

    public AttToExcel(JLabel sb) {
        this.sb = sb;
        Pval = new ArrayList<Double>();
        Tval = new ArrayList<Double>();

        channels = new Vector<CalibrationData>();
    }

    public boolean open() {
        try {
            if (config.getConfig().getProperty("out-dir") != null) {
                out_file = config.getConfig().getProperty("out-dir");
            }
            out_file = out_file + "attestation.xls";
            template = Workbook.getWorkbook(new File(template_file));
            wb = Workbook.createWorkbook(new File(out_file), template);
        } catch (Exception e) {
            sb.setText("Ошибка " + e.getMessage());
            return false;
        }
        return true;

    }

    public void populate() {
        try {
             sb.setText("Чтение шаблона");
             sb.repaint();
            //dialog.setLabel.repaint();
            if (open()) {
                sb.setText("Загрузка данных");
                loadData();
                sb.setText("Формирование отчета");
                fill();
                sb.setText("Сохранение файла в " + out_file);
                save();
            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fill() {
        WritableSheet sh;
        WritableCell cell, cell1, cell2, cell3, cell4, cell5, cell6;
        try {
            for (int i = 0; i < channels.size(); i++) {
                if (channels.get(i) != null) {
                    sh = wb.getSheet(getSheetByCh(channels.get(i).getChannel()));

                    if (sh != null) {
                        cell = sh.getWritableCell(2 + getRowByVal(channels.get(i).getValue()), 4);
                        if (cell.getType() == CellType.NUMBER) {
                                Number val = (Number) cell;
                                val.setValue(channels.get(i).getValue());
                            }
                        for (int n = 0; n < channels.get(i).getDataCount(); n++) {
                            //get cell
                            cell = sh.getWritableCell(2 + getRowByVal(channels.get(i).getValue()), 5 + n);
                            //set cell
                            if (cell.getType() == CellType.NUMBER) {
                                Number val = (Number) cell;
                                val.setValue(channels.get(i).getDataResult(n));
                            }
                        }
                        //errors
                        cell1 = sh.getWritableCell(2 + getRowByVal(channels.get(i).getValue()), 25);
                        cell2 = sh.getWritableCell(2 + getRowByVal(channels.get(i).getValue()), 26);
                        cell3 = sh.getWritableCell(2 + getRowByVal(channels.get(i).getValue()), 27);
                        cell4 = sh.getWritableCell(2 + getRowByVal(channels.get(i).getValue()), 28);
                        cell5 = sh.getWritableCell(2 + getRowByVal(channels.get(i).getValue()), 29);
                        if (cell1.getType() == CellType.NUMBER) {
                            Number val = (Number) cell1;
                            val.setValue(channels.get(i).getMedium());
                        }
                        if (cell2.getType() == CellType.NUMBER) {
                            Number val = (Number) cell2;
                            val.setValue(channels.get(i).getMSQR());
                        }
                        if (cell3.getType() == CellType.NUMBER) {
                            Number val = (Number) cell3;
                            val.setValue(channels.get(i).getSysError());
                        }
                        if (cell4.getType() == CellType.NUMBER) {
                            Number val = (Number) cell4;
                            val.setValue(channels.get(i).getRandError());
                        }
                        if (cell5.getType() == CellType.NUMBER) {
                            Number val = (Number) cell5;
                            val.setValue(channels.get(i).getRelError());
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getSheetByCh(int ch) {
        switch (ch) {
            case 11:
                return "P2";
            case 21:
                return "P3";
            case 31:
                return "P4";
            case 41:
                return "P5";
            case 12:
                return "T2";
            case 22:
                return "T3";
            case 32:
                return "T4";
            case 42:
                return "T5";
            case 43:
                return "T6";
            case 5:
                return "T7";
            default:
                return null;
        }
    }

    private void getRows() {
        ResultSet result = null;

        try {
            final String sql = "SELECT DISTINCT VALUE "
                    + "FROM ATT_RESULT "
                    + "ORDER BY VALUE ";
            Statement load = conn.createStatement();
            result = load.executeQuery(sql);
            //int p = 0, t = 0;
            //get values
            while (result.next()) {
                if (result.getDouble(1) > 50) {
                    Pval.add(result.getDouble(1));
                } else {
                    Tval.add(result.getDouble(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getRowByVal(double val) {
        if (val > 50) {
            return Pval.indexOf(val);
        } else {
            return Tval.indexOf(val);
        }
    }

    private void save() {
        try {
            wb.write();
            wb.close();
        } catch (Exception e) {
             sb.setText("Ошибка " + e.getMessage());
        }
        sb.setText("Сохранено в файл " + out_file);
    }

    private void loadData() {
        ResultSet result = null;

        try {
            connect();
            getRows();
            PreparedStatement loadData = conn.prepareStatement("SELECT "
                    + "CHANNEL, NUM, VALUE, RESULT "
                    + "FROM ATT_RESULT "
                    + "WHERE CHANNEL=? AND VALUE=? ORDER BY NUM",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            //load P
            for (int ch = 0; ch < Pch.length; ch++) {
                for (int val = 0; val < Pval.size(); val++) {
                    loadData.setInt(1, Pch[ch]);
                    loadData.setDouble(2, Pval.get(val));
                    result = loadData.executeQuery();
                    result.beforeFirst();
                    if (result.next()) {
                        result.beforeFirst();
                        this.channels.add(new CalibrationData());
                        this.channels.lastElement().setChannel(Pch[ch]);
                        this.channels.lastElement().setValue(Pval.get(val));
                        while (result.next()) {
                            this.channels.lastElement().add(1);
                            this.channels.lastElement().setResult(result.getDouble(4), result.getInt(2));
                        }
                        this.channels.lastElement().set();
                    }
                }
            }
            //load  T
            for (int ch = 0; ch < Tch.length; ch++) {
                for (int val = 0; val < Tval.size(); val++) {
                    loadData.setInt(1, Tch[ch]);
                    loadData.setDouble(2, Tval.get(val));
                    result = loadData.executeQuery();
                    result.beforeFirst();
                    if (result.next()) {
                        result.beforeFirst();
                        this.channels.add(new CalibrationData());
                        this.channels.lastElement().setChannel(Tch[ch]);
                        this.channels.lastElement().setValue(Tval.get(val));
                        while (result.next()) {
                            this.channels.lastElement().add(1);
                            this.channels.lastElement().setResult(result.getDouble(4), result.getInt(2));
                        }
                        this.channels.lastElement().set();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    private void connect() {
       conn = db.connFile();
    }
 
}


