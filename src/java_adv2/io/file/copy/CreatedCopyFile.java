package java_adv2.io.file.copy;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreatedCopyFile {

    private static final int FILE_SIZE = 200 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        String fileName = "temp/copy.dat";
        long startTime = System.currentTimeMillis();

        FileOutputStream fos = new FileOutputStream(fileName);
        byte[] buffer = new byte[FILE_SIZE];
        fos.write(buffer);
        fos.close();

        long endTime = System.currentTimeMillis();

        System.out.println("FILE created: " + fileName);
        System.out.println("FILE created: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
