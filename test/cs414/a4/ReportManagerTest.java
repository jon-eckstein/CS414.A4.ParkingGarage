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
public class ReportManagerTest {
    
    public ReportManagerTest() {
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
    public void testgetUsageReport() {
        System.out.println("getUsageReport");
        Date startDate = null;
        Date endDate = null;
        ReportManager instance = null;
        UsageReportViewModel expResult = null;
        UsageReportViewModel result = instance.getUsageReport(startDate, endDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsageReport method, of class ReportManager.
     */
    @Test
    public void testGetUsageReport() {
        System.out.println("getUsageReport");
        Date startDate = null;
        Date endDate = null;
        ReportManager instance = null;
        UsageReportViewModel expResult = null;
        UsageReportViewModel result = instance.getUsageReport(startDate, endDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
