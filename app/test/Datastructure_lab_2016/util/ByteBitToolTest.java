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
        String message = "The method With parameter value " + byteLength + " the value should be greater than zero";
        Assert.assertTrue(message, actualValue > 0);
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
        if (byteLength > 0 || byteLength < 8)
            expectedValue = 8 - byteLength;
        int actualValue = testInstance.getNecessaryPaddingLength(byteLength);
        msg = "With parameter value " + byteLength + " the value should be " + expectedValue;
        assertTrue(msg, actualValue == expectedValue);
    }

    public void getPaddedBytes_returnsByteArray() {
        testInstance = new ByteBitTool();
    }

    public void getPaddedBytes_returnsBytesDivisibleByEight() {
        testInstance = new ByteBitTool();
    }

    public void leftShift_returnsByteArray() {
        testInstance = new ByteBitTool();
    }

    public void concatenate_returnsByteArray() {
        testInstance = new ByteBitTool();
    }

    public void getBit_returnsInteger() {
        testInstance = new ByteBitTool();
    }

    public void setBit_() {
        testInstance = new ByteBitTool();
    }

    public void getBits_returnsByteArray() {
        testInstance = new ByteBitTool();
    }

    public void permutateBits_returnsByteArray() {
        testInstance = new ByteBitTool();
    }

    public void exclusiveOR_returnsByteArray() {
        testInstance = new ByteBitTool();
    }

    public void substituteBits_returnsByteArray() {
        testInstance = new ByteBitTool();
    }

    public void splitBytes_returnsByteArray() {
        testInstance = new ByteBitTool();
    }

    // TESTS

    /**
     *
     * @throws Exception
     */
    @Test
    public void ByteBitTests() throws Exception {
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
    }
}
