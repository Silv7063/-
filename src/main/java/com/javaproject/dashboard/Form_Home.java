package com.javaproject.dashboard;

import com.javaproject.DatabaseManager;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_Home extends javax.swing.JPanel {
    public static Form_Home SystemIndex = null;
    private String employeeNumber = "0";
    private String attendanceNumber = "0";
    private String leaveNumber = "0";

    public Form_Home() {
        initComponents();
        ConnectMysql();
        setBackground(new Color(0, 0, 0, 0));
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/employee1.png")), "員工總數", employeeNumber));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/attendance.png")), "今天出席", attendanceNumber));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/absent.png")), "今天請假", leaveNumber));
        //  add row table
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        table.addRow(new Object[]{"2024-06-10", "各位同事，請注意，端午節假期將從[2024-06-08]到[2024-06-09]。祝大家假期愉快！", StatusType.APPROVED});
        table.addRow(new Object[]{"2024-05-29", "親愛的員工，系統將於[2024-06-01]進行維護，期間系統將暫時無法使用。", StatusType.APPROVED});
        table.addRow(new Object[]{"2024-03-19", "我們將於[2024-04-29]舉行團隊建設活動，地點為[基隆]。請大家踴躍參加，增進彼此的交流與合作！", StatusType.APPROVED});
        table.addRow(new Object[]{"2024-02-18", "恭喜[陳小紅]被評為本月的員工之星！感謝他的辛勤工作和突出貢獻！", StatusType.APPROVED});

        if (SystemIndex == null) {
            SystemIndex = this;
        }
    }

    public void ConnectMysql() {
        LocalDate today = LocalDate.now();
        String formattedDate = today.toString();

        try (Connection con = DatabaseManager.getConnection()) {
            // 查詢語句
            String query = "SELECT " +
                    "emp.employee_count, " +
                    "att.attendance_count, " +
                    "lea.leave_count " +
                    "FROM " +
                    "(SELECT COUNT(id) AS employee_count FROM employee) emp " +
                    "JOIN " +
                    "(SELECT COUNT(id) AS attendance_count FROM attendance WHERE date = ?) att " +
                    "JOIN " +
                    "(SELECT COUNT(id) AS leave_count FROM leavesystem WHERE DATE(start) <= CURDATE() AND DATE(end) > CURDATE()) lea";

            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setString(1, formattedDate);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        employeeNumber = String.valueOf(rs.getInt("employee_count"));
                        attendanceNumber = String.valueOf(rs.getInt("attendance_count"));
                        leaveNumber = String.valueOf(rs.getInt("leave_count"));
                        card1.setValue(employeeNumber);
                        card2.setValue(attendanceNumber);
                        card3.setValue(leaveNumber);
                    }
                }
            }
        } catch (SQLException ce) {
            ce.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.javaproject.dashboard.Card();
        card2 = new com.javaproject.dashboard.Card();
        card3 = new com.javaproject.dashboard.Card();
        panelBorder1 = new com.javaproject.dashboard.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new com.javaproject.dashboard.Table();

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("更新公告");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "日期", "內容", "狀態"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFont(new java.awt.Font("微软雅黑", 0, 12)); // NOI18N
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spTable))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.javaproject.dashboard.Card card1;
    private com.javaproject.dashboard.Card card2;
    private com.javaproject.dashboard.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private com.javaproject.dashboard.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private com.javaproject.dashboard.Table table;
    // End of variables declaration//GEN-END:variables
}
