package com.javaproject.dashboard;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JPanel implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5)); // Increase horizontal gap to 10

        CustomLabel editLabel = new CustomLabel(new ImageIcon(getClass().getResource("/edit_icon.png")));
        CustomLabel removeLabel = new CustomLabel(new ImageIcon(getClass().getResource("/remove_icon.png")));

        add(editLabel);
        add(removeLabel);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground(Color.WHITE);
        return this;
    }
}
