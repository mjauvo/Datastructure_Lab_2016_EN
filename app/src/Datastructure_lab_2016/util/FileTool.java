package Datastructure_lab_2016.util;

import java.io.*;

/**
 * A utility class for handling files.
 *
 * @author Markus
 */
public class FileTool
{
    /**
     * Returns a new File instance.
     * 
     * @param fileName
     * @return A File object
     * @throws FileNotFoundException 
     */
    public File getFile(String fileName) throws FileNotFoundException {
        return new File(fileName);
    }

    /**
     * Returns the file's byte length.
     * 
     * @param fileName
     * @return The integer value of file's byte length
     * @throws java.io.FileNotFoundException 
     */
    public int getFileLength(String fileName) throws FileNotFoundException {
        return (int) getFile(fileName).length();
    }

    /**
     * Returns an file input stream.
     * 
     * @param filename
     * @return An InputStream object 
     * @throws java.io.FileNotFoundException 
     */
    public FileInputStream getInputStream(String filename) throws FileNotFoundException {
        return new FileInputStream(getFile(filename));
    }

    /**
     * Returns an file output stream.
     * 
     * @param filename
     * @return An InputStream object 
     * @throws java.io.FileNotFoundException 
     */
    public FileOutputStream getOutputStream(String filename) throws FileNotFoundException {
        return new FileOutputStream(getFile(filename));
    }
}
