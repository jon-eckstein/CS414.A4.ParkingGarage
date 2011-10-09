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
public class EntryEventTest {
    
    public EntryEventTest() {
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
     * Test of getTicketId method, of class EntryEvent.
     */
    @Test
    public void testGetTicketId() {
        System.out.println("getTicketId");
        EntryEvent instance = null;
        String expResult = "";
        String result = instance.getTicketId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntryDate method, of class EntryEvent.
     */
    @Test
    public void testGetEntryDate() {
        System.out.println("getEntryDate");
        EntryEvent instance = null;
        Date expResult = null;
        Date result = instance.getEntryDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
