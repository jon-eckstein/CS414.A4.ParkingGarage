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
public class CardPayment extends Payment {
 
    private String cardNumber;
    private Date expireDate;
    
    public CardPayment(String cardNum, Date datePaid, Date dateExpire, BigDecimal amount, String ticket){
        cardNumber = cardNum;
        expireDate = dateExpire;
        this.datePaid = datePaid;
        amount = amountPaid;
        if(Utilities.isNullOrEmpty(ticket))
            ticketId = ticket;               
    }
    
    public CardPayment(String cardNum, Date dateExpire, BigDecimal amount, Date datePaid){
        this(cardNum, datePaid, dateExpire, amount, null);
    }
    
    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return the expireDate
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * @param expireDate the expireDate to set
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
    
}
