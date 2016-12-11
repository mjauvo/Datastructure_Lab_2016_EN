package Datastructure_lab_2016.util;

/**
 * A utility class for displaying messages.
 * <p>
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
        String message = "";

        switch(i) {

            // PROCEDURE MESSAGES
            case 11:
                message = "\nENCRYPTION PROCEDURE STARTED\n";
                break;
            case 12:
                message = "ENCRYPTION PROCEDURE COMPLETE\n";
                break;
            case 21:
                message = "\nDECRYPTION PROCEDURE STARTED\n";
                break;
            case 22:
                message = "DECRYPTION PROCEDURE COMPLETE\n";
                break;

            // TASK MESSAGES
            case 41:
                message = "\t--Reading from file...";
                break;
            case 42:
                message = "\t--Writing to file...";
                break;

            // COMPLETION MESSAGES
            case 89:
                message = "FAILED\n";
                break;
            case 99:
                message = "OK\n";
                break;
        }
        System.out.print(message);
    }
}
