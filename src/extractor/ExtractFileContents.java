package extractor;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

public class ExtractFileContents {

    private ArrayList<String> words;

    public ExtractFileContents(String path){
        words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getWords() {
        return words;
    }
}
