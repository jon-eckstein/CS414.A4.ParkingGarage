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
public class ParkingGarageTest {
    
    public ParkingGarageTest() {
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
     * Test of createFullfillment method, of class ParkingGarage.
     */
    @Test
    public void testCreateFullfillment() throws Exception {
        System.out.println("createFullfillment");
        ParkingGarage instance = null;
        String expResult = "";
        String result = instance.createFullfillment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processExit method, of class ParkingGarage.
     */
    @Test
    public void testProcessExit() throws Exception {
        System.out.println("processExit");
        String ticketId = "";
        Date exitDateTime = null;
        ParkingGarage instance = null;
        double expResult = 0.0;
        double result = instance.processExit(ticketId, exitDateTime);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processFlatRate method, of class ParkingGarage.
     */
    @Test
    public void testProcessFlatRate() throws Exception {
        System.out.println("processFlatRate");
        Date exitDateTime = null;
        ParkingGarage instance = null;
        double expResult = 0.0;
        double result = instance.processFlatRateExit(exitDateTime);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processCreditCardPayment method, of class ParkingGarage.
     */
    @Test
    public void testProcessCreditCardPayment() throws Exception {
        System.out.println("processCreditCardPayment");
        ParkingGarage instance = null;
        instance.processExit(null, null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRate method, of class ParkingGarage.
     */
    @Test
    public void testSetRate() {
        System.out.println("setRate");
        Date startDate = null;
        Date endDate = null;
        double rate = 0.0;
        boolean isFlatRate = false;
        ParkingGarage instance = null;
        instance.setRate(startDate, endDate, rate, isFlatRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalAvailableSpots method, of class ParkingGarage.
     */
    @Test
    public void testGetTotalAvailableSpots() {
        System.out.println("getTotalAvailableSpots");
        ParkingGarage instance = null;
        int expResult = 0;
        int result = instance.getTotalAvailableSpots();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
