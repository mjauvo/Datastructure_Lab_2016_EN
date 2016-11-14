package Datastructure_lab_2016.util;

/**
 * A utility class for displaying messages.
 * 
 * @author Markus J. Auvo 2016
 */
public class MessageTool
{
    /**
     * Displays the specified message.
     * 
     * @param i The message number.
     */
    public void display(int i) {
        switch(i) {

            default:
                break;

            // PROCEDURE MESSAGES

            case 11:
                System.out.println("\nENCRYPTION PROCEDURE STARTED"); break;
            case 12:
                System.out.println("ENCRYPTION PROCEDURE COMPLETE\n"); break;
            case 21:
                System.out.println("\nDECRYPTION PROCEDURE STARTED"); break;
            case 22:
                System.out.println("DECRYPTION PROCEDURE COMPLETE\n"); break;

            // TASK MESSAGES

            case 41:
                System.out.print("\t--Reading from plain image file..."); break;
            case 42:
                System.out.print("\t--Writing to encrypted image file..."); break;
            case 61:
                System.out.print("\t--Reading from encrypted image file..."); break;
            case 62:
                System.out.print("\t--Writing to decrypted image file..."); break;

            // COMPLETION MESSAGES

            case 89:
                System.out.println("FAILED"); break;
            case 99:
                System.out.println("OK"); break;
        }
    }
}
