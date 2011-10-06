/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.util.Date;

/**
 *
 * @author jeckstein
 */
public class Rate {
    
    private Date startDateTime;
    private Date endDateTime;
    private double rate;
    private boolean isFlatRate;

    Rate(Date startDate, Date endDate, double rate, boolean isFlat) {
        setEndDateTime(endDate);
        setStartDateTime(startDate);
        setRate(rate);
        setIsFlatRate(isFlat);
    }

    /**
     * @return the startDateTime
     */
    public Date getStartDateTime() {
        return startDateTime;
    }

    /**
     * @param startDateTime the startDateTime to set
     */
    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    /**
     * @return the endDateTime
     */
    public Date getEndDateTime() {
        return endDateTime;
    }

    /**
     * @param endDateTime the endDateTime to set
     */
    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * @return the isFlatRate
     */
    public boolean getIsFlatRate() {
        return isFlatRate;
    }

    /**
     * @param isFlatRate the isFlatRate to set
     */
    public void setIsFlatRate(boolean isFlatRate) {
        this.isFlatRate = isFlatRate;
    }

    
}
