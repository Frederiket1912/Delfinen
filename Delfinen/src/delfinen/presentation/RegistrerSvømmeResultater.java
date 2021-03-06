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
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Talha Noory
 */
public class RegistrerSvømmeResultater extends javax.swing.JFrame {

    private Controller c;
    private int CPR;

    /**
     * Creates new form RegistrerSvømmeResultater
     */
    public RegistrerSvømmeResultater(int CPR) {
        initComponents();
        DataAccessorFile dao = new DataAccessorFile();
        BetalingCalculator bc = new BetalingCalculator();
        c = new Controller(dao, bc);
        c.getMedlemmer();
        this.setTitle("Register Svømme Resulater");
        for (Konkurrencesvømmer m : c.getKonkurrencesvømmere()) {
            if (m.getCprnr() == CPR) {
                this.JCPR.setText("CPR: " + CPR);
                this.jName.setText(m.getName());
                this.CPR = CPR;
            }
        }

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        JDato = new javax.swing.JTextField();
        JSvømTid = new javax.swing.JTextField();
        JPlacering = new javax.swing.JTextField();
        JStævne = new javax.swing.JTextField();
        JCrawl = new javax.swing.JCheckBox();
        JBryst = new javax.swing.JCheckBox();
        JButterfly = new javax.swing.JCheckBox();
        JRygcrawl = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButtonSvømmeresultater = new javax.swing.JButton();
        jButtonHovedemenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jName = new javax.swing.JLabel();
        JCPR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDatoActionPerformed(evt);
            }
        });

        JSvømTid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSvømTidActionPerformed(evt);
            }
        });

        JPlacering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPlaceringActionPerformed(evt);
            }
        });

        JStævne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JStævneActionPerformed(evt);
            }
        });

        buttonGroup1.add(JCrawl);
        JCrawl.setText("Crawl");
        JCrawl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCrawlActionPerformed(evt);
            }
        });

        buttonGroup1.add(JBryst);
        JBryst.setText("Brystsvømning");

        buttonGroup1.add(JButterfly);
        JButterfly.setText("Butterfly");
        JButterfly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButterflyActionPerformed(evt);
            }
        });

        buttonGroup1.add(JRygcrawl);
        JRygcrawl.setText("Rygcrawl");

        jButton1.setText("Registrer resultat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonSvømmeresultater.setText("Svømmeresultater");
        jButtonSvømmeresultater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSvømmeresultaterActionPerformed(evt);
            }
        });

        jButtonHovedemenu.setText("Coach view");
        jButtonHovedemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHovedemenuActionPerformed(evt);
            }
        });

        jLabel1.setText("Dato for resultat:");

        jLabel2.setText("Stævnets navn:");

        jLabel3.setText("Svømmers tid i sek:");

        jLabel4.setText("Placering ved stævnet:");

        jName.setText("Navn");

        JCPR.setText("CPR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JSvømTid, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JPlacering, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JDato, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JStævne, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCPR)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JRygcrawl)
                            .addComponent(JCrawl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JButterfly)
                            .addComponent(JBryst)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButtonSvømmeresultater)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonHovedemenu, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jName)
                    .addComponent(JCPR))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JStævne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCrawl)
                    .addComponent(JButterfly))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBryst)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JSvømTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JPlacering, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JRygcrawl)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSvømmeresultater, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHovedemenu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCrawlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCrawlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCrawlActionPerformed

    private void JButterflyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButterflyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JButterflyActionPerformed

    private void jButtonHovedemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHovedemenuActionPerformed
        this.dispose();
        CoachView hm = new CoachView();
        hm.setVisible(true);    }//GEN-LAST:event_jButtonHovedemenuActionPerformed

    private void jButtonSvømmeresultaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSvømmeresultaterActionPerformed
        this.dispose();
        SvømmeResultater sr = new SvømmeResultater();
        sr.setVisible(true);
    }//GEN-LAST:event_jButtonSvømmeresultaterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Konkurrencesvømmer km = c.getKonkurrencesvømmerPåCprnr(CPR);

        try {
            String stævnenavn = this.JStævne.getText();
            String dato = this.JDato.getText();
            int tid = Integer.parseInt(this.JSvømTid.getText());
            String disc = this.getSelectedButtonText(buttonGroup1);
            int placering = Integer.parseInt(this.JPlacering.getText());
            if (this.getSelectedButtonText(buttonGroup1).equals("Crawl")) {
                c.opretResultat(km, tid, dato, Disciplin.CRAWL, stævnenavn, placering);
                JOptionPane.showMessageDialog(null,"Crawl resultat Oprettet");
            } else if (this.getSelectedButtonText(buttonGroup1).equals("Butterfly")) {
                c.opretResultat(km, tid, dato, Disciplin.BUTTERFLY, stævnenavn, placering);
                JOptionPane.showMessageDialog(null,"Butterfly resultat Oprettet");
            } else if (this.getSelectedButtonText(buttonGroup1).equals("Rygcrawl")) {
                c.opretResultat(km, tid, dato, Disciplin.RYGCRAWL, stævnenavn, placering);
                JOptionPane.showMessageDialog(null,"Rygcrawl resultat Oprettet");
            } else if (this.getSelectedButtonText(buttonGroup1).equals("Brystsvømning")) {
                c.opretResultat(km, tid, dato, Disciplin.BRYSTSVØMNING, stævnenavn, placering);
                JOptionPane.showMessageDialog(null,"Brystsvømning resultat Oprettet");
            }
        } catch (Exception ex) {

        }

        //c.opretResultat(m, SOMEBITS, date, Disciplin.CRAWL, competitionName, HEIGHT);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JDatoActionPerformed

    private void JStævneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JStævneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JStævneActionPerformed

    private void JSvømTidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSvømTidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JSvømTidActionPerformed

    private void JPlaceringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPlaceringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPlaceringActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrerSvømmeResultater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrerSvømmeResultater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrerSvømmeResultater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrerSvømmeResultater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new RegistrerSvømmeResultater().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JBryst;
    private javax.swing.JCheckBox JButterfly;
    private javax.swing.JLabel JCPR;
    private javax.swing.JCheckBox JCrawl;
    private javax.swing.JTextField JDato;
    private javax.swing.JTextField JPlacering;
    private javax.swing.JCheckBox JRygcrawl;
    private javax.swing.JTextField JStævne;
    private javax.swing.JTextField JSvømTid;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonHovedemenu;
    private javax.swing.JButton jButtonSvømmeresultater;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jName;
    // End of variables declaration//GEN-END:variables
}
