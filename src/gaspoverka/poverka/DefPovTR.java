package gaspoverka.poverka;

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
            cell.setBackground(new Color(240,128,128));
        } else {
            cell.setBackground(new Color(152,251,152));
        }
        JLabel renderedLabel = (JLabel)cell;
        renderedLabel.setHorizontalAlignment(CENTER);
        return cell;
    }
}
