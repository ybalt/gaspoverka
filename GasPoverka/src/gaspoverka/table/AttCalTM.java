package gaspoverka.table;

import java.util.*;
import javax.swing.table.*;
import java.math.*;
import gaspoverka.data.*;

public class AttCalTM extends AbstractTableModel {

    public static final int Point_INDEX = 0;
    public static final int X_INDEX = 1;
    public static final int Y_INDEX = 2;
    public static final int Xs_INDEX = 3;
    public static final int Ys_INDEX = 4;
    protected String[] columnNamesInitial = {"Точка", "Эталон", "Измерено", "Расчет", "Поправка"};
    protected String[] columnNames;
    protected Vector<calculator> dataVector;
    

    public AttCalTM() {
        dataVector = new Vector<calculator>();
        columnNames = new String[5];
        setRows(0, "");

    }

    private class calculator {

        private int channel;
        private String type;
        private double x;
        private double y;
        private double xs;
        private double ys;
        private Double k1, b1;
        private Double k2, b2;

        // <editor-fold defaultstate="collapsed" desc="get & set">
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getXs() {
            return xs;
        }

        public void setXs(double xs) {
            this.xs = xs;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getYs() {
            return ys;
        }

        public void setYs(double ys) {
            this.ys = ys;
        }

        public double getB1() {
            return b1;
        }

        public void setB1(double b1) {
            this.b1 = b1;
        }

        public double getB2() {
            return b2;
        }

        public void setB2(double b2) {
            this.b2 = b2;
        }

        public double getK1() {
            return k1;
        }

        public void setK1(double k1) {
            this.k1 = k1;
        }

        public double getK2() {
            return k2;
        }

        public void setK2(double k2) {
            this.k2 = k2;
        }

        // </editor-fold>
        public calculator(String type) {
            this.setType(type);
            this.setX(0);
            this.setY(0);
            this.setXs(0);
            this.setYs(0);
            this.setK1(0);
            this.setK2(0);
            this.setB1(0);
            this.setB2(0);

        }
        
    }

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

    public void save(){

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
            calculator row = new calculator(String.valueOf(alphabet[i]));
            dataVector.add(row);
        }
        fireTableChanged(null);
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        switch (col) {
            case Point_INDEX:
                dataVector.get(row).setType(value.toString());
                break;
            case X_INDEX:
                dataVector.get(row).setX(Double.parseDouble(value.toString()));
                break;
            case Y_INDEX:
                dataVector.get(row).setY(Double.parseDouble(value.toString()));
                break;
            case Xs_INDEX:
                dataVector.get(row).setXs(Double.parseDouble(value.toString()));
                break;
            case Ys_INDEX:
                dataVector.get(row).setYs(Double.parseDouble(value.toString()));
                break;

        }
        fireTableChanged(null);
    }

    public void set() {
        for (int i = 0; i < dataVector.size() - 1; i++) {
            calculator A = dataVector.get(i);
            calculator B = dataVector.get(i + 1);
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
                double G1 = B.getYs() - A.getYs();
                double G2 = A.getY() * B.getYs();
                double G3 = B.getY() * A.getYs();
                double G4 = B.getY() - A.getY();
                A.setK2(G1 / G4);
                A.setB2((-G2 + G3) / G4);

            } catch (Exception e) {
            }
        }
        fireTableChanged(null);
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case Point_INDEX:
                return String.class;
            default:
                return Double.class;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case Point_INDEX:
                return dataVector.get(row).getType();
            case X_INDEX:
                return dataVector.get(row).getX();
            case Y_INDEX:
                return dataVector.get(row).getY();
            case Xs_INDEX:
                return dataVector.get(row).getXs();
            case Ys_INDEX:
                return dataVector.get(row).getYs();
            default:
                return new Object();
        }
    }

    public double getX(int point) {
        try {
            return dataVector.get(point).getX();
        } catch (Exception e) {
            return 0;
        }
    }

    public double getY(int point){
        try {
            return dataVector.get(point).getY();
        } catch (Exception e) {
            return 0;
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
