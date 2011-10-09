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
public class PaymentTest {
    
    public PaymentTest() {
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
     * Test of getAmountPaid method, of class Payment.
     */
    @Test
    public void testGetAmountPaid() {
        System.out.println("getAmountPaid");
        Payment instance = new PaymentImpl();
        BigDecimal expResult = null;
        BigDecimal result = instance.getAmountPaid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmountPaid method, of class Payment.
     */
    @Test
    public void testSetAmountPaid() {
        System.out.println("setAmountPaid");
        BigDecimal amountPaid = null;
        Payment instance = new PaymentImpl();
        instance.setAmountPaid(amountPaid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatePaid method, of class Payment.
     */
    @Test
    public void testGetDatePaid() {
        System.out.println("getDatePaid");
        Payment instance = new PaymentImpl();
        Date expResult = null;
        Date result = instance.getDatePaid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDatePaid method, of class Payment.
     */
    @Test
    public void testSetDatePaid() {
        System.out.println("setDatePaid");
        Date datePaid = null;
        Payment instance = new PaymentImpl();
        instance.setDatePaid(datePaid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PaymentImpl extends Payment {
    }
}
