package br.com.bmo.java8tips.interviews;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QntStringAsSubstringInWord {
    public static int numOfStrings(String[] patterns, String word) {
        return Stream.of(patterns)
                .parallel()
                .filter(p -> word.contains(p))
                .collect(Collectors.toList())
                .size();
//        return (int) count;
    }
}
