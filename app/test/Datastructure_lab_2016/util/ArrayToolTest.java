package Datastructure_lab_2016.util;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * A test class for ArrayTool class.
 * 
 * @author Markus J. Auvo 2016
 */
public class ArrayToolTest
{
    private ArrayTool testInstance;
    private String msg;

    /**
     * Tests whether the value returned by the method
     * getIP() is an integer array.
     * 
     * @throws java.lang.Exception
     */
    public void getIP_returnsIntegerArray() throws Exception {
        testInstance = new ArrayTool();
        msg = "Method getIP() should return an integer array! It does NOT!";
        assertTrue(msg, testInstance.getIP() instanceof int[]);
    }

    /**
     * Tests whether the integer array IP returned by the method
     * getIP() has the correct number of elements.
     * 
     * @throws java.lang.Exception
     */
    public void getIP_returnsCorrectArrayLength() throws Exception {
        testInstance = new ArrayTool();
        int expectedLength = 64;
        msg  = "Integer array IP returned by the method getIP() has incorrect number of elements!\n";
        msg += "The array should contain " + expectedLength + " elements!\n";
        assertTrue(msg, testInstance.getIP().length == expectedLength);
    }

    /**
     * Tests whether the value returned by the method
     * getPC1() is an integer array.
     * 
     * @throws java.lang.Exception
     */
    public void getPC1_returnsIntegerArray() throws Exception {
        testInstance = new ArrayTool();
        msg = "Method getPC1() should return an integer array! It does NOT!";
        assertTrue(msg, testInstance.getPC1() instanceof int[]);
    }

    /**
     * Tests whether the integer array PC1 returned by the method
     * getPC1() has the correct number of elements.
     * 
     * @throws java.lang.Exception
     */
    public void getPC1_returnsCorrectArrayLength() throws Exception {
        testInstance = new ArrayTool();
        int expectedLength = 56;
        msg  = "Integer array PC1 returned by the method getPC1() has incorrect number of elements!\n";
        msg += "The array should contain " + expectedLength + " elements!\n";
        assertTrue(msg, testInstance.getPC1().length == expectedLength);
    }

    /**
     * Tests whether the value returned by the method
     * getPC2() is an integer array.
     * 
     * @throws java.lang.Exception
     */
    public void getPC2_returnsIntegerArray() throws Exception {
        testInstance = new ArrayTool();
        msg = "Method getPC2() should return an integer array! It does NOT!";
        assertTrue(msg, testInstance.getPC2() instanceof int[]);
    }

    /**
     * Tests whether the integer array PC2 returned by the method
     * getPC2() has the correct number of elements.
     * 
     * @throws java.lang.Exception
     */
    public void getPC2_returnsCorrectArrayLength() throws Exception {
        testInstance = new ArrayTool();
        int expectedLength = 48;
        msg  = "Integer array PC2 returned by the method getPC2() has incorrect number of elements!\n";
        msg += "The array should contain " + expectedLength + " elements!\n";
        assertTrue(msg, testInstance.getPC2().length == expectedLength);
    }

    /**
     * Tests whether the value returned by the method
     * getBitShifts() is an integer array.
     * 
     * @throws java.lang.Exception
     */
    public void getBitShifts_returnsIntegerArray() throws Exception {
        testInstance = new ArrayTool();
        msg = "Method getBitShifts() should return an integer array! It does NOT!";
        assertTrue(msg, testInstance.getBitShifts() instanceof int[]);
    }

    /**
     * Tests whether the integer array BIT_SHITS returned by the method
     * getBitShifts() has the correct number of elements.
     * 
     * @throws java.lang.Exception
     */
    public void getBitShifts_returnsCorrectArrayLength() throws Exception {
        testInstance = new ArrayTool();
        int expectedLength = 16;
        msg  = "Integer array BIT_SHIFTS returned by the method getBitShifts() has incorrect number of elements!\n";
        msg += "The array should contain " + expectedLength + " elements!\n";
        assertTrue(msg, testInstance.getBitShifts().length == expectedLength);
    }

    /**
     * Tests whether the value returned by the method
     * getExpansion() is an integer array.
     * 
     * @throws java.lang.Exception
     */
    public void getExpansion_returnsIntegerArray() throws Exception {
        testInstance = new ArrayTool();
        msg = "Method getExpansion() should return an integer array! It does NOT!";
        assertTrue(msg, testInstance.getExpansion() instanceof int[]);
    }

    /**
     * Tests whether the integer array EXPANSION returned by the method
     * getExpansion() has the correct number of elements.
     * 
     * @throws java.lang.Exception
     */
    public void getExpansion_returnsCorrectArrayLength() throws Exception {
        testInstance = new ArrayTool();
        int expectedLength = 48;
        msg  = "Integer array EXPANSION returned by the method getExpansion() has incorrect number of elements!\n";
        msg += "The array should contain " + expectedLength + " elements!\n";
        assertTrue(msg, testInstance.getExpansion().length == expectedLength);
    }

    /**
     * Tests whether the value returned by the method
     * getSubstitution() is an integer array.
     * 
     * @throws java.lang.Exception
     */
    @Test
    public void getSubstitution_returnsIntegerArray() throws Exception {
        testInstance = new ArrayTool();
        msg = "Method getSubstitution() should return an integer array! It does NOT!";
        Assert.assertTrue(msg, testInstance.getSubstitution() instanceof int[]);
    }

    /**
     * Tests whether the integer array returned by the method
     * getSubstitution() has the correct number of elements.
     * 
     * @throws java.lang.Exception
     */
    @Test
    public void getSubstitution_returnsCorrectArrayLength() throws Exception {
        testInstance = new ArrayTool();
        int expectedLength = 8*64;
        msg  = "Integer array S returned by the method getSubstitution() has incorrect number of elements!\n";
        msg += "The array should contain 8*64 elements!\n";
        Assert.assertTrue(msg, testInstance.getSubstitution().length == expectedLength);
    }

    /**
     * Tests whether the value returned by the method
     * getP() is an integer array.
     * 
     * @throws java.lang.Exception
     */
    public void getP_returnsIntegerArray() throws Exception {
        testInstance = new ArrayTool();
        msg = "Method getP() should return an integer array! It does NOT!";
        assertTrue(msg, testInstance.getP() instanceof int[]);
    }

    /**
     * Tests whether the integer array P returned by the method
     * getP() has the correct number of elements.
     * 
     * @throws java.lang.Exception
     */
    public void getP_returnsCorrectArrayLength() throws Exception {
        testInstance = new ArrayTool();
        int expectedLength = 32;
        msg  = "Integer array P returned by the method getP() has incorrect number of elements!\n";
        msg += "The array should contain " + expectedLength + " elements!\n";
        Assert.assertTrue(msg, testInstance.getP().length == expectedLength);
    }

    /**
     * Tests whether the value returned by the method
     * getFP() is an integer array.
     * 
     * @throws java.lang.Exception
     */
    public void getFP_returnsIntegerArray() throws Exception {
        testInstance = new ArrayTool();
        msg = "Method getFP() should return an integer array! It does NOT!";
        Assert.assertTrue(msg, testInstance.getFP() instanceof int[]);
    }

    /**
     * Tests whether the integer array FP returned by the method
     * getFP() has the correct number of elements.
     * 
     * @throws java.lang.Exception
     */
    public void getFP_returnsCorrectArrayLength() throws Exception {
        int expectedLength = 64;
        msg  = "Integer array FP returned by the method getFP() has incorrect number of elements!\n";
        msg += "The array should contain " + expectedLength + " elements!\n";
        Assert.assertTrue(testInstance.getFP().length == expectedLength);
    }

    // TESTS

    /**
     * Executes integer array tests.
     *
     * @throws Exception
     */

    @Test
    public void integerArrayTests() throws Exception {
        System.out.print("ArrayToolTest...executing array tests...");
        getIP_returnsIntegerArray();
        getPC1_returnsIntegerArray();
        getPC2_returnsIntegerArray();
        getBitShifts_returnsIntegerArray();
        getExpansion_returnsIntegerArray();
        getSubstitution_returnsIntegerArray();
        getP_returnsIntegerArray();
        System.out.println("OK");
    }

    /**
     * Executes integer array element tests.
     *
     * @throws Exception
     */
    @Test
    public void integerArrayElementTests() throws Exception {
        System.out.print("ArrayToolTest...executing array element tests...");
        getIP_returnsCorrectArrayLength();
        getPC1_returnsCorrectArrayLength();
        getPC2_returnsCorrectArrayLength();
        getBitShifts_returnsCorrectArrayLength();
        getExpansion_returnsCorrectArrayLength();
        getSubstitution_returnsCorrectArrayLength();
        getP_returnsCorrectArrayLength();
        System.out.println("OK");
    }
}
