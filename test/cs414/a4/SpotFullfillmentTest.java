/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

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
public class SpotFullfillmentTest {
    
    public SpotFullfillmentTest() {
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
     * Test of getTicketNumber method, of class SpotFullfillment.
     */
    @Test
    public void testGetTicketNumber() {
        System.out.println("getTicketNumber");
        SpotFullfillment instance = new SpotFullfillment();
        String expResult = "";
        String result = instance.getTicketNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExitDateTime method, of class SpotFullfillment.
     */
    @Test
    public void testSetExitDateTime() {
        System.out.println("setExitDateTime");
        Date exitDateTime = null;
        SpotFullfillment instance = new SpotFullfillment();
        instance.setExitDateTime(exitDateTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRate method, of class SpotFullfillment.
     */
    @Test
    public void testSetRate() {
        System.out.println("setRate");
        double currentRate = 0.0;
        SpotFullfillment instance = new SpotFullfillment();
        instance.setRate(currentRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class SpotFullfillment.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        SpotFullfillment instance = new SpotFullfillment();
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntryDateTime method, of class SpotFullfillment.
     */
    @Test
    public void testGetEntryDateTime() {
        System.out.println("getEntryDateTime");
        SpotFullfillment instance = new SpotFullfillment();
        Date expResult = null;
        Date result = instance.getEntryDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExitDateTime method, of class SpotFullfillment.
     */
    @Test
    public void testGetExitDateTime() {
        System.out.println("getExitDateTime");
        SpotFullfillment instance = new SpotFullfillment();
        Date expResult = null;
        Date result = instance.getExitDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
