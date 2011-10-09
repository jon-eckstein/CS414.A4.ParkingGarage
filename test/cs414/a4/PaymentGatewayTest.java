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
public class PaymentGatewayTest {
    
    public PaymentGatewayTest() {
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
     * Test of processTransaction method, of class PaymentGateway.
     */
    @Test
    public void testProcessTransaction() {
        System.out.println("processTransaction");
        String cardNumber = "";
        Date expireDate = null;
        BigDecimal amount = null;
        PaymentGateway instance = new PaymentGateway();
        boolean expResult = false;
        boolean result = instance.processTransaction(cardNumber, expireDate, amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
