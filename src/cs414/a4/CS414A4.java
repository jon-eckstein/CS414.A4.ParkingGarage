/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author jeckstein
 */
public class CS414A4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        
        ParkingGarage parkingGarage = new ParkingGarage();
        
        Integer selectedOption = listOptionsAndGetResult();
        
        switch(selectedOption){
            case 1:
                String ticketId = parkingGarage.createFullfillment();
                Utilities.printLn("Your ticket Id is: " + ticketId);
                Utilities.printLn("Please enter. Have a nice day.");
            
        } 
        
    }
    
    private static Integer listOptionsAndGetResult() throws IOException{
                
        boolean isSelectionOk = false;
        while(!isSelectionOk){
            Utilities.printLn("Please select from the following options:");
            Utilities.printLn("1) Get ticket for entry.");
            Utilities.printLn("2) Get exit total.");
            Utilities.printLn("3) Pay total with Credit or Debit Card.");
            Utilities.printLn("4) Pay total with Cash.");
            Utilities.printLn("5) Administrator Only: Set parking rate.");
            Utilities.printLn("6) Administrator Only: View usage reports.");
            Utilities.printLn("7) Administrator Only: View revenue reports.");
            Utilities.printLn("8) Quit.");
            InputStreamReader cin = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(cin);

            String option = in.readLine();
            Utilities.printLn("You typed: " + option);
            Integer intOption = Utilities.tryParseInt(option);
            if(intOption != null && intOption >= 1 && intOption <=8){
                isSelectionOk = true;
                return intOption;
            }else{
               Utilities.printLn("Invalid Selection.");
            }
        }
        return null;
    }
    
     
}
