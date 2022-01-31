package br.com.bmo.java8tips.streams;

import br.com.bmo.java8tips.model.Employee;
import br.com.bmo.java8tips.model.EmployeeUtils;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StreamsTest {
    List<Employee> employees = EmployeeUtils.createEmployeesFaker(5);

    @Test
    void testCountMustBeEquals() {
        assertEquals(5, employees.size(), "Must be equals");
    }

    @Test
    void testCountWithLambdaAndMockito() {
        List<String> list = mock(List.class);
        when(list.size()).thenAnswer(invocation -> 5);

        assertEquals(5, list.size());
    }

    @Test
    void testPeek() {
        System.out.println(employees);
        Set<String> employeesSet = employees.stream()
                .filter(Employee::isHighSalary)
                .peek(System.out::println)
                .map(Employee::getName)
                .peek(System.out::println)
                .collect(Collectors.toSet());

        System.out.println(employeesSet);
        assertNotNull(employeesSet);
    }

    @Test
    void testSort() {
        employees.sort(Comparator.comparingDouble(Employee::getSalary));

        employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .ifPresent(value -> System.out.printf("Employees Salary average is %f", value));
    }
}
