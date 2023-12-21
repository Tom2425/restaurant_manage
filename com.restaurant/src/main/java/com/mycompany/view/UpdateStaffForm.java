/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.view;

import com.mycompany.model.Admin;
import com.mycompany.model.Dish;
import com.mycompany.service.AdminService;
import com.mycompany.service.DishService;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class UpdateStaffForm extends javax.swing.JFrame {

    private DashBoardForm dashBoard;
    private Admin admin;

    /**
     * Creates new form AddDish
     */
    public UpdateStaffForm() {
        initComponents();
    }
    

    public UpdateStaffForm(DashBoardForm dashBoard) {
        this.dashBoard = dashBoard;
        initComponents();

    }
     public UpdateStaffForm(DashBoardForm dashBoard,Admin admin) {
        this.admin  = admin;
        this.dashBoard = dashBoard;
        initComponents();
       customComponent();

    }
    public void  customComponent(){
            nameField.setText(this.admin.getName());
            passwordField.setText(this.admin.getPassword());
            confirmPasswordField.setText(this.admin.getPassword());
            phoneField.setText(this.admin.getPhone());
            usernameField.setText(this.admin.getUsername());
            roleField.setSelectedItem(this.admin.getRole());
    }
    public boolean validateUsernameField() {
        String regrex = "^[a-zA-Z][a-zA-Z0-9_]{5,20}$";
        Pattern p = Pattern.compile(regrex);
        String value = usernameField.getText().trim();
        Matcher m = p.matcher(value);

        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username field mustn't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            if (m.matches()) {
                Admin a = AdminService.getByUsername(value);
                if(a != null){
                    System.out.print(a.toString());
                    JOptionPane.showMessageDialog(this, "Your username was existed!", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                return true;

            } else {
                JOptionPane.showMessageDialog(this, "Your username is invalid!!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    public boolean validateNameField() {
        String regrex = "^[a-zA-Z' ]+$";
        String value = nameField.getText().trim();
        Pattern p = Pattern.compile(regrex);
        Matcher m = p.matcher(value);
        if (value.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name field mustn't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            if (m.matches()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Your name is invalid!!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

    }

    public boolean validatePhoneField() {
        String regrex = "^[+]?[0-9]{1,14}$";
        String value = phoneField.getText().trim();
        Pattern p = Pattern.compile(regrex);
        Matcher m = p.matcher(value);
        if (value.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The phone field mustn't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            if (m.matches()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Your phone is invalid!!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    public boolean validatePasswordField() {
        String regrex = "^[^\\s]{5,50}$";
        String value = String.valueOf(passwordField.getPassword()).trim();
        Pattern p = Pattern.compile(regrex);
        Matcher m = p.matcher(value);
        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(this, "The password field mustn't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            if (m.matches()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Your password value is invalid!!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    public boolean validateConfirmPasswordField() {
        String password = String.valueOf(passwordField.getPassword()).trim();
        String confirmPassword = String.valueOf(confirmPasswordField.getPassword()).trim();
        if (password.equals(confirmPassword)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Confirm password does not match!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        panel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        roleField = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        cancelBtn = new javax.swing.JButton();
        addStaffBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(10, 100, 0, 0));

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setToolTipText("");
        jPanel1.setMinimumSize(new java.awt.Dimension(85, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(370, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Add Staff");
        jPanel1.add(jLabel1);

        jPanel4.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(277, 227));
        jPanel2.setLayout(new java.awt.GridLayout(0, 1));

        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Name: ");
        jLabel2.setRequestFocusEnabled(false);
        jPanel6.add(jLabel2, java.awt.BorderLayout.WEST);

        nameField.setPreferredSize(new java.awt.Dimension(220, 22));
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        jPanel6.add(nameField, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel6);

        panel11.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("Phone");
        jLabel7.setRequestFocusEnabled(false);
        panel11.add(jLabel7, java.awt.BorderLayout.WEST);

        phoneField.setPreferredSize(new java.awt.Dimension(220, 22));
        phoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneFieldActionPerformed(evt);
            }
        });
        panel11.add(phoneField, java.awt.BorderLayout.EAST);

        jPanel2.add(panel11);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Username: ");
        jLabel3.setRequestFocusEnabled(false);
        jPanel7.add(jLabel3, java.awt.BorderLayout.WEST);

        usernameField.setPreferredSize(new java.awt.Dimension(220, 22));
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        jPanel7.add(usernameField, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Password:  ");
        jLabel4.setRequestFocusEnabled(false);
        jPanel8.add(jLabel4, java.awt.BorderLayout.WEST);

        passwordField.setPreferredSize(new java.awt.Dimension(220, 22));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        jPanel8.add(passwordField, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel8);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("Confirm password");
        jLabel5.setRequestFocusEnabled(false);
        jPanel9.add(jLabel5, java.awt.BorderLayout.WEST);

        confirmPasswordField.setPreferredSize(new java.awt.Dimension(220, 22));
        confirmPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordFieldActionPerformed(evt);
            }
        });
        jPanel9.add(confirmPasswordField, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel9);

        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("Role");
        jLabel6.setRequestFocusEnabled(false);
        jPanel10.add(jLabel6, java.awt.BorderLayout.WEST);

        jPanel5.setPreferredSize(new java.awt.Dimension(220, 54));
        jPanel5.setLayout(new java.awt.BorderLayout());

        roleField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "staff", "admin" }));
        jPanel5.add(roleField, java.awt.BorderLayout.WEST);

        jPanel10.add(jPanel5, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel10);

        jPanel4.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(100, 50));

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        addStaffBtn.setText("Update");
        addStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStaffBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(addStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(addStaffBtn))
                .addContainerGap())
        );

        jPanel4.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void addStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStaffBtnActionPerformed
        Admin admin = new Admin();
        if (validateNameField()&& validatePhoneField() && validateUsernameField() && validatePasswordField() && validateConfirmPasswordField()) {
            admin.setId(this.admin.getId());
            admin.setName(nameField.getText());
            admin.setUsername(usernameField.getText());
            admin.setPassword(String.valueOf(passwordField.getPassword()));
            admin.setPhone(phoneField.getText());
            admin.setRole(String.valueOf(roleField.getSelectedItem()));
            AdminService.update(admin);
            this.dispose();
            this.dashBoard.handlStaffTable();
        }


    }//GEN-LAST:event_addStaffBtnActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void confirmPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPasswordFieldActionPerformed

    private void phoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateStaffForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateStaffForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateStaffForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateStaffForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateStaffForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStaffBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField nameField;
    private javax.swing.JPanel panel11;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JComboBox<String> roleField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
