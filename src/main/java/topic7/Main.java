package topic7;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.RegExUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) {
        getUniqueWords("src/main/java/topic7/frankenstein_text.txt", "src/main/java/topic7/output.txt");
    }

    public static void getUniqueWords(String inFile, String outFile) {
        try {
            HashMap<String, Integer> wordMap = new HashMap<>();
            populateWordMap(inFile, wordMap);
            writeSortedWords(outFile, wordMap);
        } catch (IOException e) {
            System.out.println("An error occurred with IO: " + e.getMessage());
        }
    }

    public static void populateWordMap(String inFile, HashMap<String, Integer> wordMap) throws IOException {
        for (String line : FileUtils.readLines(new File(inFile), "UTF-8")) {
            String[] words = StringUtils.split(line);
            for (String word : words) {
                word = RegExUtils.replaceAll(word, "[^a-zA-Z]", "").toLowerCase();
                wordMap.merge(word, 1, Integer::sum);
            }
        }
    }

    public static void writeSortedWords(String outFile, HashMap<String, Integer> wordMap) throws IOException {
        List<Map.Entry<String, Integer> > list =
                new LinkedList<>(wordMap.entrySet());

        list.sort(reverseOrder(Map.Entry.comparingByValue()));

        for (Map.Entry<String, Integer> entry : list) {
            FileUtils.writeStringToFile(new File(outFile), entry.getKey() + " " + entry.getValue() + "\n", "UTF-8", true);
        }
    }
}