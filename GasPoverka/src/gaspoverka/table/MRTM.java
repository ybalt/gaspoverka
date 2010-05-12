package gaspoverka.table;

import gaspoverka.data.*;
import javax.swing.table.*;
import java.util.*;

public class MRTM extends AbstractTableModel {

    public static final int MRH_INDEX = 0;
    public static final int MRL_INDEX = 1;
    public static final int Error_INDEX = 2;
    protected String[] columnNames = {"ДИ.Н", "ДИ.В", "Погр"};
    boolean edit = false;
    Vector dataVector;

    public MRTM() {
        dataVector = new Vector();
        Vector row = new Vector();
        row.add(Double.valueOf("0"));
        row.add(Double.valueOf("0"));
        row.add(Double.valueOf("0"));
        dataVector.add(row);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void reload(MeasureRange mr) {
        dataVector.clear();
        for (int i = 0; i < mr.getNum(); i++) {
            Vector row = new Vector();
            row.add(mr.getMRL(i));
            row.add(mr.getMRH(i));
            row.add(mr.getError(i));
            dataVector.add(row);
        }
        fireTableChanged(null);
        edit = false;
    }

    public void updateData(MeasureRange mr) {
        mr.setNum(dataVector.size());
        for (int i = 0; i < dataVector.size(); i++) {
            mr.setNumber(i, i);
            mr.setMRL(i, (Double) ((Vector) dataVector.get(i)).get(0));
            mr.setMRH(i, (Double) ((Vector) dataVector.get(i)).get(1));
            mr.setError(i, (Double) ((Vector) dataVector.get(i)).get(2));
        }
        edit = false;
    }

    public void setMRRow(int i) {
        if (edit) {
            dataVector.clear();
            for (int j = 0; j < i; j++) {
                Vector row = new Vector();
                row.add(Double.valueOf("0"));
                row.add(Double.valueOf("0"));
                row.add(Double.valueOf("0"));
                dataVector.add(row);
            }
        }

        fireTableChanged(null);
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case MRH_INDEX:
            case MRL_INDEX:
            case Error_INDEX:
                return Double.class;
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


