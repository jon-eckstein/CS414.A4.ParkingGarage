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
public class CashPayment extends Payment {
    
    public CashPayment(BigDecimal amount, String ticketNum, Date date){        
        amountPaid = amount;        
        datePaid = date;
        
        if(!Utilities.isNullOrEmpty(ticketNum))
            ticketId = ticketNum;
    }
    
    public CashPayment(BigDecimal amount, Date date){
        this(amount,null,date);
    }
    
}
