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
public class RateManagerTest {
    
    public RateManagerTest() {
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
     * Test of getRegularRate method, of class RateManager.
     */
    @Test
    public void testGetRegularRate() throws Exception {
        System.out.println("getRegularRate");
        Date entryDateTime = null;
        Date exitDateTime = null;
        RateManager instance = new RateManager();
        BigDecimal expResult = null;
        BigDecimal result = instance.getRegularRate(entryDateTime, exitDateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlatRate method, of class RateManager.
     */
    @Test
    public void testGetFlatRate() throws Exception {
        System.out.println("getFlatRate");
        Date exitDateTime = null;
        RateManager instance = new RateManager();
        BigDecimal expResult = null;
        BigDecimal result = instance.getFlatRate(exitDateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRate method, of class RateManager.
     */
    @Test
    public void testSetRate() {
        System.out.println("setRate");
        Date startDate = null;
        Date endDate = null;
        BigDecimal rate = null;
        boolean isFlatRate = false;
        RateManager instance = new RateManager();
        instance.setRate(startDate, endDate, rate, isFlatRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
