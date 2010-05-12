package gaspoverka.table;


import java.util.*;
import gaspoverka.db.*;
import javax.swing.table.*;


public class SensorsTM extends AbstractTableModel {
private SensorsDB db;
    public static final int Type_INDEX = 0;
    public static final int Channel_INDEX = 1;
    public static final int InfoOut_INDEX = 2;
    protected String[] columnNames = {"Тип", "Канал", "Инф.вывод"};
    protected Vector dataVector;

    public SensorsTM() {
        this.db = new SensorsDB();
        set();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void set() {
        this.dataVector = db.getTable();
        fireTableChanged(null); // notify everyone that we have a new table.
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case Type_INDEX:
                return String.class;
            case Channel_INDEX:
                return Integer.class;
            case InfoOut_INDEX:
                return String.class;
            default:
                return Object.class;
        }

    }

    public Object getValueAt(int row, int col) {
        return ((Vector) dataVector.get(row)).get(col);

    }

    public int getRowCount() {
        return dataVector.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
