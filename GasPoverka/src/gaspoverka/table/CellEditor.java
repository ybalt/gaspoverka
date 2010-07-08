package gaspoverka.table;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class CellEditor extends javax.swing.AbstractCellEditor implements
        TableCellEditor {

    JTextField component = new JTextField();
    //Double component = new Double(null);

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        component.setText(value.toString());
        System.out.println(component.toString());
        component.setSelectionStart(0);
        component.setSelectionEnd(value.toString().length());
        return component;
    }

    @Override
    public Object getCellEditorValue() {
        return Double.parseDouble(component.getText());
    }
}
