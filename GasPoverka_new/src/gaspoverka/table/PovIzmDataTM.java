package gaspoverka.table;

import javax.swing.table.*;
import gaspoverka.data.result.*;

public class PovIzmDataTM extends AbstractTableModel {

    public static final int N_INDEX = 0;
    public static final int RV_INDEX = 1;
    public static final int RP_INDEX = 2;
    public static final int RT_INDEX = 3;
    public static final int RVpr_INDEX = 4;
    public static final int CV_INDEX = 5;
    public static final int CP_INDEX = 6;
    public static final int CT_INDEX = 7;
    public static final int CVpr_INDEX = 8;
    public static final int Err_INDEX = 9;
    public static final int DErr_INDEX = 10;
    protected String[] columnNames = {"№", "V м3/ч", "P кПа", "T С°", "Vпр м3",
        "V м3/ч", "P кПа", "T С°", "Vпр м3", "δ %", "δд %"};
    protected Result data;

    public PovIzmDataTM(Result data) {
        this.data = data;
        set();
    }

    public void flush() {
    }

    public void recalc() {
    }

    public void addRow() {
        int i;
        if (data.getData().size() == 0) {
            i = 0;
        } else {
            i = data.getData().lastElement().getMeasureNum();
        }
        data.getData().add(new Izm());
        data.getData().lastElement().setMeasureNum(i + 1);
        set();
    }

    public void delRow() {
        if (data.getData().size()>0) {
            data.getData().remove(data.getData().size()-1);
        }
        set();
    }

    public void set() {
        fireTableChanged(null);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case N_INDEX:
                return Integer.class;
            default:
                return Double.class;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case N_INDEX:
                return data.getData().get(row).getMeasureNum();

            case RV_INDEX:
                return data.getData().get(row).getRV();
            case RP_INDEX:
                return data.getData().get(row).getRP();
            case RT_INDEX:
                return data.getData().get(row).getRT();
            case RVpr_INDEX:
                return data.getData().get(row).getRVpr();

            case CV_INDEX:
                return data.getData().get(row).getCV();
            case CP_INDEX:
                return data.getData().get(row).getCP();
            case CT_INDEX:
                return data.getData().get(row).getCT();
            case CVpr_INDEX:
                return data.getData().get(row).getCVpr();

            case Err_INDEX:
                return data.getData().get(row).getErr();
            case DErr_INDEX:
                return data.getDErr(row);
        }
        return new Object();

    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        switch (col) {
            case RV_INDEX:
                data.getData().get(row).setRV(Double.parseDouble(value.toString()));
                break;
            case RP_INDEX:
                data.getData().get(row).setRP(Double.parseDouble(value.toString()));
                break;
            case RT_INDEX:
                data.getData().get(row).setRT(Double.parseDouble(value.toString()));
                break;

            case CV_INDEX:
                data.getData().get(row).setCV(Double.parseDouble(value.toString()));
                break;
            case CP_INDEX:
                data.getData().get(row).setCP(Double.parseDouble(value.toString()));
                break;
            case CT_INDEX:
                data.getData().get(row).setCT(Double.parseDouble(value.toString()));
                break;
        }
        fireTableChanged(null);
    }

    @Override
    public int getRowCount() {
        return data.getData().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        switch (col) {
            case RV_INDEX:
            case RT_INDEX:
            case RP_INDEX:
            case CV_INDEX:
            case CT_INDEX:
            case CP_INDEX:
                return true;
            default:
                return false;
        }

    }
}
