package gaspoverka.table;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonEditor extends AbstractCellEditor
    {

    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JButton but) {
        //super(but);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            }
        });
    }

//    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        button.setText("+");
        return button;
    }

    @Override
    public JButton getCellEditorValue() {
        isPushed = false;
        return button;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

}
