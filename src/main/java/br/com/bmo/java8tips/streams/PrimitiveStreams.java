package br.com.bmo.java8tips.streams;

import br.com.bmo.java8tips.model.Employee;
import br.com.bmo.java8tips.model.EmployeeUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    List<Employee> employees = EmployeeUtils.createEmployeesFaker(21);

    private void testEmployeesReduce() {
        // using Boxing is too expensive!!
        Optional<Double> totalSalaries = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println("totalSalaries with reduce = " + totalSalaries.get());
    }

    private void testIntStream() {
        // Available for Int, Double, etc
        int[] values = new int[] {2, 3, 5, 10};
        IntStream.of(values).forEach(System.out::println);

        IntStream.of(99, 111).forEach(System.out::println);
    }

    private void testConvertStream() {
        double sumOfSalaries = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("sumOfSalaries = " + sumOfSalaries);
    }

    public static void main(String[] args) {
        new PrimitiveStreams().testEmployeesReduce();
        new PrimitiveStreams().testIntStream();
        new PrimitiveStreams().testConvertStream();
    }
}
