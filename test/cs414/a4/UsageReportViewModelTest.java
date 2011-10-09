/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.util.ArrayList;
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
public class UsageReportViewModelTest {
    
    public UsageReportViewModelTest() {
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
     * Test of addDetail method, of class UsageReportViewModel.
     */
    @Test
    public void testAddDetail() {
        System.out.println("addDetail");
        UsageReportDetail detail = null;
        UsageReportViewModel instance = null;
        instance.addDetail(detail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReportDetail method, of class UsageReportViewModel.
     */
    @Test
    public void testGetReportDetail() {
        System.out.println("getReportDetail");
        UsageReportViewModel instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getReportDetail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDate method, of class UsageReportViewModel.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        UsageReportViewModel instance = null;
        Date expResult = null;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class UsageReportViewModel.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        Date startDate = null;
        UsageReportViewModel instance = null;
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndDate method, of class UsageReportViewModel.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        UsageReportViewModel instance = null;
        Date expResult = null;
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndDate method, of class UsageReportViewModel.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        Date endDate = null;
        UsageReportViewModel instance = null;
        instance.setEndDate(endDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
