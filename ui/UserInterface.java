/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Peter
 */
public class UserInterface extends javax.swing.JFrame {

    /**
     * Creates new form UserInterface
     */
    public UserInterface() {
        initComponents();
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
        header_btn_close = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox4 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(38, 38, 38));
        jPanel1.setLayout(null);

        header_btn_close.setIcon(new javax.swing.ImageIcon("F:\\Eigene Dateien\\Desktop\\SMiner Icons\\icons8_Delete_32px_4.png")); // NOI18N
        header_btn_close.setBorderPainted(false);
        header_btn_close.setContentAreaFilled(false);
        header_btn_close.setFocusable(false);
        header_btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                header_btn_closeActionPerformed(evt);
            }
        });
        jPanel1.add(header_btn_close);
        header_btn_close.setBounds(650, 0, 40, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 690, 40);

        jPanel2.setBackground(new java.awt.Color(47, 47, 47));
        jPanel2.setLayout(null);

        jComboBox4.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4", "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox4);
        jComboBox4.setBounds(100, 50, 160, 27);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 40, 690, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void header_btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_header_btn_closeActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_header_btn_closeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton header_btn_close;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
