/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hogwarts;

import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * En av våra bibilioteksklasser som används för att göra delar av arbetet mer 
 * inkapslade.
 */
public class Util {
    
    
    public Util(){
    }
    /**
     *
     * @param lista
     * @return
     */
    public static String[] konverteraArrayListTillArray(ArrayList<String> lista) {
        
        String [] sektionsArray = new String[lista.size()];
        for(int i = 0; i < lista.size(); i++){
            sektionsArray[i] = lista.get(i);
        }
        
        return sektionsArray;
    }
    public static boolean convertCharToBool(char c){
        
        if(c == 'T'){
            return true;
        }else{
            return false;
        }
    }
    public static char convertBoolToChar(boolean b){
        
        if(b){
            return 'T';
        }else{
            return 'F';
        }
    }
    public static boolean isAdmin(InfDB db, int id){
         try {
            String result = db.fetchSingle("Select ADMINISTRATOR FROM LARARE WHERE LARAR_ID = " + id + ";");
            if(result != null){
                return convertCharToBool(result.charAt(0));
            }else{
                return false;
            }
            
        } catch (InfException ex) {
            return false;
        }
    }
    
    public static String[] elevhemsArray(InfDB db){
        
         try {
            ArrayList<String> result = db.fetchColumn("SELECT ELEVHEMSNAMN FROM ELEVHEM;");
            
            return konverteraArrayListTillArray(result);
        } catch (InfException ex) {
            return null;
        }
    
    }
    public static String stringFromCharArray(char[] array){
        String string = "";
        //Lägg ihop alla karaktärer till en sträng 
        for(int i = 0; i < array.length; i++){
            string = string + array[i];
        }
        return string;
    }
    
    
    
}



