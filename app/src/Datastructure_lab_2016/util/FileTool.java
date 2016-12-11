package Datastructure_lab_2016.util;

import java.io.*;

/**
 * A utility class for handling files.
 * <p>
 * @author Markus J. Auvo 2016
 */
public class FileTool
{
    /**
     * Returns a new File instance.
     * 
     * @param fileName The name of the file
     * @return A File object
     * @throws FileNotFoundException 
     */
    public File getFile(String fileName) throws FileNotFoundException {
        return new File(fileName);
    }

    /**
     * Returns the file's byte length.
     * 
     * @param fileName The name of the file
     * @return The integer value of file's byte length
     * @throws java.io.FileNotFoundException 
     */
    public int getFileLength(String fileName) throws FileNotFoundException {
        return (int) getFile(fileName).length();
    }

    /**
     * Returns an file input stream.
     * 
     * @param fileName The name of the file
     * @return An InputStream object 
     * @throws java.io.FileNotFoundException 
     */
    public FileInputStream getInputStream(String fileName) throws FileNotFoundException {
        return new FileInputStream(getFile(fileName));
    }

    /**
     * Returns an file output stream.
     * 
     * @param fileName The name of the file
     * @return An InputStream object 
     * @throws java.io.FileNotFoundException 
     */
    public FileOutputStream getOutputStream(String fileName) throws FileNotFoundException {
        return new FileOutputStream(getFile(fileName));
    }
}
