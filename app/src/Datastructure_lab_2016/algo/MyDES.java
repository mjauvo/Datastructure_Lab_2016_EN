package Datastructure_lab_2016.algo;

import Datastructure_lab_2016.util.*;
import java.util.Arrays;

/**
 * A class demonstrating DES algorithm using student's own implementation.
 * 
 * Implementation uses a block size of 64 bits (8 bytes). Therefore, if
 * necessary, the original message is padded with random characters to
 * achieve a message length divisible with 8.
 *
 * @author Markus J. Auvo, 2016
 */
public class MyDES
{
    // INSTANCE VARIABLES

    private final ArrayTool AT;
    private final ByteBitTool BBT;
    private final KeyGen KG;
    private final MessageTool MT;
    private final String CIPHER_KEY;

    // PRIMITIVE VARIABLES

    private int numOfBlocks;
    private byte[] byteBlock;
    private long startTime;
    private long endTime;

    // MESSAGE CONSTANTS

    private final int ENCRYPTION_START      =   11;
    private final int ENCRYPTION_COMPLETE   =   12;
    private final int DECRYPTION_START      =   21;
    private final int DECRYPTION_COMPLETE   =   22;
    
    private final int READ_FROM_FILE        =   41;
    private final int WRITE_TO_FILE         =   42;
    private final int FAILURE               =   89;
    private final int SUCCESS               =   99;

    /**
     * Constructor.
     * 
     * @throws Exception 
     */
    public MyDES() throws Exception {
        this.AT = new ArrayTool();
        this.BBT = new ByteBitTool();
        this.KG = new KeyGen();
        this.MT = new MessageTool();
        this.CIPHER_KEY = KG.getRandomKey();
    }

    public int[] getOperationMessages(int OPERATION_MODE) {
        int[] OPERATION = new int[2];

        // The chosen DES operation mode
        // 0 = encryption, 1 = decryption
        switch (OPERATION_MODE) {
            case 0:
                OPERATION[0] = ENCRYPTION_START;
                OPERATION[1] = ENCRYPTION_COMPLETE;
                break;
            case 1:
                OPERATION[0] = DECRYPTION_START;
                OPERATION[1] = DECRYPTION_COMPLETE;
                break;
        }
        return OPERATION;
    } 

    /**
     * Executes an encryption or decryption on a given file
     * and stores the resulting information into a given file.
     * 
     * @param inputFile The file containing the input data
     * @param outputFile The file containing the output data
     * @param OPERATION The chosen operation (0 = encrypt || 1 = decrypt)
     * @throws Exception 
     */
    public void execute(int OPERATION, String inputFile, String outputFile) throws Exception {
        int[] OP_MSG = getOperationMessages(OPERATION);

        // Operation start
        MT.display(OP_MSG[0]);

        // Start timer
        this.startTime = System.currentTimeMillis();

        MT.display(READ_FROM_FILE);
        // Get data bytes (with necessary padding) from input file
        byte[] inputBytes = BBT.getFileBytes(inputFile);
        MT.display(SUCCESS);
        // Define a byte array for processed data to be stored into a file
        byte[] outputBytes = new byte[inputBytes.length];

        // Arrange bytes into 8-byte (64-bit) blocks and crypt the blocks.
        int blockSize = 8;
        if (inputBytes.length % 8 == 0) {
            numOfBlocks = inputBytes.length/8;
        }
        else {
            numOfBlocks = -1;
            System.out.println("Number of bytes NOT DIVISIBLE BY 8");
            System.exit(0);
        }

        // Process an 8-byte block
        System.out.print("\t");
        for (int i=1; i<=numOfBlocks; i++) {
            if (i % 6000 == 0) {
                // A simple "progress bar"
                System.out.print("#");
            }
            int start = (i-1) * blockSize;
            int end = start + blockSize;
            byteBlock = Arrays.copyOfRange(inputBytes, start, end);

            // Operation: Initial Permutation
            byteBlock = BBT.permutateBits(byteBlock, AT.getIP());
            int InitBlockSize = AT.getIP().length;
            byte[] leftBlock = BBT.getBits(byteBlock, 0, InitBlockSize/2);
            byte[] rightBlock = BBT.getBits(byteBlock, InitBlockSize/2, InitBlockSize/2);

            byte[][] roundSubKeys = KG.getRoundSubKeys(CIPHER_KEY);
            int numOfRoundSubKeys = roundSubKeys.length;

            // The real magic is in the encryption/decryption 16 rounds which
            // are performed on each data block. The ONLY difference between
            // encryption and decryption is the order in which the process
            // round subkeys are used.
            //
            // ENCRYPTION: subkeys 1..16
            // DECRYPTION: subkeys 16..1
            //
            for (int k=0; k<numOfRoundSubKeys; k++) {
                byte[] tempRightBlock = rightBlock;

                // Operation: Expansion
                rightBlock = BBT.permutateBits(rightBlock, AT.getExpansion());

                switch (OPERATION) {
                    // Encrypt
                    case 0:
                        rightBlock = BBT.exclusiveOR(rightBlock, roundSubKeys[k]);
                        break;
                    // Decrypt
                    case 1:
                        rightBlock = BBT.exclusiveOR(rightBlock, roundSubKeys[numOfRoundSubKeys-k-1]);
                        break;
                    default:
                        break;
                }

                // Operation: Substitution
                rightBlock = BBT.substituteBits(rightBlock);

                // Operation: Permutation
                rightBlock = BBT.permutateBits(rightBlock, AT.getP());

                // Operation: Exclusive-OR
                rightBlock = BBT.exclusiveOR(leftBlock, rightBlock);

                leftBlock = tempRightBlock;
            }

            byte[] blocksLeftRight = BBT.concatenate(rightBlock, InitBlockSize/2, leftBlock, InitBlockSize/2);

            // Operation: Final Premutation
            blocksLeftRight = BBT.permutateBits(blocksLeftRight, AT.getFP());

            // Assemble crypted blocks back into a byte array
            System.arraycopy(blocksLeftRight, 0, outputBytes, (i-1) * blockSize, blockSize);
        }
        System.out.println();

        // Store the byte array into a file
        MT.display(WRITE_TO_FILE);
        BBT.setFileBytes(outputFile, outputBytes);
        MT.display(SUCCESS);

        // End timer
        this.endTime = System.currentTimeMillis();

        // Operation complete
        MT.display(OP_MSG[1]);
        System.out.println("Execution time: " + (endTime-startTime) + " milliseconds");
    }
}
