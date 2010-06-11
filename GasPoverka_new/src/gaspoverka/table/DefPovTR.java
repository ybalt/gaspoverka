package gaspoverka.table;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class DefPovTR extends DefaultTableCellRenderer {

    protected int col;

    public void IzmTableRender(int interactiveColumn) {
        this.col = interactiveColumn;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column < 6 && column>1) {
            cell.setBackground(Color.RED);
        } else {
            cell.setBackground(Color.GREEN);
        }
        JLabel renderedLabel = (JLabel)cell;
        renderedLabel.setHorizontalAlignment(CENTER);
        return cell;
    }
}
