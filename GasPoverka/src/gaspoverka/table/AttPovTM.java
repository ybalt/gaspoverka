package gaspoverka.table;

import java.util.*;
import javax.swing.table.*;
import java.lang.Math.*;

public class AttPovTM extends AbstractTableModel {

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
    protected Vector<calculator> dataVector;
    double Value = 0;
    double Medium = 0;
    double SysError = 0;
    double MSQR = 0;
    double RandError = 0;
    double RelError = 0;

    private class calculator {

        private int Number;
        private double Result;

        public int getNumber() {
            return Number;
        }

        public void setNumber(int Number) {
            this.Number = Number;
        }

        public double getResult() {
            return Result;
        }

        public void setResult(double Result) {
            this.Result = Result;
        }

        public calculator(int num) {
            this.setNumber(num);
            this.setResult(0);
        }
    }

    public AttPovTM() {
        dataVector = new Vector();
        set();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setRow() {
        for (int i =0;i<20;i++) {
        dataVector.add(new calculator(i+1));}
        set();
    }

    public void clear() {
        dataVector.clear();
        set();
    }

    public void set() {
        Medium = 0;
        SysError = 0;
        MSQR = 0;
        RandError = 0;
        RelError = 0;

        double median = 0;
        double sum = 0;
        double Student = 2.094;

        for (int i = 0; i < dataVector.size(); i++) {
            calculator A = dataVector.get(i);
            median = median + A.getResult();
        }

        Medium = median / dataVector.size();

        SysError = ((Medium / Value) - 1) * 100;

        for (int i = 0; i < dataVector.size(); i++) {
            calculator A = dataVector.get(i);
            sum = sum + ((A.getResult() - Medium) * (A.getResult() - Medium));
        }
        MSQR = java.lang.Math.sqrt(sum/(dataVector.size()-1));
        RandError = Student*(MSQR/Medium)*100;
        RelError = SysError + RandError;
        fireTableChanged(null);
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
                return dataVector.get(row).getNumber();
            case Value_INDEX:
                return Value;
            case Result_INDEX:
                return dataVector.get(row).getResult();
            case Medium_INDEX:
                return Medium;
            case SysError_INDEX:
                return SysError;
            case MSQR_INDEX:
                return MSQR;
            case RandError_INDEX:
                return RandError;
            case RelError_INDEX:
                return RelError;
            default:
                return new Object();
        }

    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        switch (col) {
            case Number_INDEX:
                dataVector.get(row).setNumber(Integer.parseInt(value.toString()));
                break;
            case Value_INDEX:
                Value = Double.parseDouble(value.toString());
                break;
            case Result_INDEX:
                dataVector.get(row).setResult(Double.parseDouble(value.toString()));
                break;
        }
        fireTableChanged(null);
    }

    @Override
    public int getRowCount() {
        return dataVector.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }
}
