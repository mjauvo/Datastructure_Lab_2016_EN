package Datastructure_lab_2016.util;

/**
 * A utility class for handling strings.
 * <p>
 * @author Markus J. Auvo 2016
 */
public class StringTool
{
    private String encFile;
    private String decFile;

    /**
     * Returns a string where a certain substring has been replaced with another substring.
     * 
     * @param oldString The string to be processed
     * @param oldSubstring The substring to be replaced
     * @param newSubstring The new substring
     * @return The string with a new substring
     */
    public String getNewString(String oldString, String oldSubstring, String newSubstring) {
        String newString = null;
        if (oldString.contains(oldSubstring)) {
            newString = oldString.replace(oldSubstring, newSubstring);
        }
        return newString;
    }

    /**
     * Returns the name of the encrypted file.
     * The name is generated from the original file name.
     * 
     * @param originalName The original file name
     * @param method The chosen DES implementation
     * @return The name of the encrypted file
     */
    public String getEncFileName(String originalName, String method) {
        // Name already exists, change only method
        if (originalName.contains("JavaWay")) {
            originalName = getNewString(originalName, "JavaWay", "MyWay");
        }
        else if (originalName.contains("MyWay")) {
            originalName = getNewString(originalName, "MyWay", "JavaWay");
        }
        // Name does not exist, so create the name
        else {
            encFile = getNewString(originalName, "ORIGINAL", "ENCRYPTED");
            if (method.equals("JavaDES")) {
                encFile = getNewString(encFile, ".jpg", ".JavaWay.jpg");
            }
            else if (method.equals("MyDES")) {
                encFile = getNewString(encFile, ".jpg", ".MyWay.jpg");
            }
        }
        return encFile;
    }

    /**
     * Returns the name of the decrypted file.
     * The name is generated from the original file name.
     * 
     * @param originalName The original file name
     * @param method The chosen DES implementation
     * @return The name of the decrypted file
     */
    public String getDecFileName(String originalName, String method) {
        // Name already exists, change only method
        if (originalName.contains("JavaWay") || originalName.contains("MyWay")) {
            if (originalName.contains("JavaWay")) {
                originalName = getNewString(originalName, "JavaWay", "MyWay");
            }
            else if (originalName.contains("MyWay")) {
                originalName = getNewString(originalName, "MyWay", "JavaWay");
            }
        }
        // Name does not exist, create name
        else {
            decFile = getNewString(originalName, "ORIGINAL", "DECRYPTED");
            if (method.equals("JavaDES")) {
                decFile = getNewString(decFile, ".jpg", ".JavaWay.jpg");
            }
            else if (method.equals("MyDES")) {
                decFile = getNewString(decFile, ".jpg", ".MyWay.jpg");
            }
        }
        return decFile;
    }
}
