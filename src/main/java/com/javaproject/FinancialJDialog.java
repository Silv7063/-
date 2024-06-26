package com.javaproject;

import com.javaproject.dashboard.Form_Home;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class FinancialJDialog extends javax.swing.JDialog {
    private Connection con = null; 
    private PreparedStatement stmt = null;
    private int update;

    public void ConnectMysql()
    {
        try {
                con = DatabaseManager.getConnection();

                String text = jTextField4.getText();
                int value = Integer.parseInt(text) + 8;

                String combined = jTextField3.getText() + " " + value;
                
                // Prevent SQL Injection
                stmt = con.prepareStatement("UPDATE financial SET salary = ?, salaryCal = ? WHERE name = ?");
                stmt.setString(1, jTextField2.getText());
                stmt.setString(2, combined);
                stmt.setString(3, jTextField1.getText());
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

    public FinancialJDialog(java.awt.Frame parent, boolean modal, String[] rowData) {
        super(parent, modal);
        initComponents();
        jPanel1.setBackground(Color.WHITE);
        jTextField1.setText(rowData[0]);
        jTextField2.setText(rowData[1]);
        jTextField3.setText(rowData[2]);
        jTextField4.setText(rowData[3]);

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if (update == 1)
                {
                    FinancialSystem.SystemIndex.ConnectMysql("UPDATE TABLE", 1);
                    Form_Home.SystemIndex.ConnectMysql();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new com.javaproject.gui2.Button();
        jButton2 = new com.javaproject.gui2.Button();
        jTextField1 = new com.javaproject.gui2.TextField();
        jTextField2 = new com.javaproject.gui2.TextField();
        jTextField3 = new com.javaproject.gui2.TextField();
        jTextField4 = new com.javaproject.gui2.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel1.setText("員工姓名");
        jLabel1.setToolTipText("");
        jLabel1.setMaximumSize(new java.awt.Dimension(100, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel2.setText("基本月薪");
        jLabel2.setMaximumSize(new java.awt.Dimension(100, 40));
        jLabel2.setMinimumSize(new java.awt.Dimension(100, 40));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel3.setText("加班時數");
        jLabel3.setMaximumSize(new java.awt.Dimension(100, 40));
        jLabel3.setMinimumSize(new java.awt.Dimension(100, 40));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jLabel4.setText("基本時薪");
        jLabel4.setMaximumSize(new java.awt.Dimension(100, 40));
        jLabel4.setMinimumSize(new java.awt.Dimension(100, 40));
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 40));

        jButton1.setBackground(new java.awt.Color(30, 180, 114));
        jButton1.setForeground(new java.awt.Color(245, 245, 245));
        jButton1.setText("更新");
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

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(300, 50));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField2.setPreferredSize(new java.awt.Dimension(300, 50));

        jTextField3.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField3.setPreferredSize(new java.awt.Dimension(300, 50));

        jTextField4.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        jTextField4.setPreferredSize(new java.awt.Dimension(300, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(100, 100, 100)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/employee.png"));

        if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty() || jTextField4.getText().isEmpty()) {
            JOptionPane pane = new JOptionPane("不能為空白", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = pane.createDialog("錯誤");
            setBackgroundRecursively(pane, Color.WHITE);
            dialog.setIconImage(icon.getImage());
            dialog.setVisible(true);
        }
        else if (!jTextField1.getText().matches("^[\\u4e00-\\u9fa5A-Za-z\\s]+$")) {
            JOptionPane pane = new JOptionPane("員工姓名只能是中文或英文", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = pane.createDialog("錯誤");
            setBackgroundRecursively(pane, Color.WHITE);
            dialog.setIconImage(icon.getImage());
            dialog.setVisible(true);
        } else if (!jTextField2.getText().matches("^[0-9]+$") || !jTextField3.getText().matches("^[0-9]+$") || !jTextField4.getText().matches("^[0-9]+$")) {
            JOptionPane pane = new JOptionPane("只能是數字", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = pane.createDialog("錯誤");
            setBackgroundRecursively(pane, Color.WHITE);
            dialog.setIconImage(icon.getImage());
            dialog.setVisible(true);
        }
        else {
            update = 1;
            ConnectMysql();
            dispose();
        }
    }

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.javaproject.gui2.Button jButton1;
    private com.javaproject.gui2.Button jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private com.javaproject.gui2.TextField jTextField1;
    private com.javaproject.gui2.TextField jTextField2;
    private com.javaproject.gui2.TextField jTextField3;
    private com.javaproject.gui2.TextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
