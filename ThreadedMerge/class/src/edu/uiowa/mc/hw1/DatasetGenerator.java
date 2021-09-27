package edu.uiowa.mc.hw1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class DatasetGenerator {

    public static void generateArray(int N) throws IOException {

        long batch[] = new long[N];
        Random r = new Random();
        for (int i = 0; i < batch.length; i++) {
            batch[i] = r.nextLong();
        }

        System.out.println(batch + " <- array created");


        FileOutputStream fos = new FileOutputStream("array.bin");
        DataOutputStream dos = new DataOutputStream(fos);

        for (int i = 0; i < batch.length; i++) {
            dos.writeLong(batch[i]);
        }
        dos.close();
        fos.close();
    }

}
