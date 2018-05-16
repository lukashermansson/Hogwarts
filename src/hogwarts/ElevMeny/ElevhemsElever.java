/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hogwarts.ElevMeny;

import hogwarts.Util;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Denna del visar upp respektive elevhems elever.
 * 
 */
public class ElevhemsElever extends javax.swing.JPanel {
    private String[] elevhem = null;
    private InfDB db;
    /**
     * Creates new form ElevhemsElever
     */
    public ElevhemsElever(InfDB db) {
        this.db = db;
        elevhem = Util.elevhemsArray(db);
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableeEever = new javax.swing.JTable();
        jComboBoxElevhem = new javax.swing.JComboBox<>();
        jLabelInfo = new javax.swing.JLabel();
        jLabelError = new javax.swing.JLabel();

        jTableeEever.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Förnamn", "Efternamn"
            }
        ));
        jScrollPane1.setViewportView(jTableeEever);

        jComboBoxElevhem.setModel(new javax.swing.DefaultComboBoxModel<>(elevhem));
        jComboBoxElevhem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxElevhemActionPerformed(evt);
            }
        });

        jLabelInfo.setText("Lista elever i elevhem");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInfo)
                    .addComponent(jComboBoxElevhem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(162, Short.MAX_VALUE))
            .addComponent(jLabelError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabelInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxElevhem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jLabelError))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxElevhemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxElevhemActionPerformed
       
        
        
        //Sql frågan tar fram eleverna baserat på vilken sovsal de är tilldelade, och eftersom att alla sovsalar tillhör ett elevhem, kan vi ta reda på vilket elevhem det tillhör.
        try {
            ArrayList<HashMap<String, String>> result = db.fetchRows("SELECT FORNAMN, EFTERNAMN FROM ELEV JOIN SOVSAL ON SOVSAL = SOVSAL_ID JOIN ELEVHEM ON ELEVHEM = ELEVHEM_ID WHERE ELEVHEMSNAMN = '"+ jComboBoxElevhem.getSelectedItem().toString() +"';");
            //hämta ut tabelldatan
            DefaultTableModel model = (DefaultTableModel) jTableeEever.getModel();
            //nollställer inehållet
            model.setRowCount(0);
            if(result != null){
                for(HashMap<String, String> row : result){
                    //Lägg till rader i tabellen
                    model.addRow(new String[] {row.get("FORNAMN"), row.get("EFTERNAMN")});
                }
                jTableeEever.setModel(model); 
            }else{
                //det finns inga prefekter i det elevhemmet
                jLabelError.setText("Det finns inga prefekter i elevhemmet!");
            }
        } catch (InfException ex) {
            //Något gick fel i databasen
            jLabelError.setText("Databasfel: " + ex.getMessage());
        }
        
    }//GEN-LAST:event_jComboBoxElevhemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxElevhem;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableeEever;
    // End of variables declaration//GEN-END:variables
}
