package edu.uiowa.mc.hw1;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        //long start = System.currentTimeMillis();
        //this
        //FIXME 2 ARGS input and output files..

        final int LONG_AMOUNT = 100000;

        DatasetGenerator.generateArray(LONG_AMOUNT);

        long[] testArray = DataLoader.getArray(LONG_AMOUNT);

        System.out.println("INITIAL ARRAY: ");
        System.out.println(testArray);
        long start = System.currentTimeMillis();

        MergeSort.multiThreadSort(testArray);

        System.out.println("\nSORTED ARRAY: ");
        System.out.println(testArray);

        System.out.println("\n" + (System.currentTimeMillis() - start) + " ms");  // KEEP TIME


    }
}