/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy h:mm a");
    
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
     * Test of getAvailableSpotCount method, of class ParkingGarage.
     */
    @Test
    public void testGetAvailableSpotCount() throws Exception {
        System.out.println("getAvailableSpotCount");
        parkingGarage.createEntryEvent();
        parkingGarage.createEntryEvent();        
        int result = parkingGarage.getAvailableSpotCount();    
        assertEquals(result, parkingGarage.getTotalSpots() - 2);        
    }

    
    /**
     * Test of getUsageReport method, of class ParkingGarage.
     */
    @Test
    public void testGetUsageReport() throws ParseException, Exception {
        System.out.println("getUsageReport");
        parkingGarage.createEntryEvent(dateFormatter.parse("01/01/2011 12:01 PM"));
        parkingGarage.createEntryEvent(dateFormatter.parse("01/01/2011 12:02 PM"));        
        parkingGarage.createEntryEvent(dateFormatter.parse("01/01/2011 12:30 PM"));
        parkingGarage.createEntryEvent(dateFormatter.parse("01/01/2011 12:31 PM"));        
                
        UsageReportViewModel result = parkingGarage.getUsageReport(dateFormatter.parse("01/01/2011 12:00 PM"), dateFormatter.parse("01/01/2011 01:00 PM"),Calendar.HOUR);
        UsageReportDetail detail = result.getReportDetail().get(0);
        assertEquals(4,detail.numSpotFilled);
        
    }
}
