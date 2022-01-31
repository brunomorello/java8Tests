package br.com.bmo.java8tips.model;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class EmployeeUtils {

    private static final int MAX_SALARY = 16000;
    private static final int MIN_SALARY = 1000;
    private static final int MAX_NUMBER_OF_DECIMALS_SALARY = 2;
    private static Faker faker = new Faker();

    public static DoublePredicate hasHighSalary = value -> value > 15000 ? true : false;

    public static List<Employee> createEmployees() {
        Employee e1 = new Employee("123", "Fulano", 1000.0, "Brazil");
        Manager e2 = new Manager("EXEC123", "Fulano Executive", 10000000.0, "Brazil");
        Employee e3 = new Employee("3322", "Ciclano", 10000.0, "Brazil");
        e1.setManager(e2);
        e2.setManager(e2);
        e3.setManager(e2);
        e2.setAssistant(e3);
        return Arrays.asList(e1, e2, e3);
    }

    public static List<Employee> createEmployeesFaker(int quantity) {
        List<Employee> employees = new ArrayList<>();
        List<Manager> managers = generateRandomManagersList();

        Function<Employee, Employee> randomManager = employee -> {
            Manager manager = managers.get(faker.random().nextInt(0, managers.size() - 1));
            employee.setManager(manager);
            return employee;
        };

        for (int i = 0; i < quantity; i++) {
            employees.add(employeeSupplier().get());
        }

        return employees.stream()
                .map(randomManager)
                .collect(Collectors.toList());
    }

    private static List<Manager> generateRandomManagersList() {
        List<Manager> managers = Arrays.asList(
                managerSupplier().get(),
                managerSupplier().get(),
                managerSupplier().get()
        );

        BiFunction<Manager, Manager, Manager> applyMasterManager = (manager, masterManager) -> {
            manager.setManager(masterManager);
            return manager;
        };

        return managers.stream()
                .map(manager -> applyMasterManager.apply(manager, managers.get(0)))
                .collect(Collectors.toList());

    }

    public static Supplier<Employee> employeeSupplier() {
        return () -> new Employee(String.valueOf(faker.number().randomDigit()),
                faker.name().fullName(),
                faker.number().randomDouble(MAX_NUMBER_OF_DECIMALS_SALARY, MIN_SALARY, MAX_SALARY),
                faker.country().name());
    }

    public static Supplier<Manager> managerSupplier() {
        return () -> new Manager(String.valueOf(faker.number().randomDigit()),
                faker.name().fullName(),
                faker.number().randomDouble(MAX_NUMBER_OF_DECIMALS_SALARY, MIN_SALARY, MAX_SALARY),
                faker.country().name());
    }

}
