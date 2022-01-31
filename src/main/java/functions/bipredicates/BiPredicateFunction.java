package functions.bipredicates;

import model.Employee;
import model.EmployeeUtils;
import model.Manager;

import java.util.List;
import java.util.function.BiPredicate;

public class BiPredicateFunction {
    BiPredicate<Employee, Manager> employeeManagerBiPredicate = (employee, manager) -> employee.getManager().equals(manager);
    BiPredicate<Employee, Manager> managerHasAssistantBiPredicate = (employee, manager) -> manager.getAssistant().equals(employee);

    BiPredicate<Employee, Manager> employeeIsManagersPersonalAssistant = employeeManagerBiPredicate.and(managerHasAssistantBiPredicate);
    BiPredicate<Employee, Manager> employeeIsSubordinateOrManagerPersonalAssistant = employeeManagerBiPredicate.or(managerHasAssistantBiPredicate);

    public static void main(String[] args) {
        BiPredicateFunction predicates = new BiPredicateFunction();
        List<Employee> employees = EmployeeUtils.createEmployees();
        employees.stream().forEach(employee -> {
            System.out.println("Processing " + employee);
            Manager manager = employee.getManager();
            System.out.println("predicates.employeeManagerBiPredicate.test(employee, manager); = " + predicates.employeeManagerBiPredicate.test(employee, manager));
            System.out.println("predicates.managerHasAssistantBiPredicate.test(employee, manager) = " + predicates.managerHasAssistantBiPredicate.test(employee, manager));
            System.out.println("predicates.employeeIsManagersPersonalAssistant.test(employee, manager) = " + predicates.employeeIsManagersPersonalAssistant.test(employee, manager));
            System.out.println("predicates.employeeIsSubordinateOrManagerPersonalAssistant.test(employee, manager) = " + predicates.employeeIsSubordinateOrManagerPersonalAssistant.test(employee, manager));
        });
    }
}
