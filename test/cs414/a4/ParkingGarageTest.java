/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
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
    
    private ParkingGarage parkingGarage;
    
    
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
        parkingGarage = new ParkingGarage();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createEntryEvent method, of class ParkingGarage.
     */
    @Test
    public void testCreateSingleEntryEvent() throws Exception {
        System.out.println("createEntryEvent");
        ParkingGarage instance = parkingGarage;        
        String result = instance.createEntryEvent();
        assertEquals("1", result);  
    }
    
    @Test
    public void testCreateMultipleEntryEvents() throws Exception {
        System.out.println("createEntryEvent");
        ParkingGarage instance = parkingGarage; 
        String result1 = instance.createEntryEvent();
        assertEquals("1", result1);  
        String result2 = instance.createEntryEvent();
        assertEquals("2", result2);          
    }

    /**
     * Test of processExit method, of class ParkingGarage.
     */
    @Test(expected=Exception.class)
    public void testProcessExitWithoutExistingEntry() throws Exception {        
        String ticketId = "some.ticket.Id";
        Date exitDateTime = new Date();        
        BigDecimal result = parkingGarage.processExit(ticketId, exitDateTime);               
        fail("Exception should have been thrown.");
    }
    
    @Test(expected=Exception.class)    
    public void testProcessExitWithoutExistingRate() throws Exception {        
        Utilities.printLn("testProcessExitWithoutExistingRate");
        String ticketId = parkingGarage.createEntryEvent();
        Date exitDateTime = new Date();        
        BigDecimal result = parkingGarage.processExit(ticketId, exitDateTime);               
        fail("Exception should have been thrown.");
    }
    
    @Test  
    public void testProcessExitRegularSingleHourSuccess() throws Exception {        
        Utilities.printLn("testProcessExitSuccess");
        
        //create a new rate...
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy");
        BigDecimal rate = new BigDecimal("30.00");
        parkingGarage.setRate(dateFormatter.parse("01/01/2011"), dateFormatter.parse("12/31/2011"), rate, false);
        String ticketId = parkingGarage.createEntryEvent(dateFormatter.parse("01/02/2011"));
        Date exitDateTime = dateFormatter.parse("01/02/2011");        
        BigDecimal result = parkingGarage.processExit("1", exitDateTime);               
        assertEquals(rate, result); 
    }
    
    @Test  
    public void testProcessExitRegularMultipleHourSuccess() throws Exception {        
        Utilities.printLn("testProcessExitSuccess");
        
        //create a new rate...
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy h:mm a");
        BigDecimal rate = new BigDecimal("30.00");
        parkingGarage.setRate(dateFormatter.parse("01/01/2011 12:00 AM"), dateFormatter.parse("12/31/2011 11:59 PM"), rate, false);
        String ticketId = parkingGarage.createEntryEvent(dateFormatter.parse("01/02/2011 01:00 PM"));
        Date exitDateTime = dateFormatter.parse("01/02/2011 3:00 PM");        
        BigDecimal result = parkingGarage.processExit("1", exitDateTime);               
        assertEquals(rate.multiply(new BigDecimal(2)), result); 
    }
    
    
    /**
     * Test of processCardPayment method, of class ParkingGarage.
     */
    @Test
    public void testProcessCardPayment() throws Exception {
        System.out.println("processCardPayment");
        BigDecimal amount = null;
        String cardNumber = "";
        Date expireDate = null;
        String ticketId = "";
        ParkingGarage instance = new ParkingGarage();
        instance.processCardPayment(amount, cardNumber, expireDate, ticketId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processCashPayment method, of class ParkingGarage.
     */
    @Test
    public void testProcessCashPayment() throws Exception {
        System.out.println("processCashPayment");
        BigDecimal amount = null;
        String ticketId = "";
        ParkingGarage instance = new ParkingGarage();
        instance.processCashPayment(amount, ticketId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processIou method, of class ParkingGarage.
     */
    @Test
    public void testProcessIou() throws Exception {
        System.out.println("processIou");
        BigDecimal amount = null;
        String customerName = "";
        String customerPhone = "";
        String customerAddress = "";
        String ticketId = "";
        ParkingGarage instance = new ParkingGarage();
        instance.processIou(amount, customerName, customerPhone, customerAddress, ticketId);
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
        BigDecimal rate = null;
        boolean isFlatRate = false;
        ParkingGarage instance = new ParkingGarage();
        instance.setRate(startDate, endDate, rate, isFlatRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableSpotCount method, of class ParkingGarage.
     */
    @Test
    public void testGetAvailableSpotCount() {
        System.out.println("getAvailableSpotCount");
        ParkingGarage instance = new ParkingGarage();
        int expResult = 0;
        int result = instance.getAvailableSpotCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalSpots method, of class ParkingGarage.
     */
    @Test
    public void testGetTotalSpots() {
        System.out.println("getTotalSpots");
        ParkingGarage instance = new ParkingGarage();
        int expResult = 0;
        int result = instance.getTotalSpots();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsageReport method, of class ParkingGarage.
     */
    @Test
    public void testGetUsageReport() {
        System.out.println("getUsageReport");
        Date startDate = null;
        Date endDate = null;
        ParkingGarage instance = new ParkingGarage();
        UsageReportViewModel expResult = null;
        UsageReportViewModel result = instance.getUsageReport(startDate, endDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
