package gaspoverka.table;


import java.util.*;
import gaspoverka.db.*;
import javax.swing.table.*;



public class ReferenceTM extends AbstractTableModel {
    private ReferenceDB db;
    public static final int Type_INDEX = 0;
    public static final int Channel_INDEX = 1;
    public static final int UD_INDEX = 2;
    public static final int PL_INDEX = 3;
    public static final int IC_INDEX = 4;
    public static final int MIC_INDEX = 5;
    protected String[] columnNames = {"Тип", "Канал", "Усл.диаметр", "Потеря давл.", "Коэф. передачи", "Мин. число имп."};
    protected Vector dataVector;

    public ReferenceTM() {
        this.db = new ReferenceDB();
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
                return Integer.class;
            case UD_INDEX:
            case PL_INDEX:
            case IC_INDEX:
            case MIC_INDEX:
                return Double.class;
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
