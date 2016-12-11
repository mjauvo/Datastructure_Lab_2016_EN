package Datastructure_lab_2016.util;

import java.io.*;

/**
 * A utility class for handling bytes and bits.
 * <p>
 * @author Markus J. Auvo 2016
 */
public class ByteBitTool
{
    // Instance variables
    private final FileTool FT;
    private final ArrayTool AT;

    // Pimitive variables
    private int length;

    /**
     * Constructor
     */
    public ByteBitTool() {
        FT = new FileTool();
        AT = new ArrayTool();
    }

    /**
     * Returns the cipher key as a byte array.
     * 
     * @param key The original key
     * @return The byte array
     * @throws java.lang.Exception
     */
    public byte[] getKeyBytes(String key) throws Exception {
        return key.getBytes();
    }

    /**
     * Retrieves the contents of a file into a byte array
     * (with potentially necessary padding).
     * 
     * @param fileName The name of the file to be read from.
     * @return Byte array representation of the file contents.
     * @throws java.lang.Exception 
     */
    public byte[] getFileBytes(String fileName) throws Exception {
        InputStream FIS  = FT.getInputStream(fileName);
        int arrayLength = FT.getFileLength(fileName);
        int paddedArrayLength = arrayLength;

        // If the length of the file is not divisible by 8 bytes, we need to
        // know the amount of padding needed to the end of the byte array.
        if (arrayLength % 8 != 0) {
            paddedArrayLength = arrayLength + getNecessaryPaddingLength(arrayLength);
        }

        // Create an byte array with the length divisible by 8 and
        // with potentially empty elements at the end.
        byte[] fileBytes = new byte[paddedArrayLength];

        // Amount of bytes read from the file input stream;
        // should be equal to file byte length since everthing
        // from the file should be read.
        int bytesRead = FIS.read(fileBytes);

        // Add necessary padding at the end of the byte array
        if (arrayLength % 8 != 0) {
            fileBytes = getPaddedBytes(fileBytes, bytesRead, length);
        }

        return fileBytes;
    }

    /**
     * Stores the contents of a byte array into a file.
     * 
     * @param OutputFile The name of the file to be written into.
     * @param dataBytes The byte array to be written.
     * @throws java.lang.Exception 
     */
    public void setFileBytes(String OutputFile, byte[] dataBytes) throws Exception {
        OutputStream OS = FT.getOutputStream(OutputFile);

        try {
            OS.write(dataBytes);
            OS.flush();
            OS.close();
        }
        catch (IOException e) {
        }
    }

    /**
     * Returns the necessary byte length for padding, *IF* the original message
     * length is greater than zero, but NOT divisible by eight (DES operates
     * on 64-bit i.e. 8-byte blocks).
     * 
     * @param originalLength Original byte length.
     * @return The byte length of necessary padding.
     * @throws java.lang.Exception
     */
    public int getNecessaryPaddingLength(int originalLength) throws Exception {
        if (originalLength > 0 && originalLength % 8 != 0) {
            length = 8 - (originalLength % 8);
        }
        return length;
    }

    /**
     * Pads an byte array with extra characters.
     * 
     * @param dataBytes The byte array to be padded.
     * @param bytesRead The numbers of non-empty elements
     * @param paddingLength The length of the padding.
     * @return 
     * @throws java.lang.Exception
     */
    public byte[] getPaddedBytes(byte[] dataBytes, int bytesRead, int paddingLength) throws Exception {
        int paddingStart = bytesRead;
        int arrayLength = dataBytes.length;

        if (paddingLength > 0) {
            for (int i = 0; i < paddingLength; i++) {
                dataBytes[paddingStart+i] = (byte) 0;
            }
        }
        return dataBytes;
    }

    /**
     * Performs a left shift operation on binary bits
     * 
     * @param input The byte array with movable bits.
     * @param length The length of the bit movement.
     * @param step
     * @return BitSet after shift operation
     * @throws java.lang.Exception
     */
    public byte[] leftShift(byte[] input, int length, int step) throws Exception{
        int numOfBytes = (length-1)/8 + 1;
        byte[] result = new byte[numOfBytes];
        for (int i=0; i<length; i++) {
            int value = getBit(input,(i+step) % length);
            setBit(result,i,value);
        }
        return result;
    }

    /**
     * "Concatenates" two byte arrays into one.
     * 
     * @param A The byte array A to be concatenated.
     * @param lengthA The bit length of A.
     * @param B The byte array B to be concatenated.
     * @param lengthB The bit length of B.
     * @return  The concatenated vector of bits.
     * @throws java.lang.Exception
     */
    public byte[] concatenate(byte[] A, int lengthA, byte[] B, int lengthB) throws Exception {
        int numOfBytes = (lengthA+lengthB-1)/8 + 1;
        byte[] concatenatedBits = new byte[numOfBytes];
        int j = 0;
        for (int i=0; i<lengthA; i++) {
            int value = getBit(A,i);
            setBit(concatenatedBits,j,value);
            j++;
        }
        for (int i=0; i<lengthB; i++) {
            int value = getBit(B,i);
            setBit(concatenatedBits,j,value);
            j++;
        }
        return concatenatedBits;
    }

    /**
     * Retrieves a bit from a byte array and from the given position.
     * 
     * @param dataBytes The byte array
     * @param position The bit position
     * @return 
     * @throws NumberFormatException
     */
    public int getBit(byte[] dataBytes, int position) throws NumberFormatException {
        int positionByte = position/8; 
        int positionBit = position%8;
        byte selectedByte = dataBytes[positionByte];
        int valueInt = selectedByte>>(8-(positionBit+1)) & 0x0001;
        return valueInt;
    }

    /**
     * Sets a bit in a byte array and in the given position.
     * 
     * @param dataBytes The byte array
     * @param position The bit position
     * @param value
     */
    public void setBit(byte[] dataBytes, int position, int value) {
        int positionByte = position/8; 
        int positionBit = position%8;
        byte oldByte = dataBytes[positionByte];
        oldByte = (byte) (((0xFF7F>>positionBit) & oldByte) & 0x00FF);
        byte newByte = (byte) ((value<<(8-(positionBit+1))) | oldByte);
        dataBytes[positionByte] = newByte;
    }

    /**
     * Selects a data portion from a byte array.
     * 
     * @param dataBytes The byte array
     * @param position The start position in the byte array
     * @param length The length of the data
     * @return 
     */
    public byte[] getBits(byte[] dataBytes, int position, int length) {
        int numOfBytes = (length-1)/8 + 1;
        byte[] result = new byte[numOfBytes];
        for (int i=0; i<length; i++) {
            int val = getBit(dataBytes,position+i);
            setBit(result,i,val);
        }
        return result;
    }

    /**
     * Permutates bits according to given permutation table.
     * 
     * @param dataBytes The bytes to be permutated.
     * @param table The permutation table.
     * @return Permutated bits.
     */
    public byte[] permutateBits(byte[] dataBytes, int[] table) {
        int numOfBytes = (table.length-1)/8 + 1;
        byte[] result = new byte[numOfBytes];
        for (int i=0; i<table.length; i++) {
            int val = getBit(dataBytes,table[i]-1);
            setBit(result,i,val);
        }
        return result;
     }

    /**
     * Performs an exclusive-OR operation on elements of two byte arrays.
     * 
     * @param a The first byte array
     * @param b The second byte array
     * @return The resulting byte array
     */
    public byte[] exclusiveOR(byte[] a, byte[] b) {
        byte[] result = new byte[a.length];
        for (int i=0; i<a.length; i++) {
            result[i] = (byte) (a[i] ^ b[i]);
        }
        return result;
    }

    /**
     * Splits a byte array into byte blocks of given length
     * 
     * @param in The byte array which is to be split
     * @param length The length of the blocks
     * @return 
     */
    public byte[] splitBytes(byte[] in, int length) {
        int numOfBytes = (8*in.length-1)/length + 1;
        byte[] result = new byte[numOfBytes];
        for (int i=0; i<numOfBytes; i++) {
            for (int j=0; j<length; j++) {
                int val = getBit(in, length*i+j); 
                setBit(result,8*i+j,val);
            }
        }
        return result;
    }

    /**
     * Performs bit substitution on a byte array according to substitution
     * (S) boxes, thus converting a 6-bit block into a 4-bit block.
     * 
     * @param in The byte array to be substituted
     * @return The resulting byte array
     */
    public byte[] substituteBits(byte[] in) {
        // Split the byte array into 6-bit blocks
        in = splitBytes(in,6);
        byte[] result = new byte[in.length/2];
        int leftHalfByte = 0;
        for (int b=0; b<in.length; b++) {
            byte selectedByte = in[b];
            // Bits 1 and 6
            int R = 2*(selectedByte>>7&0x0001)+(selectedByte>>2&0x0001);
            // Middle 4 bits (bits 2-5)
            int C = selectedByte>>3&0x000F;
            // 4-bit (half byte) result
            int halfByte = AT.getSubstitution()[64*b+16*R+C];
            if (b % 2 == 0)
                leftHalfByte = halfByte; // Left half byte
            else
                result[b/2] = (byte) (16*leftHalfByte + halfByte);
        }
        return result;
    }
}