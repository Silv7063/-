package com.javaproject;

import com.javaproject.dashboard.ScrollBar;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DataEditPanel extends JPanel {
    public static DataEditPanel SystemIndex = null;
    private Connection con = null; 
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private String name; 
    private String position; 
    private String department; 
    private String state; 
    private String email;
    private int salary; 
    
    public DataEditPanel() {
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

        tableDataEdit.setName("tableDataEdit");
        jComboBox1.setBackground(Color.LIGHT_GRAY);
    }
    
    public DataEditPanel(String name, String position, String department, String state, String email,int salary) {
        this.name = name;
        this.position=position;
        this.department=department;
        this.state=state;
        this.email=email;
        this.salary=salary;
    }
    
    public void ConnectMysql(String inputUsername, int mode){
        try {
                con = DatabaseManager.getConnection();
                DefaultTableModel model = (DefaultTableModel) tableDataEdit.getModel();
                model.setRowCount(0);
                String Name;

                String item = (String) jComboBox1.getSelectedItem();
                switch(item){
                    case "員工姓名" ->{
                        item = "name";
                    }
                    case "員工職務" ->{
                        item = "position";
                    }
                    case "所屬部門" ->{
                        item = "department";
                    }
                    case "工作狀態" ->{
                        item = "state";
                    }default -> {
                        item = "name";
                    }
                }

                switch (mode) {
                    case 0 -> {
                        stmt = con.prepareStatement("SELECT DISTINCT e.*, f.salary FROM employee e JOIN financial f ON e.name = f.name WHERE e." + item + " = ?");
                        stmt.setString(1, inputUsername);
                        rs = stmt.executeQuery();
                        
                        while(rs.next()){
                            Name = rs.getString("name");
                            DataEditPanel employee = new DataEditPanel(Name, rs.getString("position"), rs.getString("department"), rs.getString("state"),rs.getString("email"),rs.getInt("salary"));
                            Object[] row = {employee.getName(), employee.getPosition(), employee.getDepartment(), employee.getState(), employee.getEmail(), employee.getSalary()};
                            model.addRow(row);
                        }
                    }case 1 ->{
                        stmt = con.prepareStatement("SELECT DISTINCT e.*, f.salary FROM employee e JOIN financial f ON e.name = f.name");
                        rs = stmt.executeQuery();

                        while (rs.next()){
                            Name = rs.getString("name");
                            DataEditPanel employee = new DataEditPanel(Name, rs.getString("position"), rs.getString("department"), rs.getString("state"),rs.getString("email"),rs.getInt("salary"));
                            Object[] row = {employee.getName(), employee.getPosition(), employee.getDepartment(), employee.getState(), employee.getEmail(), employee.getSalary()};
                            model.addRow(row);
                        }
                    }case 2 ->{
                        stmt = con.prepareStatement("SELECT DISTINCT e.*, f.salary FROM employee e JOIN financial f ON e.name = f.name WHERE e." + item + " LIKE ?");
                        stmt.setString(1, inputUsername + "%");
                        rs = stmt.executeQuery();

                        while (rs.next()){
                            Name = rs.getString("name");
                            DataEditPanel employee = new DataEditPanel(Name, rs.getString("position"), rs.getString("department"), rs.getString("state"),rs.getString("email"),rs.getInt("salary"));
                            Object[] row = {employee.getName(), employee.getPosition(), employee.getDepartment(), employee.getState(), employee.getEmail(), employee.getSalary()};
                            model.addRow(row);
                        } 
                    }default -> {
                    }
                }
        } catch (Exception ce) { 
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
    
     public void ConnectMysql(String inputUsername){
        try {
            con = DatabaseManager.getConnection();
            DefaultTableModel model = (DefaultTableModel) tableDataEdit.getModel();
            model.setRowCount(0);
            stmt = con.prepareStatement("DELETE FROM employee WHERE name = ?");
            stmt.setString(1, inputUsername);
            stmt.executeUpdate();
            stmt = con.prepareStatement("DELETE FROM financial WHERE name = ?");
            stmt.setString(1, inputUsername);
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

    @Override
    public String getName(){
        return name;
    }
    public String getPosition(){
        return position;
    }
    public String getDepartment(){
        return department;
    }
    public String getState(){
        return state;
    }
    public String getEmail(){
        return email;
    }
    public int getSalary(){
        return salary;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new com.javaproject.gui2.Button();
        jButton3 = new com.javaproject.gui2.Button();
        jButton1 = new com.javaproject.gui2.Button();
        jTextField1 = new com.javaproject.gui2.TextField();
        button1 = new com.javaproject.gui2.Button();
        panelBorder1 = new com.javaproject.dashboard.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDataEdit = new com.javaproject.dashboard.Table2();

        setPreferredSize(new java.awt.Dimension(915, 600));

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel1.setText("尋找");
        jLabel1.setMaximumSize(new java.awt.Dimension(70, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(70, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 40));

        jComboBox1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "員工姓名", "員工職務", "所屬部門", "工作狀態" }));

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

        jTextField1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField1.setMinimumSize(new java.awt.Dimension(200, 500));
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 50));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
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

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        tableDataEdit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "員工姓名", "員工職務", "所屬部門", "工作狀態", "電子信箱", "月薪", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDataEdit.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        tableDataEdit.setName("tableDataEdit"); // NOI18N
        tableDataEdit.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tableDataEdit.setShowGrid(false);
        tableDataEdit.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tableDataEdit);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConnectMysql(jTextField1.getText(), 0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ConnectMysql(jTextField1.getText(), 2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ConnectMysql(jTextField1.getText(), 1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        DataEditDialog dialog = new DataEditDialog(null, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_button1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.javaproject.gui2.Button button1;
    private com.javaproject.gui2.Button jButton1;
    private com.javaproject.gui2.Button jButton2;
    private com.javaproject.gui2.Button jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.javaproject.gui2.TextField jTextField1;
    private com.javaproject.dashboard.PanelBorder panelBorder1;
    private com.javaproject.dashboard.Table2 tableDataEdit;
    // End of variables declaration//GEN-END:variables
}
