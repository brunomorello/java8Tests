package br.com.bmo.java8tips.streams.advanced;

import com.github.javafaker.Faker;
import br.com.bmo.java8tips.model.Employee;
import br.com.bmo.java8tips.model.EmployeeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

    private void testFlatMap() {
        Faker faker = new Faker();
        List<Employee> employees = EmployeeUtils.createEmployeesFaker(10).stream()
                .map(employee -> {
                    employee.setFavoriteFood(Arrays.asList(faker.food().vegetable(), faker.food().dish()));
                    return employee;
                })
                .collect(Collectors.toList());

        Stream<String> employeesFavoriteFood = employees.stream().flatMap(employee -> employee.getFavoriteFood().stream());
        employeesFavoriteFood.forEach(System.out::println);
    }

    private void testFlatMapFruitsAndVeggies() {
        String[] fruits = new String[] {"apple", "orange", "mango", "strawberry", "banana"};
        String[] veggies = new String[] {"carrot", "potato", "lettuce", "eggplant", "onion", "garlic"};

        Stream<List<String>> listStream = Stream.of(Arrays.asList(fruits), Arrays.asList(veggies));
        listStream.flatMap(s -> s.stream())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("testFlatMap...");
        new FlatMap().testFlatMap();

        System.out.println("testFlatMapFruitsAndVeggies...");
        new FlatMap().testFlatMapFruitsAndVeggies();
    }
}
