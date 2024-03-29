/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hogwarts.ElevMeny;

import hogwarts.Util;
import hogwarts.Validation;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Här kan vi ta reda på vilka kurser som en lärare har lärt ut 
 * under en viss period.
 * 
 */
public class LararKurser extends javax.swing.JPanel {
    private InfDB db;
    private String[] larare;
    
    
    /**
     * Creates new form LararKurser
     */
    public LararKurser(InfDB db) {
        this.db = db;
        ArrayList<String> listan = new ArrayList<String>();
        
        
        //Läs in listan med lärare 
        try {
            ArrayList<HashMap<String, String>> result = db.fetchRows("SELECT FORNAMN, EFTERNAMN FROM LARARE;");
            if(result != null){
                for(HashMap<String, String> row: result){
                    listan.add(row.get("FORNAMN") + " " + row.get("EFTERNAMN"));
                }
            }else{
                // jLabel5 är en label som vanligtvis är utan text, och visas bara när vi ger den en text. Finns många såna exempel i våra koder.
                jLabelError.setText("Finns inga lärare");
            }
        } catch (InfException ex) {
           jLabelError.setText("Databasfel när lärardata hämtades: " + ex.getMessage());
        }
        larare = Util.konverteraArrayListTillArray(listan);
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

        jLabelInfo = new javax.swing.JLabel();
        jComboBoxLarare = new javax.swing.JComboBox<>();
        jLabelLarare = new javax.swing.JLabel();
        jTextFieldFran = new javax.swing.JTextField();
        jTextFieldTill = new javax.swing.JTextField();
        jLabelFran = new javax.swing.JLabel();
        jLabelTill = new javax.swing.JLabel();
        jLabelError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButtonSok = new javax.swing.JButton();

        jLabelInfo.setText("Hämta kurser som en lärare har under tidsperiod");

        jComboBoxLarare.setModel(new javax.swing.DefaultComboBoxModel<>(larare));

        jLabelLarare.setText("Välj lärare");

        jTextFieldFran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFranActionPerformed(evt);
            }
        });

        jLabelFran.setText("Från");

        jLabelTill.setText("Till");

        jScrollPane1.setViewportView(jList1);

        jButtonSok.setText("Sök");
        jButtonSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelInfo)
                            .addComponent(jLabelLarare)
                            .addComponent(jComboBoxLarare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldFran, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTill)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldTill, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonSok))))
                            .addComponent(jLabelFran))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(468, 468, 468))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelInfo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabelLarare)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxLarare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTill, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelFran))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSok))
                        .addGap(20, 20, 20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(jLabelError))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFranActionPerformed

    private void jButtonSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSokActionPerformed
        // TODO add your handling code here:
        
        //knappen exekverar att fylla listan med kurserna för vald lärare.
       DefaultListModel model = new DefaultListModel();
       model.clear();
        if(!Validation.textComponentEmpty(jTextFieldFran) && !Validation.textComponentEmpty(jTextFieldTill)){
            String datum1 = jTextFieldFran.getText();
            String datum2 = jTextFieldTill.getText();
            if(Validation.datumValidering(datum1) && Validation.datumValidering(datum2)){
                try {
                    //Namn får inte inehålla mellanrumm för att denna kod skall fungera 
                    String[] namnArray = jComboBoxLarare.getSelectedItem().toString().split(" ");
                    ArrayList<String> result = db.fetchColumn("SELECT KURSNAMN FROM KURS JOIN LARARE ON KURSLARARE = LARAR_ID WHERE FORNAMN = '" + namnArray[0] + "' AND EFTERNAMN = '"+ namnArray[1] + "' AND ((KURSSTART > CAST ('" + datum1 + "' AS DATE) AND  KURSSTART < CAST ('"+ datum2 + "' AS DATE) OR (KURSSLUT > CAST ('" + datum1 + "' AS DATE) AND KURSSLUT < CAST ('"+ datum2 + "' AS DATE))));");
                  
                    //tömm listan på gammla svar
                    model.clear();
                    
                    //populera listan med svarsposter
                    if(result != null){
                        for(String kurs : result){
                            model.addElement(kurs);
                        }
                    }
                    
                } catch (InfException ex) {
                    jLabelError.setText("DatumFel vänligen ange ett korrekt datum");
                }
            }else{
                jLabelError.setText("Datumen är inte enligt korekt format: vänligen ange yyyy/mm/dd");
            }
        }
        jList1.setModel(model);
    }//GEN-LAST:event_jButtonSokActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSok;
    private javax.swing.JComboBox<String> jComboBoxLarare;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelFran;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelLarare;
    private javax.swing.JLabel jLabelTill;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldFran;
    private javax.swing.JTextField jTextFieldTill;
    // End of variables declaration//GEN-END:variables
}
