/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author jeckstein
 */
public class ParkingGarage {
   private EntryExitManager entryExitManager;
   private RateManager rateManager;
   private PaymentManager paymentManager;
   private ReportManager reportManager;
   private int totalSpots;  
   private static final int DEFAULT_TOTAL_SPOTS = 100;
   
   
   public ParkingGarage(EntryExitManager eem, PaymentManager pm, int numSpots){       
       entryExitManager = eem;
       rateManager = eem.rateManager;       
       paymentManager = pm;
       totalSpots = numSpots;
       reportManager = new ReportManager(entryExitManager, totalSpots);
   }
   
   public ParkingGarage(){
       this(new EntryExitManager(new RateManager()), new PaymentManager(new PaymentGateway()), DEFAULT_TOTAL_SPOTS);
   }
   
   
   public String createEntryEvent(Date entryDate) throws Exception{
       int totalFilled = entryExitManager.getFilledSpots();
       
        if(totalFilled < totalSpots){
           EntryEvent spot = entryExitManager.createEntryEvent(entryDate);
           return spot.getTicketId();           
       }else{
           throw new Exception("Parking lot is full.");
       }              
   }

   public String createEntryEvent() throws Exception{
       return createEntryEvent(new Date());
   }
   
   public BigDecimal processExit(String ticketId, Date exitDateTime) throws Exception{
       ExitEvent exit = entryExitManager.createExitEvent(ticketId, exitDateTime);
       return exit.getTotal();        
   }
  
    
   public void processCardPayment(BigDecimal amount, String cardNumber, Date expireDate, String ticketId) throws Exception{       
       ExitEvent exitEvent = entryExitManager.getExitEvent(ticketId);
       Payment payment = paymentManager.createCreditCardPayment(amount, new Date(), cardNumber, expireDate);
       exitEvent.addPayment(payment);
   }
   
   public void processCashPayment(BigDecimal amount, String ticketId) throws Exception{
       ExitEvent exitEvent = entryExitManager.getExitEvent(ticketId);
       Payment payment = paymentManager.createCashPayment(amount, new Date());
       exitEvent.addPayment(payment);
   }
   
   public void processIou(BigDecimal amount, String customerName, String customerPhone, String customerAddress, String ticketId) throws Exception{
       ExitEvent exitEvent = entryExitManager.getExitEvent(ticketId);
       exitEvent.setBalanceOwed(new BalanceOwed(amount, new Date(), customerName, customerAddress, customerPhone));             
   }
   
   public void setRate(Date startDate, Date endDate, BigDecimal rate, boolean isFlatRate){       
        rateManager.setRate(startDate, endDate, rate, isFlatRate);       
   }
   
   public int getAvailableSpotCount(){
       return getTotalSpots() - entryExitManager.getFilledSpots();
   }
   
   public UsageReportViewModel getUsageReport(Date startDate, Date endDate){
       return reportManager.getUsageReport(startDate, endDate);
   }
   
    /**
     * @return the totalSpots
     */
    public int getTotalSpots() {
        return totalSpots;
    }    
}
