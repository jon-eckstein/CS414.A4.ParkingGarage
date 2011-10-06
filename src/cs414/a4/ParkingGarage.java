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
   private EntryExitManager spotFullfillmentManager;
   private RateManager rateManager;
   private PaymentManager paymentManager;
   private int totalSpots;  
   private final int DEFAULT_TOTAL_SPOTS = 30;
   
   public ParkingGarage(EntryExitManager sfm, RateManager rm, PaymentManager pm, int numSpots){       
       spotFullfillmentManager = sfm;
       rateManager = rm;       
       paymentManager = pm;
       totalSpots = numSpots;
   }
   
   public ParkingGarage(){
       this(new EntryExitManager(), new RateManager(), new PaymentManager(new PaymentGateway()), 30);
   }
   
   
   
   /*
   public ParkingGarage()             
   {
       this(new SpotFullfillment(), new RateManager());
   }
   */
   
   public String createFullfillment() throws Exception{
       int totalFilled = spotFullfillmentManager.getTotalFullfilledSpots();
       
        if(totalFilled < totalSpots){
           SpotFullfillment spot = spotFullfillmentManager.createFullfillment();
           return spot.getTicketNumber();           
       }else{
           throw new Exception("Parking lot is full.");
       }              
   }

   public double processExit(String ticketId, Date exitDateTime) throws Exception{
       SpotFullfillment spot = spotFullfillmentManager.getSpotFullfillment(ticketId);
       spot.setExitDateTime(exitDateTime);       
       double currentRate = rateManager.getRegularRate(spot.getEntryDateTime(), spot.getExitDateTime());
       spot.setRate(currentRate);
       double total = spot.getTotal();
       return total;                  
   }
   
   public double processFlatRateExit(Date exitDateTime) throws Exception{
       return rateManager.getFlatRate(exitDateTime);
   }
   
   
   public void processCardPayment(BigDecimal amount, String cardNumber, Date expireDate, String ticketId) throws Exception{       
       paymentManager.createCreditCardPayment(amount, new Date(), cardNumber, expireDate, ticketId);
   }
   
   public void processCashPayment(BigDecimal amount, String ticketId){
       paymentManager.createCashPayment(amount, new Date(), ticketId);
   }
   
   public void setRate(Date startDate, Date endDate, double rate, boolean isFlatRate){       
        rateManager.setRate(startDate, endDate, rate, isFlatRate);       
   }
   
   
   
    /**
     * @return the totalAvailableSpots
     */
    public int getTotalAvailableSpots() {
        return totalSpots;
    }
    
    
}
