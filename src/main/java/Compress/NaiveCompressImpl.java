package Compress;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NaiveCompressImpl implements Compressor {
    @Override
    public String compress(String input) {
        if (input == null || input.isEmpty())
            return "";

        Arrays.stream(input.split(" ")).map(
                word -> word.substring(0,1).toUpperCase()+
                        word.substring(1).toLowerCase())
                .collect(Collectors.joining(""));


        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase());
            sb.append(word.substring(1).toLowerCase());

        }


        return sb.toString();
    }

    @Override
    public String uncompress(String input) {
        if (input == null || input.isEmpty())
            return "";
        String[] words = input.split("(?=\\p{Lu})");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.toLowerCase());
            sb.append(" ");
        }
        return sb.toString().trim();    // trim usuwa spację
    }

}
