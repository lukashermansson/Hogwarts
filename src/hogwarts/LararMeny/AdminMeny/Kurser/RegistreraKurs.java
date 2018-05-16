/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hogwarts.LararMeny.AdminMeny.Kurser;

import hogwarts.Util;
import hogwarts.Validation;
import java.util.ArrayList;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Denna del lägger till kurser för Hogwarts. 
 * man får välja kursnamn (frivilligt i en textruta), lärare (genom en combobox),
 * vilket ämne de tillhör (också genom en combobox), och start o slutdatum.
 * 
 */
public class RegistreraKurs extends javax.swing.JPanel {
    
    private InfDB db;
    private String[] larare;
    private String[] amnen;

    /**
     * Creates new form RegistreraKurs
     */
    public RegistreraKurs(InfDB db) {
        this.db = db;
        //skapar en lista för lärare så att man kan bestämma läraren i combo boxen
        ArrayList<String> listan = new ArrayList<String>();
        //skapar en lista för ämnen som kan bestämma ämnen i combo boxen.
        ArrayList<String> amnelista = new ArrayList<String>();
        //Gör ett försök att fylla lärarlistan som kallas listan.
        try {
            ArrayList<HashMap<String, String>> result = db.fetchRows("SELECT FORNAMN, EFTERNAMN FROM LARARE;");
            if(result != null){
                for(HashMap<String, String> row: result){
                    //denna del lägger in namnet på läraren i listan, men separarer förnamn och efternamnet.
                    listan.add(row.get("FORNAMN") + " " + row.get("EFTERNAMN"));
                }
            }else{
                jLabelError1.setText("Finns inga lärare");
            }
            //blir det något fel i try, kommer detta skrivas.
        } catch (InfException ex) {
           jLabelError1.setText("Databasfel när lärardata hämtades: " + ex.getMessage());
        }
        larare = Util.konverteraArrayListTillArray(listan);
        
        //Denna del fyller i amneslistan med namn på ämnena. Det som läggs till i databasen är detta ämnes ID nummer.
        try {
            ArrayList<HashMap<String, String>> res = db.fetchRows("SELECT AMNESNAMN FROM AMNE;");
            if(res != null){
                for(HashMap<String, String> row: res){
                    amnelista.add(row.get("AMNESNAMN"));
                }
            }else{
                jLabelError1.setText("Finns inga ämnen");
            }
        }catch (InfException ex) {
                jLabelError1.setText("Databasfel när ämnesdata hämtades: " + ex.getMessage());
        }
        amnen = Util.konverteraArrayListTillArray(amnelista);
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
        jLabelKurs = new javax.swing.JLabel();
        jTextFieldKurs = new javax.swing.JTextField();
        jLabelLarare = new javax.swing.JLabel();
        jLabelFran = new javax.swing.JLabel();
        jTextFieldFran = new javax.swing.JTextField();
        jLabelTill = new javax.swing.JLabel();
        jTextFieldTill = new javax.swing.JTextField();
        jLabelAmne = new javax.swing.JLabel();
        jComboBoxLarare = new javax.swing.JComboBox<>();
        jComboBoxAmne = new javax.swing.JComboBox<>();
        jButtonLaggTill = new javax.swing.JButton();
        jLabelError1 = new javax.swing.JLabel();
        jLabelError2 = new javax.swing.JLabel();

        jLabelInfo.setText("Lägg till en kurs");

        jLabelKurs.setText("Kursnamn:");

        jLabelLarare.setText("Lärare:");

        jLabelFran.setText("Från:");

        jLabelTill.setText("Till:");

        jTextFieldTill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTillActionPerformed(evt);
            }
        });

        jLabelAmne.setText("Tillhör ämne:");

        jComboBoxLarare.setModel(new javax.swing.DefaultComboBoxModel<>(larare));

        jComboBoxAmne.setModel(new javax.swing.DefaultComboBoxModel<>(amnen));

        jButtonLaggTill.setText("Lägg till");
        jButtonLaggTill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLaggTillActionPerformed(evt);
            }
        });

        jLabelError1.setText("                                   ");

        jLabelError2.setText("                   ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInfo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelKurs)
                            .addComponent(jLabelLarare))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldKurs, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxAmne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxLarare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFran)
                            .addComponent(jTextFieldFran, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTill, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTill)))
                    .addComponent(jLabelAmne)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonLaggTill)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelError2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelError1))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelKurs)
                    .addComponent(jTextFieldKurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLarare)
                    .addComponent(jComboBoxLarare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAmne)
                    .addComponent(jComboBoxAmne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFran)
                    .addComponent(jLabelTill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLaggTill)
                    .addComponent(jLabelError2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelError1)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLaggTillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLaggTillActionPerformed
        // TODO add your handling code here:
        //Denna del av kodningen har hand om vad som händer när man trycker på knappen med texten "Lägg till"
        
        if(!Validation.textComponentEmpty(jTextFieldKurs) && !Validation.textComponentEmpty(jTextFieldFran) && !Validation.textComponentEmpty(jTextFieldTill)){
            //String delarna här ger en variabel vi kan använda oss av i sql frågorna.
            String kursNamnField = jTextFieldKurs.getText();
            String startDatum = jTextFieldFran.getText();
            String slutDatum = jTextFieldTill.getText();
            
            //tar namnen från lärare combo boxen och separerar för och efternamnet.
            String lararVal = (String)jComboBoxLarare.getSelectedItem();
            String[] lararNamn = lararVal.split(" ");
            
            String amnesVal = (String)jComboBoxAmne.getSelectedItem();
            
            try {
                //String lararID delen tar fram namnen som vi separaerade ovanför och ger en möjlighet för oss att söka på deras id nummer.
                String lararID = db.fetchSingle("SELECT LARAR_ID FROM LARARE WHERE FORNAMN = '" + lararNamn[0] +  "' AND EFTERNAMN = '" + lararNamn[1] + "'");
                String amnesID = db.fetchSingle("SELECT AMNE_ID FROM AMNE WHERE AMNESNAMN = '" +amnesVal+"'");
                db.insert("INSERT INTO KURS (KURS_ID, KURSNAMN, KURSSTART, KURSSLUT, KURSLARARE, AMNESTILLHORIGHET) VALUES (((SELECT FIRST 1 KURS_ID FROM KURS ORDER BY KURS_ID DESC) +1),'" +kursNamnField+"','" +startDatum+"','"+slutDatum+"','"+lararID+"','"+amnesID+"');");
                jLabelError2.setText("Kursen har nu lagts till.");
                jLabelError1.setText(" ");
            } catch (InfException ex) {
                jLabelError1.setText("Något gick fel, kolla datumen");
                jLabelError2.setText(" ");
            }
        }
            
        
    }//GEN-LAST:event_jButtonLaggTillActionPerformed

    private void jTextFieldTillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTillActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLaggTill;
    private javax.swing.JComboBox<String> jComboBoxAmne;
    private javax.swing.JComboBox<String> jComboBoxLarare;
    private javax.swing.JLabel jLabelAmne;
    private javax.swing.JLabel jLabelError1;
    private javax.swing.JLabel jLabelError2;
    private javax.swing.JLabel jLabelFran;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelKurs;
    private javax.swing.JLabel jLabelLarare;
    private javax.swing.JLabel jLabelTill;
    private javax.swing.JTextField jTextFieldFran;
    private javax.swing.JTextField jTextFieldKurs;
    private javax.swing.JTextField jTextFieldTill;
    // End of variables declaration//GEN-END:variables
}
