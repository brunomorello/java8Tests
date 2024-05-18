package br.com.bmo.java8tips.streams;

import br.com.bmo.java8tips.model.Employee;
import br.com.bmo.java8tips.model.EmployeeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CommonOperations {
    List<Employee> employees = EmployeeUtils.createEmployeesFaker(4);

    private void testFiltering() {
        employees.stream()
                .filter(Employee::isHighSalary)
                .filter(employee -> employee.getName().length() > 15)
                .forEach(System.out::println);
    }

    private void testMapping() {
        employees.stream()
                .filter(Employee::isHighSalary)
                .map(Employee::getName)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private void testCollecting() {
        List<Employee> employeeList = employees.stream().collect(Collectors.toList());

        Stream.of(
                new Employee("123", "123", 3000.0, "Brazil"),
                new Employee("123", "123", 3000.0, "Brazil"),
                new Employee("123", "123", 3000.1, "Brazil")
        ).collect(Collectors.toSet())
                .forEach(System.out::println);

        employeeList.stream()
                .collect(Collectors.toMap(Employee::getName, employee -> employee))
                .forEach((s, employee) -> System.out.println("key: " + s + " value:" + employee));
    }

    private void testDistinct() {
        Stream.of(
                new Employee("123", "123", 3000.0, "Brazil"),
                new Employee("123", "123", 3000.0, "Brazil"),
                new Employee("123", "123", 3000.1, "Brazil")
        )
                .distinct()
                .forEach(System.out::println);
    }

    private void testLimit() {
        Stream.of(
                        new Employee("333", "333", 3000.0, "Brazil"),
                        new Employee("123", "123", 3000.0, "Brazil"),
                        new Employee("123", "123", 3000.0, "Brazil"),
                        new Employee("123", "123", 3000.1, "Brazil")
                )
                .limit(2)
                .forEach(System.out::println);
    }

    private void testSkip() {
        Stream.of(
                        new Employee("333", "333", 3000.0, "Brazil"),
                        new Employee("123", "123", 3000.0, "Brazil"),
                        new Employee("123", "123", 3000.0, "Brazil"),
                        new Employee("123", "123", 3000.1, "Brazil")
                )
                .skip(1)
                .forEach(System.out::println);
    }

    private void testMatch() {
        Optional<Employee> first = employees.stream()
                .filter(Employee::isHighSalary)
                .findFirst();
        System.out.println("findFirst: " + first);

        Optional<Employee> any = employees.stream()
                .filter(Employee::isHighSalary)
                .findAny();
        System.out.println("findAny: " + any);

        boolean existsEmployeesWithNameStartingWithA = employees.stream()
                .anyMatch(employee -> employee.getName().startsWith("A"));
        System.out.println("existsEmployeesWithNameStartingWithA: " + existsEmployeesWithNameStartingWithA);

        boolean allEmployeesNameStartsWithB = employees.stream()
                .allMatch(employee -> employee.getName().startsWith("B"));
        System.out.println("allEmployeesNameStartsWithB: " + allEmployeesNameStartsWithB);

        System.out.println("starting thereAreHighSalariesOnStream....");
        System.out.println(employees);
        boolean thereAreHighSalariesOnStream = employees.stream()
                .noneMatch(Employee::isHighSalary);
        System.out.println("thereAreHighSalariesOnStream? " + thereAreHighSalariesOnStream);
    }

    private void testReducing() {
        System.out.println("concatenating...");
        Optional<String> allSalaries = employees.stream()
                .map(Employee::getSalary)
                .map(String::valueOf)
                .reduce((s, s2) -> s + " + " + s2);
        System.out.println("Concatenated salaries: " + allSalaries);

        System.out.println("sum all salaries...");
        Optional<Double> totalSalaries = employees.stream()
                .map(Employee::getSalary)
                .reduce((aDouble, aDouble2) -> aDouble + aDouble2);
        System.out.println("sum of all salaries is " + totalSalaries);

        List<Integer> totalEmployeesByCountry = Arrays.asList(5, 10, 20);
        Integer totalOfEmployees = totalEmployeesByCountry.stream()
                .reduce(0, (integer, integer2) -> integer + integer2);
        System.out.println("World Wide total of Employees: " + totalOfEmployees);
    }

    public static void main(String[] args) {
        System.out.println("testFiltering...");
        new CommonOperations().testFiltering();

        System.out.println("testMapping...");
        new CommonOperations().testMapping();

        System.out.println("testCollecting...");
        new CommonOperations().testCollecting();

        System.out.println("testDistinct...");
        new CommonOperations().testDistinct();

        System.out.println("testLimit...");
        new CommonOperations().testLimit();

        System.out.println("testSkip...");
        new CommonOperations().testSkip();

        System.out.println("testMatch...");
        new CommonOperations().testMatch();

        System.out.println("testReducing...");
        new CommonOperations().testReducing();

        IntStream.range(0,10)
                .filter(x -> x % 2 == 0)
                .forEach(x -> System.out.print(x + " "));
    }
}
