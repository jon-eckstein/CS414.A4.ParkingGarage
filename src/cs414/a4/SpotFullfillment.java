/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author jeckstein
 */
public class SpotFullfillment {

    private String ticketNumber;
    private Date entryDateTime;
    private Date exitDateTime;
    private double rate;
    
    
    
    public SpotFullfillment(){
        ticketNumber = UUID.randomUUID().toString();
    }
    
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setExitDateTime(Date exitDateTime) {
        this.exitDateTime = exitDateTime;
    }

    public void setRate(double currentRate) {
        this.rate = currentRate;
    }

    public double getTotal() {       
        if(entryDateTime == null)
            throw new NullPointerException("entryDateTime cannot be null");
        if(exitDateTime == null)
            throw new NullPointerException("exitDateTime cannot be null");
                       
        long milliDiff =  exitDateTime.getTime() - entryDateTime.getTime();
        long hourDiff = (long) (milliDiff * (2.77777778 )* 10e-7);
        if(hourDiff < 0)
            hourDiff = 1;
        return hourDiff * rate;
    }

    public Date getEntryDateTime() {
        return entryDateTime;
    }

    public Date getExitDateTime() {
        return exitDateTime;
    }
    
}
