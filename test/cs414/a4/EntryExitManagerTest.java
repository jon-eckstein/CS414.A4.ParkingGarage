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
public class EntryExitManagerTest {
    
    
    private EntryExitManager entryExitManager;
    private RateManager rateManager;
    
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

    /**
     * Test of getFilledSpots method, of class EntryExitManager.
     */
    @Test
    public void testGetFilledSpots() {
        System.out.println("getFilledSpots");
        EntryExitManager instance = entryExitManager;
        int expResult = 0;
        int result = instance.getFilledSpots();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of createEntryEvent method, of class EntryExitManager.
     */
    @Test
    public void testCreateEntryEvent() {
        System.out.println("createEntryEvent");
        EntryExitManager instance = null;
        EntryEvent expResult = null;
        EntryEvent result = instance.createEntryEvent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createExitEvent method, of class EntryExitManager.
     */
    @Test
    public void testCreateExitEvent() throws Exception {
        System.out.println("createExitEvent");
        String ticketId = "";
        Date exitDateTime = null;
        EntryExitManager instance = null;
        ExitEvent expResult = null;
        ExitEvent result = instance.createExitEvent(ticketId, exitDateTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntryEvent method, of class EntryExitManager.
     */
    @Test
    public void testGetEntryEvent() throws Exception {
        System.out.println("getEntryEvent");
        String ticketId = "";
        EntryExitManager instance = null;
        EntryEvent expResult = null;
        EntryEvent result = instance.getEntryEvent(ticketId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExitEvent method, of class EntryExitManager.
     */
    @Test
    public void testGetExitEvent() throws Exception {
        System.out.println("getExitEvent");
        String ticketId = "";
        EntryExitManager instance = null;
        ExitEvent expResult = null;
        ExitEvent result = instance.getExitEvent(ticketId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentEntryEvents method, of class EntryExitManager.
     */
    @Test
    public void testGetCurrentEntryEvents() {
        System.out.println("getCurrentEntryEvents");
        EntryExitManager instance = null;
        EntryEvent[] expResult = null;
        EntryEvent[] result = instance.getCurrentEntryEvents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExitEvents method, of class EntryExitManager.
     */
    @Test
    public void testGetExitEvents() {
        System.out.println("getExitEvents");
        EntryExitManager instance = null;
        ExitEvent[] expResult = null;
        ExitEvent[] result = instance.getExitEvents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
