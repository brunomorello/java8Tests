package br.com.bmo.java8tips.optionals;

import br.com.bmo.java8tips.model.Employee;
import br.com.bmo.java8tips.model.EmployeeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Optionals {
    private void testIfPresent() {
        List<Integer> integers = Arrays.asList(5, 5, 3);
        Optional<Integer> total = integers.stream().reduce((integer, integer2) -> integer + integer2);

        if (total.isPresent())
            System.out.println(total.get());
    }

    private void testIfElse() {
        Employee emp1 = null;
        Employee emp2 = EmployeeUtils.employeeSupplier().get();

        Optional<Employee> empOpt = Optional.ofNullable(emp1);
        empOpt.ifPresent(System.out::println);

        String name = empOpt.orElse(emp2).getName();
        System.out.println("Employee name= " + name);
    }

    private void orElseThrow() throws Exception {
        Employee employee = null;
        Optional<Employee> employeeOptional = Optional.of(employee);
        employeeOptional.orElseThrow(Exception::new);
    }

    private void testFilterMap() {
        Optional<Employee> employee = Optional.of(EmployeeUtils.employeeSupplier().get());

        employee.filter(Employee::isHighSalary)
                .ifPresent(System.out::println);

        employee
                .filter(e -> e.getName().length() > 10)
                .map(e -> e.getName())
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("testIfPresent...");
        new Optionals().testIfPresent();

        System.out.println("testIfElse...");
        new Optionals().testIfElse();

        System.out.println("orElseThrow...");
        try {
            new Optionals().orElseThrow();
        } catch (Exception e) {
            System.out.println("orElseThrow... " + e);
        }

        System.out.println("testFilterMap...");
        new Optionals().testFilterMap();
    }
}
