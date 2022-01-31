package functions;

import model.Employee;

import java.util.function.Consumer;

public class ConsumerFunction {
    Consumer<Employee> printInfo = employee -> System.out.println("Printing Employee info: " + employee);
    Consumer<Employee> persistEmployee = employee -> persist(employee);
    Consumer<Employee> notifyEmployee = employee -> notification(employee);
    Consumer<Employee> saveAndNotifyEmployee = printInfo.andThen(persistEmployee).andThen(notifyEmployee);
    Consumer<Employee> persistAndPrintEmployeeInfo = persistEmployee.andThen(printInfo);

    private void persist(Employee employee) {
        System.out.println("Persisting employee #" + employee.getId());
    }

    private void notification(Employee employee) {
        System.out.println("Sending Notification about employee #" + employee.getId() + ": " + employee.getName());
    }

    private void testConsumer(Employee employee) {
        printInfo.accept(employee);
        persistEmployee.accept(employee);
    }

    private void testAndThen(Employee employee) {
        persistAndPrintEmployeeInfo.accept(employee);
    }

    private void testChainedConsumer(Employee employee) {
        saveAndNotifyEmployee.accept(employee);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("124", "Fulano", 5910.15, "Brazil");
        ConsumerFunction consumers = new ConsumerFunction();

        consumers.testConsumer(e1);
        consumers.testAndThen(e1);
        consumers.testChainedConsumer(e1);
    }
}
