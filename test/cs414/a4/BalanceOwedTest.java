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
public class BalanceOwedTest {
    
    public BalanceOwedTest() {
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
     * Test of getAmountOwed method, of class BalanceOwed.
     */
    @Test
    public void testGetAmountOwed() {
        System.out.println("getAmountOwed");
        BalanceOwed instance = null;
        BigDecimal expResult = null;
        BigDecimal result = instance.getAmountOwed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmountOwed method, of class BalanceOwed.
     */
    @Test
    public void testSetAmountOwed() {
        System.out.println("setAmountOwed");
        BigDecimal amountOwed = null;
        BalanceOwed instance = null;
        instance.setAmountOwed(amountOwed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateOwed method, of class BalanceOwed.
     */
    @Test
    public void testGetDateOwed() {
        System.out.println("getDateOwed");
        BalanceOwed instance = null;
        Date expResult = null;
        Date result = instance.getDateOwed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateOwed method, of class BalanceOwed.
     */
    @Test
    public void testSetDateOwed() {
        System.out.println("setDateOwed");
        Date dateOwed = null;
        BalanceOwed instance = null;
        instance.setDateOwed(dateOwed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerName method, of class BalanceOwed.
     */
    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        BalanceOwed instance = null;
        String expResult = "";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerName method, of class BalanceOwed.
     */
    @Test
    public void testSetCustomerName() {
        System.out.println("setCustomerName");
        String customerName = "";
        BalanceOwed instance = null;
        instance.setCustomerName(customerName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerAddress method, of class BalanceOwed.
     */
    @Test
    public void testGetCustomerAddress() {
        System.out.println("getCustomerAddress");
        BalanceOwed instance = null;
        String expResult = "";
        String result = instance.getCustomerAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerAddress method, of class BalanceOwed.
     */
    @Test
    public void testSetCustomerAddress() {
        System.out.println("setCustomerAddress");
        String customerAddress = "";
        BalanceOwed instance = null;
        instance.setCustomerAddress(customerAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerPhoneNumber method, of class BalanceOwed.
     */
    @Test
    public void testGetCustomerPhoneNumber() {
        System.out.println("getCustomerPhoneNumber");
        BalanceOwed instance = null;
        String expResult = "";
        String result = instance.getCustomerPhoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerPhoneNumber method, of class BalanceOwed.
     */
    @Test
    public void testSetCustomerPhoneNumber() {
        System.out.println("setCustomerPhoneNumber");
        String customerPhoneNumber = "";
        BalanceOwed instance = null;
        instance.setCustomerPhoneNumber(customerPhoneNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
