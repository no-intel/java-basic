package java_adv2.io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java_adv2.io.text.TextConst.FILE_NAME;

public class ReaderWriterMainV3 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("write string = " + writeString);

        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        fw.write(writeString);
        fw.close();

        FileReader fr = new FileReader(FILE_NAME, UTF_8);

        StringBuilder content = new StringBuilder();
        int ch;
        while ((ch = fr.read()) != -1) {
            content.append((char) ch);
        }
        fr.close();
        System.out.println("read string = " + content);
    }
}
