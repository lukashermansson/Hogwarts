/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hogwarts.LararMeny.AdminMeny.Larare.AndraLarare;

import hogwarts.Util;
import hogwarts.Validation;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Byt ut förnamn, efternamn, och/eller lösenord för en lärare, eller ta bort en lärare.
 */
public class AndraLarareForm extends javax.swing.JFrame {
    private InfDB db;
    int lararID;
    
    String fornamn, efternamn, password;
    char admin;
    /**
     * Creates new form AndraLarareForm
     */
    public AndraLarareForm(InfDB db, int lararID) {
        this.db = db;
        this.lararID = lararID;
        initComponents();
        try {
            HashMap<String, String> res = db.fetchRow("SELECT FORNAMN, EFTERNAMN, LOSENORD, ADMINISTRATOR FROM LARARE WHERE LARAR_ID = " + lararID + ";");
            
            fornamn = res.get("FORNAMN");
            efternamn = res.get("EFTERNAMN");
            password = res.get("LOSENORD");
            
            admin = res.get("ADMINISTRATOR").charAt(0);
            
            
            jTextFieldFornamn.setText(fornamn);
            jTextFieldEfternamn.setText(efternamn);
            
            jCheckBoxAdmin.setSelected(Util.convertCharToBool(admin));
        } catch (InfException ex) {
            System.out.println("Sql fel");
        }
        
        
        this.setTitle(fornamn + " " + efternamn);
        jLabelElevInfo.setText("Andra info för: " + fornamn + " " + efternamn);
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelElevInfo = new javax.swing.JLabel();
        jLabelFornamn = new javax.swing.JLabel();
        jLabelEfternamn = new javax.swing.JLabel();
        jCheckBoxAdmin = new javax.swing.JCheckBox();
        jTextFieldFornamn = new javax.swing.JTextField();
        jTextFieldEfternamn = new javax.swing.JTextField();
        jButtonAndra = new javax.swing.JButton();
        jButtonTaBort = new javax.swing.JButton();
        jLabelError = new javax.swing.JLabel();
        jPasswordFieldLosen = new javax.swing.JPasswordField();
        jLabelLosen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelFornamn.setText("Nytt Förnamn:");

        jLabelEfternamn.setText("Nytt Efternamn:");

        jCheckBoxAdmin.setText("Admin");

        jButtonAndra.setText("Ändra");
        jButtonAndra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAndraActionPerformed(evt);
            }
        });

        jButtonTaBort.setText("Ta Bort Lärare");
        jButtonTaBort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTaBortActionPerformed(evt);
            }
        });

        jLabelLosen.setText("Nytt Lösen:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelFornamn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelEfternamn)
                                .addComponent(jLabelLosen))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPasswordFieldLosen)
                                .addComponent(jTextFieldEfternamn))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAndra)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonTaBort))
                    .addComponent(jCheckBoxAdmin)
                    .addComponent(jLabelElevInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelElevInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFornamn)
                    .addComponent(jTextFieldFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEfternamn)
                    .addComponent(jTextFieldEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLosen)
                    .addComponent(jPasswordFieldLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jCheckBoxAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonTaBort)
                    .addComponent(jButtonAndra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Denna knapp tar bort en lärare från skolans register om den inte är kurslärare eller föreståndare. 
    private void jButtonTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTaBortActionPerformed
        try {
            int antalElevhemsForestandarPositioner = Integer.parseInt(db.fetchSingle("SELECT COUNT(*) FROM ELEVHEM WHERE FORESTANDARE = " + lararID + ";"));
            if(antalElevhemsForestandarPositioner == 0){
                int antalKurser = Integer.parseInt(db.fetchSingle("SELECT COUNT(*) FROM KURS WHERE KURSLÄRARE = " + lararID + ";"));
                if(antalKurser == 0){
                    db.delete("DELETE FROM HAR_KOMPETENS_I WHERE LARAR_ID = " + lararID + ";");
                    db.delete("DELETE FROM LARARE WHERE LARAR_ID = " + lararID + ";");
                    this.setVisible(false);
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "Läraren togs bort!");
                }else{
                    JOptionPane.showMessageDialog(null, "Kan inte ta bort: Lararen är kurslärare för " + antalKurser + " kurs/kurser");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Kan inte ta bort: Lararen är föreståndare för något elevhem");
            }
        } catch (InfException ex) {
            System.out.println("SQL fel");
        }
    }//GEN-LAST:event_jButtonTaBortActionPerformed

    private void jButtonAndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAndraActionPerformed
        // TODO add your handling code here:
        boolean failed = false;
        boolean noPass = false;
        try{
            if(Validation.textComponentEmpty(jPasswordFieldLosen)){
                noPass = true;
            
            }
            System.out.println(jTextFieldFornamn.getText());
            System.out.println(jTextFieldEfternamn.getText());
            
            System.out.println(Validation.stringContainsNumber(jTextFieldEfternamn.getText()));
            System.out.println(Validation.stringContainsSpace(jTextFieldEfternamn.getText()));
            System.out.println(Validation.isValidName(jTextFieldEfternamn.getText()));
            if(Validation.textComponentEmpty(jTextFieldFornamn)){
                failed = true;
                jLabelError.setText("Vanligen skriv in ett förnamn");
            }
            if(Validation.textComponentEmpty(jTextFieldEfternamn)){
                failed = true;
                jLabelError.setText("Vanligen skriv in ett efternamn");
            }
            if(!Validation.isValidName(jTextFieldFornamn.getText())){
                failed = true;
                jLabelError.setText("Förnamnet får ej inehålla mellanrumm eller siffror");
            }
            if(!Validation.isValidName(jTextFieldEfternamn.getText())){
                failed = true;
                jLabelError.setText("Efternamnet får ej inehålla mellanrumm eller siffror");
            }
            if(!Validation.valideraLängdPaLararNamn(jTextFieldFornamn.getText())){
                failed = true;
                jLabelError.setText("Vanligen ange minst tre täcken i som förnamn");
            }
            if(!Validation.valideraLängdPaLararNamn(jTextFieldEfternamn.getText())){
                failed = true;
                jLabelError.setText("Vanligen ange minst tre täcken i som efternamn");
            }
            
        
        
            if(!failed){
                String treFornamn = jTextFieldFornamn.getText().substring(0, 3);
                String treEfternamn = jTextFieldFornamn.getText().substring(0, 3);
                int result = Integer.parseInt(db.fetchSingle("SELECT count(*) FROM LARARE WHERE FORNAMN LIKE '" + treFornamn + "%' AND EFTERNAMN LIKE '" + treEfternamn + "%' AND LARAR_ID != " + lararID + ";"));
                if(result == 0){
                        db.update("UPDATE LARARE SET FORNAMN = '"+ jTextFieldFornamn.getText() +"', EFTERNAMN = '" + jTextFieldEfternamn.getText() + "', ADMINISTRATOR = '" + Util.convertBoolToChar(jCheckBoxAdmin.isSelected()) + "' WHERE LARAR_ID = "+ lararID + ";");
                    if(!noPass){
                        db.update("UPDATE LARARE SET LOSENORD = '" + Util.stringFromCharArray(jPasswordFieldLosen.getPassword()) + "' WHERE LARAR_ID = " + lararID + ";");
                    }
                    jLabelError.setText("Uppdaterade andvändaren!");
                }else{
                    jLabelError.setText("Det existerar redan en andvändare med det andvändarnamnet.");
                }
                
               
            }
        
        }catch(InfException ex){
            
        }
    }//GEN-LAST:event_jButtonAndraActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAndra;
    private javax.swing.JButton jButtonTaBort;
    private javax.swing.JCheckBox jCheckBoxAdmin;
    private javax.swing.JLabel jLabelEfternamn;
    private javax.swing.JLabel jLabelElevInfo;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelFornamn;
    private javax.swing.JLabel jLabelLosen;
    private javax.swing.JPasswordField jPasswordFieldLosen;
    private javax.swing.JTextField jTextFieldEfternamn;
    private javax.swing.JTextField jTextFieldFornamn;
    // End of variables declaration//GEN-END:variables
}
