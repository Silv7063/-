package com.javaproject;

public class MainSystem {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(DatabaseManager::close));
        System.setProperty("sun.java2d.noddraw", "true");
        
        java.awt.EventQueue.invokeLater(() -> {
            LoginSystemG loginSystemG = new LoginSystemG(() -> {
                System.out.println("Login successful.");

                java.awt.EventQueue.invokeLater(() -> {
                    new dashBoard().setVisible(true);
                });
                
                /*
                mailSystem mail = new mailSystem();
                mail.mailMsg("Login", "Login successful.");
                */
            });
            loginSystemG.setVisible(true);
        });
    }
}
