package br.com.bmo.java8tips.generics;

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

    public static <T extends Comparable> int countGreaterItems(T[] items, T item) {
        int count = 0;
        for (T auxItem : items) {
            if (auxItem.compareTo(item) > 0) {
                count++;
            }
        }
        return count;
    }
}

class Person implements Comparable<Person> {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(age, o.age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
