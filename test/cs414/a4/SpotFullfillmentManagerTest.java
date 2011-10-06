/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

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
public class SpotFullfillmentManagerTest {
    
    public SpotFullfillmentManagerTest() {
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
     * Test of getTotalFullfilledSpots method, of class SpotFullfillmentManager.
     */
    @Test
    public void testGetTotalFullfilledSpots() {
        System.out.println("getTotalFullfilledSpots");
        EntryExitManager instance = new EntryExitManager();
        int expResult = 0;
        int result = instance.getTotalFullfilledSpots();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createFullfillment method, of class SpotFullfillmentManager.
     */
    @Test
    public void testCreateFullfillment() {
        System.out.println("createFullfillment");
        EntryExitManager instance = new EntryExitManager();
        SpotFullfillment expResult = null;
        SpotFullfillment result = instance.createFullfillment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpotFullfillment method, of class SpotFullfillmentManager.
     */
    @Test
    public void testGetSpotFullfillment() throws Exception {
        System.out.println("getSpotFullfillment");
        String ticketId = "";
        EntryExitManager instance = new EntryExitManager();
        SpotFullfillment expResult = null;
        SpotFullfillment result = instance.getSpotFullfillment(ticketId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
