package com.javaproject;

import com.javaproject.dashboard.ScrollBar;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Leave extends javax.swing.JPanel {
    public static Leave SystemIndex = null;
    private String name;
    private String reason;
    private String start;
    private String end;
    private long day;
    private Connection con = null; 
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public void ConnectMysql(String inputUsername, int mode) {
        try (Connection con = DatabaseManager.getConnection()) {
            DefaultTableModel model = (DefaultTableModel) tableLeave.getModel();
            model.setRowCount(0);

            switch (mode) {
                case 0 -> {
                    try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM leavesystem WHERE name = ?")) {
                        stmt.setString(1, inputUsername);
                        try (ResultSet rs = stmt.executeQuery()) {
                            while (rs.next()) {
                                Leave employee = new Leave(rs.getString("name"), rs.getString("reason"), rs.getString("start"), rs.getString("end"));
                                Object[] row = {employee.getName(), employee.getReason(), employee.getStart(), employee.getEnd(), employee.getDay()};
                                model.addRow(row);
                            }
                        }
                    }
                }
                case 1 -> {
                    try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM leavesystem");
                         ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            Leave employee = new Leave(rs.getString("name"), rs.getString("reason"), rs.getString("start"), rs.getString("end"));
                            Object[] row = {employee.getName(), employee.getReason(), employee.getStart(), employee.getEnd(), employee.getDay()};
                            model.addRow(row);
                        }
                    }
                }
                case 2 -> {
                    try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM leavesystem WHERE name LIKE ?")) {
                        stmt.setString(1, inputUsername + "%");
                        try (ResultSet rs = stmt.executeQuery()) {
                            while (rs.next()) {
                                Leave employee = new Leave(rs.getString("name"), rs.getString("reason"), rs.getString("start"), rs.getString("end"));
                                Object[] row = {employee.getName(), employee.getReason(), employee.getStart(), employee.getEnd(), employee.getDay()};
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

    public void ConnectMysql(String inputUsername, String start)
    {
        try {
            con = DatabaseManager.getConnection();
            DefaultTableModel model = (DefaultTableModel) tableLeave.getModel();
            model.setRowCount(0);
            stmt = con.prepareStatement("DELETE FROM leavesystem WHERE name = ? AND start = ?");
            stmt.setString(1, inputUsername);
            stmt.setString(2, start);
            stmt.executeUpdate();
        } catch (SQLException ce) {
            ce.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    public Leave() {
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
        tableLeave.setName("tableLeave");
    }
    
    public Leave(String name, String reason, String start, String end) {
        this.name = name;
        this.reason = reason;
        this.start = start;
        this.end = end;
        calculateDay();
    }
    
    @Override
    public String getName()
    {
        return name;
    }

    public String getReason()
    {
        return reason;
    }

    public String getStart()
    {
        return start;
    }

    public String getEnd()
    {
        return end;
    }

    public long getDay()
    {
        return day;
    }

    public void calculateDay()
    {
        // 定義日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 將日期字串轉換為 LocalDate 對象
        LocalDate startDate = LocalDate.parse(getStart(), formatter);
        LocalDate endDate = LocalDate.parse(getEnd(), formatter);

        // 計算兩個日期之間的天數
        this.day = ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.javaproject.dashboard.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLeave = new com.javaproject.dashboard.Table2();
        jButton2 = new com.javaproject.gui2.Button();
        jButton1 = new com.javaproject.gui2.Button();
        jButton3 = new com.javaproject.gui2.Button();
        button1 = new com.javaproject.gui2.Button();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new com.javaproject.gui2.TextField();

        setPreferredSize(new java.awt.Dimension(915, 600));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setPreferredSize(new java.awt.Dimension(867, 493));

        jScrollPane1.setBorder(null);

        tableLeave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "員工姓名", "請假原因", "開始日期", "結束日期", "請假天數", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLeave.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        tableLeave.setName("tableLeave"); // NOI18N
        jScrollPane1.setViewportView(tableLeave);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

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

        button1.setText("新增記錄");
        button1.setFocusable(false);
        button1.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        button1.setMaximumSize(new java.awt.Dimension(100, 50));
        button1.setMinimumSize(new java.awt.Dimension(100, 50));
        button1.setPreferredSize(new java.awt.Dimension(100, 50));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel1.setText("員工姓名");
        jLabel1.setMaximumSize(new java.awt.Dimension(70, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(70, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 40));

        jTextField1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField1.setMinimumSize(new java.awt.Dimension(200, 500));
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ConnectMysql(jTextField1.getText(), 1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ConnectMysql(jTextField1.getText(), 2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConnectMysql(jTextField1.getText(), 0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        LeaveJDialog dialog = new LeaveJDialog(null, true);
        dialog.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.javaproject.gui2.Button button1;
    private com.javaproject.gui2.Button jButton1;
    private com.javaproject.gui2.Button jButton2;
    private com.javaproject.gui2.Button jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.javaproject.gui2.TextField jTextField1;
    private com.javaproject.dashboard.PanelBorder panelBorder1;
    private com.javaproject.dashboard.Table2 tableLeave;
    // End of variables declaration//GEN-END:variables
}
