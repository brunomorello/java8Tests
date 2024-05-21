package br.com.bmo.java8tips.streams;

import br.com.bmo.java8tips.model.Employee;
import br.com.bmo.java8tips.model.EmployeeUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @Test
    void distinctString() {
        String[] strArray = {"hello", "shell"};
        String distinct = Stream.of(strArray)
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.joining());

        assertEquals("helos", distinct);
    }

    @Test
    void distinctString2() {
        String[] arr = {"d","b","c","b","c","a"};

        Map<String, List<String>> stringListMap = Stream.of(arr)
                .collect(Collectors.groupingBy(String::toString));
        List<String> distinctArr = new ArrayList<>(stringListMap.size());

        for (int i = 0; i < arr.length; i++) {
            if (stringListMap.get(arr[i]).size() == 1) {
                distinctArr.add(arr[i]);
            }
        }
        assertEquals(2, distinctArr.size());
    }
}
