package gaspoverka.calibration;

import gaspoverka.util.Channel;
import javax.swing.table.AbstractTableModel;

public class AttACalTM extends AbstractTableModel {
    
    public static final int Point_INDEX = 0;
    public static final int A_INDEX = 1;
    protected String[] columnNamesInitial = {"Коэффициент", "Значение"};
    protected String[] columnNames;
    protected String ANames[] = {"A-2", "A-1", "A0", "A1", "A2"};
    protected Channel ch;

    public AttACalTM() {
        columnNames = columnNamesInitial;
    }

    public void setDataVector(Channel ch) {
        this.ch = ch;
        fireTableChanged(null);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        switch (col) {
            case A_INDEX:
            ch.getCalData().getA0Points()[row] = Double.valueOf(value.toString());
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
                return ANames[row];
            case A_INDEX:
                return ch.getCalData().getA0Points()[row];
            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount() {
        return ch.getCalData().getA0Points().length;
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
