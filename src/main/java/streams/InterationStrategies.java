package streams;

import model.Employee;
import model.EmployeeUtils;

import java.util.List;

public class InterationStrategies {
    public static void main(String[] args) {
        List<Employee> employeesFaker = EmployeeUtils.createEmployeesFaker(15);

        employeesFaker.stream()
                .filter(Employee::isHighSalary)
//                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
