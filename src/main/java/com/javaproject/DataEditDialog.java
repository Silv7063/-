package com.javaproject;

import com.javaproject.dashboard.Form_Home;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataEditDialog extends javax.swing.JDialog {
    private Connection con = null; 
    private PreparedStatement stmt = null;
    private int mode;
    private int update;
    
    public DataEditDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jPanel.setBackground(Color.WHITE);
        mode = 0;
        this.setLocationRelativeTo(null);

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if (update == 1)
                {
                    DataEditPanel.SystemIndex.ConnectMysql("UPDATE TABLE", 1);
                    FinancialSystem.SystemIndex.ConnectMysql("UPDATE TABLE", 1);
                    Form_Home.SystemIndex.ConnectMysql();
                }
            }
        });
    }
    
    public DataEditDialog(java.awt.Frame parent, boolean modal, String[] rowData) {
        super(parent, modal);
        initComponents();
        jPanel.setBackground(Color.WHITE);
        jTextField1.setText(rowData[0]);
        jTextField2.setText(rowData[1]);
        jTextField3.setText(rowData[2]);
        jTextField4.setText(rowData[3]);
        jTextField5.setText(rowData[4]);
        jButton1.setText("更新");
        jTextField1.setEnabled(false);
        mode = 1;
        this.setLocationRelativeTo(null);

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if (update == 1)
                {
                    DataEditPanel.SystemIndex.ConnectMysql("UPDATE TABLE", 1);
                    Form_Home.SystemIndex.ConnectMysql();
                }
            }
        });
    }

    public void ConnectMysql()
    {
        try {
                con = DatabaseManager.getConnection();
                if (mode == 0){
                    stmt = con.prepareStatement("INSERT INTO employee (name, position, department, state, email) VALUES (?, ?, ?, ?, ?)");
                    stmt.setString(1, jTextField1.getText());
                    stmt.setString(2, jTextField2.getText());
                    stmt.setString(3, jTextField3.getText()); 
                    stmt.setString(4, jTextField4.getText());
                    stmt.setString(5, jTextField5.getText());
                    stmt.executeUpdate();
                    
                    stmt = con.prepareStatement("INSERT INTO financial (name, salary, salaryCal) VALUES (?, ?, ?) ");
                    stmt.setString(1, jTextField1.getText());
                    stmt.setInt(2,0);
                    stmt.setString(3,"200 10");
                }else if (mode == 1) {
                    stmt = con.prepareStatement("UPDATE employee SET position = ?, department = ?, state = ?, email = ? WHERE name = ?");
                    stmt.setString(1, jTextField2.getText());
                    stmt.setString(2, jTextField3.getText());
                    stmt.setString(3, jTextField4.getText()); 
                    stmt.setString(4, jTextField5.getText());
                    stmt.setString(5, jTextField1.getText());
                }
                stmt.executeUpdate();
        } catch (SQLException ce) {
                ce.printStackTrace();
        } finally {
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jTextField1 = new com.javaproject.gui2.TextField();
        jTextField2 = new com.javaproject.gui2.TextField();
        jTextField3 = new com.javaproject.gui2.TextField();
        jTextField4 = new com.javaproject.gui2.TextField();
        jTextField5 = new com.javaproject.gui2.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new com.javaproject.gui2.Button();
        jButton2 = new com.javaproject.gui2.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(null);
        setResizable(false);

        jPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel.setName(""); // NOI18N
        jPanel.setPreferredSize(new java.awt.Dimension(623, 470));

        jTextField1.setText("範例");
        jTextField1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(300, 50));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setText("一般僱員");
        jTextField2.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField2.setPreferredSize(new java.awt.Dimension(300, 50));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setText("~");
        jTextField3.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField3.setPreferredSize(new java.awt.Dimension(300, 50));

        jTextField4.setText("在職");
        jTextField4.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField4.setPreferredSize(new java.awt.Dimension(300, 50));

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField5.setText("123456@gmail.com");
        jTextField5.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField5.setPreferredSize(new java.awt.Dimension(300, 50));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel1.setText("員工姓名");
        jLabel1.setToolTipText("");
        jLabel1.setMaximumSize(new java.awt.Dimension(100, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel2.setText("員工職務");
        jLabel2.setMaximumSize(new java.awt.Dimension(100, 40));
        jLabel2.setMinimumSize(new java.awt.Dimension(100, 40));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel3.setText("工作狀態");
        jLabel3.setMaximumSize(new java.awt.Dimension(100, 40));
        jLabel3.setMinimumSize(new java.awt.Dimension(100, 40));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel5.setText("電子信箱");
        jLabel5.setToolTipText("");
        jLabel5.setMaximumSize(new java.awt.Dimension(100, 40));
        jLabel5.setMinimumSize(new java.awt.Dimension(100, 40));
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel8.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel8.setText("所屬部門");
        jLabel8.setMaximumSize(new java.awt.Dimension(100, 40));
        jLabel8.setMinimumSize(new java.awt.Dimension(100, 40));
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 40));

        jButton1.setBackground(new java.awt.Color(30, 180, 114));
        jButton1.setForeground(new java.awt.Color(245, 245, 245));
        jButton1.setText("新增");
        jButton1.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jButton1.setMaximumSize(new java.awt.Dimension(100, 50));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton1.setRippleColor(new java.awt.Color(255, 255, 255));
        jButton1.setShadowColor(new java.awt.Color(30, 180, 114));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(253, 83, 83));
        jButton2.setForeground(new java.awt.Color(245, 245, 245));
        jButton2.setText("取消");
        jButton2.setToolTipText("");
        jButton2.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jButton2.setMaximumSize(new java.awt.Dimension(100, 50));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 50));
        jButton2.setName(""); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton2.setRippleColor(new java.awt.Color(255, 255, 255));
        jButton2.setShadowColor(new java.awt.Color(253, 83, 83));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(318, 318, 318)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)))
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        update = 1;
        ConnectMysql();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.javaproject.gui2.Button jButton1;
    private com.javaproject.gui2.Button jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel;
    private com.javaproject.gui2.TextField jTextField1;
    private com.javaproject.gui2.TextField jTextField2;
    private com.javaproject.gui2.TextField jTextField3;
    private com.javaproject.gui2.TextField jTextField4;
    private com.javaproject.gui2.TextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
