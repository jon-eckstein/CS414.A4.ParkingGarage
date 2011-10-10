/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4.unitTests;

import cs414.a4.integrationTests.ReportManagerTest;
import cs414.a4.integrationTests.RateManagerTest;
import cs414.a4.integrationTests.EntryExitManagerTest;
import cs414.a4.integrationTests.ParkingGarageTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author jeckstein
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ParkingGarageTest.class, EntryEventTest.class,  ReportManagerTest.class,  RateManagerTest.class, EntryExitManagerTest.class, ExitEventTest.class})
public class A4Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
