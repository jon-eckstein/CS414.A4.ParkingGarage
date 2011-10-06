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
public class BalanceOwed {
    private BigDecimal amountOwed;
    private Date dateOwed;
    private String ticketId;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    
    public BalanceOwed(BigDecimal amountOwed, Date dateOwed, String ticketId, String customerName, String customerAddress, String customerPhoneNumber){
        this.amountOwed = amountOwed;
        this.dateOwed = dateOwed;
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    /**
     * @return the amountOwed
     */
    public BigDecimal getAmountOwed() {
        return amountOwed;
    }

    /**
     * @param amountOwed the amountOwed to set
     */
    public void setAmountOwed(BigDecimal amountOwed) {
        this.amountOwed = amountOwed;
    }

    /**
     * @return the dateOwed
     */
    public Date getDateOwed() {
        return dateOwed;
    }

    /**
     * @param dateOwed the dateOwed to set
     */
    public void setDateOwed(Date dateOwed) {
        this.dateOwed = dateOwed;
    }

    /**
     * @return the ticketId
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the customerAddress
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * @param customerAddress the customerAddress to set
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * @return the customerPhoneNumber
     */
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    /**
     * @param customerPhoneNumber the customerPhoneNumber to set
     */
    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
    
    
}
