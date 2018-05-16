/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hogwarts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.text.JTextComponent;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * En av våra bibilioteksklasser som används för att göra delar av arbetet mer 
 * inkapslade.
 */
public class Validation {
    
    public static boolean isValidName(String name){
        if(!stringContainsSpace(name) && !stringContainsNumber(name)){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean stringContainsSpace(String inp){
        return inp.contains(" ");
    }
    public static boolean stringContainsNumber(String inp){
        for(char character : inp.toCharArray()){
            if(Character.isDigit(character)){
                return true;
            }
        }
        return false;
    }
    public static boolean textComponentEmpty(JTextComponent comp){
        
        if(comp.getText().equals("")){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean datumValidering(String datum){
        
        if(datum == null){
            return false;
        }
        SimpleDateFormat datumValiderare = new SimpleDateFormat("yyyy/mm/dd");
        
        
        try {
            datumValiderare.parse(datum);  
	} catch (ParseException e) {
            return false;
	}

	return true;
    }
    
    public enum losenValidering {
      SUCCESSFULL, WRONG_USERNAME_FORMAT, NO_USER, WRONG_PASSWORD, SQL_ERROR
    }
    
    public static boolean valideraLängdPaLararNamn(String namn){
        if(namn.length() >= 3){
            return true;
        }else{
            return false; 
        }
        
    }
    
    public static losenValidering valideraLösenord(InfDB db, String user, String password){
        String treFornamn = null;
        String treEfternamn = null;
        //Plocka framm 3 första förnamn och 3 första efternamn 
        if(user.length() > 5 && user.length() < 7){
       
            treFornamn = user.substring(0, 3);
            treEfternamn = user.substring(3, 6);
            
        }else{
            //jLabel3.setText("Felaktigt format på andvändarnamn! Vänligen skriv in 6st täcken!");
            return losenValidering.WRONG_USERNAME_FORMAT;
        }
        
        
        if(treFornamn != null && treEfternamn != null){
            String SQLPassword = null;
            
            try{
                String result = db.fetchSingle("SELECT LOSENORD FROM LARARE WHERE FORNAMN LIKE '" + treFornamn + "%' AND EFTERNAMN LIKE '" + treEfternamn + "%';");
                if(result != null){
                    SQLPassword = result;
                }
            }catch(InfException e){
                return losenValidering.SQL_ERROR;
            }
            //Lösenortds validering
            if(SQLPassword != null){
                if(password.equals(SQLPassword)){
                    //Sucsessfull
                    return losenValidering.SUCCESSFULL;
                    
                }else{
                    //Unsucsessfull
                    //jLabel3.setText("Fel Lösenord och andvändarkombination");
                    return losenValidering.WRONG_PASSWORD;
                }
            
            }else{
                //Sql got no rows
                //jLabel3.setText("Det finns ingen andvändare med det namnet");
                return losenValidering.NO_USER;
            }
        }else{
            return losenValidering.WRONG_USERNAME_FORMAT;
        }
    }
}
