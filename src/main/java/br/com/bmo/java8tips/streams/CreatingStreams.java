package br.com.bmo.java8tips.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CreatingStreams {
    private void testEmptyStreams() {
        Stream<String> empty = Stream.empty();
        System.out.println("Empty Stream: " + empty.count());
    }

    private void createStreamsForValues() {
        // Streams can handle Lists, Maps or Sets
        Stream<String> fruits = Stream.of("orange", "pear", "banana", "mango");
        System.out.println("fruits stream count= " + fruits.count());

        String[] fruits2 = {"apple", "grape", "strawberry"};
        Stream<String> fruits2Stream = Stream.of(fruits2);
        System.out.println("fruits2Stream count= " + fruits2Stream.count());
    }

    private void testRandomValuesStream() {
        // receives a supplier
//        Stream<Double> doubleStream = Stream.generate(Math::random);
//        doubleStream.forEach(System.out::println);

        Stream<Integer> integerStream = Stream.iterate(1, i -> i + 1);
        integerStream.forEach(System.out::println);
    }

    private void testFileStream() {
        System.out.println("Starting printing file content using br.com.bmo.java8tips.streams");
        try {
            Stream<String> linesOnFile = Files.lines(Paths.get("src/main/resources/sample.txt"));
            linesOnFile.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreatingStreams creatingStreams = new CreatingStreams();
        creatingStreams.testEmptyStreams();
        creatingStreams.createStreamsForValues();
//        creatingStreams.testRandomValuesStream();
        creatingStreams.testFileStream();
    }
}
