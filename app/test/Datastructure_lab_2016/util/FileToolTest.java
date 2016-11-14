package Datastructure_lab_2016.util;

import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;

/**
 * A test class for FileTool class.
 *
 * @author Markus
 */
public class FileToolTest
{
    private FileTool testInstance;
    private String msg;

    private final String INPUT_FILE = "data/Picture3.ORIGINAL.jpg";
    private final String OUTPUT_FILE = "data/Picture3.ENCRYPTED.jpg";

    /**
     * Tests whether the method returns a new instance of the class 'File'.
     * 
     * @param fileName
     * @throws FileNotFoundException 
     */
    public void getFile_returnsNewFileInstance(String fileName) throws FileNotFoundException {
        testInstance = new FileTool();
        msg  = "Method does not return a new 'File' object!";
        assertTrue(msg, testInstance.getFile(fileName) instanceof File);
    }

    /**
     * Tests whether the method returns a file byte length as an integer.
     *
     * @param fileName
     * @throws FileNotFoundException
     */
    public void getFileLength_returnsInteger(String fileName) throws FileNotFoundException {
        testInstance = new FileTool();
        int fileLength = testInstance.getFileLength(fileName);
        msg  = "Method returns a file byte length which is not an integer!";
        assertTrue(msg, ((Object)fileLength).getClass().getName().equals("java.lang.Integer"));
    }

    /**
     * Tests whether the method returns a file byte length of zero or more bytes.
     *
     * @param fileName
     * @throws FileNotFoundException
     */
    public void getFileLength_returnsZeroOrGreaterInteger(String fileName) throws FileNotFoundException {
        testInstance = new FileTool();
        int fileLength = testInstance.getFileLength(fileName);
        msg  = "Method returns a file byte length as a negative integer!";
        assertTrue(msg, fileLength >= 0);
    }

    /**
     * Tests whether the method returns an instance of the correct
     * class, i.e. InputStream
     * 
     * @throws FileNotFoundException 
     */
    public void getInputStream_returnsCorrectClassInstance() throws FileNotFoundException {
        testInstance = new FileTool();
        msg  = "Method should return an instance of FileInputStream, but instead ";
        msg += "the method returns an instance of ";
        msg += testInstance.getInputStream(INPUT_FILE).getClass();
        assertTrue(msg, testInstance.getInputStream(INPUT_FILE) instanceof FileInputStream);
    }

    /**
     * Tests whether the method returns an instance of the correct
     * class, i.e. OutStream
     * 
     * @throws FileNotFoundException 
     */
    @Test
    public void getOutputStream_returnsCorrectClassInstance() throws FileNotFoundException {
        testInstance = new FileTool();
        msg  = "Method should return an instance of FileOutputStream, but instead ";
        msg += "the method returns an instance of ";
        msg += testInstance.getOutputStream(OUTPUT_FILE).getClass();
        assertTrue(msg, testInstance.getOutputStream(OUTPUT_FILE) instanceof FileOutputStream);
    }

    // TESTS

    @Test
    public void classInstanceTests() throws Exception {
        System.out.print("FileToolTest...executing instance variable tests...");
        getFile_returnsNewFileInstance(INPUT_FILE);
        getInputStream_returnsCorrectClassInstance();
        getOutputStream_returnsCorrectClassInstance();
        System.out.println("OK");
    }

    @Test
    public void primitiveVariableTests() throws Exception {
        System.out.print("FileToolTest...executing primitive variable tests...");
        getFileLength_returnsInteger(INPUT_FILE);
        getFileLength_returnsZeroOrGreaterInteger(INPUT_FILE);
        System.out.println("OK");
    }
}
