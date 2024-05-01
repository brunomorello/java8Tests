package br.com.bmo.java8tips.generics;

import java.util.*;
public class Exercise {
    public void runExercise() {

        // you have to implement the other classes such that the following code can run without any error

        Library<Algorithm> library = new Library<>();
        library.add(new SearchAlgorithm());
        library.add(new SortingAlgorithm());
        library.add(new GraphAlgorithm());

        Algorithm item = library.getLast();

        while(item!=null) {
            item.execute();
            item = library.getLast();
        }
    }
}

interface Algorithm {
    void execute();
}

class SearchAlgorithm implements Algorithm {

    @Override
    public void execute() {
        System.out.println("executing SearchAlgorithm");
    }
}

class SortingAlgorithm implements Algorithm {

    @Override
    public void execute() {
        System.out.println("executing SortingAlgorithm");
    }

}

class GraphAlgorithm implements Algorithm {

    @Override
    public void execute() {
        System.out.println("executing GraphAlgorithm");
    }
}

class Library<T> {

    List<T> algorithms;

    public Library() {
        this.algorithms = new ArrayList<>();
    }

    public void add(T algorithm) {
        this.algorithms.add(algorithm);
    }

    public T getLast() {
        if (algorithms.isEmpty()) {
            return null;
        }
        return algorithms.remove(algorithms.size() -1);
    }
}