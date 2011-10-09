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
public class RateTest {
    
    public RateTest() {
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
     * Test of getStartDateTime method, of class Rate.
     */
    @Test
    public void testGetStartDateTime() {
        System.out.println("getStartDateTime");
        Rate instance = null;
        Date expResult = null;
        Date result = instance.getStartDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDateTime method, of class Rate.
     */
    @Test
    public void testSetStartDateTime() {
        System.out.println("setStartDateTime");
        Date startDateTime = null;
        Rate instance = null;
        instance.setStartDateTime(startDateTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndDateTime method, of class Rate.
     */
    @Test
    public void testGetEndDateTime() {
        System.out.println("getEndDateTime");
        Rate instance = null;
        Date expResult = null;
        Date result = instance.getEndDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndDateTime method, of class Rate.
     */
    @Test
    public void testSetEndDateTime() {
        System.out.println("setEndDateTime");
        Date endDateTime = null;
        Rate instance = null;
        instance.setEndDateTime(endDateTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRate method, of class Rate.
     */
    @Test
    public void testGetRate() {
        System.out.println("getRate");
        Rate instance = null;
        BigDecimal expResult = null;
        BigDecimal result = instance.getRate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRate method, of class Rate.
     */
    @Test
    public void testSetRate() {
        System.out.println("setRate");
        BigDecimal rate = null;
        Rate instance = null;
        instance.setRate(rate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsFlatRate method, of class Rate.
     */
    @Test
    public void testGetIsFlatRate() {
        System.out.println("getIsFlatRate");
        Rate instance = null;
        boolean expResult = false;
        boolean result = instance.getIsFlatRate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsFlatRate method, of class Rate.
     */
    @Test
    public void testSetIsFlatRate() {
        System.out.println("setIsFlatRate");
        boolean isFlatRate = false;
        Rate instance = null;
        instance.setIsFlatRate(isFlatRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
