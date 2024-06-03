package com.javaproject.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.RenderingHints;

public class PanelCover extends javax.swing.JPanel {

    private final MigLayout layout;
    private JLabel title;
    private JLabel description;
    private JLabel description1;

    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);
        init();

    }

    private void init() {
        title = new JLabel("歡迎回來!");
        title.setFont(new Font("Microsoft YaHei", 1, 30));
        title.setForeground(new Color(245, 245, 245));
        add(title);
        description = new JLabel("邁向高效管理，從這裡開始");
        description.setFont(new Font("Microsoft JhengHei", 1, 14));
        description.setForeground(new Color(245, 245, 245));
        add(description);
        description1 = new JLabel("為了您的賬號安全，請勿與他人分享您的登錄信息");
        description1.setFont(new Font("Microsoft JhengHei", 1, 14));
        description1.setForeground(new Color(245, 245, 245));
        add(description1);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//启用抗锯齿
        GradientPaint gra = new GradientPaint(0, 0, new Color(73, 119, 182), 0, getHeight(), new Color(39, 84, 184));
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }
}
