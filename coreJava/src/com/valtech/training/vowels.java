package com.valtech.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class vowels {

    public static void main(String[] args) {
        String sentence = "Hello how are you?";
        String[] words = sentence.split("[\\s.,!?]+");

        List<String> wordList = new ArrayList<>();

        for (String word : words) {
            int maxVowelCount = findMaxVowelCount(word);
            wordList.add(word + ": " + maxVowelCount + " vowels");
        }

        Collections.sort(wordList, Comparator.comparingInt(s -> Integer.parseInt(s.split(":")[1].trim().split(" ")[0])));
        
        Collections.reverse(wordList);

        for (String word : wordList) {
            System.out.println(word);
        }
    }

    public static int findMaxVowelCount(String word) {
        int maxVowelCount = 0;
        int currentVowelCount = 0;

        for (char ch : word.toLowerCase().toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                currentVowelCount++;
            } else {
                maxVowelCount = Math.max(maxVowelCount, currentVowelCount);
                currentVowelCount = 0;
            }
        }

        maxVowelCount = Math.max(maxVowelCount, currentVowelCount);
        return maxVowelCount;
    }
}
