package gaspoverka.table;

import gaspoverka.data.*;
import javax.swing.table.*;
import java.util.*;

public class KPTM extends AbstractTableModel {

    public static final int KP_INDEX = 0;
    public static final int ValueL_INDEX = 1;
    public static final int ValueH_INDEX = 2;
    public static final int Error_INDEX = 3;
    protected String[] columnNames = {"КТ", "Зн.Н", "Зн.В", "Погр."};
    boolean edit = false;
    Vector dataVector;

    public KPTM() {
        dataVector = new Vector();
        Vector row = new Vector();
        row.add(Integer.valueOf(0));
        row.add(Float.valueOf(0));
        row.add(Float.valueOf(0));
        row.add(Float.valueOf(0));
        dataVector.add(row);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void reload(CountersKP kp) {
        dataVector.clear();
        for (int i = 0; i < kp.getNum(); i++) {
            Vector row = new Vector();
            row.add(kp.getKP(i));
            row.add(kp.getValueL(i));
            row.add(kp.getValueH(i));
            row.add(kp.getError(i));
            dataVector.add(row);
        }
        fireTableChanged(null);
        edit = false;
    }

    public void updateData(CountersKP kp) {
        kp.setNum(dataVector.size());
        for (int i = 0; i < dataVector.size(); i++) {
            kp.setKP(i,
                    (Integer) ((Vector) dataVector.get(i)).get(0),
                    (Float) ((Vector) dataVector.get(i)).get(1),
                    (Float) ((Vector) dataVector.get(i)).get(2),
                    (Float) ((Vector) dataVector.get(i)).get(3));
        }
        edit = false;
    }

    public void setMRRow(int i) {
        if (edit) {
            dataVector.clear();
            for (int j = 0; j < i; j++) {
                Vector row = new Vector();
                row.add(Integer.valueOf(0));
                row.add(Float.valueOf(0));
                row.add(Float.valueOf(0));
                row.add(Float.valueOf(0));
                dataVector.add(row);
            }
        }

        fireTableChanged(null);
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case KP_INDEX:
                return Integer.class;
            case ValueL_INDEX:
            case ValueH_INDEX:
            case Error_INDEX:
                return Float.class;
            default:
                return Object.class;
        }

    }

    public Object getValueAt(int row, int col) {
        return ((Vector) dataVector.get(row)).get(col);
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        ((Vector) dataVector.get(row)).set(col, value);
        fireTableChanged(null);
    }

    public int getRowCount() {
        return dataVector.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if (!edit) {
            return false;
        } else {
            return true;
        }
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
        fireTableChanged(null);
    }
}
