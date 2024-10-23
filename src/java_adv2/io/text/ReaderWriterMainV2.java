package java_adv2.io.text;

import java.io.*;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java_adv2.io.text.TextConst.FILE_NAME;

public class ReaderWriterMainV2 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("write string = " + writeString);

        byte[] writeBytes = writeString.getBytes(UTF_8);
        System.out.println("write bytes = " + Arrays.toString(writeBytes));

        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8);
        osw.write(writeString);
        osw.close();

        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, UTF_8);

        StringBuffer content = new StringBuffer();
        int ch;
        while ((ch = isr.read()) != -1) {
            content.append((char) ch);
        }
        isr.close();

        System.out.println("read string = " + content);
    }
}
