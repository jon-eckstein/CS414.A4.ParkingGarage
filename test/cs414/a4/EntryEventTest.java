/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy h:mm a");
    
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

    @Test(expected=IllegalArgumentException.class)
    public void testCreateEntryWithNullTicketIdShouldFail() throws ParseException{
        EntryEvent entry = new EntryEvent(null, dateFormatter.parse("12/31/2011 12:31 PM"));        
        fail("Should have thrown exception");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testCreateEntryWithNullEntryDateShouldFail() throws ParseException{
        EntryEvent entry = new EntryEvent("1",null);        
        fail("Should have thrown exception");
    }
}
