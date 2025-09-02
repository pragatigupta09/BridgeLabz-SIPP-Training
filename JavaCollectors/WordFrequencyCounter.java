package JavaCollectors;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        String paragraph = "Sports bring people together. Sports inspire teamwork. Sports create leaders.";

        Pattern pattern = Pattern.compile("[^a-zA-Z ]"); 
        String normalizedText = pattern.matcher(paragraph).replaceAll("").toLowerCase();

        Map<String, Long> wordFrequencies = Arrays.stream(normalizedText.split("\s+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toMap(
                        Function.identity(), 
                        word -> 1L,         
                        Long::sum            
                ));

        System.out.println("Word Frequencies:");
        wordFrequencies.forEach((word, count) ->
                System.out.println(word + " -> " + count)
        );
    }
}