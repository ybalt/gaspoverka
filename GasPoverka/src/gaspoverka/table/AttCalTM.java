package gaspoverka.table;

import gaspoverka.data.config.Point;
import java.util.*;
import javax.swing.table.*;
import java.math.*;
import gaspoverka.data.*;

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

    /*
    public String ur1(int i) {
        int decimalPlace = 4;
        BigDecimal k = new BigDecimal(dataVector.get(i).getK1());
        BigDecimal b = new BigDecimal(dataVector.get(i).getB1());
        k = k.setScale(decimalPlace, BigDecimal.ROUND_UP);
        b = b.setScale(decimalPlace, BigDecimal.ROUND_UP);

        String ur = "y=x*"
                + k
                + "+"
                + b;
        return ur;

    }

    public String ur2(int i) {
        int decimalPlace = 4;
        BigDecimal k = new BigDecimal(dataVector.get(i).getK2());
        BigDecimal b = new BigDecimal(dataVector.get(i).getB2());
        k.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        b.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        String ur = "y=x*"
                + k
                + "+"
                + b;
        return ur;
    }

    */
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
/*
    public void set() {
        for (int i = 0; i < dataVector.size() - 1; i++) {
            Point A = dataVector.get(i);
            Point B = dataVector.get(i + 1);
            try {
                //y=x*(F1/F4)-(F2/F4)+(F3/F4)
                //y=kx+b
                double F1 = B.getY() - A.getY();
                double F2 = A.getX() * B.getY();
                double F3 = B.getX() * A.getY();
                double F4 = B.getX() - A.getX();
                A.setK1(F1 / F4);
                A.setK2((-F2 + F3) / F4);
                //                //
                double G1 = B.getYS() - A.getYS();
                double G2 = A.getY() * B.getYS();
                double G3 = B.getY() * A.getYS();
                double G4 = B.getY() - A.getY();
                A.setK2(G1 / G4);
                A.setB2((-G2 + G3) / G4);

            } catch (Exception e) {
            }
        }
        fireTableChanged(null);
    }
*/
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
