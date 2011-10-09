/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.math.BigDecimal;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeckstein
 */
public class PaymentManagerTest {
    
    public PaymentManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createCreditCardPayment method, of class PaymentManager.
     */
    @Test
    public void testCreateCreditCardPayment() throws Exception {
        System.out.println("createCreditCardPayment");
        BigDecimal amount = null;
        Date datePaid = null;
        String cardNumber = "";
        Date expireDate = null;
        PaymentManager instance = null;
        CardPayment expResult = null;
        CardPayment result = instance.createCreditCardPayment(amount, datePaid, cardNumber, expireDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCashPayment method, of class PaymentManager.
     */
    @Test
    public void testCreateCashPayment() {
        System.out.println("createCashPayment");
        BigDecimal amount = null;
        Date datePaid = null;
        PaymentManager instance = null;
        CashPayment expResult = null;
        CashPayment result = instance.createCashPayment(amount, datePaid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBalanceOwed method, of class PaymentManager.
     */
    @Test
    public void testCreateBalanceOwed() {
        System.out.println("createBalanceOwed");
        BigDecimal amountOwed = null;
        Date dateOwed = null;
        String customerName = "";
        String customerAddress = "";
        String customerPhoneNumber = "";
        PaymentManager instance = null;
        BalanceOwed expResult = null;
        BalanceOwed result = instance.createBalanceOwed(amountOwed, dateOwed, customerName, customerAddress, customerPhoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
