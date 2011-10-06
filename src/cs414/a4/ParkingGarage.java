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
   private int totalSpots;  
   private static final int DEFAULT_TOTAL_SPOTS = 30;
   
   public ParkingGarage(EntryExitManager eem, PaymentManager pm, int numSpots){       
       entryExitManager = eem;
       rateManager = eem.rateManager;       
       paymentManager = pm;
       totalSpots = numSpots;
   }
   
   public ParkingGarage(){
       this(new EntryExitManager(new RateManager()), new PaymentManager(new PaymentGateway()), DEFAULT_TOTAL_SPOTS);
   }
   
   public String createEntryEvent() throws Exception{
       int totalFilled = entryExitManager.getFilledSpots();
       
        if(totalFilled < totalSpots){
           EntryEvent spot = entryExitManager.createEntryEvent();
           return spot.getTicketId();           
       }else{
           throw new Exception("Parking lot is full.");
       }              
   }

   public BigDecimal processExit(String ticketId, Date exitDateTime) throws Exception{
       ExitEvent exit = entryExitManager.createExitEvent(ticketId, exitDateTime);
       return exit.getTotal();        
   }
  
    
   public void processCardPayment(BigDecimal amount, String cardNumber, Date expireDate, String ticketId) throws Exception{       
       paymentManager.createCreditCardPayment(amount, new Date(), cardNumber, expireDate, ticketId);
   }
   
   public void processCashPayment(BigDecimal amount, String ticketId){
       paymentManager.createCashPayment(amount, new Date(), ticketId);
   }
   
   public void setRate(Date startDate, Date endDate, BigDecimal rate, boolean isFlatRate){       
        rateManager.setRate(startDate, endDate, rate, isFlatRate);       
   }
   
    /**
     * @return the totalSpots
     */
    public int getTotalSpots() {
        return totalSpots;
    }    
}
