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

        String FILE_NAME = "Picture4";

        int ENCRYPTION = 0;
        int DECRYPTION = 1;

        String ORIGINAL_FILE = "data/" + FILE_NAME + ".ORIGINAL.jpg";
        String ENCRYPT_JAVA_FILE  = "data/" + FILE_NAME + ".ENCRYPTED.JavaWay.jpg";
        String DECRYPT_JAVA_FILE  = "data/" + FILE_NAME + ".DECRYPTED.JavaWay.jpg";
        String ENCRYPT_MY_FILE  = "data/" + FILE_NAME + ".ENCRYPTED.MyWay.jpg";
        String DECRYPT_MY_FILE  = "data/" + FILE_NAME + ".DECRYPTED.MyWay.jpg";

        /**
         * JavaDES
         */

        //System.out.println();
        //System.out.println("## JavaDES: " + FILE_NAME + " ##");
        //JavaDES JavaWay = new JavaDES();
        //JavaWay.encryptImage(ORIGINAL_FILE, ENCRYPT_JAVA_FILE);
        //JavaWay.decryptImage(ENCRYPT_JAVA_FILE, DECRYPT_JAVA_FILE);

        /**
         * MyDES
         */

        System.out.println();
        System.out.println("## MyDES: " + FILE_NAME + " ##");
        MyDES MyWay = new MyDES();
        MyWay.execute(ENCRYPTION, ORIGINAL_FILE, ENCRYPT_MY_FILE);
        MyWay.execute(DECRYPTION, ENCRYPT_MY_FILE, DECRYPT_MY_FILE);
    }
}
