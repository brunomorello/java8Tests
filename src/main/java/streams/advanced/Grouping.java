package streams.advanced;

import model.Employee;
import model.EmployeeUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    private void testGrouping() {
        Map<String, List<Employee>> employeesByLocation = EmployeeUtils.createEmployeesFaker(20)
                .stream()
                .collect(Collectors.groupingBy(Employee::getLocation));
        System.out.println(employeesByLocation);
    }

    private void testGroupByLocationAndHighSalary() {
        Map<String, Map<String, List<Employee>>> groupByLocationAndHighSalary = EmployeeUtils.createEmployeesFaker(10)
                .stream()
                .collect(Collectors.groupingBy((Employee::getLocation), Collectors.groupingBy(employee -> employee.isHighSalary() ? "isHighSalary" : "isNOTHighSalary")));
        System.out.println(groupByLocationAndHighSalary);
    }

    public static void main(String[] args) {
        System.out.println("testGrouping...");
        new Grouping().testGrouping();

        System.out.println("testGroupByLocationAndHighSalary...");
        new Grouping().testGroupByLocationAndHighSalary();
    }
}
