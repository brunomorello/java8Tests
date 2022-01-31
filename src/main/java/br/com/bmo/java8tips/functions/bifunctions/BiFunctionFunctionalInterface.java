package br.com.bmo.java8tips.functions.bifunctions;

import br.com.bmo.java8tips.model.Employee;
import br.com.bmo.java8tips.model.EmployeeUtils;
import br.com.bmo.java8tips.model.Manager;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionFunctionalInterface {
    BiFunction<Employee, Manager, Employee> employeesManagersAssistantBiFunction = (employee, manager) -> employee.getManager().getAssistant();
    Function<Employee, Employee> employeesManagerAssistant = employee -> employee.getManager().getAssistant();
    Function<Employee, Manager> assistantManager = employee -> employee.getManager();

    public static void main(String[] args) {
        BiFunctionFunctionalInterface client = new BiFunctionFunctionalInterface();
        List<Employee> employees = EmployeeUtils.createEmployees();

        Employee employee = employees.get(0);
        Employee managerAssistant = client.employeesManagersAssistantBiFunction.apply(employee, employee.getManager());
        System.out.println("employeesManagersAssistantBiFunction =" + managerAssistant);

        Employee result = client.employeesManagersAssistantBiFunction.andThen(client.assistantManager).apply(employee, employee.getManager());
        System.out.println("assistantManager = " + result);

        Employee managerAssistant2 = client.employeesManagerAssistant.apply(employee);
        System.out.println("client.employeesManagerAssistant.apply(employee) =" + managerAssistant2);
    }
}
