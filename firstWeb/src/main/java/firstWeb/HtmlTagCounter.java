package firstWeb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagCounter {

    public static void main(String[] args) {
        String filePath = "D:/Batch-1/Batch-1/eclipse/firstWeb/src/main/java/firstWeb/HtmlTagCounter.html"; // Specify the path to your HTML file
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            int lineNumber = 0;

            Map<String, Integer> tagCounts = new HashMap<>();

            while ((line = br.readLine()) != null) {
                lineNumber++;

                Pattern pattern = Pattern.compile("<\\s*([a-zA-Z]+)\\s*");
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String tagName = matcher.group(1);
                    tagCounts.put(tagName, tagCounts.getOrDefault(tagName, 0) + 1);
                    System.out.println("Tag: <" + tagName + "> on line " + lineNumber + " starts at index " +
                            matcher.start() + " and ends at index " + matcher.end());
                }
            }

            br.close();

            System.out.println("\nTag Counts:");
            for (Map.Entry<String, Integer> entry : tagCounts.entrySet()) {
                System.out.println("<" + entry.getKey() + ">: " + entry.getValue() + " opening tags");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
