package br.com.bmo.java8tips.streams;

import br.com.bmo.java8tips.model.Employee;
import br.com.bmo.java8tips.model.EmployeeUtils;

import java.util.List;

public class IntroduceStreams {
    public static void main(String[] args) {
        List<Employee> employeesFaker = EmployeeUtils.createEmployeesFaker(15);

        employeesFaker.stream()
                .filter(employee -> EmployeeUtils.hasHighSalary.test(employee.getSalary()))
//                .map(Employee::getName)
//                .distinct()
//                .limit(2)
                .forEach(System.out::println);
    }
}
