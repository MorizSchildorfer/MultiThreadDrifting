package edu.uiowa.mc.hw1;

import java.io.*;

public class DataLoader {

    public static long[] getArray(int N) throws IOException {
        //FileInputStream fis = new FileInputStream("array.bin");
        FileInputStream fis = new FileInputStream("100000_ALL_SAME.bin");
        DataInputStream dis = new DataInputStream(fis);

        long[] arr = new long[N];

        try {
            int index = 0;
            while (true) {
                long l = dis.readLong();
                arr[index] = l;
                index += 1;
            }
        } catch (EOFException e) {
            fis.close();
        }
    return(arr);
    }
}
