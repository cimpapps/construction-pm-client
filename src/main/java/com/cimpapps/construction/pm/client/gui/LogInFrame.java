package com.cimpapps.construction.pm.client.gui;

import com.cimpapps.construction.pm.client.controllers.UserController;
import construction.pm.lib.dto.UserDTO;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class LogInFrame extends javax.swing.JFrame {

    /**
     * Creates new form LogInFrame
     */
    public LogInFrame() {
        initComponents();

        addActionListeners();
        passwordPasswordField.setFocusable(true);

        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldUserName = new javax.swing.JTextField();
        passwordPasswordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonLogIn = new javax.swing.JButton();
        buttonRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("username:");

        jLabel2.setText("password:");

        buttonLogIn.setText("Log In");

        buttonRegister.setText("Register");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRegister)
                        .addGap(69, 69, 69)
                        .addComponent(buttonLogIn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textFieldUserName)
                        .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLogIn)
                    .addComponent(buttonRegister))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogIn;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField passwordPasswordField;
    private javax.swing.JTextField textFieldUserName;
    // End of variables declaration//GEN-END:variables

    private void addActionListeners() {
        buttonLogIn.addActionListener(ev -> logIn());
        buttonRegister.addActionListener(ev -> register());
        passwordPasswordField.setFocusable(true);
        passwordPasswordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER)
                    logIn();
            }
            
            
        });
    }

    private void logIn() {
        String username = textFieldUserName.getText();
        String password = String.valueOf(passwordPasswordField.getPassword());
        UserDTO user = UserController.getInstance().logIn(username, password);

        if (user != null) {
            dispose();
            new ProjectFrame(user);
        } else {
            JOptionPane.showMessageDialog(this, "FAIL!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    private void register() {
        new RegisterFrame();
    }

}
