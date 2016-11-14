package Datastructure_lab_2016.algo;

import static org.junit.Assert.*;
import org.junit.*;
import javax.crypto.*;

/**
 * A test class for JavaDES class.
 *
 * @author Markus J. Auvo
 */
public class JavaDESTest
{
    private JavaDES testInstance;
    private String msg;
    /**
     * Tests whether a class instance is instantiated
     * with the correct crypto algorithm.
     * 
     * @param expected
     * @throws java.lang.Exception
     */
    public void classInstantiatesWithCorrectAlgorithm(String expected) throws Exception {
        testInstance = new JavaDES();
        String actual = testInstance.getAlgorithm();
        msg  = "Class 'JavaDES' should be instantiated with " + expected + " algorithm";
        msg += ", but instead class is instantiated with " + actual + " algorithm!";
        assertTrue(msg, expected.equals(actual));
    }

    /**
     * Tests whether a class instance is instantiated with
     * SecretKey class object as the encryption key.
     * 
     * @throws Exception 
     */
    public void classInstantiatesWithSecretKeyClass() throws Exception {
        testInstance = new JavaDES();
        msg  = "Class 'JavaDES' should be instantiated with encryption key of ";
        msg += "SecretKey class, but instead class is instantiated with ";
        msg += testInstance.getSecretKey().getClass();
        assertTrue(msg, testInstance.getSecretKey() instanceof SecretKey);
    }

    /**
     * Tests whether encryption uses the correct Cipher class.
     * 
     * @throws java.lang.Exception
     */
    public void classInstantiatesWithCorrectEncryptorClass() throws Exception {
        testInstance = new JavaDES();
        msg  = "Class 'JavaDES' should be instantiated with encryptor of ";
        msg += "Cipher class, but instead class is instantiated with ";
        msg += testInstance.getEncryptor().getClass();
        assertTrue(msg, testInstance.getEncryptor() instanceof Cipher);
    }

    /**
     * Tests whether decryption uses the correct Cipher class.
     * 
     * @throws java.lang.Exception
     */
    public void classInstantiatesWithCorrectDecryptorClass() throws Exception {
        testInstance = new JavaDES();
        Cipher expected = Cipher.getInstance("DES");
        msg  = "Class 'JavaDES' should be instantiated with decryptor of ";
        msg += expected.getClass() + ", but instead class is instantiated with ";
        msg += testInstance.getDecryptor().getClass();
        assertTrue(msg, expected.getClass().equals(testInstance.getDecryptor().getClass()));
    }

    // TESTS

    /**
     * Executes class instance instantiation tests.
     *
     * @throws Exception
     */
    @Test
    public void classInstantiationTests() throws Exception {
        System.out.print("JavaDESTest...executing class instantiation tests tests...");
        classInstantiatesWithCorrectAlgorithm("DES");
        classInstantiatesWithSecretKeyClass();
        classInstantiatesWithCorrectEncryptorClass();
        classInstantiatesWithCorrectDecryptorClass();
        System.out.println("OK");
    }
}
