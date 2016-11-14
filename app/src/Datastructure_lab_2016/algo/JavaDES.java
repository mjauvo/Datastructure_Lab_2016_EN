package Datastructure_lab_2016.algo;

import Datastructure_lab_2016.util.*;
import javax.crypto.*;
import java.io.*;

/**
 * A class demonstrating DES algorithm using
 * Java's own cryptography structures.
 *
 * @author Markus J. Auvo 2016
 */
public class JavaDES
{
    // GENERAL INSTANCE VARIABLES

    private final MessageTool MT;
    private final FileTool FT;

    // CRYPTO VARIABLES

    private final String ALGO;
    private final SecretKey SEC_KEY;
    private final Cipher ENC_CIPHER;
    private final Cipher DEC_CIPHER;

    // MESSAGE CONSTANTS

    private final int ENCRYPTION_START      =   11;
    private final int ENCRYPTION_COMPLETE   =   12;
    private final int DECRYPTION_START      =   21;
    private final int DECRYPTION_COMPLETE   =   22;
    
    private final int READ_PLAIN_IMAGE      =   41;
    private final int WRITE_ENC_IMAGE       =   42;
    private final int READ_ENC_IMAGE        =   61;
    private final int WRITE_DEC_IMAGE       =   62;
    private final int FAILURE               =   89;
    private final int SUCCESS               =   99;

    /**
     * Constructor.
     * 
     * @throws Exception
     */
    public JavaDES() throws Exception {
        this.ALGO = "DES";
        this.SEC_KEY = KeyGenerator.getInstance(ALGO).generateKey();
        this.ENC_CIPHER = Cipher.getInstance(ALGO);
        this.DEC_CIPHER = Cipher.getInstance(ALGO);
        this.ENC_CIPHER.init(Cipher.ENCRYPT_MODE, SEC_KEY);
        this.DEC_CIPHER.init(Cipher.DECRYPT_MODE, SEC_KEY);
        this.MT = new MessageTool();
        this.FT = new FileTool();
    }

    /**
     * Returns the encryption algorithm used in this instance.
     * 
     * @return 
     */
    public String getAlgorithm() {
        return this.ALGO;
    }

    /**
     * Returns the Cipher object used in encryption.
     * 
     * @return 
     */
    public Cipher getEncryptor() {
        return this.ENC_CIPHER;
    }

    /**
     * Returns the Cipher object used in decryption.
     * 
     * @return 
     */
    public Cipher getDecryptor() {
        return this.DEC_CIPHER;
    }

    /**
     * Returns the key generated and used in this instance.
     * 
     * @return The encryption key
     */
    public SecretKey getSecretKey() {
        return this.SEC_KEY;
    }

    /**
     * Encrypts a plain image file.
     *
     * @param inputFile The name of the input file
     * @param outputFile The name of the output file
     * @throws java.io.FileNotFoundException
     */
    public void encryptImage(String inputFile, String outputFile) throws FileNotFoundException {
        InputStream IS  = FT.getInputStream(inputFile);
        OutputStream OS = FT.getOutputStream(outputFile);

        MT.display(ENCRYPTION_START);
        try {
            MT.display(READ_PLAIN_IMAGE);
            byte[] buffer = new byte[2048];
            int length;
            while ((length = IS.read(buffer)) > 0) {
                OS.write(ENC_CIPHER.update(buffer, 0, length));
                OS.flush();
            }
            MT.display(SUCCESS);
            MT.display(WRITE_ENC_IMAGE);

            OS.write(ENC_CIPHER.doFinal());
            MT.display(SUCCESS);
            IS.close();
            OS.close();
            MT.display(ENCRYPTION_COMPLETE);
        }
        catch (IOException | IllegalBlockSizeException | BadPaddingException e) {
            MT.display(FAILURE);
        }
    }

    /**
     * Decrypts an encrypted image file.
     *
     * @param inputFile
     * @param outputFile
     * @throws java.io.FileNotFoundException
     */
    public void decryptImage(String inputFile, String outputFile) throws FileNotFoundException {
        InputStream IS  = FT.getInputStream(inputFile);
        OutputStream OS = FT.getOutputStream(outputFile);

        MT.display(DECRYPTION_START);
        try {
            MT.display(READ_ENC_IMAGE);
            byte[] buffer = new byte[2048];
            int length;
            while ((length = IS.read(buffer)) > 0) {
                OS.write(DEC_CIPHER.update(buffer, 0, length));
                OS.flush();
            }
            MT.display(SUCCESS);
            MT.display(WRITE_DEC_IMAGE);
            OS.write(DEC_CIPHER.doFinal());
            MT.display(SUCCESS);
            IS.close();
            OS.close();
            MT.display(DECRYPTION_COMPLETE);
        }
        catch (IOException | IllegalBlockSizeException | BadPaddingException e) {
        }
    }
}