package br.com.bmo.java8tips.streams.advanced;

import br.com.bmo.java8tips.model.Employee;
import br.com.bmo.java8tips.model.EmployeeUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partitioning {

    List<Employee> employeesList = EmployeeUtils.createEmployeesFaker(35);

    private void partitionByHighSalary() {
        Map<Boolean, List<Employee>> listMap = employeesList.stream()
                .collect(Collectors.partitioningBy(Employee::isHighSalary));
        System.out.println(listMap);
    }

    private void partitioningAndGrouping() {
        Map<Boolean, Map<String, List<Employee>>> map = employeesList.stream()
                .collect(Collectors.partitioningBy((Employee::isHighSalary), Collectors.groupingBy(Employee::getLocation)));

        for (Boolean key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    public static void main(String[] args) {
        System.out.println("partitionByHighSalary...");
        new Partitioning().partitionByHighSalary();

        System.out.println("partitioningAndGrouping...");
        new Partitioning().partitioningAndGrouping();
    }
}
