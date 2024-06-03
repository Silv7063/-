package com.javaproject.dashboard;

import com.javaproject.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.TableCellEditor;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private JPanel panel;
    private CustomLabel editLabel;
    private CustomLabel removeLabel;
    private JTable table;

    public ButtonEditor(JTable table) {
        this.table = table;
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5)); // Increase horizontal gap to 10
        editLabel = new CustomLabel(new ImageIcon(getClass().getResource("/edit_icon.png")));
        removeLabel = new CustomLabel(new ImageIcon(getClass().getResource("/remove_icon.png")));

        MouseAdapter mouseAdapter;
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.getEditingRow();
                fireEditingStopped();
                if (e.getSource() == editLabel) {
                    String[] rowData = new String[0];
                    
                    if (table.getName().equals("tableFinancial")) {
                        if (row >= 0 && row < table.getRowCount()) {
                            rowData = new String[table.getColumnCount()];
                            for (int i = 0; i < table.getColumnCount(); i++) {
                                Object value = table.getValueAt(row, i);
                                rowData[i] = (value != null) ? value.toString() : "";
                            }
                        }

                        FinancialJDialog dialog = new FinancialJDialog(null, true, rowData);
                        dialog.setVisible(true);
                    }
                    else if (table.getName().equals("tableAttendance")) {
                        if (row >= 0 && row < table.getRowCount()) {
                            rowData = new String[table.getColumnCount()];
                            for (int i = 0; i < table.getColumnCount(); i++) {
                                Object value = table.getValueAt(row, i);
                                rowData[i] = (value != null) ? value.toString() : "";
                            }
                        }

                        AttendanceJDialog dialog = new  AttendanceJDialog(null, true, rowData);
                        dialog.setVisible(true);
                    }
                    else if (table.getName().equals("tableLeave")) {
                        if (row >= 0 && row < table.getRowCount()) {
                            rowData = new String[table.getColumnCount()];
                            for (int i = 0; i < table.getColumnCount(); i++) {
                                Object value = table.getValueAt(row, i);
                                rowData[i] = (value != null) ? value.toString() : "";
                            }
                        }

                        LeaveJDialog dialog = new LeaveJDialog(null, true, rowData);
                        dialog.setVisible(true);
                    }
                    else if (table.getName().equals("tableDataEdit")) {
                        if (row >= 0 && row < table.getRowCount()) {
                            rowData = new String[table.getColumnCount()];
                            for (int i = 0; i < table.getColumnCount(); i++) {
                                Object value = table.getValueAt(row, i);
                                rowData[i] = (value != null) ? value.toString() : "";
                            }
                        }

                        DataEditDialog dialog = new DataEditDialog(null, true, rowData);
                        dialog.setVisible(true);
                    }
                } else if (e.getSource() == removeLabel) {
                    String[] rowData = new String[0];

                    if (table.getName().equals("tableAttendance")) {
                        if (row >= 0 && row < table.getRowCount()) {
                            rowData = new String[table.getColumnCount()];
                            for (int i = 0; i < table.getColumnCount(); i++) {
                                Object value = table.getValueAt(row, i);
                                rowData[i] = (value != null) ? value.toString() : "";
                            }
                        }

                        String message = String.format("你要刪除 %s 員工的資料嗎？", rowData[0]);
                        JLabel messageLabel = new JLabel(message);
                        ImageIcon icon = new ImageIcon(getClass().getResource("/employee.png"));
                        JOptionPane pane = new JOptionPane(messageLabel, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
                        JDialog dialog = pane.createDialog("確認");
                        setBackgroundRecursively(pane, Color.WHITE);
                        dialog.setIconImage(icon.getImage());
                        dialog.setVisible(true);

                        Object selectedValue = pane.getValue();

                        if (selectedValue != null) {
                            if (selectedValue instanceof Integer) {
                                int result = (int) selectedValue;
                                if (result == JOptionPane.YES_OPTION) {
                                    Attendance.SystemIndex.ConnectMysql(rowData[0], rowData[1]);
                                    Attendance.SystemIndex.ConnectMysql("Update", 1);
                                    Form_Home.SystemIndex.ConnectMysql();
                                }
                            }
                        }
                    }
                    else if (table.getName().equals("tableLeave")) {
                        if (row >= 0 && row < table.getRowCount()) {
                            rowData = new String[table.getColumnCount()];
                            for (int i = 0; i < table.getColumnCount(); i++) {
                                Object value = table.getValueAt(row, i);
                                rowData[i] = (value != null) ? value.toString() : "";
                            }
                        }

                        String message = String.format("你要刪除 %s 員工的資料嗎？", rowData[0]);
                        JLabel messageLabel = new JLabel(message);
                        ImageIcon icon = new ImageIcon(getClass().getResource("/employee.png"));
                        JOptionPane pane = new JOptionPane(messageLabel, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
                        JDialog dialog = pane.createDialog("確認");
                        setBackgroundRecursively(pane, Color.WHITE);
                        dialog.setIconImage(icon.getImage());
                        dialog.setVisible(true);

                        Object selectedValue = pane.getValue();
                        if (selectedValue != null) {
                            if (selectedValue instanceof Integer) {
                                int result = (int) selectedValue;
                                if (result == JOptionPane.YES_OPTION) {
                                    Leave.SystemIndex.ConnectMysql(rowData[0], rowData[2]);
                                    Leave.SystemIndex.ConnectMysql("Update", 1);
                                    Form_Home.SystemIndex.ConnectMysql();
                                }
                            }
                        }
                    }else if (table.getName().equals("tableDataEdit") || table.getName().equals("tableFinancial")) {
                        if (row >= 0 && row < table.getRowCount()) {
                            rowData = new String[table.getColumnCount()];
                            for (int i = 0; i < table.getColumnCount(); i++) {
                                Object value = table.getValueAt(row, i);
                                rowData[i] = (value != null) ? value.toString() : "";
                            }
                        }

                        String message = String.format("你要刪除 %s 員工的資料嗎？", rowData[0]);
                        JLabel messageLabel = new JLabel(message);
                        ImageIcon icon = new ImageIcon(getClass().getResource("/employee.png"));
                        JOptionPane pane = new JOptionPane(messageLabel, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
                        JDialog dialog = pane.createDialog("確認");
                        setBackgroundRecursively(pane, Color.WHITE);
                        dialog.setIconImage(icon.getImage());
                        dialog.setVisible(true);

                        Object selectedValue = pane.getValue();
                        if (selectedValue != null) {
                            if (selectedValue instanceof Integer) {
                                int result = (int) selectedValue;
                                if (result == JOptionPane.YES_OPTION) {
                                    DataEditPanel.SystemIndex.ConnectMysql(rowData[0]);
                                    DataEditPanel.SystemIndex.ConnectMysql("Update", 1);
                                    FinancialSystem.SystemIndex.ConnectMysql("Update", 1);
                                    Form_Home.SystemIndex.ConnectMysql();
                                }
                            }
                        }
                    }
                }
            }
        };

        editLabel.addMouseListener(mouseAdapter);
        removeLabel.addMouseListener(mouseAdapter);

        panel.add(editLabel);
        panel.add(removeLabel);
    }
    
    // 遞歸設置所有元件的背景顏色
    private static void setBackgroundRecursively(Component component, Color color) {
        if (component instanceof JComponent) {
            ((JComponent) component).setOpaque(true);
            component.setBackground(color);
        }
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                setBackgroundRecursively(child, color);
            }
        }
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
