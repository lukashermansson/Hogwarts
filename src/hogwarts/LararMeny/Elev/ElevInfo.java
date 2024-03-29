/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hogwarts.LararMeny.Elev;

import hogwarts.Validation;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Välj en elev att ändra information om alternativt att ta bort. 
 * detta dyker upp i elevInfoForm klassen.
 */
public class ElevInfo extends javax.swing.JPanel {

    private InfDB db;
    private int lararID;

    /**
     * Creates new form ElevInfo
     */

    public ElevInfo(InfDB db, int lararID) {
        //Uppdatera fält
        this.db = db;
        this.lararID = lararID;
        
        //Genera inehåll!
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

        jPanel5 = new javax.swing.JPanel();
        jLabelInfo = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabelFornamn = new javax.swing.JLabel();
        jLabelEfternamn = new javax.swing.JLabel();
        jButtonValj = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jTextFornamn = new javax.swing.JTextField();
        jTextEfternamn = new javax.swing.JTextField();
        jLabelError1 = new javax.swing.JLabel();
        jLabelError2 = new javax.swing.JLabel();

        jPanel5.setForeground(new java.awt.Color(51, 51, 255));

        jLabelInfo.setText("Välj en elev att ändra information om.");

        jLabelFornamn.setText("Förnamn:");

        jLabelEfternamn.setText("Efternamn:");

        jButtonValj.setText("Välj elev");
        jButtonValj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValjActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel19))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelError2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelError1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(40, 40, 40))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabelInfo))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonValj)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEfternamn)
                                    .addComponent(jLabelFornamn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInfo)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFornamn)
                            .addComponent(jTextFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEfternamn)
                            .addComponent(jTextEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jButtonValj)
                        .addGap(43, 43, 43)
                        .addComponent(jLabelError2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabelError1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 863, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValjActionPerformed
        // TODO add your handling code here:
        String fraga = "SELECT ELEV_ID FROM ELEV WHERE FORNAMN = '" + jTextFornamn.getText() + "' AND EFTERNAMN = '" + jTextEfternamn.getText() + "';";
        
        //kontrolera att båda textruterna har innehåll
        if (!Validation.textComponentEmpty(jTextFornamn) && !Validation.textComponentEmpty(jTextEfternamn)) {
            String fornamn = jTextFornamn.getText();
            String efternamn = jTextEfternamn.getText();

            try {
                String fragaID = db.fetchSingle(fraga);
                if(fragaID != null){
                    //evelen finns visa popupskärmenn
                    new ElevInfoForm(db, Integer.parseInt(fragaID), lararID).setVisible(true);
                    
                } else {
                    jLabelError1.setText("Vänligen skriv in ett namn på en existerande elev");
                }
                
            } catch (InfException ex) {
                //Ett fel i sql har skett
                jLabelError1.setText("SQL Fel");
            }

        } else {
            jLabelError1.setText("Vänligen skriv in ett förnamn och efternamn");

        }
    }//GEN-LAST:event_jButtonValjActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonValj;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabelEfternamn;
    private javax.swing.JLabel jLabelError1;
    private javax.swing.JLabel jLabelError2;
    private javax.swing.JLabel jLabelFornamn;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextEfternamn;
    private javax.swing.JTextField jTextFornamn;
    // End of variables declaration//GEN-END:variables
}
