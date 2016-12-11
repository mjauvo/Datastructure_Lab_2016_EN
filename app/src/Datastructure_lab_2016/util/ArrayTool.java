package Datastructure_lab_2016.util;

/**
 * A utility class for handling DES related arrays.
 * <p>
 * @author Markus J. Auvo 2016
 */
public class ArrayTool
{
    /**
     * Initial Permutation (IP) table.
     * <p>
     * The message block is permuted by this permutation
     * at the beginning of the algorithm.
     */
    private final int[] IP = { 
        58, 50, 42, 34, 26, 18, 10, 2,
        60, 52, 44, 36, 28, 20, 12, 4,
        62, 54, 46, 38, 30, 22, 14, 6,
        64, 56, 48, 40, 32, 24, 16, 8,
        57, 49, 41, 33, 25, 17, 9,  1,
        59, 51, 43, 35, 27, 19, 11, 3,
        61, 53, 45, 37, 29, 21, 13, 5,
        63, 55, 47, 39, 31, 23, 15, 7
    };

    /**
     * Permuted Choice 1 (PC1) table.
     * <p>
     * The supplied 64-bit key is permuted according
     * to this table into a 56-bit key. (This is why
     * DES is only a 56-bit algorithm, even though you
     * provide 64 bits of key material.)
     */
    private final int[] PC1 = {
        57, 49, 41, 33, 25, 17,  9,  1,
        58, 50, 42, 34, 26, 18, 10,  2,
        59, 51, 43, 35, 27, 19, 11,  3,
        60, 52, 44, 36, 63, 55, 47, 39,
        31, 23, 15,  7, 62, 54, 46, 38,
        30, 22, 14,  6, 61, 53, 45, 37,
        29, 21, 13,  5, 28, 20, 12,  4
    };

    /**
     * Permuted Choice 2 (PC2) table.
     * <p>
     * The subkey generation process applies this permutation
     * to transform its running 56-bit key value into the
     * final set of 16 subkeys of 48-bits.
     */
    private final int[] PC2 = {
        14, 17, 11, 24,  1,  5,
         3, 28, 15,  6, 21, 10,
        23, 19, 12,  4, 26,  8,
        16,  7, 27, 20, 13,  2,
        41, 52, 31, 37, 47, 55,
        30, 40, 51, 45, 33, 48,
        44, 49, 39, 56, 34, 53,
        46, 42, 50, 36, 29, 32
    };
	
    /**
     * Subkey bit shifts which are done on each round.
     * <p>
     * Part of the subkey generation process involves shifting
     * certain bit-sections of the key stuff by either one or
     * two bits to the left. This table specifies how many bits
     * to shift left for each of the 16 steps.
     */
    private final int[] BIT_SHIFTS = {
        1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
    };
	
    /**
     * Expansion permutation (P-box)
     * <p>
     * The Feistel function begins by applying this permutation to its
     * 32-bit input half-block to create an "expanded" 48-bit value.
     */
    private final int[] EXPANSION = {
        32,  1,  2,  3,  4,  5,
        4,   5,  6,  7,  8,  9,
        8,   9, 10, 11, 12, 13,
        12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21,
        20, 21, 22, 23, 24, 25,
        24, 25, 26, 27, 28, 29,
        28, 29, 30, 31, 32,  1
    };

    /**
     * Substitution (S) boxes which form the very core of the security
     * of DES algorithm.
     * <p>
     * A crucial step in the Feistel function is to perform bit
     * substitutions according to this table.  A 48-bit value is
     * split into 6-bit sections, and each section is permuted into
     * a different 6-bit value according to these eight tables.
     * (One table for each section.)
     */
    private final int[] S = {
        // S1
        14,  4, 13,  1,  2, 15, 11,  8,  3, 10,  6, 12,  5,  9,  0,  7,
         0, 15,  7,  4, 14,  2, 13,  1, 10,  6, 12, 11,  9,  5,  3,  8,
         4,  1, 14,  8, 13,  6,  2, 11, 15, 12,  9,  7,  3, 10,  5,  0,
        15, 12,  8,  2,  4,  9,  1,  7,  5, 11,  3, 14, 10,  0,  6,  13,
        // S2
        15,  1,  8, 14,  6, 11,  3,  4,  9,  7,  2, 13, 12,  0,  5, 10,
         3, 13,  4,  7, 15,  2,  8, 14, 12,  0,  1, 10,  6,  9, 11,  5,
        10, 14,  7, 11, 10,  4, 13,  1,  5,  8, 12,  6,  9,  3,  2, 15,
        13,  8, 10,  1,  3, 15,  4,  2, 11,  6,  7, 12,  0,  5, 14,  9,
        // S3
        10,  0,  9, 14, 6,  3, 15,  5,  1, 13, 12,  7, 11,  4,  2,  8,
        13,  7,  0,  9, 3,  4,  6, 10,  2,  8,  5, 14, 12, 11, 15,  1,
        13,  6,  4,  9, 8, 15,  3,  0, 11,  1,  2, 12,  5, 10, 14,  7,
         1, 10, 13,  0, 6,  9,  8,  7,  4, 15, 14,  3, 11,  5,  2, 12,
        // S4
         7, 13, 14,  3,  0,  6,  9, 10,  1,  2,  8,  5, 11, 12,  4, 15,
        13,  8, 11,  5,  6, 15,  0,  3,  4,  7,  2, 12,  1, 10, 14,  9,
        10,  6,  9,  0, 12, 11,  7, 13, 15,  1,  3, 14,  5,  2,  8,  4,
         3, 15,  0,  6, 10,  1, 13,  8,  9,  4,  5, 11, 12,  7,  2, 14,
        // S5
        2, 12,  4,  1,  7, 10, 11,  6,  8,  5,  3, 15, 13,  0, 14,  9,
        14,11,  2, 12,  4,  7, 13,  1,  5,  0, 15, 10,  3,  9,  8,  6,
        4,  2,  1, 11, 10, 13,  7,  8, 15,  9, 12,  5,  6,  3,  0, 14,
        11, 8, 12,  7,  1, 14,  2, 13,  6, 15,  0,  9, 10,  4,  5,  3,
        // S6
        12,  1, 10, 15,  9,  2,  6,  8,  0, 13,  3,  4, 14,  7,  5, 11,
        10, 15,  4,  2,  7, 12,  9,  5,  6,  1, 13, 14,  0, 11,  3,  8,
         9, 14, 15,  5,  2,  8, 12,  3,  7,  0,  4, 10,  1, 13, 11,  6,
         4,  3,  2, 12,  9,  5, 15, 10, 11, 14,  1,  7,  6,  0,  8, 13,
        // S7
        4, 11,  2, 14, 15,  0,  8, 13,  3, 12,  9,  7,  5, 10,  6,  1,
        13, 0, 11,  7,  4,  9,  1, 10, 14,  3,  5, 12,  2, 15,  8,  6,
        1,  4, 11, 13, 12,  3,  7, 14, 10, 15,  6,  8,  0,  5,  9,  2,
        6, 11, 13,  8,  1,  4, 10,  7,  9,  5,  0, 15, 14,  2,  3, 12,
        // S8
        13,  2,  8,  4,  6, 15, 11,  1, 10,  9,  3, 14,  5,  0, 12,  7,
         1, 15, 13,  8, 10,  3,  7,  4, 12,  5,  6, 11,  0, 14,  9,  2,
         7, 11,  4,  1,  9, 12, 14,  2,  0,  6, 10, 13, 15,  3,  5,  8,
         2,  1, 14,  7,  4, 10,  8, 13, 15, 12,  9,  0,  3,  5,  6, 11
    };

    /**
     * Permutation (P) table.
     * <p>
     * The Feistel function concludes by applying this 32-bit permutation
     * to the result of the S-box substitution, in order to spread the
     * output bits across 6 different S-boxes in the next round.
     */
    private final int[] P = {
        16,  7, 20, 21,
        29, 12, 28, 17,
         1, 15, 23, 26,
         5, 18, 31, 10,
         2,  8, 24, 14,
        32, 27,  3,  9,
        19, 13, 30,  6,
        22, 11,  4, 25
    };

    /**
     * Final Permutation (FP), also Inverse Permutation table.
     * <p>
     * The final result is permuted by this permutation to
     * generate the final ciphertext block.
     */
    private final int[] FP = {
        40, 8, 48, 16, 56, 24, 64, 32,
        39, 7, 47, 15, 55, 23, 63, 31,
        38, 6, 46, 14, 54, 22, 62, 30,
        37, 5, 45, 13, 53, 21, 61, 29,
        36, 4, 44, 12, 52, 20, 60, 28,
        35, 3, 43, 11, 51, 19, 59, 27,
        34, 2, 42, 10, 50, 18, 58, 26,
        33, 1, 41,  9, 49, 17, 57, 25
    };

    /**
     * Returns the <i>Initial Permutation</i> table.
     * <p>
     * @return The <i>Initial Permutation</i> table
     */
    public int[] getIP() {
        return IP;
    }

    /**
     * Returns the <i>Permuted Choice 1</i> table.
     * 
     * @return The <i>Permuted Choice 1</i> table
     */
    public int[] getPC1() {
        return PC1;
    }

    /**
     * Returns the <i>Permuted Choice 2</i> table.
     * 
     * @return The <i>Permuted Choice 2</i> table
     */
    public int[] getPC2() {
        return PC2;
    }

    /**
     * Returns the bit shift rotations which are done on each round.
     * 
     * @return The number of bit shift rotations
     */
    public int[] getBitShifts() {
        return BIT_SHIFTS;
    }

    /**
     * Returns the <i>Expansion</i> table.
     * 
     * @return The <i>Expansion</i> table
     */
    public int[] getExpansion() {
        return EXPANSION;
    }

    /**
     * Returns the <i>Substitution</i> boxes
     *
     * @return The <i>Substitution</i> boxes
     */
    public int[] getSubstitution() {
        return S;
    }

    /**
     * Returns the <i>Permutation</i> table
     * 
     * @return The <i>Permutation</i> table
     */
    public int[] getP() {
        return P;
    }

    /**
     * Returns the <i>Final Permutation</i> table
     * 
     * @return The <i>Final Permutation</i> table
     */
    public int[] getFP() {
        return FP;
    }
}
