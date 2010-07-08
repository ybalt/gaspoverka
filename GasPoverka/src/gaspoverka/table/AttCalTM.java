package gaspoverka.table;

import gaspoverka.data.config.Point;
import java.util.*;
import javax.swing.table.*;

public class AttCalTM extends AbstractTableModel {

    public static final int Point_INDEX = 0;
    public static final int X_INDEX = 1;
    public static final int Y_INDEX = 2;
    public static final int Ys_INDEX = 3;
    protected String[] columnNamesInitial = {"Точка", "Эталон", "Измерено", "Поправка"};
    protected String[] columnNames;
    protected Vector<Point> dataVector;

    public AttCalTM() {
        columnNames = columnNamesInitial;
    }

    public void setData(Vector<Point> vector) {
        dataVector = vector;
        fireTableChanged(null);
    }

    public void addRow() {
        int i;
        if (dataVector.size() == 0) {
            i = 1;
        } else {
            i = dataVector.lastElement().getPoint() + 1;
        }
        Point p = new Point(i);
        dataVector.add(p);
        fireTableChanged(null);
    }

    public void clear() {
        dataVector.clear();
        fireTableChanged(null);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setRows(int type, String post) {
        for (int i = 1; i < 5; i++) {
            columnNames[i] = columnNamesInitial[i] + ", " + post;
        }
        dataVector.clear();
        char[] alphabet = new char[6];
        for (char c = 'A'; c <= 'F'; ++c) {
            alphabet[c - 'A'] = c;
        }
        for (int i = 0; i < type; i++) {
            //calculator row = new calculator(String.valueOf(alphabet[i]));
            //dataVector.add(row);
        }
        fireTableChanged(null);
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        switch (col) {
            case Point_INDEX:
                dataVector.get(row).setPoint(Integer.parseInt(value.toString()));
                break;
            case X_INDEX:
                dataVector.get(row).setX(Double.parseDouble(value.toString()));
                break;
            case Y_INDEX:
                dataVector.get(row).setY(Double.parseDouble(value.toString()));
                break;
            case Ys_INDEX:
                dataVector.get(row).setYS(Double.parseDouble(value.toString()));
                break;

        }
        fireTableChanged(null);
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case Point_INDEX:
                return Integer.class;
            default:
                return Double.class;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case Point_INDEX:
                return dataVector.get(row).getPoint();
            case X_INDEX:
                return dataVector.get(row).getX();
            case Y_INDEX:
                return dataVector.get(row).getY();
            case Ys_INDEX:
                return dataVector.get(row).getYS();
            default:
                return new Object();
        }
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
        switch (col) {
            case Point_INDEX:
                return false;
            default:
                return true;
        }
    }
}
