package functions;

import model.Employee;
import model.EmployeeUtils;

import java.util.function.Function;

public class FunctionFunctionalInterface {
    // Function Functional Interface is used in situations like
    // mappings or transformations
    Function<String, Employee> employeeFinderById = id -> {
        return EmployeeUtils.createEmployees().stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id #" + id));
    };

    public static void main(String[] args) {
        FunctionFunctionalInterface function = new FunctionFunctionalInterface();
        Employee employeeFound = function.employeeFinderById.apply("123");
        System.out.println(employeeFound);
    }
}
