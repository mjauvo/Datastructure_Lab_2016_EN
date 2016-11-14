package Datastructure_lab_2016;

import Datastructure_lab_2016.algo.*;

/**
 * Lab assignment for Datastructures and Algorithms
 * Intermediate studies @ University of Helsinki.
 * 
 * Purpose of the assignment is to compare the performance between
 * Java's own crypto tools and crypto algorithm developed by the
 * student using picture files of different size (0.5MB, 1MB, 2MB).
 * 
 * This algorithm implements Data Encryption Standard (DES).
 *
 * This application does not implement MVC design pattern, since the focus
 * is in the implementation of an encryption algorithm and the text based
 * user interface is meant only to provide means to serve this purpose.
 *
 * @author Markus J. Auvo 2016
 */
public class Main
{
    /**
     * Main method and entry point to application
     * 
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {

        String ORIGINAL_FILE = "data/Picture3.ORIGINAL.jpg";
        String ENCRYPT_FILE  = "data/Picture3.JavaWay.ENCRYPTED.jpg";
        String DECRYPT_FILE  = "data/Picture3.JavaWay.DECRYPTED.jpg";

        /**
         * JavaDES
         */

        System.out.println();
        System.out.println("## JavaDES ##");
        JavaDES theJavaWay = new JavaDES();
        theJavaWay.encryptImage(ORIGINAL_FILE, ENCRYPT_FILE);
        theJavaWay.decryptImage(ENCRYPT_FILE, DECRYPT_FILE);

    }
}
