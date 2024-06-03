package com.javaproject;

import com.javaproject.dashboard.ScrollBar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FinancialSystem extends JPanel {
    public static FinancialSystem SystemIndex = null;
    private String name;
    private int baseSalary;
    private int baseTsalary;
    private int overtimeHours;
    private double overtimeRate;

    public void ConnectMysql(String inputUsername, int mode) {
        try (Connection con = DatabaseManager.getConnection()) {
            DefaultTableModel model = (DefaultTableModel) tableFinancial.getModel();
            model.setRowCount(0);

            switch (mode) {
                case 0 -> {
                    try (PreparedStatement stmt = con.prepareStatement("SELECT salary, salaryCal FROM financial WHERE name = ?")) {
                        stmt.setString(1, inputUsername);
                        try (ResultSet rs = stmt.executeQuery()) {
                            if (rs.next()) { // 只讀取一行
                                int salaryData = rs.getInt("salary");
                                String salaryCalData = rs.getString("salaryCal");

                                // 存儲整數陣列
                                List<Integer> intArray = new ArrayList<>();

                                // 以空格分隔字串並轉換為整數
                                String[] splitString = salaryCalData.split(" ");

                                for (String str : splitString) {
                                    intArray.add(Integer.valueOf(str));
                                }

                                FinancialSystem employee = new FinancialSystem(inputUsername, salaryData, intArray.get(0), intArray.get(1) - 8, 1.5);

                                // 獲取表格模型
                                Object[] row = {employee.getName(), employee.getbaseSalary(), employee.getbaseTsalary(), employee.getOvertimeHours(), employee.calculateOvertimePay(), employee.calculateGrossSalary(), employee.calculateTax(), employee.calculateNetSalary()};
                                model.addRow(row);
                            }
                        }
                    }
                }
                case 1 -> {
                    try (PreparedStatement stmt = con.prepareStatement("SELECT name, salary, salaryCal FROM financial");
                         ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            String nameData = rs.getString("name");
                            int salaryData = rs.getInt("salary");
                            String salaryCalData = rs.getString("salaryCal");

                            // 存儲整數陣列
                            List<Integer> intArray = new ArrayList<>();

                            // 以空格分隔字串並轉換為整數
                            String[] splitString = salaryCalData.split(" ");

                            for (String str : splitString) {
                                intArray.add(Integer.valueOf(str));
                            }

                            FinancialSystem employee = new FinancialSystem(nameData, salaryData, intArray.get(0), intArray.get(1) - 8, 1.5);

                            // 獲取表格模型
                            Object[] row = {employee.getName(), employee.getbaseSalary(), employee.getbaseTsalary(), employee.getOvertimeHours(), employee.calculateOvertimePay(), employee.calculateGrossSalary(), employee.calculateTax(), employee.calculateNetSalary()};
                            model.addRow(row);
                        }
                    }
                }
                case 2 -> {
                    try (PreparedStatement stmt = con.prepareStatement("SELECT name, salary, salaryCal FROM financial WHERE name LIKE ?")) {
                        stmt.setString(1, inputUsername + "%");
                        try (ResultSet rs = stmt.executeQuery()) {
                            while (rs.next()) {
                                String nameData = rs.getString("name");
                                int salaryData = rs.getInt("salary");
                                String salaryCalData = rs.getString("salaryCal");

                                // 存儲整數陣列
                                List<Integer> intArray = new ArrayList<>();

                                // 以空格分隔字串並轉換為整數
                                String[] splitString = salaryCalData.split(" ");

                                for (String str : splitString) {
                                    intArray.add(Integer.valueOf(str));
                                }

                                FinancialSystem employee = new FinancialSystem(nameData, salaryData, intArray.get(0), intArray.get(1) - 8, 1.5);

                                // 獲取表格模型
                                Object[] row = {employee.getName(), employee.getbaseSalary(), employee.getbaseTsalary(), employee.getOvertimeHours(), employee.calculateOvertimePay(), employee.calculateGrossSalary(), employee.calculateTax(), employee.calculateNetSalary()};
                                model.addRow(row);
                            }
                        }
                    }
                }
                default -> {
                    // 可以添加更多模式或其他操作
                }
            }
        } catch (SQLException ce) {
            ce.printStackTrace();
        }
    }

    public FinancialSystem() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        jScrollPane1.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        jScrollPane1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        ConnectMysql("UPDATE TABLE", 1);
        if (SystemIndex == null) {
            SystemIndex = this;
        }
        tableFinancial.setName("tableFinancial");
    }

    public FinancialSystem(String name, int baseSalary, int baseTsalary, int overtimeHours, double overtimeRate) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.baseTsalary = baseTsalary;
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
    }

    @Override
    public String getName()
    {
        return name;
    }
    
    public int getbaseSalary()
    {
        return baseSalary;
    }
    
    public int getbaseTsalary()
    {
        return baseTsalary;
    }
    
    public int getOvertimeHours()
    {
        return overtimeHours;
    }

    public int calculateOvertimePay() {
        double overtimePay = ((double) baseSalary / 8 / 30 * overtimeHours) * overtimeRate;
        return (int) Math.round(overtimePay);
    }

    public int calculateGrossSalary() {
        double grossSalary = baseSalary + calculateOvertimePay();
        return (int) Math.round(grossSalary);
    }

    public int calculateTax() {
        double grossSalary = calculateGrossSalary();
        double tax;
        if (grossSalary <= 50000) {
            tax = grossSalary * 0.1;
        } else {
            tax = grossSalary * 0.2;
        }
        return (int) Math.round(tax);
    }

    public int calculateNetSalary() {
        double netSalary = calculateGrossSalary() - calculateTax();
        return (int) Math.round(netSalary);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new com.javaproject.gui2.TextField();
        jButton1 = new com.javaproject.gui2.Button();
        jButton3 = new com.javaproject.gui2.Button();
        jButton2 = new com.javaproject.gui2.Button();
        panelBorder1 = new com.javaproject.dashboard.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFinancial = new com.javaproject.dashboard.Table2();

        setBackground(new java.awt.Color(253, 253, 253));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(915, 600));

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel1.setText("員工姓名");
        jLabel1.setMaximumSize(new java.awt.Dimension(70, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(70, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 40));

        jTextField1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField1.setMinimumSize(new java.awt.Dimension(200, 500));
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 50));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("指定查找");
        jButton1.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jButton1.setMaximumSize(new java.awt.Dimension(100, 50));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("模糊查詢");
        jButton3.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jButton3.setMaximumSize(new java.awt.Dimension(100, 50));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton3.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("全部列出");
        jButton2.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jButton2.setMaximumSize(new java.awt.Dimension(100, 50));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton2.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        tableFinancial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "員工姓名", "基本月薪", "基本時薪", "加班時數", "加班費", "月薪", "稅", "淨工資", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFinancial.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        tableFinancial.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tableFinancial.setShowGrid(false);
        tableFinancial.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tableFinancial);
        if (tableFinancial.getColumnModel().getColumnCount() > 0) {
            tableFinancial.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ConnectMysql(jTextField1.getText(), 2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConnectMysql(jTextField1.getText(), 0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ConnectMysql(jTextField1.getText(), 1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.javaproject.gui2.Button jButton1;
    private com.javaproject.gui2.Button jButton2;
    private com.javaproject.gui2.Button jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.javaproject.gui2.TextField jTextField1;
    private com.javaproject.dashboard.PanelBorder panelBorder1;
    private com.javaproject.dashboard.Table2 tableFinancial;
    // End of variables declaration//GEN-END:variables
}
