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
public class RateManager {

    private ArrayList<Rate> rates;
    
    public RateManager(){
        rates = new ArrayList<Rate>();              
    }
    
    
    public BigDecimal getRegularRate(Date entryDateTime, Date exitDateTime) throws Exception {
        
        for(Rate rateRecord : rates){
            if(exitDateTime.before(rateRecord.getEndDateTime()) && entryDateTime.after(rateRecord.getStartDateTime())
                    && !rateRecord.getIsFlatRate())
                return rateRecord.getRate();            
        }
        
        throw new Exception("Could not find a rate within specified time period.");
    }

    public BigDecimal getFlatRate(Date exitDateTime) throws Exception {
        
        for(Rate rateRecord : rates){
            if(exitDateTime.before(rateRecord.getEndDateTime()) && exitDateTime.after(rateRecord.getStartDateTime())
                    && rateRecord.getIsFlatRate())
                return rateRecord.getRate();            
        }
        
        throw new Exception("Could not find a rate within specified time period.");
        
    }

    public void setRate(Date startDate, Date endDate, BigDecimal rate, boolean isFlatRate) {
        //TODO:need to find a date cross-over.
        Rate newRate = new Rate(startDate, endDate, rate, isFlatRate);
        rates.add(newRate);
    }
    
}
