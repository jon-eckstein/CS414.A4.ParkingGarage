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
import java.util.Calendar;
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
                    getCustomerPayment(regularTotal, exitTicketId);
                    
                    break;
                case 4:
                    BigDecimal flatTotal = parkingGarage.processExit(null, new Date());
                    Utilities.printLn("Your total is: " + flatTotal.toString());                    
                    getCustomerPayment(flatTotal, null);
                    break;
                                    
                case 5:                    
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
                case 6:
                    Utilities.printLn("Please enter the start date(mm/dd/yy), end date(mm/dd/yy), breakdown(months[MO],days[D],hours[H], minutes[MI]):");
                    String reportLine = in.readLine();
                    String[] reportDetails = reportLine.split(",");
                    Date reportStartDate = dateFormatter.parse(reportDetails[0]);
                    Date reportEndDate = dateFormatter.parse(reportDetails[1]);
                    int delimeter = 0;
                    if(reportDetails[3].equals("MO"))                    
                        delimeter = Calendar.MONTH;
                    if(reportDetails[3].equals("D"))                    
                        delimeter = Calendar.DATE;
                    if(reportDetails[3].equals("H"))                    
                        delimeter = Calendar.HOUR;
                    if(reportDetails[3].equals("MI"))                    
                        delimeter = Calendar.MINUTE;
                    printUsageReport(parkingGarage.getUsageReport(reportStartDate, reportEndDate, delimeter));
                    break;
                case 7:
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
            Utilities.printLn("5) Administrator Only: Set parking rate.");
            Utilities.printLn("6) Administrator Only: View usage reports.");
            Utilities.printLn("7) Quit.");
           
            String option = in.readLine();
     
            Integer intOption = Utilities.tryParseInt(option);
            if(intOption != null && intOption >= 1 && intOption <=7){
                isSelectionOk = true;
                return intOption;
            }else{
               Utilities.printLn("Invalid Selection.");
            }
        }
        return null;
    }
    
    
    private static void getCustomerPayment(BigDecimal total, String ticketId) throws Exception{
        boolean validOption = false;
        while(validOption){
            Utilities.printLn("How would you like to pay this total? Cash [C], Card [CD], or IOU [IOU]");
            String payOption = in.readLine();

            if(payOption.equals("C")){
                validOption = true;
                parkingGarage.processCashPayment(total, ticketId);                
            }else if(payOption.equals("CD")){
                validOption = true;
                Utilities.printLn("Please enter card number, expiration date (MM/dd/yyyy):");
                String[] cardDetails = in.readLine().split(",");                        
                parkingGarage.processCardPayment(total, cardDetails[0], dateFormatter.parse(cardDetails[1]) , ticketId);
            }else if(payOption.equals("IOU")){
                validOption = true;
                Utilities.printLn("Please enter customer name, phone number, address:");        
                String[] customerDetails = in.readLine().split(",");
                parkingGarage.processIou(total, customerDetails[0], customerDetails[1], customerDetails[2], ticketId);
            }else{
                Utilities.printLn("Invalid option.");        
            }
        }
        Utilities.printLn("Thank you for your business. Please come again.");        
    }
    
    private static void printUsageReport(UsageReportViewModel viewModel){
        
        String delimeter="";
        if(viewModel.getDelimiter() == Calendar.MONTH)
            delimeter = "Month";
        if(viewModel.getDelimiter() == Calendar.DATE)
            delimeter = "Day";
        if(viewModel.getDelimiter() == Calendar.HOUR)
            delimeter = "Hour";
        if(viewModel.getDelimiter() == Calendar.MINUTE)
            delimeter = " Minute";
        
        Utilities.printLn("***********************************************");
        Utilities.printLn("Garage Usage Report");
        Utilities.printLn("Staring:" + viewModel.getStartDate() + ", Ending:" + viewModel.getEndDate() + ".");                       
        Utilities.printLn("***********************************************");
        Utilities.printLn("Date\t\t" + delimeter + "\tSpots Taken\tPercent Filled");
        for(UsageReportDetail detail : viewModel.getReportDetail()){            
            Utilities.printLn(dateFormatter.format(detail.detailDate) + "\t" + detail.delimeter + "\t" + detail.numSpotFilled + "\t\t" + detail.percentageOccupied);
        }
    }
}
