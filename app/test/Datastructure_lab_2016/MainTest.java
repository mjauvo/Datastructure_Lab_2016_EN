package Datastructure_lab_2016;

import Datastructure_lab_2016.algo.*;
import Datastructure_lab_2016.util.*;

/**
 *
 * @author mjauv
 */
public class MainTest {
    private static final JavaDESTest JDT = new JavaDESTest();
    private static final FileToolTest FTT = new FileToolTest();

    public static void main(String[] args) throws Exception {
        JDT.classInstantiationTests();
        FTT.classInstanceTests();
        FTT.primitiveVariableTests();
    }
}
