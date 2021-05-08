package rumaria.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLineUsingBufferedReader {

    public static void main(String[] args) {
        // the path of the root folder of this project
        System.out.println("ini loh");
        System.out.println(System.getProperty("user.dir"));
        String filePath = System.getProperty("user.dir") + "\\text-input.txt";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
