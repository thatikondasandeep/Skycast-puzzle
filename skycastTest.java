/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package skycast;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class SkycastTest {
    
    Skycast instance;
    public SkycastTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
      
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
          instance = new Skycast();
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of countNoOfClicks method, of class Skycast.
     */
    @Test
    public void testCountNoOfClicks1() throws Exception {
        System.out.println("countNoOfClicks TestCase1");
        String str1="1 20";
        String str2="2 18 19";
        String str3="5 15 14 17 1 17";        
        int expResult = 7;
        int result = instance.countNoOfClicks(str1,str2,str3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    
    /**
     * Test of countDigits method, of class Skycast.
     */
    @Test
    public void testCountNoOfClicks2() throws Exception {
        System.out.println("countNoOfClicks TestCase2");
        String str1="103 108";
        String str2="1 104";
        String str3="5 105 106 107 103 105";        
        int expResult = 8;
        int result = instance.countNoOfClicks(str1,str2,str3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
   
    /**
     * Test of countDigits method, of class Skycast.
     */
    @Test
    public void testCountNoOfClicks3() throws Exception {
        System.out.println("countNoOfClicks TestCase3");
        String str1="1 100";
        String str2="4 78 79 80 3";
        String str3="8 10 13 13 100 99 98 77 81";        
        int expResult = 12;
        int result = instance.countNoOfClicks(str1,str2,str3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
    
    /**
     * Test of countDigits method, of class Skycast. 
    */
    @Test
    public void testCountNoOfClicks4() throws Exception {
        System.out.println("countNoOfClicks TestCase4");
        String str1="1 200";
        String str2="0";
        String str3="4 1 100 1 101";        
        int expResult = 7;
        int result = instance.countNoOfClicks(str1,str2,str3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
    /**
     * Test of elementIsLessThanGreaterThanPreviousSet method, of class Skycast.
     */
    @Test
    public void testElementIsLessThanGreaterThanPreviousSet() {
        System.out.println("elementIsLessThanGreaterThanPreviousSet");
        int current = 1003;
        int size = 3;
        int previousNumber = 1005;
        int previousPreviousNumber = 1009;
        instance = new Skycast();
        boolean expResult = true;
        boolean result = instance.elementIsLessThanGreaterThanPreviousSet(current, size, previousNumber, previousPreviousNumber);
        assertEquals(expResult, result);
        
    }
    
    
    /**
     * Test of elementIsLessThanGreaterThanPreviousSet method, of class Skycast.
     */
    @Test
    public void testElementIsLessThanGreaterThanPreviousSet1() {
        System.out.println("elementIsLessThanGreaterThanPreviousSet1");
        int current = 1003;
        int size = 3;
        int previousNumber = 1000;
        int previousPreviousNumber = 1009;
        instance = new Skycast();
        boolean expResult = false;
        boolean result = instance.elementIsLessThanGreaterThanPreviousSet(current, size, previousNumber, previousPreviousNumber);
        assertEquals(expResult, result);
        
    }
    
   
    
    /**
     * Test of elementIsInBoundaries method, of class Skycast.
     */
    @Test
    public void testElementIsInBoundaries() {
        System.out.println("elementIsInBoundaries");
        int current = 9999;
        int startNumber = 1;
        int endNumber = 10000;
        int size = 4;
        int previousNumber = 1;
        int previousPreviousNumber = 10;
        boolean expResult = true;
        boolean result = instance.elementIsInBoundaries(current, startNumber, endNumber, size, previousNumber, previousPreviousNumber);
        assertEquals(expResult, result);
    }
  
     /**
     * Test of elementIsInBoundaries method, of class Skycast.
     */
    @Test
    public void testElementIsInBoundaries1() {
        System.out.println("elementIsInBoundaries1");
        int current = 999;
        int startNumber = 1;
        int endNumber = 10000;
        int size = 4;
        int previousNumber = 1;
        int previousPreviousNumber = 10;
        boolean expResult = false;
        boolean result = instance.elementIsInBoundaries(current, startNumber, endNumber, size, previousNumber, previousPreviousNumber);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of skipElement method, of class Skycast.
     */
    @Test
    public void testSkipElement() {
        System.out.println("skipElement");
        Set<Integer> blocked =  new HashSet<>();
        blocked.add(9);
        blocked.add(10);
        blocked.add(11);
        int previousNumber = 8;
        int current = 12;
        boolean expResult = true;
        boolean result = instance.skipElement(blocked, previousNumber, current);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of skipElement method, of class Skycast.
     */
    @Test
    public void testSkipElement1() {
        System.out.println("skipElement1");
        Set<Integer> blocked =  new HashSet<>();
        blocked.add(9);
        blocked.add(10);
        int previousNumber = 8;
        int current = 12;
        boolean expResult = false;
        boolean result = instance.skipElement(blocked, previousNumber, current);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of skipElement method, of class Skycast.
     */
    @Test
    public void testSkipElement2() {
        System.out.println("skipElement2");
        Set<Integer> blocked =  new HashSet<>();
        blocked.add(104);
        int previousNumber =103;
        int current = 105;
        boolean expResult = true;
        boolean result = instance.skipElement(blocked, previousNumber, current);
        assertEquals(expResult, result);
    }
    /**
     * Test of countDigits method, of class Skycast.
     */
    @Test
    public void testCountDigits() {
        System.out.println("countDigits");
        int current = 100;
        int expResult = 3;
        int result = instance.countDigits(current);
        assertEquals(expResult, result);
        
     }
    
     /**
     * Test of countDigits method, of class Skycast.
     */
    @Test
    public void testCountDigits1() {
        System.out.println("countDigits");
        int current = 9999;
        int expResult = 4;
        int result = instance.countDigits(current);
        assertEquals(expResult, result);
        
     }
    
     /**
     * Test of countDigits method, of class Skycast.
     */
    @Test
    public void testCountDigits2() {
        System.out.println("countDigits");
        int current = 9;
        int expResult = 1;
        int result = instance.countDigits(current);
        assertEquals(expResult, result);
        
     }
    
    /**
     * Test of checkrange method, of class Skycast.
     */
    @Test
    public void testCheckrange() {
        System.out.println("checkrange");
        int current = 3;
        boolean expResult = false;
        boolean result = instance.checkrange(current);
        assertEquals(expResult, result);
       
    }
   
    /**
     * Test of checkrange method, of class Skycast.
     */
    @Test
    public void testCheckrange1() {
        System.out.println("checkrange1");
        int current = 0;
        boolean expResult = true;
        boolean result = instance.checkrange(current);
        assertEquals(expResult, result);
       
    }
    
}
