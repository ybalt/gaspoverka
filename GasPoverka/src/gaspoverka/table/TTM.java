package gaspoverka.table;

import gaspoverka.data.*;
import javax.swing.table.*;
import java.util.*;

public class TTM extends AbstractTableModel {

    public static final int Number_INDEX = 0;
    public static final int VL_INDEX = 1;
    public static final int VH_INDEX = 2;
    public static final int Error_INDEX = 3;
    protected String[] columnNames;
    boolean edit = false;
    Vector<T> devT;

    public TTM(Vector<T> t, String[] columnNames) {
        this.columnNames = columnNames;
        this.devT = t;
    }

    public void setDev(Vector<T> t) {
        this.devT = t;
        refresh();
    }

    public void setRow(int newnum) {
        int lastnum;
        if (devT.size() > 0) {
            lastnum = devT.get(devT.size() - 1).getNumber();
        } else {
            lastnum = 0;
        }
        if (newnum > lastnum) {
            devT.add(new T());
            devT.lastElement().setNumber(newnum);
        }
        if ((newnum < lastnum) && (lastnum != 0)) {
            devT.removeElementAt(devT.size() - 1);
        }
        refresh();

    }

    public void refresh() {
        fireTableChanged(null);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case Number_INDEX:
                return Integer.class;
            case VL_INDEX:
            case VH_INDEX:
            case Error_INDEX:
                return Double.class;
            default:
                return Object.class;
        }

    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case Number_INDEX:
                return devT.get(row).getNumber();
            case VL_INDEX:
                return devT.get(row).getVL();
            case VH_INDEX:
                return devT.get(row).getVH();
            case Error_INDEX:
                return devT.get(row).getError();
            default:
                return Object.class;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
         switch (col) {
            case Number_INDEX:
                devT.get(row).setNumber(Integer.valueOf(value.toString()));
                break;
            case VL_INDEX:
                devT.get(row).setVL(Double.valueOf(value.toString()));
                break;
            case VH_INDEX:
                devT.get(row).setVH(Double.valueOf(value.toString()));
                break;
            case Error_INDEX:
                devT.get(row).setError(Double.valueOf(value.toString()));
                break;
        }
         refresh();
    }

    @Override
    public int getRowCount() {
        return devT.size();
    }

    @Override
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
