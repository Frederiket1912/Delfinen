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
import delfinen.logic.Controller;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author frederik
 */
public class RedigereMedlemmer extends javax.swing.JFrame {
    private Controller c;
    /**
     * Creates new form NewJFrame
     */
    public RedigereMedlemmer() {
        initComponents();
        DataAccessorFile dao = new DataAccessorFile();
        c = new Controller(dao);
        c.getMedlemmer();
    }

    public void editUser() {
        
        this.jTextField4.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0).toString());
        this.jTextField5.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(),1).toString());
        this.jTextField6.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(),2).toString());
        this.jTextField7.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(),3).toString());
        
        DefaultTableModel model = createTable();
        Object[] message = {
            "Navn:", jTextField4,
            "Aktiv eller Passiv A/P:", jTextField5,
            "Email:", jTextField6, "Fødselsår", jTextField7,
        //"Motionist/Koncurrence:", jTextField8
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Edit User", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            //navnet på variablen burde nok være medlemskabsstatus da aktivitetsform er om de er motionist/konkurrencesvømmer
            boolean medlemskabsstatus = true;
            try {
                model.setValueAt(jTextField4.getText(), this.jTable1.getSelectedRow(), 0);
                int alder = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString());
                if (jTextField5.getText().equalsIgnoreCase("a")) {
                    medlemskabsstatus = true;
                } else {
                    medlemskabsstatus = false;
                }
                
                Medlem tempMedlem = c.søgMedlemPåCprnr(Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()));
                //vi skal huske at ændre 15 til enten at få en værdi fra et field, 
                //eller bare at få værdien fra tempMedlem.getFødelsår(), hvis fødselsåret ikke skal kunne redigeres.
                c.redigerMedlem(tempMedlem, jTextField4.getText(), alder, medlemskabsstatus, jTextField6.getText());
               
                

            } catch (Exception ex) {

            }
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

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        jTextField6.setText("jTextField6");

        jTextField7.setText("jTextField7");

        jTextField8.setText("jTextField8");

        jButton4.setText("jButton4");

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
                "Navn", "CPR", "E-mail", "Fødselsdag", "Betalingsår"
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

        jButton5.setText("Betaling");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MailField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(71, 71, 71))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CPRfield, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jButton5))
                                    .addComponent(OpretMedlem))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CPRfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(MailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(12, 12, 12)
                        .addComponent(OpretMedlem)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CPRfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPRfieldActionPerformed

    }//GEN-LAST:event_CPRfieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<Integer> betalingsår = new ArrayList();
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
                Object rowData[] = new Object[5];
                rowData[0] = m.getName();
                rowData[1] = m.getCprnr();
                rowData[2] = m.getMail();
                rowData[3] = m.getFødselsår();

                for(Betaling b : m.getBetalinger()){
                    betalingsår.add(b.getBetalingsyear());
                }
                rowData[4] = betalingsår;


                model.addRow(rowData);

            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        editUser();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        for (Medlem m : c.getMedlemmer()) {
            if (Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()) == m.getCprnr()) {
                try {
                    c.sletMedlem(m);
                } catch (Exception ex) {
                    //skal nok noget ind her :p
                }
                break;
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void OpretMedlemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpretMedlemActionPerformed
        new OpretMedlem().setVisible(true);
    }//GEN-LAST:event_OpretMedlemActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        DefaultTableModel model = createTable();


        Medlem tempMedlem = c.søgMedlemPåCprnr(Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(),1).toString()));
           this.jTextField4.setText(""+tempMedlem.getCprnr());
           this.jTextField5.setText(tempMedlem.getName());




        Object[] message = {
            "CPR:", jTextField4,
            "Navn", jTextField5,
                "Betalingsår", jTextField6

        };
        int option = JOptionPane.showConfirmDialog(null, message, "Edit User", JOptionPane.OK_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            //jeg har lavet en ny attribut til betaling der er en boolean.
            //hvis de betaler 0, altså ikke betaler skal den sættes til false, ellers til true
            Betaling b = new Betaling(tempMedlem, Integer.parseInt(this.jTextField6.getText()), true);
            tempMedlem.setBetalinger(b);



        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(RedigereMedlemmer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedigereMedlemmer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedigereMedlemmer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedigereMedlemmer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RedigereMedlemmer().setVisible(true);
                

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CPRfield;
    private javax.swing.JTextField MailField;
    private javax.swing.JTextField NameField;
    private javax.swing.JButton OpretMedlem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
