package br.com.bmo.java8tips.functions;

import br.com.bmo.java8tips.model.Employee;
import br.com.bmo.java8tips.model.EmployeeUtils;
import br.com.bmo.java8tips.model.Manager;

import java.util.List;
import java.util.function.Function;

public class ComposingFunctions {
    Function<Employee, Manager> managerFinder = employee -> employee.getManager();
    Function<Manager, Employee> assistantFinder = manager -> manager.getAssistant();

    private Employee getEmployeeManagerAssistant(Employee employee) {
        Function<Employee, Employee> empManagerAssistantFinder = managerFinder.andThen(assistantFinder);
        return empManagerAssistantFinder.apply(employee);
    }

    public static void main(String[] args) {
        ComposingFunctions client = new ComposingFunctions();
        List<Employee> employeeList = EmployeeUtils.createEmployees();

        System.out.println("Employee's Manager's Assistant: " + client.getEmployeeManagerAssistant(employeeList.get(0)));
    }
}
