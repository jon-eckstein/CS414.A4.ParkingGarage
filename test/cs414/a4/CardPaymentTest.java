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
public class CardPaymentTest {
    
    public CardPaymentTest() {
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
     * Test of getCardNumber method, of class CardPayment.
     */
    @Test
    public void testGetCardNumber() {
        System.out.println("getCardNumber");
        CardPayment instance = null;
        String expResult = "";
        String result = instance.getCardNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCardNumber method, of class CardPayment.
     */
    @Test
    public void testSetCardNumber() {
        System.out.println("setCardNumber");
        String cardNumber = "";
        CardPayment instance = null;
        instance.setCardNumber(cardNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExpireDate method, of class CardPayment.
     */
    @Test
    public void testGetExpireDate() {
        System.out.println("getExpireDate");
        CardPayment instance = null;
        Date expResult = null;
        Date result = instance.getExpireDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExpireDate method, of class CardPayment.
     */
    @Test
    public void testSetExpireDate() {
        System.out.println("setExpireDate");
        Date expireDate = null;
        CardPayment instance = null;
        instance.setExpireDate(expireDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
