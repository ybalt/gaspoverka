package gaspoverka.table;


import java.util.*;
import gaspoverka.db.*;
import javax.swing.table.*;

public class CounterTM extends AbstractTableModel {

    private CountersDB db;
    public static final int Type_INDEX = 0;
    public static final int Channel_INDEX = 1;
    public static final int UDiameter_INDEX = 2;
    public static final int PressureLeak_INDEX = 3;
    public static final int ImpulseCount_INDEX = 4;
    protected String[] columnNames = {"Тип", "Канал", "Усл.диаметр", "Потеря давл.", "Коэф. передачи"};
    protected Vector dataVector;

    public CounterTM() {
        this.db = new CountersDB();
        set();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void set() {
        dataVector = db.getTable();
        fireTableChanged(null); 
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case Type_INDEX:
                return String.class;
            case Channel_INDEX:
            case UDiameter_INDEX:
            case PressureLeak_INDEX:
            case ImpulseCount_INDEX:
                return Integer.class;
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
