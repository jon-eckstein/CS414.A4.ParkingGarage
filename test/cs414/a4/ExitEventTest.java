/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs414.a4;

import java.math.BigDecimal;
import java.math.BigInteger;
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
public class ExitEventTest {
    
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy h:mm a"); 
    
    
    public ExitEventTest() {
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
     * Test of getTotal method, of class ExitEvent.
     */
    @Test
    public void testGetTotalForSingleHour() throws ParseException {        
        System.out.println("testGetTotalForSingleHour");        
        BigDecimal rate = new BigDecimal("30.00");
        EntryEvent entry = new EntryEvent("1",dateFormatter.parse("01/01/2011 1:10 PM"));
        ExitEvent instance = new ExitEvent(entry, dateFormatter.parse("01/01/2011 2:10 PM"), rate); 
        BigDecimal result = instance.getTotal();
        assertEquals(rate, result);        
    }

    @Test
    public void testLessThanAnHourShouldCalcAs1Hour() throws ParseException {        
        System.out.println("testLessThanAnHourShouldCalcAs1Hour");        
        BigDecimal rate = new BigDecimal("30.00");
        EntryEvent entry = new EntryEvent("1",dateFormatter.parse("01/01/2011 1:10 PM"));
        ExitEvent instance = new ExitEvent(entry, dateFormatter.parse("01/01/2011 1:45 PM"), rate); 
        BigDecimal result = instance.getTotal();
        assertEquals(rate, result);        
    }
    
    @Test
    public void testFractionOfAnHourShouldCalcCorrectly() throws ParseException {        
        System.out.println("testFractionOfAnHourShouldCalcCorrectly");        
        BigDecimal rate = new BigDecimal("30.00");
        EntryEvent entry = new EntryEvent("1",dateFormatter.parse("01/01/2011 1:10 PM"));
        ExitEvent instance = new ExitEvent(entry, dateFormatter.parse("01/01/2011 2:45 PM"), rate); 
        BigDecimal result = instance.getTotal();
        assertEquals(new BigDecimal("47.50"), result);                
    }
    
    @Test
    public void testFlatRateShouldCalcCorrectly() throws ParseException {        
        System.out.println("testFlatRateShouldCalcCorrectly");        
        BigDecimal rate = new BigDecimal("50.00");        
        ExitEvent instance = new ExitEvent(null, dateFormatter.parse("01/01/2011 2:45 PM"), rate); 
        BigDecimal result = instance.getTotal();
        assertEquals(rate, result);                
    }
    
    @Test
    public void testGetEntryEventForFlatRateShouldReturnNull() throws ParseException{
        System.out.println("testGetEntryEventForFlatRateShouldReturnNull");        
        BigDecimal rate = new BigDecimal("50.00");        
        ExitEvent instance = new ExitEvent(null, dateFormatter.parse("01/01/2011 2:45 PM"), rate); 
        Date startDate = instance.getEntryDate();
        assertEquals(null, startDate);                
    }
    

    /**
     * Test of addPayment method, of class ExitEvent.
     */
    @Test
    public void testNewPaymentShouldBeSavedInCollection() throws Exception {
        System.out.println("testNewPaymentShouldBeSavedInCollection");        
        BigDecimal rate = new BigDecimal("30.00");        
        EntryEvent entry = new EntryEvent("1",dateFormatter.parse("01/01/2011 1:10 PM"));
        ExitEvent exit = new ExitEvent(entry, dateFormatter.parse("01/01/2011 2:10 PM"), rate); 
        BigDecimal total = exit.getTotal();
        Payment payment = new CashPayment(total, dateFormatter.parse("01/01/2011 2:10 PM"));
        exit.addPayment(payment);
        assertEquals(1, exit.getPayments().size());                          
    }

    @Test(expected=Exception.class)
    public void testOverPayShouldThrowException() throws Exception {
        BigDecimal rate = new BigDecimal("30.00");        
        EntryEvent entry = new EntryEvent("1",dateFormatter.parse("01/01/2011 1:10 PM"));
        ExitEvent exit = new ExitEvent(entry, dateFormatter.parse("01/01/2011 2:10 PM"), rate); 
        BigDecimal total = exit.getTotal();
        Payment payment = new CashPayment(total.multiply(new BigDecimal("2")), dateFormatter.parse("01/01/2011 2:10 PM"));
        exit.addPayment(payment);
    }
    
    /**
     * Test of setBalanceOwed method, of class ExitEvent.
     */
    @Test
    public void testSetIou() throws ParseException, Exception {
        System.out.println("testSetIou");
        BigDecimal rate = new BigDecimal("30.00");        
        EntryEvent entry = new EntryEvent("1",dateFormatter.parse("01/01/2011 1:10 PM"));
        ExitEvent exit = new ExitEvent(entry, dateFormatter.parse("01/01/2011 2:10 PM"), rate); 
        BigDecimal total = exit.getTotal();
        Iou owed = new Iou(total, dateFormatter.parse("01/01/2011 2:10 PM"), "some name", "some address", "some phone");
        exit.setIou(owed);
        assertEquals(owed, exit.getIou());
            
    }
    
    @Test(expected=Exception.class)
    public void testSetIouWithDifferentOwedAmountShouldFail() throws ParseException, Exception {
        System.out.println("testSetIouWithDifferentOwedAmountShouldFail");
        BigDecimal rate = new BigDecimal("30.00");        
        EntryEvent entry = new EntryEvent("1",dateFormatter.parse("01/01/2011 1:10 PM"));
        ExitEvent exit = new ExitEvent(entry, dateFormatter.parse("01/01/2011 2:10 PM"), rate); 
        BigDecimal total = exit.getTotal();
        Iou owed = new Iou(total.multiply(new BigDecimal("2")), dateFormatter.parse("01/01/2011 2:10 PM"), "some name", "some address", "some phone");
        exit.setIou(owed);
    }
    
    

    
}
