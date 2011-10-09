/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jeckstein
 */
public class ExitEvent {
    
    private EntryEvent entryEvent;
    private ArrayList<Payment> payments;
    private BalanceOwed balance;
    private Date exitDateTime;    
    private BigDecimal rate;    
    private boolean isFlatRate = false;
    private final int  HOURS_IN_MILLI = 1000*60*60;
    
    public ExitEvent(EntryEvent entryEvent, Date exitDateTime, BigDecimal rate){
        this.entryEvent = entryEvent;
        this.exitDateTime = exitDateTime;
        this.rate = rate;
        if(entryEvent == null)
        isFlatRate = true;
    }
    
    
    public BigDecimal getTotal() {       
        if(isFlatRate)
            return rate;
        else{                
            long hourDiff =  (exitDateTime.getTime()/HOURS_IN_MILLI) - (getEntryDate().getTime()/HOURS_IN_MILLI);
            //long hourDiff = (long) (milliDiff * (2.77777778 )* 10e-7);
            //long hourDiff = (long) (milliDiff / 1000 * 60 * 60);
            if(hourDiff <= 0)
                hourDiff = 1;
            
            return BigDecimal.valueOf(hourDiff).multiply(rate);
        }
    }
    
    public String getTicketId(){
        if(entryEvent != null)
            return entryEvent.getTicketId();
        else
            return null;
    }
    
    public Date getEntryDate(){        
        if(entryEvent != null)
            return entryEvent.getEntryDate();
        else
            return null;        
    }
    
    public Date getExitDate(){
        return this.exitDateTime;
    }
    
    public void addPayment(Payment payment){
        
        if(totalPaid().add(payment.getAmountPaid()).compareTo(getTotal()) <= 0){
            payments.add(payment);
        }else{
            throw new IllegalArgumentException("Adding this payment will overpay the transaction. Payment not added.");
        }               
    }
    
    public void setBalanceOwed(BalanceOwed owed){
        balance = owed;
    }
    
    private BigDecimal totalPaid(){
        BigDecimal value = new BigDecimal(0);
        
        for(Payment payment : payments){
            value = value.add(payment.getAmountPaid());
        }
        
        return value;        
    }
    
    
    
    
    
    
    
}
