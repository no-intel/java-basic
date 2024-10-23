package java_adv2.io.text;

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java_adv2.io.text.TextConst.FILE_NAME;

public class ReaderWriterMainV4 {
    private static final int BUFFER_SIZE = 81922;

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("== Write string == ");
        System.out.println(writeString);

        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        FileReader fr = new FileReader(FILE_NAME, UTF_8);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        StringBuilder content = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            content.append(line).append("\n");
        }
        br.close();
        System.out.println("== Read String ==");
        System.out.println(content);
    }
}
