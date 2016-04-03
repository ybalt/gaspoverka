package gaspoverka.table;

import gaspoverka.poverka.Poverka;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.sql.Date;

public class ReportTM  extends AbstractTableModel {

    public static final int Povnum_INDEX = 0;
    public static final int Type_INDEX = 1;
    public static final int Devnum_INDEX = 2;
    public static final int Owner_INDEX = 3;
    public static final int Executor_INDEX = 4;
    public static final int Date_INDEX = 5;
    protected String[] columnNames = {"№ поверки", "Тип", "Номер устройства", "Владелец", "Исполнитель", "Дата"};
    public List<Poverka> pov;


    public ReportTM(List<Poverka> pov) {
        this.pov = pov;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case Povnum_INDEX:
                return Long.class;
            case Type_INDEX:
            case Devnum_INDEX:
            case Owner_INDEX:
            case Executor_INDEX:
                return String.class;
            case Date_INDEX:
                return Date.class;
            default:
                return Object.class;
        }

    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
           case Povnum_INDEX:
                return pov.get(row).getPovNum();
            case Type_INDEX:
                return pov.get(row).getType();
            case Devnum_INDEX:
                return pov.get(row).getDevNum();
            case Owner_INDEX:
                return pov.get(row).getOwner();
            case Executor_INDEX:
                return pov.get(row).getExec();
            case Date_INDEX:
                return pov.get(row).getNow();
            default:
                return Object.class;
        }
    }

    @Override
    public int getRowCount() {
        return pov.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
            return false;
    }


}
