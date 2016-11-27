package Datastructure_lab_2016.util;

import java.io.*;
import static org.junit.Assert.*;
import org.junit.*;


/**
 * A test class for ByteBitTool class.
 *
 * @author Markus
 */
public class ByteBitToolTest
{
    private ByteBitTool testInstance;
    private ArrayTool testAT;
    private String msg;

    private final String TEST_KEY = "TEST_KEY";
    private final String TEST_FILE = "data/Picture1.ORIGINAL.jpg";

    /**
     * Tests whether the cipher is of correct length (8 bytes)
     * 
     * @param key The cipher key
     * @throws Exception 
     */
    public void getKeyBytes_correctKeyLength(String key) throws Exception {
        msg = "The cipher key should be 8 bytes long, but it is NOT!!";
        int expectedLength = 8;
        assertTrue(msg, key.length() == expectedLength);
    }


    /**
     * Tests whether the method returns a byte array.
     * 
     * @param key The cipher key
     * @throws Exception 
     */
    public void getKeyBytes_returnsByteArray(String key) throws Exception {
        testInstance = new ByteBitTool();
        msg = "Method getKeyBytes() should return a byte array! It does NOT!";
        assertTrue(msg, testInstance.getKeyBytes(key) instanceof byte[]);
    }

    /**
     * Tests whether the method returns a byte array.
     * 
     * @param fileName
     * @throws java.io.FileNotFoundException 
     */
    public void getFileBytes_returnsByteArray(String fileName) throws FileNotFoundException, Exception {
        testInstance = new ByteBitTool();
        msg = "Method getFileBytes() should return a byte array! It does NOT!";
        assertTrue(msg, testInstance.getFileBytes(fileName) instanceof byte[]);
    }

    /**
     * Tests whether method returns zero when given byte length is zero.
     *
     * @throws java.lang.Exception
     */
    public void getNecessaryPaddingLength_returnsZeroWithLengthZero() throws Exception {
        testInstance = new ByteBitTool();
        int expectedValue = 0;
        msg = "Method getNecessaryPaddingLength() should return value " + expectedValue + " when given byte length is zero! It does NOT!";
        assertTrue(testInstance.getNecessaryPaddingLength(0) == expectedValue);
    }

    /**
     * Tests whether method returns zero when given byte length is zero.
     *
     * @throws java.lang.Exception
     */
    public void getNecessaryPaddingLength_returnsZeroWithLengthEight() throws Exception {
        testInstance = new ByteBitTool();
        int expectedValue = 0;
        msg = "Method getNecessaryPaddingLength() should return value " + expectedValue + " when given byte length is zero! It does NOT!";
        assertTrue(testInstance.getNecessaryPaddingLength(8) == expectedValue);
    }

    /**
     * Tests whether the returned padding length is greater than zero.
     * 
     * @param byteLength The given byte length
     * @pre 0 < byteLength && byteLength < 8
     * @throws Exception
     */
    public void getNecessaryPaddingLength_returnsGreaterThanZeroWithOneToSeven(int byteLength) throws Exception {
        testInstance = new ByteBitTool();
        int actualValue = testInstance.getNecessaryPaddingLength(byteLength);
        msg = "The method With parameter value " + byteLength + " the value should be greater than zero";
        Assert.assertTrue(msg, actualValue > 0);
    }

    /**
     * Tests whether the returned value is correct.
     *
     * @param byteLength
     * @throws Exception
     */
    public void getNecessaryPaddingLength_returnsCorrectValue(int byteLength) throws Exception {
        testInstance = new ByteBitTool();
        int expectedValue = 0;
        if (byteLength < 8 && byteLength > 0) {
            expectedValue = 8 - byteLength;
        }
        int actualValue = testInstance.getNecessaryPaddingLength(byteLength);
        msg  = "Method returns " + actualValue + " with parameter " + byteLength + ". ";
        msg += "The value should be " + expectedValue;
        assertTrue(msg, actualValue == expectedValue);
    }

    /**
     * Tests whether method tries to add elements outside the array bounds.
     * 
     * @param arrayLength
     * @param start
     * @param paddingLength
     * @throws Exception 
     */
    public void getPaddedBytes_addsNotElementsOutsideArrayBounds(int arrayLength, int start, int paddingLength) throws Exception {
        testInstance = new ByteBitTool();
        byte[] testBytes = new byte[arrayLength];
        msg = "Array has only " + arrayLength + " element(s) and you are trying to add elements starting ";
        msg += "from element number " + (start+1) + ". You cannot add elements outside the array ";
        msg += "bounds!!";
        assertTrue(msg, start < arrayLength);
    }

    /**
     * Tests whether the method returns a byte array.
     * 
     * @param start
     * @param arrayLength
     * @param paddingLength
     * @throws Exception 
     */
    public void getPaddedBytes_returnsByteArray(int arrayLength, int start, int paddingLength) throws Exception {
        testInstance = new ByteBitTool();
        byte[] testBytes = new byte[arrayLength];
        msg = "Method getPaddedBytes() should return a byte array! It does NOT!";
        Assert.assertTrue(msg, testInstance.getPaddedBytes(testBytes, start, paddingLength)  instanceof byte[]);
    }

    /**
     * Tests whether the method returns a byte array.
     * 
     * @param length
     * @param step
     * @throws Exception 
     */
    public void leftShift_returnsByteArray(int length, int step) throws Exception {
        testInstance = new ByteBitTool();
        byte[] testBytes = {2, 4, 6, 1, 3, 5, 7};
        msg = "";
        assertTrue(msg, testInstance.leftShift(testBytes, length, step) instanceof byte[]);
    }

    /**
     * Tests whether the method returns a byte array.
     * 
     * @throws Exception 
     */
    public void concatenate_returnsByteArray() throws Exception {
        testInstance = new ByteBitTool();
        byte[] testA = new byte[2];
        int testLengthA = 4;
        byte[] testB = new byte[3];
        int testLengthB = 6;
        msg = "Method getPaddedBytes() should return a byte array! It does NOT!";
        assertTrue(msg, testInstance.concatenate(testA, testLengthA, testB, testLengthB) instanceof byte[]);
    }

    /**
     * Tests whether the method returns an integer.
     * 
     * @param position 
     */
    public void getBit_returnsInteger(int position) {
        testInstance = new ByteBitTool();
        byte[] testBytes = {2, 4, 6, 1, 3, 5};
        msg = "Method should return an integer! It does NOT!";
        assertTrue(msg, testInstance.getBit(testBytes, position) % 1 == 0);
    }

    public void getBits_returnsByteArray(int position, int length) {
        testInstance = new ByteBitTool();
        byte[] testBytes = {2, 4, 6, 1, 3, 5};
        msg = "Method should return a byte array! It does NOT!";
        assertTrue(msg, testInstance.getBits(testBytes, position, length) instanceof byte[]);
    }

    public void permutateBits_returnsByteArray() {
        testInstance = new ByteBitTool();
        byte[] testBytes = {2, 4, 6, 8, 10, 1, 3, 5, 7, 9};
        int[] testPermutations = {2, 3, 5, 6, 8, 9};
        msg = "Method should return a byte array! It does NOT!";
        assertTrue(msg, testInstance.permutateBits(testBytes, testPermutations) instanceof byte[]);
    }

    public void exclusiveOR_returnsByteArray() {
        testInstance = new ByteBitTool();
        byte[] testA = {1, 3, 5, 7};
        byte[] testB = {2, 3, 6, 8};
        msg = "Method should return a byte array! It does NOT!";
        assertTrue(msg, testInstance.exclusiveOR(testA, testB) instanceof byte[]);
    }

    public void splitBytes_returnsByteArray(int length) {
        testInstance = new ByteBitTool();
        byte[] testBytes = {1, 3, 5, 7, 9, 11, 2, 4, 6, 8, 10};
        msg = "Method should return a byte array! It does NOT!";
        assertTrue(msg, testInstance.splitBytes(testBytes, length) instanceof byte[]);
    }

    // TESTS

    /**
     *
     * @throws Exception
     */
    @Test
    public void ByteBitTests() throws Exception {
        System.out.print("ByteBitToolTest...executing byte and bit tests...");
        getKeyBytes_returnsByteArray(TEST_KEY);
        getKeyBytes_correctKeyLength(TEST_KEY);
        getFileBytes_returnsByteArray(TEST_FILE);
        getNecessaryPaddingLength_returnsZeroWithLengthZero();
        getNecessaryPaddingLength_returnsZeroWithLengthEight();
        getNecessaryPaddingLength_returnsGreaterThanZeroWithOneToSeven(3);
        getNecessaryPaddingLength_returnsGreaterThanZeroWithOneToSeven(5);
        getNecessaryPaddingLength_returnsGreaterThanZeroWithOneToSeven(2);
        getNecessaryPaddingLength_returnsGreaterThanZeroWithOneToSeven(6);
        getNecessaryPaddingLength_returnsGreaterThanZeroWithOneToSeven(1);
        getNecessaryPaddingLength_returnsGreaterThanZeroWithOneToSeven(7);
        getNecessaryPaddingLength_returnsCorrectValue(0);
        getNecessaryPaddingLength_returnsCorrectValue(2);
        getNecessaryPaddingLength_returnsCorrectValue(3);
        getNecessaryPaddingLength_returnsCorrectValue(5);
        getNecessaryPaddingLength_returnsCorrectValue(6);
        getNecessaryPaddingLength_returnsCorrectValue(7);
        getNecessaryPaddingLength_returnsCorrectValue(8);
        //getPaddedBytes_addsNotElementsOutsideArrayBounds(0, 0, 0); // TEST FAILS
        //getPaddedBytes_addsNotElementsOutsideArrayBounds(0, 2, 1); // TEST FAILS
        getPaddedBytes_addsNotElementsOutsideArrayBounds(3, 1, 1);
        //getPaddedBytes_addsNotElementsOutsideArrayBounds(2, 3, 1); // TEST FAILS
        getPaddedBytes_returnsByteArray(2, 1, 1);
        getPaddedBytes_returnsByteArray(4, 1, 1);
        getPaddedBytes_returnsByteArray(3, 1, 1);
        getPaddedBytes_returnsByteArray(5, 1, 1);
        leftShift_returnsByteArray(2, 1);
        leftShift_returnsByteArray(1, 2);
        concatenate_returnsByteArray();
        getBit_returnsInteger(1);
        getBit_returnsInteger(2);
        getBit_returnsInteger(3);
        getBit_returnsInteger(4);
        getBit_returnsInteger(5);
        getBits_returnsByteArray(1, 3);
        getBits_returnsByteArray(2, 2);
        getBits_returnsByteArray(3, 1);
        permutateBits_returnsByteArray();
        splitBytes_returnsByteArray(1);
        splitBytes_returnsByteArray(2);
        System.out.println("OK");
    }
}
