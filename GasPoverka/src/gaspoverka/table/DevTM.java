package gaspoverka.table;

import java.util.*;
import gaspoverka.data.*;
import javax.swing.table.*;

public class DevTM extends AbstractTableModel {

    public static final int Type_INDEX = 0;
    public static final int Channel_INDEX = 1;
    public static final int UD_INDEX = 2;
    public static final int PL_INDEX = 3;
    public static final int IC_INDEX = 4;
    public static final int MIC_INDEX = 5;
    protected String[] columnNames = {"Тип", "Канал", "Усл.диаметр", "Потеря давл.", "Коэф. передачи", "Мин.кол.имп"};
    Vector<Dev> dataVector;
    int editRow = -1;

    public DevTM(Vector<Dev> dataVector) {
        this.dataVector = dataVector;
    }

    public void refresh(Vector<Dev> dataVector) {
        this.dataVector = dataVector;
        fireTableChanged(null);
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case Type_INDEX:
                return String.class;
            case Channel_INDEX:
            case UD_INDEX:
            case PL_INDEX:
            case IC_INDEX:
            case MIC_INDEX:
                return Integer.class;
            default:
                return Object.class;
        }

    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case Type_INDEX:
                return dataVector.get(row).getType();
            case Channel_INDEX:
                return dataVector.get(row).getChannel();
            case UD_INDEX:
                return dataVector.get(row).getUD();
            case PL_INDEX:
                return dataVector.get(row).getPL();
            case IC_INDEX:
                return dataVector.get(row).getIC();
            case MIC_INDEX:
                return dataVector.get(row).getMIC();
            default:
                return Object.class;
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
    public void setValueAt(Object value, int row, int col) {
        switch (col) {
            case Type_INDEX:
                dataVector.get(row).setType(String.valueOf(value));
                break;
            case Channel_INDEX:
                dataVector.get(row).setChannel(Integer.valueOf(value.toString()));
                break;
            case UD_INDEX:
                dataVector.get(row).setUD(Integer.valueOf(value.toString()));
                break;
            case PL_INDEX:
                dataVector.get(row).setPL(Integer.valueOf(value.toString()));
                break;
            case IC_INDEX:
                dataVector.get(row).setIC(Integer.valueOf(value.toString()));
                break;
            case MIC_INDEX:
                dataVector.get(row).setMIC(Integer.valueOf(value.toString()));
                break;
        }
        fireTableChanged(null);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if (editRow == row) {
            return true;
        } else {
            return false;
        }
    }

    public void setRowEdit(int row) {
        editRow = row;
    }
}
