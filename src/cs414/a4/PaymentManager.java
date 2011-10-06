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
public class PaymentManager {
 
    ArrayList<Payment> payments;
    ArrayList<BalanceOwed> balances;
    PaymentGateway paymentGateway;
    
    public PaymentManager(PaymentGateway pg){        
        payments = new ArrayList<Payment>();
        balances = new ArrayList<BalanceOwed>();
        paymentGateway = pg;
    }

    public void createCreditCardPayment(BigDecimal amount, Date datePaid, String cardNumber, Date expireDate, String ticketId) throws Exception {
        
        if(paymentGateway.processTransaction(cardNumber,expireDate, amount)){
            payments.add(new CardPayment(cardNumber, datePaid, expireDate, amount, ticketId));
        }else{
            throw new Exception("Card could not be authorized.");
        }                
    }

    public void createCashPayment(BigDecimal amount, Date datePaid, String ticketId) {
        payments.add(new CashPayment(amount, ticketId, datePaid));
    }
    
    
    public void createBalanceOwed(BigDecimal amountOwed, Date dateOwed, String ticketId, String customerName, String customerAddress, String customerPhoneNumber){        
        balances.add(new BalanceOwed(amountOwed, dateOwed, ticketId, customerName, customerAddress, customerPhoneNumber));        
    }

    

    
    
    
    
}
