/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4.integrationTests;

import cs414.a4.EntryEvent;
import cs414.a4.EntryExitManager;
import cs414.a4.ParkingGarage;
import cs414.a4.RateManager;
import cs414.a4.ReportManager;
import cs414.a4.UsageReportViewModel;
import java.math.BigDecimal;
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
public class ReportManagerTest {
    
    private EntryExitManager entryExitManager;
    private RateManager rateManager;
    private ReportManager reportManager;
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy h:mm a"); 
    
    public ReportManagerTest() {
        rateManager = new RateManager();
        entryExitManager = new EntryExitManager(rateManager);
        reportManager = new ReportManager(entryExitManager, ParkingGarage.DEFAULT_TOTAL_SPOTS);        
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
     * Test of GetUsageReport method, of class ReportManager.
     */
    @Test
    public void testGetUsageReportBrokenDownByDay() throws ParseException, Exception {
        System.out.println("getUsageReport");
        //create some entries...
        rateManager.setRate(dateFormatter.parse("01/01/2011 12:00 AM"), dateFormatter.parse("12/31/2020 11:59 PM"), new BigDecimal("20.00"), false);
        EntryEvent event1 = entryExitManager.createEntryEvent(dateFormatter.parse("01/01/2011 10:00 AM"));
        EntryEvent event2 = entryExitManager.createEntryEvent(dateFormatter.parse("01/01/2011 11:30 AM"));
        entryExitManager.createExitEvent(event1.getTicketId(),dateFormatter.parse("01/01/2011 01:00 PM"));
        entryExitManager.createExitEvent(event2.getTicketId(),dateFormatter.parse("01/01/2011 01:30 PM"));
        
        EntryEvent event3 = entryExitManager.createEntryEvent(dateFormatter.parse("01/02/2011 10:00 AM"));
        EntryEvent event4 = entryExitManager.createEntryEvent(dateFormatter.parse("01/02/2011 11:30 AM"));
        entryExitManager.createExitEvent(event3.getTicketId(),dateFormatter.parse("01/02/2011 01:00 PM"));
        entryExitManager.createExitEvent(event4.getTicketId(),dateFormatter.parse("01/02/2011 01:30 PM"));
        
        Date reportStart = dateFormatter.parse("01/01/2011 01:00 AM");
        Date reportEnd = dateFormatter.parse("01/02/2011 11:59 PM");
        UsageReportViewModel viewModel = reportManager.getUsageReport(reportStart, reportEnd, Calendar.DATE);
        
        assertEquals(2, viewModel.getReportDetail().size());
    }

    
}
