package br.com.bmo.java8tips.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTwo {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Address address = createNewInstanceWithArguments(Address.class, "rua 1", "199 RC");
        Person p1 = createNewInstanceWithArguments(Person.class, address, "test", 30);
        System.out.println(p1);
    }

    public static <T> T createNewInstanceWithArguments(Class<T> clazz, Object ... args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (constructor.getParameterTypes().length == args.length) {
                return (T) constructor.newInstance(args);
            }
        }
        System.out.println("No constructor was found for given params");
        return null;
    }

    public static class Person {
        private final Address address;
        private final String name;
        private final int age;

        public Person() {
            this.name = "anonymous";
            this.age = 0;
            this.address = null;
        }

        public Person(String name) {
            this.name = name;
            this.age = 0;
            this.address = null;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            this.address = null;
        }

        public Person(Address address, String name, int age) {
            this.address = address;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "address=" + address +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class Address {
        private String street;
        private String numberAndComplement;

        public Address(String street, String numberAndComplement) {
            this.street = street;
            this.numberAndComplement = numberAndComplement;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", numberAndComplement='" + numberAndComplement + '\'' +
                    '}';
        }
    }
}
