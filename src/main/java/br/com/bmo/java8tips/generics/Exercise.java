package br.com.bmo.java8tips.generics;

import java.util.*;
public class Exercise {
    public void runExercise() {
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

class Library<T extends Algorithm> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library<?> library = (Library<?>) o;
        return Objects.equals(algorithms, library.algorithms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(algorithms);
    }
}