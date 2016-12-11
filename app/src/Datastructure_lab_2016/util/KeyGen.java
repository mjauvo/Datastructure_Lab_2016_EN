package Datastructure_lab_2016.util;

/**
 * A utility class for generating keys for DES algorithm
 * <p>
 * @author Markus J. Auvo, 2016
 */
public class KeyGen
{
    // INSTANCE VARIABLES
    private final ArrayTool AT;
    private final ByteBitTool BBT;

    /**
     * Constructor
     */
    public KeyGen() {
        this.AT = new ArrayTool();
        this.BBT = new ByteBitTool();
    }

    /**
     * Returns a randomly generated 8-byte key.
     * 
     * @return A new 8-byte key.
     */
    public String getRandomKey() {
        int keyLength = 8;
        char[] keyChars = new char[8];
        String key;

        for (int i=0; i < keyLength; i++) {
            int value = (int) Math.round(Math.random() * 255);
            keyChars[i] = (char) value;
            
        }
        key = String.valueOf(keyChars);
        return key;
    }

    /**
     * Generates and returns an array of 16 subkeys of 48-bits
     * (6 bytes) for encryption/decryption process. are needed.
     * 
     * @param originalKey The original 64-bit key
     * @return The array of 48-bit sub keys.
     * @throws java.lang.Exception 
     */
    public byte[][] getRoundSubKeys(String originalKey) throws Exception {
        // Get Permutated Choice 1 table
        int[] PC1 = AT.getPC1();
        // Get Permutated Choice 2 table
        int[] PC2 = AT.getPC2();
        // Get the array for bit shifts
        int[] BIT_SHIFTS = AT.getBitShifts();

        int permutatedKeySize = PC1.length;
        int amountOfSubKeys = 16;

        // Convert original key into a byte array
        byte[] keyBytes = BBT.getKeyBytes(originalKey);
        // Permutate byte array according to PC1 table
        byte[] permutatedKey = BBT.permutateBits(keyBytes, PC1);
        int halfKeySize = permutatedKeySize/2;

        // Divide permutated key block into two half blocks
        byte[] C = BBT.getBits(permutatedKey, 0, halfKeySize);
        byte[] D = BBT.getBits(keyBytes, halfKeySize, halfKeySize);

        // Define an array for the subkeys used
        // in encryption/decryption rounds
        byte[][] roundSubKeys = new byte[amountOfSubKeys][];

        // Generate 16 subkeys
        for (int i=0; i < amountOfSubKeys; i++) {
            // Perform bit shifts on both half blocks according bit shift array
            C = BBT.leftShift(C, halfKeySize, BIT_SHIFTS[i]);
            D = BBT.leftShift(D, halfKeySize, BIT_SHIFTS[i]);

            // "Concatenate" half blocks back into a whole block
            byte[] CD = BBT.concatenate(D, halfKeySize, D, halfKeySize);

            // Finally, permutate the block according to PC2 table
            roundSubKeys[i] = BBT.permutateBits(CD, PC2);
        }
        return roundSubKeys;
    }
}
