package com.javaproject;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.javaproject.dashboard.ScrollBar;

public class Attendance extends javax.swing.JPanel {
    public static Attendance SystemIndex = null;
    private String employeeName;
    private String date;
    private String signInTime;
    private String signOutTime;
    private long workingHours;
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public void ConnectMysql(String inputUsername, int mode) {
        try (Connection con = DatabaseManager.getConnection()) {
            DefaultTableModel model = (DefaultTableModel) tableAppendance.getModel();
            model.setRowCount(0);

            switch (mode) {
                case 0 -> {
                    // Prevent SQL Injection
                    try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM attendance WHERE employee_name = ?")) {
                        stmt.setString(1, inputUsername);
                        try (ResultSet rs = stmt.executeQuery()) {
                            while (rs.next()) {
                                Attendance employee = new Attendance(rs.getString("employee_name"), rs.getString("date"), rs.getString("sign_in"), rs.getString("sign_out"));
                                Object[] row = {employee.getEmployeeName(), employee.getDate(), employee.getSignInTime(), employee.getSignOutTime(), employee.getWorkingHours()};
                                model.addRow(row);
                            }
                        }
                    }
                }
                case 1 -> {
                    // Prevent SQL Injection
                    try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM attendance");
                         ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            Attendance employee = new Attendance(rs.getString("employee_name"), rs.getString("date"), rs.getString("sign_in"), rs.getString("sign_out"));
                            Object[] row = {employee.getEmployeeName(), employee.getDate(), employee.getSignInTime(), employee.getSignOutTime(), employee.getWorkingHours()};
                            model.addRow(row);
                        }
                    }
                }
                case 2 -> {
                    // Prevent SQL Injection
                    try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM attendance WHERE employee_name LIKE ?")) {
                        stmt.setString(1, inputUsername + "%");
                        try (ResultSet rs = stmt.executeQuery()) {
                            while (rs.next()) {
                                Attendance employee = new Attendance(rs.getString("employee_name"), rs.getString("date"), rs.getString("sign_in"), rs.getString("sign_out"));
                                Object[] row = {employee.getEmployeeName(), employee.getDate(), employee.getSignInTime(), employee.getSignOutTime(), employee.getWorkingHours()};
                                model.addRow(row);
                            }
                        }
                    }
                }
                default -> {
                    // 可以添加更多模式或其他操作
                }
            }
        } catch (SQLException | ParseException ce) {
            ce.printStackTrace();
        }
    }

    public void ConnectMysql(String inputUsername, String date)
    {
        try {
            con = DatabaseManager.getConnection();
            DefaultTableModel model = (DefaultTableModel) tableAppendance.getModel();
            model.setRowCount(0);
            stmt = con.prepareStatement("DELETE FROM attendance WHERE employee_name = ? AND date = ?");
            stmt.setString(1, inputUsername);
            stmt.setString(2, date);
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

    public Attendance(String employeeName, String date, String signInTime, String signOutTime) throws ParseException {
        this.employeeName = employeeName;
        this.date = date;
        this.signInTime = signInTime;
        this.signOutTime = signOutTime;
        calculateWorkingHours();
    }

    private void calculateWorkingHours() throws ParseException {
        if (!signOutTime.equals("~")) {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date signInDate = timeFormat.parse(signInTime);
            Date signOutDate = timeFormat.parse(signOutTime);

            // 考慮可能的跨日情況
            long duration = signOutDate.getTime() - signInDate.getTime();

            if (duration < 0) {
                duration += 24 * 60 * 60 * 1000; // 如果跨日，補加24小時
            }
            this.workingHours = duration / (1000 * 60 * 60); // 轉換為小時
        }
        else
        {
            this.workingHours = 0;
        }
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDate() {
        return date;
    }

    public String getSignInTime() {
        return signInTime;
    }

    public String getSignOutTime() {
        return signOutTime;
    }

    public long getWorkingHours() {
        return workingHours;
    }

    public Attendance() {
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
        tableAppendance.setName("tableAttendance");
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
        tableAppendance = new com.javaproject.dashboard.Table2();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new com.javaproject.gui2.Button();
        jButton3 = new com.javaproject.gui2.Button();
        jButton1 = new com.javaproject.gui2.Button();
        jTextField1 = new com.javaproject.gui2.TextField();
        jButton4 = new com.javaproject.gui2.Button();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setPreferredSize(new java.awt.Dimension(867, 493));

        jScrollPane1.setBorder(null);

        tableAppendance.setForeground(new java.awt.Color(255, 255, 255));
        tableAppendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "員工姓名", "日期", "簽到時間", "簽退時間", "工作時數", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAppendance.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        tableAppendance.setName("tableAttendance"); // NOI18N
        jScrollPane1.setViewportView(tableAppendance);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel1.setText("員工姓名");
        jLabel1.setMaximumSize(new java.awt.Dimension(70, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(70, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 40));

        jButton2.setText("指定查找");
        jButton2.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jButton2.setMaximumSize(new java.awt.Dimension(100, 50));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton2.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        jButton1.setText("全部列出");
        jButton1.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jButton1.setMaximumSize(new java.awt.Dimension(100, 50));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField1.setMinimumSize(new java.awt.Dimension(200, 500));
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 50));

        jButton4.setText("新增記錄");
        jButton4.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jButton4.setMaximumSize(new java.awt.Dimension(100, 50));
        jButton4.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton4.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ConnectMysql(jTextField1.getText(), 0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ConnectMysql(jTextField1.getText(), 2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConnectMysql(jTextField1.getText(), 1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        AttendanceJDialog dialog = new AttendanceJDialog(null, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.javaproject.gui2.Button jButton1;
    private com.javaproject.gui2.Button jButton2;
    private com.javaproject.gui2.Button jButton3;
    private com.javaproject.gui2.Button jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.javaproject.gui2.TextField jTextField1;
    private com.javaproject.dashboard.PanelBorder panelBorder1;
    private com.javaproject.dashboard.Table2 tableAppendance;
    // End of variables declaration//GEN-END:variables
}
