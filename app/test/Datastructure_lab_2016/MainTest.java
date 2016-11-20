package Datastructure_lab_2016;

import Datastructure_lab_2016.algo.*;
import Datastructure_lab_2016.util.*;

/**
 * Application's main test class which runs all
 * the application's tests in one run. This is
 * where you add and implement unit tests.
 *
 * @author Markus J. Auvo 2016
 */
public class MainTest {
    private static final JavaDESTest JDT = new JavaDESTest();
    private static final FileToolTest FTT = new FileToolTest();
    private static final ArrayToolTest ATT = new ArrayToolTest();
    private static final ByteBitToolTest BBTT = new ByteBitToolTest();

    public static void main(String[] args) throws Exception {
        JDT.classInstantiationTests();
        FTT.classInstanceTests();
        FTT.primitiveVariableTests();
        ATT.integerArrayTests();
        ATT.integerArrayElementTests();
        BBTT.ByteBitTests();
    }
}
