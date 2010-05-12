package gaspoverka.table;

import java.util.*;
import javax.swing.table.*;

public class PovPovDataTM extends AbstractTableModel {

    public static final int BUTTON = 0;
    public static final int GR_INDEX = 1;
    public static final int PR_INDEX = 2;
    public static final int TR_INDEX = 3;
    public static final int VR_INDEX = 4;
    public static final int VRpr_INDEX = 5;
    public static final int GC_INDEX = 6;
    public static final int PC_INDEX = 7;
    public static final int TC_INDEX = 8;
    public static final int VC_INDEX = 9;
    public static final int VCpr_INDEX = 10;
    public static final int Error_INDEX = 11;
    protected String[] columnNames = {"KP", "G м3/ч", "P кПа", "T С°", "V м3", "Vпр м3",
        "G м3/ч", "P кПа", "T С°", "V м3", "Vпр м3", "δ %"};
    protected Vector dataVector;

    public PovPovDataTM() {
        dataVector = new Vector();
        addRows();

    }

    public void recalc() {
        // GR = (float)((Vector) dataVector.get(0)).get(0);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void addRows() {
        for (int j = 0; j < 15; j++) {
            Vector row = new Vector();
            row.add(Integer.valueOf((j/3)+1));
            for (int i = 1; i < 12; i++) {
                row.add(Float.valueOf("0"));
            }
            dataVector.add(row);
        }
        set();
    }

    public void delRow() {
        if (dataVector.size() > 0) {
            dataVector.remove(dataVector.size() - 1);
            set();
        }
    }

    public void set() {
        fireTableChanged(null);
    }

    @Override
    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
        //return Float.class;
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
        switch (col) {
            case VRpr_INDEX:
            case VCpr_INDEX:
            case Error_INDEX:
                return false;
            default:
                return true;
        }

    }
}
