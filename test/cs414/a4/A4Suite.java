/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

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
@Suite.SuiteClasses({cs414.a4.ParkingGarageTest.class, cs414.a4.RateManagerTest.class, cs414.a4.RateTest.class, cs414.a4.CS414A4Test.class, cs414.a4.SpotFullfillmentManagerTest.class, cs414.a4.SpotFullfillmentTest.class})
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
