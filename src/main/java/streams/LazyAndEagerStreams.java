package streams;

import model.Employee;
import model.EmployeeUtils;

import java.util.List;
import java.util.stream.Stream;

public class LazyAndEagerStreams {
    List<Employee> employees = EmployeeUtils.createEmployeesFaker(15);

    private void testLazy() {
        // lazy methods
        // map, filter, sort, peak, distinct, limit or skip
        employees.stream()
                .filter(employee -> {
                    System.out.println("inside lazy method");
                    return employee.isHighSalary();
                });
//              when added eager method, filter is executed
//                .count();
    }

    private void testEager() {
        // eager methods - terminal operators
        // count, forEach, findFirst, findAny, order or match
        Stream<Employee> employeeStream = employees.stream()
                .filter(employee -> {
                    System.out.println("filtering...");
                    return employee.isHighSalary();
                })
                .map(employee -> {
                    System.out.println("mapping...");
                    return employee;
                });

        System.out.println("employeeStream count = " + employeeStream.count());
    }

    public static void main(String[] args) {
        new LazyAndEagerStreams().testLazy();
        new LazyAndEagerStreams().testEager();
    }
}
