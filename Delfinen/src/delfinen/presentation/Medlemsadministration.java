/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.presentation;

import delfinen.data.Betaling;
import delfinen.data.DataAccessorFile;
import delfinen.data.Medlem;
import delfinen.data.Motionist;
import delfinen.logic.BetalingCalculator;
import delfinen.logic.Controller;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author frederik
 */
public class Medlemsadministration extends javax.swing.JFrame {

    private Controller c;

    /**
     * Creates new form NewJFrame
     */
    public Medlemsadministration() {
        initComponents();
        DataAccessorFile dao = new DataAccessorFile();
        BetalingCalculator bc = new BetalingCalculator();
        c = new Controller(dao, bc);
        visAlle();
        this.setTitle("Redigere Medlemmer");

    }

    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            
            if (button.isSelected()) {
                return button.getText();
            }
        }
        
        return null;
    }
    
    public void editUser() {
        Medlem tempMedlem = c.getMedlemPåCprnr(Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()));
        String medlemsstatus = "P";
        this.jTextField4.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString());
        if(tempMedlem.isMedlemskabsstatus()){
            medlemsstatus = "A";
        }
        this.jTextField5.setText(medlemsstatus);
        this.jTextField6.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString());
        this.jTextField7.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString());

        DefaultTableModel model = createTable();
        Object[] message = {
            "Navn:", jTextField4,
            "Aktiv eller Passiv A/P:", jTextField5,
            "Email:", jTextField6, "Fødselsår", jTextField7, //"Motionist/Koncurrence:", jTextField8
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Edit User", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            boolean medlemskabsstatus = false;
            try {
                model.setValueAt(jTextField4.getText(), this.jTable1.getSelectedRow(), 0);
                int alder = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString());
                if (jTextField5.getText().equalsIgnoreCase("a")) {
                    medlemskabsstatus = true;
                } else {
                    medlemskabsstatus = false;
                }

                
                //vi skal huske at ændre 15 til enten at få en værdi fra et field, 
                //eller bare at få værdien fra tempMedlem.getFødelsår(), hvis fødselsåret ikke skal kunne redigeres.
                c.redigerMedlem(tempMedlem, jTextField4.getText(), alder, medlemskabsstatus, jTextField6.getText());

            } catch (Exception ex) {

            }
        }
    }

    public static void errorMessage(){
            Object[] message = {
                "Invalid input", 
                
                    

            };
         int option = JOptionPane.showConfirmDialog(null, message, "Fejlmeddelse", JOptionPane.OK_CANCEL_OPTION);
            
    }
    public void visAlle() {
        
        DefaultTableModel model = createTable();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        int tempCPR = 0;
        for (Medlem m : c.getMedlemmer()) {
            try {
                tempCPR = Integer.parseInt(this.CPRfield.getText());
                System.out.println(m.getBetalinger());

            } catch (Exception ex) {
            }

            Object rowData[] = new Object[5];
            rowData[0] = m.getName();
            rowData[1] = m.getCprnr();
            rowData[2] = m.getMail();
            rowData[3] = m.getFødselsår();
            
            ArrayList<Integer> betalingsår = new ArrayList();
            for (Betaling b : m.getBetalinger()) {
                betalingsår.add(b.getBetalingsyear());
            }
            rowData[4] = betalingsår;

            model.addRow(rowData);

        }
    }

    public DefaultTableModel createTable() {
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        int rowCount = model.getRowCount();
        int ColumnCount = model.getColumnCount();
        this.jTable1.isCellEditable(rowCount, ColumnCount - 1);
        return model;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jOptionPane1 = new javax.swing.JOptionPane();
        jOptionPane2 = new javax.swing.JOptionPane();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        CPRfield = new javax.swing.JTextField();
        MailField = new javax.swing.JTextField();
        NameField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        OpretMedlem = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        jTextField6.setText("jTextField6");

        jTextField7.setText("jTextField7");

        jTextField8.setText("jTextField8");

        jButton4.setText("jButton4");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jRadioButton1.setText("jRadioButton1");

        jRadioButton2.setText("jRadioButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CPRfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPRfieldActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Navn", "CPR", "E-mail", "Fødselsår", "Betalingsår"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Søg");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit selected");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Slet Medlem");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("CPR");

        jLabel2.setText("E-Mail");

        jLabel3.setText("Navn");

        OpretMedlem.setText("Opret Medlem");
        OpretMedlem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpretMedlemActionPerformed(evt);
            }
        });

        jButton5.setText("Opret ny Betaling");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Vis Alle");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Hovedmenu");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(OpretMedlem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MailField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CPRfield)
                            .addComponent(NameField))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(jButton7)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CPRfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(15, 15, 15)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(OpretMedlem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CPRfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPRfieldActionPerformed

    }//GEN-LAST:event_CPRfieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        DefaultTableModel model = createTable();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        int tempCPR = 0;
        for (Medlem m : c.getMedlemmer()) {
            try {
                tempCPR = Integer.parseInt(this.CPRfield.getText());
                System.out.println(m.getBetalinger());

            } catch (Exception ex) {
            }
            if (m.getCprnr() == tempCPR || m.getMail().toLowerCase().equals(this.MailField.getText().toLowerCase()) || m.getName().toLowerCase().equals(this.NameField.getText().toLowerCase())) {
                ArrayList<Integer> betalingsår = new ArrayList();
                Object rowData[] = new Object[5];
                rowData[0] = m.getName();
                rowData[1] = m.getCprnr();
                rowData[2] = m.getMail();
                rowData[3] = m.getFødselsår();

                for (Betaling b : m.getBetalinger()) {
                    betalingsår.add(b.getBetalingsyear());
                }
                rowData[4] = betalingsår;

                model.addRow(rowData);

            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            editUser();
            visAlle();
        } catch (Exception ex) {
            
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {

            for (Medlem m : c.getMedlemmer()) {
                if (Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()) == m.getCprnr()) {
                    try {
                        c.sletMedlem(m);
                        visAlle();

                    } catch (Exception ex) {
                        //skal nok noget ind her :p
                    }
                    break;
                }
            }
        } catch (Exception ex) {

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void OpretMedlemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpretMedlemActionPerformed

        new OpretMedlem().setVisible(true);
    }//GEN-LAST:event_OpretMedlemActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            DefaultTableModel model = createTable();

            Medlem tempMedlem = c.getMedlemPåCprnr(Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()));
            this.jLabel4.setText("CPR: " + tempMedlem.getCprnr());
            this.jLabel5.setText("Navn: " + tempMedlem.getName());
            this.jTextField6.setText("");
            this.jRadioButton1.setText("");
            this.jRadioButton2.setText("");
            this.buttonGroup2.add(this.jRadioButton1);
            this.buttonGroup2.add(this.jRadioButton2);
            boolean betalt = false;
            Object[] message = {
                "", jLabel4,
                "", jLabel5,
                "Betalingsår", jTextField6,
                "Betalt", jRadioButton1,
                "Ikke betalt", jRadioButton2
                    

            };
            int option = JOptionPane.showConfirmDialog(null, message, "Opret Betaling", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                
                if(this.getSelectedButtonText(buttonGroup2).equals("Betalt")){
                    betalt = true;
                }else{
                    betalt = false;
                }
                c.opretBetaling(tempMedlem, Integer.parseInt(this.jTextField6.getText()), betalt);
                
            }
        } catch (Exception ex) {

        }
        visAlle();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        visAlle();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
        Hovedemenu hm = new Hovedemenu();
        hm.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(Medlemsadministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Medlemsadministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Medlemsadministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Medlemsadministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Medlemsadministration().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CPRfield;
    private javax.swing.JTextField MailField;
    private javax.swing.JTextField NameField;
    private javax.swing.JButton OpretMedlem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
