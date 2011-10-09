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
public class ExitEventTest {
    
    public ExitEventTest() {
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
     * Test of getTotal method, of class ExitEvent.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        ExitEvent instance = null;
        BigDecimal expResult = null;
        BigDecimal result = instance.getTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicketId method, of class ExitEvent.
     */
    @Test
    public void testGetTicketId() {
        System.out.println("getTicketId");
        ExitEvent instance = null;
        String expResult = "";
        String result = instance.getTicketId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntryDate method, of class ExitEvent.
     */
    @Test
    public void testGetEntryDate() {
        System.out.println("getEntryDate");
        ExitEvent instance = null;
        Date expResult = null;
        Date result = instance.getEntryDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPayment method, of class ExitEvent.
     */
    @Test
    public void testAddPayment() {
        System.out.println("addPayment");
        Payment payment = null;
        ExitEvent instance = null;
        instance.addPayment(payment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBalanceOwed method, of class ExitEvent.
     */
    @Test
    public void testSetBalanceOwed() {
        System.out.println("setBalanceOwed");
        BalanceOwed owed = null;
        ExitEvent instance = null;
        instance.setBalanceOwed(owed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExitDate method, of class ExitEvent.
     */
    @Test
    public void testGetExitDate() {
        System.out.println("getExitDate");
        ExitEvent instance = null;
        Date expResult = null;
        Date result = instance.getExitDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
