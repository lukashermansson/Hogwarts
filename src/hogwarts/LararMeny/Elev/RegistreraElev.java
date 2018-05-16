/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hogwarts.LararMeny.Elev;

import hogwarts.Validation;
import java.util.ArrayList;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Lägg till en elev, bestäm sovsal (och därmed elevhem).
 */
public class RegistreraElev extends javax.swing.JPanel {
    private InfDB db;
    
    /**
     * Creates new form RegistreraElev
     */
    public RegistreraElev(InfDB db) {
        this.db = db;
        
        initComponents();
        
       
        uppdateraElevhemsLista();
        
        
    }
    //populera listan med elevhem
    private void uppdateraElevhemsLista(){
        jComboBoxSovsal.removeAllItems();
         try {
            ArrayList<HashMap<String, String>> result = db.fetchRows("SELECT VANING, ELEVHEMSNAMN FROM SOVSAL JOIN ELEVHEM ON ELEVHEM = ELEVHEM_ID;");
            if(result != null){
                for(HashMap<String, String> row : result){
                    jComboBoxSovsal.addItem(row.get("ELEVHEMSNAMN") + " våning: "+ row.get("VANING"));
                }
            }else{
                jLabelError.setText("Det finns inga elevhem");
            }
        } catch (InfException ex) {
            jLabelError.setText("Sql fel");
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

        jLabelInfo = new javax.swing.JLabel();
        jLabelFornamn = new javax.swing.JLabel();
        jLabelEfternamn = new javax.swing.JLabel();
        jLabelSovsal = new javax.swing.JLabel();
        jComboBoxSovsal = new javax.swing.JComboBox<>();
        jTextFieldEfternamn = new javax.swing.JTextField();
        jTextFieldFornamn = new javax.swing.JTextField();
        jButtonRegistrera = new javax.swing.JButton();
        jLabelError = new javax.swing.JLabel();

        jLabelInfo.setText("Registrera elev");

        jLabelFornamn.setText("Förnamn:");

        jLabelEfternamn.setText("Efternamn:");

        jLabelSovsal.setText("Sovsal");

        jComboBoxSovsal.setModel(new javax.swing.DefaultComboBoxModel<>());

        jButtonRegistrera.setText("Registrera");
        jButtonRegistrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelInfo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelFornamn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEfternamn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEfternamn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelSovsal)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxSovsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 230, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButtonRegistrera))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabelError)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelInfo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFornamn)
                    .addComponent(jTextFieldFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEfternamn)
                    .addComponent(jTextFieldEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSovsal)
                    .addComponent(jComboBoxSovsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonRegistrera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jLabelError))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistreraActionPerformed
        // TODO add your handling code here:
        
       
        
        if(!Validation.textComponentEmpty(jTextFieldEfternamn) && !Validation.textComponentEmpty(jTextFieldFornamn)){
            String fornamn = jTextFieldFornamn.getText();
            String efternamn = jTextFieldEfternamn.getText();
            if(Validation.isValidName(fornamn) && Validation.isValidName(efternamn)){
                int sovsal = -1;
                String elevhemsnamn = jComboBoxSovsal.getSelectedItem().toString().split(" ")[0];
                String vaning = jComboBoxSovsal.getSelectedItem().toString().split(" ")[2];
                try {
                    sovsal = Integer.parseInt(db.fetchSingle("SELECT SOVSAL_ID from SOVSAL JOIN ELEVHEM ON ELEVHEM = ELEVHEM_ID WHERE ELEVHEMSNAMN = '" + elevhemsnamn +"' And VANING = " + vaning +";"));
                } catch (InfException ex) {
                     jLabelError.setText("Ingen sovsal med det namnet existerar");
                }
            
                if(sovsal != -1){
                    try {
                        //sovsalen finns, lägg in eleven
                        db.insert("INSERT INTO ELEV (ELEV_ID, FORNAMN, EFTERNAMN, SOVSAL) VALUES (((SELECT FIRST 1 ELEV_ID FROM ELEV ORDER BY ELEV_ID DESC) + 1),'" +fornamn +"', '" + efternamn + "', "+ sovsal + ");");
                        jLabelError.setText("Lade till ny andvändare");
                    } catch (InfException ex) {
                        jLabelError.setText("SQL Fel");
                    }
                }
            }else{
                jLabelError.setText("Förnamnet och efternamnet får ej inehålla mellanrumm eller siffror");
            }
        }else{
            jLabelError.setText("Vänligen skriv in ett förnamn och efternamn!");
        }
    }//GEN-LAST:event_jButtonRegistreraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrera;
    private javax.swing.JComboBox<String> jComboBoxSovsal;
    private javax.swing.JLabel jLabelEfternamn;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelFornamn;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelSovsal;
    private javax.swing.JTextField jTextFieldEfternamn;
    private javax.swing.JTextField jTextFieldFornamn;
    // End of variables declaration//GEN-END:variables
}