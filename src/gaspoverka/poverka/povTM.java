package gaspoverka.poverka;

import javax.swing.table.*;

public class povTM extends AbstractTableModel {

    public static final int KP_INDEX = 0;
    public static final int N_INDEX = 1;
    public static final int RV_INDEX = 2;
    public static final int RP_INDEX = 3;
    public static final int RT_INDEX = 4;
    public static final int RVpr_INDEX = 5;
    public static final int CV_INDEX = 6;
    public static final int CP_INDEX = 7;
    public static final int CT_INDEX = 8;
    public static final int CVpr_INDEX = 9;
    public static final int Err_INDEX = 10;
    public static final int DErr_INDEX = 11;
    protected String[] columnNames = {"KP", "№", "G м3/ч", "P кПа", "T С°", "Vпр м3",
        "G м3/ч", "P кПа", "T С°", "Vпр м3", "δ %", "δд %"};
    protected Poverka data;
    protected boolean isDeltaT=false;

    public void setIsDeltaT(boolean isDeltaT) {
        this.isDeltaT = isDeltaT;
    }

    public boolean getIsDeltaT() {
        return isDeltaT;
    }

    public povTM(Poverka data) {
        this.data = data;
    }

    public void setRow(int KP) {
        data.getData().clear();
        for (int j = 0; j < (KP * 3); j++) {
            data.getData().add(new PoverkaPoint());
            data.getData().get(data.getData().size() - 1).setMeasureNum(j + 1);
            //data.getData().lastElement().setMeasureNum(j + 1);
        }
        this.fireTableChanged(null);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case N_INDEX:
            case KP_INDEX:
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
            case KP_INDEX:
                return ((data.getData().get(row).getMeasureNum() - 1) / 3) + 1;

            case RV_INDEX:
                return data.getData().get(row).getRG();
            case RP_INDEX:
                return data.getData().get(row).getRP();
            case RT_INDEX:
                return data.getData().get(row).getRT();
            case RVpr_INDEX:
                return data.getData().get(row).getRV();

            case CV_INDEX:
                return data.getData().get(row).getCG();
            case CP_INDEX:
                return data.getData().get(row).getCP();
            case CT_INDEX:
                return data.getData().get(row).getCT();
            case CVpr_INDEX:
                return data.getData().get(row).getCV();

            case Err_INDEX:
                if (isDeltaT) {
                    return data.getData().get(row).getErrT();
                } else {
                    return data.getData().get(row).getErr();
                }
            case DErr_INDEX:
                return data.getDErr(row);
        }
        return new Object();

    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        switch (col) {
            case RV_INDEX:
                data.getData().get(row).setRG(Double.parseDouble(value.toString()));
                break;
            case RP_INDEX:
                data.getData().get(row).setRP(Double.parseDouble(value.toString()));
                break;
            case RT_INDEX:
                data.getData().get(row).setRT(Double.parseDouble(value.toString()));
                break;
            case RVpr_INDEX:
                data.getData().get(row).setRV(Double.parseDouble(value.toString()));
                break;

            case CV_INDEX:
                data.getData().get(row).setCG(Double.parseDouble(value.toString()));
                break;
            case CP_INDEX:
                data.getData().get(row).setCP(Double.parseDouble(value.toString()));
                break;
            case CT_INDEX:
                data.getData().get(row).setCT(Double.parseDouble(value.toString()));
                break;
            case CVpr_INDEX:
                data.getData().get(row).setCV(Double.parseDouble(value.toString()));
                break;
        }
        this.fireTableCellUpdated(row, col);
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
            case CVpr_INDEX:
            case RVpr_INDEX:
                return true;
            default:
                return false;
        }

    }
}
