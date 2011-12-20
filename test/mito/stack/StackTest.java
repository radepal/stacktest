/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mito.stack;

import java.util.EmptyStackException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author student
 */
public class StackTest {

    public StackTest() {
    }
Stack instance=null;
   

    @Before
    public void setUp() {
        instance = new Stack();
    }

    @After
    public void tearDown() {
        instance = null;
    }


    @Test
    public void testIsFullFalse() {
        boolean expResult = false;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFullTrue() {
        boolean expResult = true;
        for (int i = 0; i < instance.MAX_SIZE; i++) {
             instance.push(new String("Test"+i));
         }
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }


    @Test
    public void testIsEmptyTrue() {
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

     @Test
    public void testIsEmptyFalse() {
        boolean expResult = false;
        instance.push(new String("Test"));
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }





    @Test
    public void testIsLoadedEmpty() {
       boolean expResult = false;
        boolean result = instance.isLoaded();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsLoadedTrue() {
       boolean expResult = true;
       instance.push(new String("Test"));
        boolean result = instance.isLoaded();
        assertEquals(expResult, result);
    }

     @Test
    public void testIsLoadedFull() {
       boolean expResult = false;
      for (int i = 0; i < instance.MAX_SIZE; i++) {
             instance.push(new String("Test"+i));
         }
        boolean result = instance.isLoaded();
        assertEquals(expResult, result);
    }


    @Test
    public void testPushEmptyStack() {
        Object expectecObject = new String("Test");
         instance.push(expectecObject);
        Object result = instance.pop() ;
        assertSame(expectecObject, result);
    }

     @Test(expected=IllegalStateException.class)
    public void testPushFullStack()throws IllegalStateException {
         for (int i = 0; i < instance.MAX_SIZE; i++) {
             instance.push(new String("Test"+i));
         }
         instance.push(new String("Test"));
         fail("Exeption should occured");

    }

   
    @Test(expected=EmptyStackException.class)
    public void testPopEmptyStack()throws EmptyStackException {
        Object result = instance.pop() ;
        fail("Exeption should occured");

    }

    @Test
    public void testPopOkStack() {
        Object expectecObject = new String("Test");
        instance.push(expectecObject);
        Object result = instance.pop() ;
        assertSame(expectecObject, result);

    }

}