package br.com.bmo.java8tips.functions.biconsumers;

import br.com.bmo.java8tips.model.Employee;

import java.util.function.BiConsumer;

public class BiConsumersFunction {
    BiConsumer<Employee, Double> employeeBonusConsumer = (employee, aDouble) -> System.out.printf("Employee %s is set of %f percent of bonus", employee, aDouble);
    BiConsumer<Employee, Double> employeeSalaryHikeConsumer = (employee, aDouble) -> System.out.printf("Employee %s is receiving %f hike in salary", employee, aDouble);

    BiConsumer<Employee, Double> employeeBonusAndSalaryHikeConsumer = employeeBonusConsumer.andThen(employeeSalaryHikeConsumer);

    public static void main(String[] args) {
        BiConsumersFunction client = new BiConsumersFunction();
        Employee e1 = new Employee("123", "Fulano", 2000.15, "Brazil");

        client.employeeBonusConsumer.accept(e1, 5.0);
        client.employeeSalaryHikeConsumer.accept(e1, 1.2);
        client.employeeBonusAndSalaryHikeConsumer.accept(e1, 2.9);
    }
}
