package template.file;

import static template.constant.Constants.COMMA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    protected Reader() {
    }

    public static void readXXX() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("......."))) {
            skipHeader(reader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(COMMA);

            }
        }
    }

    private static void skipHeader(BufferedReader reader) throws IOException {
        reader.readLine();
    }
}
