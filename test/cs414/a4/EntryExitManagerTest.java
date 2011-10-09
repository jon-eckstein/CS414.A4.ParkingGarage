/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.math.BigDecimal;
import java.text.ParseException;
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
public class EntryExitManagerTest {
    
    
    private EntryExitManager entryExitManager;
    private RateManager rateManager;
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy h:mm a"); 
    
    public EntryExitManagerTest() {
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        rateManager =  new RateManager();
        entryExitManager = new EntryExitManager(rateManager);
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testTicketIdShouldBeIncremented(){        
        String ticketId1 = entryExitManager.createEntryEvent().getTicketId();
        String ticketId2 = entryExitManager.createEntryEvent().getTicketId();
        Integer expected = (Integer.parseInt(ticketId1) + 1);
        assertEquals(expected.toString() , ticketId2);        
    }
    
    /**
     * Test of getFilledSpots method, of class EntryExitManager.
     */
    @Test
    public void testGetFilledSpots() {
        System.out.println("getFilledSpots");
        entryExitManager.createEntryEvent();
        entryExitManager.createEntryEvent();
        int expResult = 2;
        int result = entryExitManager.getFilledSpots();
        assertEquals(expResult, result);              
    }
    
    @Test
    public void testGetFilledSpotsWithExitShouldRemoveFilledSpot() throws Exception {
        System.out.println("testGetFilledSpotsWithExitShouldRemoveFilledSpot");
        String ticketId1 = entryExitManager.createEntryEvent().getTicketId();
        String ticketId2 = entryExitManager.createEntryEvent().getTicketId();
        rateManager.setRate(dateFormatter.parse("01/01/2011 12:00 AM"), dateFormatter.parse("12/31/2020 11:59 PM"), BigDecimal.ZERO, false);
        entryExitManager.createExitEvent(ticketId2);
        int expResult = 1;
        int result = entryExitManager.getFilledSpots();
        assertEquals(expResult, result);              
    }
           
    /**
     * Test of getCurrentEntryEvents method, of class EntryExitManager.
     */
    @Test
    public void testGetCurrentEntryEvents() {
        System.out.println("getCurrentEntryEvents");
        String ticketId1 = entryExitManager.createEntryEvent().getTicketId();
        String ticketId2 = entryExitManager.createEntryEvent().getTicketId();
        EntryEvent[] result = entryExitManager.getCurrentEntryEvents();        
        assertEquals(2, result.length);         
    }
    
    @Test
    public void testEntryShouldBeRemovedIfExitOccurs() throws ParseException, Exception {
        System.out.println("testEntryShouldBeRemovedIfExitOccurs");
        EntryEvent entry1 =  entryExitManager.createEntryEvent();
        String ticketId1 = entry1.getTicketId();
        String ticketId2 = entryExitManager.createEntryEvent().getTicketId();
        rateManager.setRate(dateFormatter.parse("01/01/2011 12:00 AM"), dateFormatter.parse("12/31/2020 11:59 PM"), BigDecimal.ZERO, false);
        entryExitManager.createExitEvent(ticketId2);
        EntryEvent[] result = entryExitManager.getCurrentEntryEvents();        
        assertEquals(1, result.length);
        assertEquals(entry1, result[0]);
    }
    

    /**
     * Test of getExitEvents method, of class EntryExitManager.
     */
    @Test
    public void testGetExitEvents() throws ParseException, Exception {
       System.out.println("testGetExitEvents");
        EntryEvent entry1 =  entryExitManager.createEntryEvent();
        String ticketId1 = entry1.getTicketId();
        String ticketId2 = entryExitManager.createEntryEvent().getTicketId();
        rateManager.setRate(dateFormatter.parse("01/01/2011 12:00 AM"), dateFormatter.parse("12/31/2020 11:59 PM"), BigDecimal.ZERO, false);
        entryExitManager.createExitEvent(ticketId1);
        entryExitManager.createExitEvent(ticketId2);
        ExitEvent[] result = entryExitManager.getExitEvents();
        assertEquals(2, result.length);               
    }
}
