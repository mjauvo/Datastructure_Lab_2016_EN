package Datastructure_lab_2016.util;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * A test class for KeyGen class.
 *
 * @author Markus J. Auvo, 2016
 */
public class KeyGenTest
{
    private KeyGen testInstance;
    private String msg;

    /**
     * Tests whether the encryption key returned
     * by the method is 8 bytes (64 bits) long.
     */
    public void getRandomKey_returnsAKeyOfEightBytes() {
        testInstance = new KeyGen();
        int actualLength = testInstance.getRandomKey().length();
        int expectedLength = 8;
        msg = "Method should return a 64-bit key! It does NOT!";
        assertTrue(msg, actualLength == expectedLength);
    }

    /**
     * Tests whether the method returns a byte array.
     * 
     * @throws java.lang.Exception
     */
    public void getRoundSubKeys_returnsByteArray() throws Exception {
        testInstance = new KeyGen();
        String testKey = testInstance.getRandomKey();
        msg = "Method getKeyBytes() should return a byte array! It does NOT!";
        assertTrue(msg, testInstance.getRoundSubKeys(testKey) instanceof byte[][]);
    }

    // TESTS

    @Test
    public void keyTests() throws Exception {
        System.out.print("KeyGenTest...executing key tests...");
        getRandomKey_returnsAKeyOfEightBytes();
        getRoundSubKeys_returnsByteArray();
        System.out.println("OK");
    }
}
