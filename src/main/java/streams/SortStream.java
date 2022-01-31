package streams;

import model.Employee;
import model.EmployeeUtils;

import java.util.Comparator;
import java.util.List;

public class SortStream {
    private void testSort() {
        List<Employee> employees = EmployeeUtils.createEmployeesFaker(15);

//        employees.sort((emp1, emp2) -> Integer.compare(emp1.getName().length(), emp2.getName().length()));
        employees.sort(Comparator.comparing(employee -> employee.getName().length()));
        System.out.println(employees);
    }

    public static void main(String[] args) {
        System.out.println("testSort...");
        new SortStream().testSort();
    }
}
