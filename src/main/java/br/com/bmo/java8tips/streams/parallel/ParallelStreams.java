package br.com.bmo.java8tips.streams.parallel;

import br.com.bmo.java8tips.model.Employee;
import br.com.bmo.java8tips.model.EmployeeUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

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

    private static long sum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    private static long sumParallel(long n) {
        return LongStream.rangeClosed(1,n).parallel()
                .reduce(0L, Long::sum);
    }

    private static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        long maxDivisor = (long) Math.sqrt(n);

        for (int i = 3; i <= maxDivisor; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println("serial stream...");
//        new ParallelStreams().testSerialStream();

//        System.out.println("parallel stream...");
//        new ParallelStreams().testParallelStream();

//        System.out.println("testCollectionParallelStream...");
//        new ParallelStreams().testPerformance();

        long start = System.currentTimeMillis();
        long sum = ParallelStreams.sum(2000000000);
        long end = System.currentTimeMillis();
        System.out.println(String.format("sum sequential: %d in %d ms", sum, (end - start)));

        start = System.currentTimeMillis();
        long sumParallel = ParallelStreams.sumParallel(2000000000);
        end = System.currentTimeMillis();
        System.out.println(String.format("sum parallelized: %d in %d ms", sumParallel, (end - start)));

        System.out.println("==============");

        start = System.currentTimeMillis();
        long qntPrimeNumbers = IntStream.rangeClosed(2, Integer.MAX_VALUE / 100)
                .filter(ParallelStreams::isPrime)
                .count();
        end = System.currentTimeMillis();
        System.out.println(String.format("qntPrimeNumbers sequential: %d in %d ms", qntPrimeNumbers, (end - start)));

        start = System.currentTimeMillis();
        long qntPrimeNumbersParallel = IntStream.rangeClosed(2, Integer.MAX_VALUE / 100)
                .parallel()
                .filter(ParallelStreams::isPrime)
                .count();
        end = System.currentTimeMillis();
        System.out.println(String.format("qntPrimeNumbers parallel: %d in %d ms", qntPrimeNumbersParallel, (end - start)));
    }
}
