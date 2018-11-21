/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.presentation;

import delfinen.data.DataAccessorFile;
import delfinen.data.Disciplin;
import delfinen.data.Konkurrencesvømmer;
import delfinen.data.Medlem;
import delfinen.logic.BetalingCalculator;
import delfinen.logic.Controller;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author frederik
 */
public class CoachView extends javax.swing.JFrame {
    private Controller c;
    /**
     * Creates new form CoachView
     */
    public CoachView() {
        initComponents();
        DataAccessorFile dao = new DataAccessorFile();
        BetalingCalculator bc = new BetalingCalculator();
        c = new Controller(dao, bc);
        c.getMedlemmer();
        visAlle();
       // for(Konkurrencesvømmer k : c.getKonkurrencesvømmere()){
       //     c.opretResultat(k, 66, "75", Disciplin.CRAWL, "Noget", 1);
       // }
       
    }
    public void visAlle(){
             
        DefaultTableModel model = createTable();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        int tempCPR = 0;
        for (Medlem m : c.getKonkurrencesvømmere()) {
            try {
                tempCPR = Integer.parseInt(this.CPRField.getText());

            } catch (Exception ex) {
            }
            
                Object rowData[] = new Object[6];
                rowData[0] = m.getName();
                rowData[1] = m.getCprnr();
                try{
                rowData[2] = c.timeFormatter(c.getBestResult((Konkurrencesvømmer)m, Disciplin.CRAWL).getTimeInSeconds());
                rowData[3] = c.timeFormatter(c.getBestResult((Konkurrencesvømmer)m, Disciplin.BRYSTSVØMNING).getTimeInSeconds());
                rowData[4] = c.timeFormatter(c.getBestResult((Konkurrencesvømmer)m, Disciplin.RYGCRAWL).getTimeInSeconds());
                rowData[5] = c.timeFormatter(c.getBestResult((Konkurrencesvømmer)m, Disciplin.BUTTERFLY).getTimeInSeconds());
                }catch(Exception ex){
                    
                }
                model.addRow(rowData);

            

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

        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        NameField = new javax.swing.JTextField();
        CPRField = new javax.swing.JTextField();
        EmailField = new javax.swing.JTextField();
        søg = new javax.swing.JButton();
        RegisterTid = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Navn", "Alder", "Crawl", "Brystsvømning", "Rygcrawl", "Butterfly"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        søg.setText("Søg");
        søg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                søgActionPerformed(evt);
            }
        });

        RegisterTid.setText("Register tid");
        RegisterTid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterTidActionPerformed(evt);
            }
        });

        jButton1.setText("Samlet Resultater");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Navn");

        jLabel2.setText("CPR");

        jLabel3.setText("E-Mail");

        jButton3.setText("Vis Alle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hovedmenu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(søg))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(RegisterTid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CPRField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmailField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NameField))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CPRField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(søg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RegisterTid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegisterTidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterTidActionPerformed
        try{
            int k = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString());
            JFrame sv = new RegistrerSvømmeResultater(k); 
            sv.setVisible(true);
            this.dispose();
        }catch(Exception ex){
            
        }
        
        
        
    }//GEN-LAST:event_RegisterTidActionPerformed

    private void søgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_søgActionPerformed
        
        DefaultTableModel model = createTable();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        int tempCPR = 0;
        for (Medlem m : c.getKonkurrencesvømmere()) {
            try {
                tempCPR = Integer.parseInt(this.CPRField.getText());

            } catch (Exception ex) {
            }
            if (m.getCprnr() == tempCPR || m.getMail().toLowerCase().equals(this.EmailField.getText().toLowerCase()) || m.getName().toLowerCase().equals(this.NameField.getText().toLowerCase())) {
                Object rowData[] = new Object[6];
                rowData[0] = m.getName();
                rowData[1] = m.getCprnr();
                try{
                rowData[2] = c.timeFormatter(c.getBestResult((Konkurrencesvømmer)m, Disciplin.CRAWL).getTimeInSeconds());
                rowData[3] = c.timeFormatter(c.getBestResult((Konkurrencesvømmer)m, Disciplin.BRYSTSVØMNING).getTimeInSeconds());
                rowData[4] = c.timeFormatter(c.getBestResult((Konkurrencesvømmer)m, Disciplin.RYGCRAWL).getTimeInSeconds());
                rowData[5] = c.timeFormatter(c.getBestResult((Konkurrencesvømmer)m, Disciplin.BUTTERFLY).getTimeInSeconds());
                }catch(Exception ex){
                    
                }
                model.addRow(rowData);

            }

        }
    }//GEN-LAST:event_søgActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        new SvømmeResultater().setVisible(true);
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        Hovedemenu hm = new Hovedemenu();
        hm.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    public DefaultTableModel createTable() {
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        int rowCount = model.getRowCount();
        int ColumnCount = model.getColumnCount();
        this.jTable1.isCellEditable(rowCount, ColumnCount - 1);
        return model;
    }
    
    
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
            java.util.logging.Logger.getLogger(CoachView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoachView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoachView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoachView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoachView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CPRField;
    private javax.swing.JTextField EmailField;
    private javax.swing.JTextField NameField;
    private javax.swing.JButton RegisterTid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton søg;
    // End of variables declaration//GEN-END:variables
}
