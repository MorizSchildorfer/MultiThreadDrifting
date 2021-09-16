package common;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.EOFException;

public class DataLoader {
    private static List<Long> longs;

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("array.bin");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            longs = new ArrayList<Long>();

            try {
                while (true) {
                    long currentLong = dataInputStream.readLong();
                    longs.add(currentLong);
                }
            } catch (EOFException exception) {
                fileInputStream.close();
            }
        } catch (IOException exception) {
            System.err.println(exception);
        }
    }

    public static List<Long> getLongs() {
        return longs;
    }
}