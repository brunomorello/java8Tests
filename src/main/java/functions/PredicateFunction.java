package functions;

import model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFunction {
    public static void main(String[] args) {

        // Simple
        Predicate<Employee> hasBonus = (emp) -> emp.getSalary() > 5000 ? true : false;
        Predicate<Employee> highSalary = (emp) -> emp.getSalary() > 9999 ? true : false;
        Predicate<Employee> isExecutive = (emp) -> emp.getId().startsWith("EXEC") ? true : false;

        // logical AND
        Predicate<Employee> hasBonusAndIsExecutive = hasBonus.and(isExecutive);

        // logical OR
        Predicate<Employee> highSalarayOrExecutive = highSalary.or(isExecutive);

        // logical AND and OR
        Predicate<Employee> highSalarayOrExecutiveButHasBonus = highSalarayOrExecutive.and(hasBonus);

        // NEGATE
        Predicate<Employee> hasNotBonus = hasBonus.negate();

        // EQUALS
        Employee emp = new Employee("333", "Fulano", 5000.0, "Brazil");
        Predicate<Employee> hasName = Predicate.isEqual(emp.getName());

        Employee e1 = new Employee("123", "Fulano", 1000.0, "Brazil");
        Employee e2 = new Employee("EXEC123", "Fulano Executive", 10000000.0, "Brazil");
        Employee e3 = new Employee("3322", "Ciclano", 10000.0, "Brazil");
        List<Employee> employees = Arrays.asList(e1, e2, e3);

        employees.parallelStream().forEach(e -> {
            System.out.println(e.getName() + " hasBonus? " + hasBonus.test(e));
            System.out.println(e.getName() + " is executive? " + isExecutive.test(e));
            System.out.println(e.getName() + " hasBonusAndIsExecutive? " + hasBonusAndIsExecutive.test(e));
            System.out.println(e.getName() + " highSalarayOrExecutiveButHasBonus? " + highSalarayOrExecutiveButHasBonus.test(e));
            System.out.println(e.getName() + " hasNotBonus? " + hasNotBonus.test(e));
            System.out.println(e.getName() + " hasName? " + hasName.test(e));
        });
    }
}
