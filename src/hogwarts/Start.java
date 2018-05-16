/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hogwarts;

import oru.inf.InfDB;
import oru.inf.InfException;

import javax.swing.JOptionPane;

/**
 * Den här klassen startar själva arbetet
 */
public class Start {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //hämta fram databasfilens sökväg
        String filepath = Start.class.getResource("HOGDB.FDB").toExternalForm();
        //String filepath = file.getPath();
        filepath = filepath.replace("file:/", "");
        filepath = filepath.replace("%20", " ");
        //filepath = filepath.replace("jar:", "jar:/");
        //System.out.println(filepath);
        try {
            InfDB databas = new InfDB(filepath);
               
            new LoginForm(databas).setVisible(true);
        }catch(InfException e){
            
            JOptionPane.showMessageDialog(null, "Kunde inte koppla upp mot databasen! " + filepath, "Fel", 2);
            
        }
        
        
    }
    
    
    
}
