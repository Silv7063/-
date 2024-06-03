package com.javaproject;

import com.javaproject.gui.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import com.javaproject.dashboard.Menu;
import com.javaproject.gui.Button;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class LoginSystemG extends javax.swing.JFrame {
    private final LoginSuccessListener listener;
    private MigLayout layout;
    private PanelCover cover;
    private PanelLoading loading;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private Menu menu;
    private JLabel topRightLabel;  // 新增 JLabel 變量

    public LoginSystemG(LoginSuccessListener listener) {
        this.listener = listener;
        initComponents();
        init();
    }

    private void init() {
        setTitle("員工管理系統");
        ImageIcon icon = new ImageIcon(getClass().getResource("/employee.png"));
        setIconImage(icon.getImage());
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loading = new PanelLoading();
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("員工管理系統");
        label.setFont(new Font("Microsoft YaHei", 1, 30));
        label.setForeground(new Color(73, 119, 182));
        login.add(label);
        menu = new Menu();
        menu.initMoving(this);  //拖動登錄界面
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/log.png")));
        txtUser.setHint("帳號");
        login.add(txtUser, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/pass_1.png")));
        txtPass.setHint("密碼");
        login.add(txtPass, "w 60%");
        com.javaproject.gui.Button cmd = new Button();
        cmd.setBackground(new Color(73, 119, 182));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setFont(new Font("Microsoft YaHei", 1, 12));
        cmd.setText("登入");
        login.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String inputUsername = txtUser.getText();
                char[] inputPassword = txtPass.getPassword();

                if (inputUsername.isEmpty()) {
                    loginAction(1);
                } else if (inputPassword.length == 0) {
                    loginAction(2);
                } else if (!inputUsername.matches("^[a-zA-Z0-9]+$")) {
                    loginAction(3);
                } else {
                    LoginDB dbSystem = new LoginDB();
                    int result = dbSystem.ConnectMysql(inputUsername, inputPassword);

                    switch (result) {
                        case 1 -> {
                            loginAction(6);
                        }
                        case 2 -> {
                            loginAction(4);
                        }
                        case 3 -> {
                            loginAction(5);
                        }
                        default -> {
                        }
                    }
                }
            }
        });
        bg.setLayout(layout);

        ImageIcon labelIcon = new ImageIcon(getClass().getResource("/close-428-32.png"));
        topRightLabel = new JLabel(labelIcon);
        topRightLabel.setFont(new Font("sanserif", 1, 14));
        bg.add(topRightLabel, "pos 1al 0 n 20");  // 將 JLabel 添加到右上角

        topRightLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane pane = new JOptionPane("你要關閉程式嗎？", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
                JDialog dialog = pane.createDialog("確認");
                setBackgroundRecursively(pane, Color.WHITE);
                dialog.setIconImage(icon.getImage());
                dialog.setVisible(true);

                Object selectedValue = pane.getValue();
                if (selectedValue instanceof Integer) {
                    int result = (int) selectedValue;
                    if (result == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            }
        });

        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.add(loading, "pos 0 0 100% 100%");
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(login, "width " + loginSize + "%, pos 1al 0 n 100%"); //  1al as 100%
        bg.add(menu,"pos 0 0 100% 100%");
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

    public void loginAction(int value) {

        switch (value) {
            case 1:
                showMessage(Message.MessageType.ERROR, "帳號輸入不能為空，請重新輸入");
                break;
            case 2:
                showMessage(Message.MessageType.ERROR, "密碼輸入不能為空，請重新輸入");
                break;
            case 3:
                showMessage(Message.MessageType.ERROR, "帳號只能包含字母和數字");
                break;
            case 4:
                showMessage(Message.MessageType.ERROR, "密碼錯誤");
                break;
            case 5:
                showMessage(Message.MessageType.ERROR, "帳號不存在");
                break;
            case 6:
                //showMessage(Message.MessageType.SUCCESS, "登陸成功");

                dispose();  // 关闭登录窗口
                if (listener != null)
                {
                    listener.onLoginSuccess();  // 调用接口方法
                }
                break;
            default:
                showMessage(Message.MessageType.ERROR, "不明錯誤");
                break;
        }
    }

    public void showMessage(Message.MessageType messageType, String message) {
        Message ms = new Message();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0.5al -30", 0); //  Insert to bg fist index 0
                    ms.setVisible(true);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if (ms.isShow()) {
                    bg.remove(ms);
                    bg.repaint();
                    bg.revalidate();
                } else {
                    ms.setShow(true);
                }
            }
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                animator.start();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);

        login = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
                loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
                loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginSystemG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginSystemG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginSystemG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginSystemG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private javax.swing.JPanel login;
    // End of variables declaration//GEN-END:variables
}
