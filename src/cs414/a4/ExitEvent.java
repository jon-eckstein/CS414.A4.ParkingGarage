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
    private boolean isFlatRate;
    
        
    
    public BigDecimal getTotal() {       
        if(isFlatRate)
            return rate;
        else{                
            long milliDiff =  exitDateTime.getTime() - getEntryDate().getTime();
            long hourDiff = (long) (milliDiff * (2.77777778 )* 10e-7);
            if(hourDiff <= 0)
                hourDiff = 1;
            
            return BigDecimal.valueOf(hourDiff).multiply(rate);
        }
    }
    
    public Date getEntryDate(){        
        if(entryEvent != null)
            return entryEvent.getEntryDate();
        else
            return null;        
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
