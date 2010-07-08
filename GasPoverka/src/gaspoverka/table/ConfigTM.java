package gaspoverka.table;

import java.util.Enumeration;
import java.util.Properties;
import javax.swing.table.AbstractTableModel;


public class ConfigTM extends AbstractTableModel {

    public static final int Variable_INDEX = 0;
    public static final int Value_INDEX = 1;
    protected String[] columnNamesInitial = {"Переменная", "Значение"};
    protected String[] columnNames;
    Properties data;
    String[] variables;
    private boolean isEdit=false;


    public ConfigTM() {
        columnNames = columnNamesInitial;
        variables = new String[100];
    }

    public void setData(Properties data) {
        int i=0;
        this.data = data;
        for (Enumeration e=data.keys();e.hasMoreElements();) {
            variables[i] = e.nextElement().toString();
            i++;
        }
        fireTableChanged(null);
    }
    public void setEdit(boolean edit) {
        isEdit = edit;
    }

    public void addRow() {
        
    }

    public void clear() {
       
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        switch (col) {
            case Variable_INDEX:
                data.setProperty(value.toString(), null);
                break;
            case Value_INDEX:
                data.setProperty(variables[row], value.toString());
                break;
        }
        fireTableChanged(null);
    }

    @Override
    public Class getColumnClass(int column) {
                return String.class;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case Variable_INDEX:
                return variables[row];
            case Value_INDEX:
                return data.get(variables[row]);
            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return isEdit;
    }



}
