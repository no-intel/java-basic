package java_adv2.io.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java_adv2.io.text.TextConst.FILE_NAME;

public class ReaderWriterMainV1 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        byte[] writeBytes = writeString.getBytes(UTF_8);
        System.out.println("write string = " + writeString);
        System.out.println("write bytes = " + Arrays.toString(writeBytes));

        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        fos.write(writeBytes);
        fos.close();

        FileInputStream fis = new FileInputStream(FILE_NAME);
        byte[] bytes = fis.readAllBytes();
        fis.close();
        String readString = new String(bytes, UTF_8);
        System.out.println("read bytes = " + Arrays.toString(bytes));
        System.out.println("read string = " + readString);
    }
}
