package streams.parallel;

import model.Employee;
import model.EmployeeUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ParallelStreams {
    List<Employee> employeeList = EmployeeUtils.createEmployeesFaker(30);

    private void testSerialStream() {
        Optional<Double> sumOfSalaries = employeeList.stream()
                .filter(employee -> {
                    System.out.printf("EmployeeId: %s Filter thread: %s:\n", employee.getId(),
                            Thread.currentThread().getName());
                    return employee.isHighSalary();
                })
                .map(employee -> {
                    System.out.printf("EmployeeId: %s Map thread: %s:\n", employee.getId(),
                            Thread.currentThread().getName());
                    return employee.getSalary();
                })
                .reduce(Double::sum);
        System.out.println(sumOfSalaries.get());
    }

    private void testParallelStream() {
        Optional<Double> sumOfSalaries = employeeList.stream()
                .parallel()
                .filter(Employee::isHighSalary)
                .peek(employee -> System.out.printf("EmployeeId: %s Filter thread: %s:\n", employee.getId(),
                        Thread.currentThread().getName()))
                .map(Employee::getSalary)
                .peek(value -> System.out.printf("Filter thread: %s: working with value %f\n",
                        Thread.currentThread().getName(), value))
                .reduce(Double::sum);

        System.out.println(sumOfSalaries.get());
    }

    private void testPerformance() {
//        List<Employee> list1 = EmployeeUtils.createEmployeesFaker(3000000);
        List<Employee> list1 = EmployeeUtils.createEmployeesFaker(30);
        List<Employee> list2 = new ArrayList<>(list1);

        Instant startTime = Instant.now();

        list1.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        Instant endTime = Instant.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.printf("%s %d %s", "Aggregate employees took ", duration.toMillis(),  " ms in Sequential Mode");

        startTime = Instant.now();

        list2.stream().parallel()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        endTime = Instant.now();
        duration = Duration.between(startTime, endTime);
        System.out.printf("%s %d %s", "Aggregate employees took ", duration.toMillis(),  " ms in Parallel Mode");
    }

    public static void main(String[] args) {
//        System.out.println("serial stream...");
//        new ParallelStreams().testSerialStream();

//        System.out.println("parallel stream...");
//        new ParallelStreams().testParallelStream();

        System.out.println("testCollectionParallelStream...");
        new ParallelStreams().testPerformance();
    }
}
