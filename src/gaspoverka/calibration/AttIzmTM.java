package gaspoverka.calibration;

import javax.swing.table.*;
import java.lang.Math.*;

public class AttIzmTM extends AbstractTableModel {

    public static final int Number_INDEX = 0;
    public static final int Value_INDEX = 1;
    public static final int Result_INDEX = 2;
    public static final int Medium_INDEX = 3;
    public static final int SysError_INDEX = 4;
    public static final int MSQR_INDEX = 5;
    public static final int RandError_INDEX = 6;
    public static final int RelError_INDEX = 7;
    protected String[] columnNames = {
        "№",
        "Измеряемая величина",
        "Результат измерения",
        "Усредненное значение результатов измерений",
        "Систематическая составляющая погрешности, %",
        "Среднее квадратическое отклонение",
        "Случайная составляющая погрешность",
        "Относительная погрешность",};
    protected CalibrationData data;
   
    public AttIzmTM(CalibrationData data) {
        this.data = data;
        //data.set();
    }

    public CalibrationData getData() {
        return data;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
   
    @Override
    public Class getColumnClass(int col) {
        switch (col) {
            case Number_INDEX:
                return Integer.class;
            default:
                return Double.class;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case Number_INDEX:
                return row+1;
            case Value_INDEX:
                return data.getValue();
            case Result_INDEX:
                return data.getDataResult(row);
            case Medium_INDEX:
                return data.getMedium();
            case SysError_INDEX:
                return data.getSysError();
            case MSQR_INDEX:
                return data.getMSQR();
            case RandError_INDEX:
                return data.getRandError();
            case RelError_INDEX:
                return data.getRelError();
            default:
                return new Object();
        }

    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        switch (col) {
            case Value_INDEX:
                data.setValue(Double.parseDouble(value.toString()));
                break;
            case Result_INDEX:
                data.setResult(Double.parseDouble(value.toString()), row);
                break;
        }
        this.fireTableCellUpdated(row, col);
    }

    @Override
    public int getRowCount() {
        return data.getDataCount();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}