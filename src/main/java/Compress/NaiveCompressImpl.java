package Compress;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NaiveCompressImpl implements Compressor {


    @Override
    public String compress(String input) {

        return Arrays.stream(input.split(" ")).map(
                word -> word.substring(0, 1).toUpperCase()
                        + word.substring(1).toLowerCase()).collect(Collectors.joining(""));
    }

    @Override
    public String uncompress(String input) {
        return Arrays.stream(input.split(" (?=\\p{Lu})"))
                .map(String::toLowerCase)
                .collect(Collectors.joining(" "));

    }
}

