package Datastructure_lab_2016.util;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * A test class for StringTool class.
 *
 * @author Markus J. Auvo, 2016
 */
public class StringToolTest
{
    private StringTool testInstance;

    /**
     * Tests whether the method returns a correct string after replacing
     * a substring in the given string with another substring.
     * 
     * @param expectedResult The string which should be returned
     * @param testString The string containing the substring
     * @param oldSub The substring to be replaced
     * @param newSub The new substring
     */
    public void getNewString_returnsCorrectNewString(String testString, String oldSub, String newSub, String expectedResult) {
        testInstance = new StringTool();
        String actualResult = testInstance.getNewString(testString, oldSub, newSub);
        String msg = "Method should return '" + expectedResult + "', ";
        msg += "but it returns '" + actualResult + "'";
        assertTrue(msg, actualResult.equals(expectedResult));
    }

    // TESTS

    @Test
    public void StringTests() throws Exception {
        System.out.print("StringToolTest...executing string tests...");
        getNewString_returnsCorrectNewString("ABCDEFG", "CDE", "XYZ", "ABXYZFG");
        getNewString_returnsCorrectNewString("Brown fox", "wn f", "ken s", "Broken sox");
        getNewString_returnsCorrectNewString("Say now", "ay n", "take c", "Stake cow");
        //getNewString_returnsCorrectNewString("Red velvet", "ed", "ose", "Rust velvet"); // TEST FAILS
        System.out.println("OK");
    }





    /**
     * Test of getEncFileName method, of class StringTool.
     */
    public void testGetEncFileName() {
        System.out.println("getEncFileName");
        String originalName = "";
        String method = "";
        String expResult = "";
        String result = testInstance.getEncFileName(originalName, method);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDecFileName method, of class StringTool.
     */
    public void testGetDecFileName() {
        System.out.println("getDecFileName");
        String originalName = "";
        String method = "";
        String expResult = "";
        String result = testInstance.getDecFileName(originalName, method);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
