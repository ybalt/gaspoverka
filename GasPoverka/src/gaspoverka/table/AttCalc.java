package gaspoverka.table;

import java.util.*;
import javax.swing.table.*;

public class AttCalc extends AbstractTableModel {

    public static final int Point_INDEX = 0;
    public static final int X_INDEX = 1;
    public static final int Y_INDEX = 2;
    public static final int Xs_INDEX = 3;
    public static final int Ys_INDEX = 4;
    protected String[] columnNames = {"Точка", "X", "Y", "X'", "Y'"};
    protected Vector<calculator> dataVector;

    public AttCalc() {
        dataVector = new Vector();
    }

    private class calculator {

        private String type;
        private float x;
        private float y;
        private float xs;
        private float ys;

        // <editor-fold defaultstate="collapsed" desc="get & set">
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getXs() {
            return xs;
        }

        public void setXs(float xs) {
            this.xs = xs;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public float getYs() {
            return ys;
        }

        public void setYs(float ys) {
            this.ys = ys;
        }// </editor-fold>

        public calculator(String type) {
            this.setType(type);
            this.setX(0);
            this.setY(0);
            this.setXs(0);
            this.setYs(0);
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setRows(int type) {
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
                dataVector.get(row).setX(Float.parseFloat(value.toString()));
                break;
            case Y_INDEX:
                dataVector.get(row).setY(Float.parseFloat(value.toString()));
                break;
            case Xs_INDEX:
                dataVector.get(row).setXs(Float.parseFloat(value.toString()));
                break;
            case Ys_INDEX:
                dataVector.get(row).setYs(Float.parseFloat(value.toString()));
                break;

        }
        //((Vector) dataVector.get(row)).set(col, value);
        fireTableChanged(null);
    }

    public void set() {
        for (int i = 0; i < dataVector.size() - 1; i++) {
            calculator A = dataVector.get(i);
            calculator B = dataVector.get(i + 1);
            try {
                //y=x*(F1/F4)-(F2/F4)+(F3/F4)
                //y=kx+b
                float F1 = B.getY() - A.getY();
                float F2 = A.getX() * B.getY();
                float F3 = B.getX() * A.getY();
                float F4 = B.getX() - A.getY();
                float k1 = F1 / F4;
                float b1 = (F3 / F4) - (F2 / F4);

                float G1 = B.getYs() - A.getYs();
                float G2 = A.getY() * B.getYs();
                float G3 = B.getY() * A.getYs();
                float G4 = B.getY() - A.getY();
                float k2 = G1 / G4;
                float b2 = (G3 / G4) - (G2 / G4);
                A.setXs(b2);
            } catch (Exception e) {
                A.setXs(0);
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
                return Float.class;
        }
    }

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
        //return ((Vector) dataVector.get(row)).get(col);

    }

    public int getRowCount() {
        return dataVector.size();
    }

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
