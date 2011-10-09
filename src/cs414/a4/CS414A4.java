/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jeckstein
 */
public class CS414A4 {

    private static InputStreamReader cin;
    private static BufferedReader in;
    private static ParkingGarage parkingGarage;
    private static DateFormat dateFormatter;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        cin = new InputStreamReader(System.in);
        in = new BufferedReader(cin);        
        parkingGarage = new ParkingGarage();
        dateFormatter = new SimpleDateFormat("MM/dd/yy");
        listMenuAndPerformAction();
    }
    
    private static void listMenuAndPerformAction() throws IOException{
        
        Integer selectedOption = listOptionsAndGetResult();
        try{
            switch(selectedOption){
                case 1:
                    int availableSpots = parkingGarage.getAvailableSpotCount();
                    Utilities.printLn("Open spot count is: " + availableSpots);
                    break;
                case 2:
                    String entryTicketId = parkingGarage.createEntryEvent();
                    Utilities.printLn("Your ticket Id is: " + entryTicketId);
                    Utilities.printLn("Please enter the garage and find a parking spot. Have a nice day!");
                    break;
                case 3:
                    Utilities.printLn("Please enter your ticket number:");
                    String exitTicketId = in.readLine(); 
                    BigDecimal regularTotal = parkingGarage.processExit(exitTicketId, new Date());
                    Utilities.printLn("Your total is: " + regularTotal.toString());
                    Utilities.printLn("How would you like to pay this total? Cash [C], Card [CD], or IOU [IOU]");
                    String payOption = in.readLine();
                    if(payOption.equals("C")){
                        parkingGarage.processCashPayment(regularTotal, exitTicketId);
                    }else if(payOption.equals("CD")){
                        Utilities.printLn("Please enter card number, expiration date (MM/dd/yyyy):");
                        String[] cardDetails = in.readLine().split(",");                        
                        parkingGarage.processCardPayment(regularTotal, cardDetails[0], dateFormatter.parse(cardDetails[1]) , exitTicketId);
                    }else if(payOption.equals("IOU")){
                        Utilities.printLn("Please enter customer name, phone number, address:");        
                        String[] customerDetails = in.readLine().split(",");
                        parkingGarage.processIou(regularTotal, customerDetails[0], customerDetails[1], customerDetails[2], exitTicketId);
                    }else{
                        Utilities.printLn("Invalid option.");        
                    }
                    Utilities.printLn("Thank you for your business. Please come again.");        
                    break;
                case 4:
                    BigDecimal flatTotal = parkingGarage.processExit(null, new Date());
                    Utilities.printLn("Your total is: " + flatTotal.toString());                    
                    break;
                case 5:
                    
                case 7:                    
                    boolean isFlatRate = false;
                    Utilities.printLn("Would you like to set a flat rate? Yes [Y], No [N]:");
                    String rateAnswer = in.readLine();
                    if(rateAnswer.equals("Y"))                        
                        isFlatRate = true;
                    Utilities.printLn("Please enter the amount, start date(mm/dd/yy), end date(mm/dd/yy):");
                    String rateLine = in.readLine();
                    String[] rateDetails = rateLine.split(",");
                    BigDecimal rate = new BigDecimal(rateDetails[0]);
                    Date startDate = dateFormatter.parse(rateDetails[1]);
                    Date endDate = dateFormatter.parse(rateDetails[2]);
                    parkingGarage.setRate(startDate, endDate, rate, isFlatRate);
                    Utilities.printLn("Rate set.");
                    break;
                case 9:
                    Utilities.printLn("Bye!");
                    return;
            }
            listMenuAndPerformAction();
        }catch(Exception ex){
            Utilities.printLn("************************************************************");
            Utilities.printLn("There was a problem with your request:\n" + ex.getMessage());
            Utilities.printLn("************************************************************");
            Utilities.printLn("");
            listMenuAndPerformAction();
        }
    }
    
    private static Integer listOptionsAndGetResult() throws IOException{
                
        boolean isSelectionOk = false;
        while(!isSelectionOk){
            Utilities.printLn("Please select from the following options:");
            Utilities.printLn("1) Show available spot count.");
            Utilities.printLn("2) Get ticket for entry.");
            Utilities.printLn("3) Get exit total.");
            Utilities.printLn("4) Get exit total for lost or damaged ticket.");            
            Utilities.printLn("5) Pay total with Credit or Debit Card.");
            Utilities.printLn("6) Pay total with Cash.");
            Utilities.printLn("7) Administrator Only: Set parking rate.");
            Utilities.printLn("8) Administrator Only: View usage reports.");
            Utilities.printLn("9) Administrator Only: View revenue reports.");
            Utilities.printLn("10) Quit.");
           
            String option = in.readLine();
     
            Integer intOption = Utilities.tryParseInt(option);
            if(intOption != null && intOption >= 1 && intOption <=10){
                isSelectionOk = true;
                return intOption;
            }else{
               Utilities.printLn("Invalid Selection.");
            }
        }
        return null;
    }     
}
