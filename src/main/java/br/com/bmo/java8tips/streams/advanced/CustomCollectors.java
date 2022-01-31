package br.com.bmo.java8tips.streams.advanced;

import br.com.bmo.java8tips.model.Employee;
import br.com.bmo.java8tips.model.EmployeeUtils;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CustomCollectors {
    List<Employee> employees = EmployeeUtils.createEmployeesFaker(5);

    private void testCustomCollector() {
        Supplier<StringBuilder> supplier = StringBuilder::new;

        BiConsumer<StringBuilder, Employee> accumulator =
                (stringBuilder, employee) -> stringBuilder.append(employee.getName()).append(",");

        BiConsumer<StringBuilder, StringBuilder> combiner =
                (s1, s2) -> s1.append(s2.toString());

        StringBuilder result = employees.stream().collect(supplier, accumulator, combiner);

        System.out.println(result);
    }

    private void testStats() {
        DoubleSummaryStatistics salaryStats = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(salaryStats);
    }

    public static void main(String[] args) {
        System.out.println("testCustomCollector...");
        new CustomCollectors().testCustomCollector();

        System.out.println("testStats...");
        new CustomCollectors().testStats();
    }
}
