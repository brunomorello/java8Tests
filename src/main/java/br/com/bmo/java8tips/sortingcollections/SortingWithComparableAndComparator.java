package br.com.bmo.java8tips.sortingcollections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingWithComparableAndComparator {
    public static void main(String[] args) {
        List<Book1> listOfBooks1 = Arrays.asList(new Book1("test1", 12),
                new Book1("test13", 32),
                new Book1("test28", 10));

        Collections.sort(listOfBooks1);
        System.out.println(listOfBooks1);

        System.out.println("\nSorting using Comparator");

        List<Book2> listOfBooks2 = Arrays.asList(new Book2("test1", 12),
                new Book2("test13", 32),
                new Book2("test13", 12),
                new Book2("test28", 10));

        Collections.sort(listOfBooks2, new Book2Comparator().reversed());
        System.out.println(listOfBooks2);

        System.out.println("\nSorting using Lambda");

        Collections.sort(listOfBooks2, Comparator.comparing(Book2::getName)
                .thenComparing(Book2::getPages).reversed());
        System.out.println(listOfBooks2);
    }
}

class Book1 implements Comparable<Book1> {
    private String name;
    private int pages;

    public Book1(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book1{" +
                "name='" + name + '\'' +
                ", pages=" + pages +
                '}';
    }

    @Override
    public int compareTo(Book1 otherBook) {
        return name.compareTo(otherBook.getName());
//        return Integer.compare(pages, otherBook.getPages());
    }
}

class Book2 {
    private String name;
    private int pages;

    public Book2(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book2{" +
                "name='" + name + '\'' +
                ", pages=" + pages +
                '}';
    }
}

// Elegant solution and using SOLID
class Book2Comparator implements Comparator<Book2> {

    @Override
    public int compare(Book2 o1, Book2 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
