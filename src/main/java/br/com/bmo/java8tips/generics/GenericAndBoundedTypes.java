package br.com.bmo.java8tips.generics;

import java.util.List;

public class GenericAndBoundedTypes {

    public static void main(String[] args) {
        System.out.println("calculateMin=" + calculateMin(5, 3));
        System.out.println("calculateMin=" + calculateMin("John", "Bruno"));
        System.out.println("calculateMin(Person)=" + calculateMin(new Person(32, "Bruno"), new Person(5, "Izzy")));
    }
    public static <T extends Comparable<T>> T calculateMin(T val1, T val2) {
        return val1.compareTo(val2) < 0 ?
            val1 : val2;
    }

    public static <T extends Number> double add(T val1, T val2) {
        return val1.doubleValue() + val2.doubleValue();
    }

    public static <T extends Comparable> int countGreaterItems(T item, T... items) {
        int count = 0;
        for (T auxItem : items) {
            if (auxItem.compareTo(item) > 0) {
                count++;
            }
        }
        return count;
    }

    // Bounded Type Param to handle both lower and upper bounds
    public static <T> void copy(List<? extends T> source, List<? super T> destination) {
        for (T sourceItem : source) {
            destination.add(sourceItem);
        }
    }

    // Upper bounded wildcard example
    public static double sumAll(List<? extends Number> sourceList) {
        double sum = 0;
        for (Number n : sourceList) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // Lower bounded wildcard example
    public static void showAll(List<? super Number> sourceList) {
        for (Object item : sourceList) {
            System.out.println(item);
        }
    }
}
