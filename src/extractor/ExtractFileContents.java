package extractor;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class to extract the contents of a CSV file
 */
public class ExtractFileContents {

    private ArrayList<String> words;

    /**
     * Constructor for Object
     * Must be provided with a string path to the file
     * Stores contents of the file into an ArrayList
     * @param path String path
     */
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

    /**
     * Getter method to get the contents of the file after the Object has been instantiated.
     * @return ArrayList of Strings
     */
    public ArrayList<String> getWords() {
        return words;
    }
}
