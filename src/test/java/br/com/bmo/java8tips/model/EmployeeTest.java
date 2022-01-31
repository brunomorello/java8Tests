package br.com.bmo.java8tips.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee employee;

    @BeforeEach
    void setup() {
        employee = new Employee("123", "Fulano", 1500.0, "Brazil");
        employee.setManager(new Manager("33", "Ciclano", 100000.0, "Brazil"));
        employee.setFavoriteFood(Arrays.asList("pizza", "spaghetti", "risotto"));
    }

    @Test
    void getId() {
        assertEquals("123", employee.getId(), "id must be 123");
    }

    @Test
    void getName() {
        assertEquals("Fulano", employee.getName(), "name must be ciclano");
    }

    @Test
    void getSalary() {
        assertEquals(1500.0, employee.getSalary(), "salary must be 1500.0");
    }

    @Test
    void getFavoriteFood() {
        assertEquals(Arrays.asList("pizza", "spaghetti", "risotto"), employee.getFavoriteFood(), "favorite food must equals");
    }

    @Test
    void setFavoriteFood() {
        employee.setFavoriteFood(Arrays.asList("mango", "soy"));
        assertEquals(Arrays.asList("mango", "soy"), employee.getFavoriteFood());
    }

    @Test
    void setManager() {
        employee.setManager(null);
        assertNull(employee.getManager());
    }

    @Test
    void getManager() {
        assertEquals("Ciclano", employee.getManager().getName(), "manager must be ciclano");
    }

    @Test
    void getLocation() {
        assertEquals("Brazil", employee.getLocation());
    }

    @Test
    void isHighSalary() {
        assertFalse(employee.isHighSalary(), "employee's salary must not be high salary");
    }

    @Test
    void testToString() {
        String employeeStringified = "Employee{id='123', name='Fulano', salary=1500.0, manager=Ciclano}";
        assertEquals(employeeStringified, employee.toString());
    }

    @Test
    void testEquals() {
        Employee employee2 = new Employee("123", "Fulano", 1500.0, "Brazil");
        employee2.setManager(new Manager("33", "Ciclano", 100000.0, "Brazil"));
        employee2.setFavoriteFood(Arrays.asList("pizza", "spaghetti", "risotto"));

        assertTrue(employee.equals(employee2));
    }

    @Test
    void testHashCode() {
        System.out.println(employee.hashCode());
        assertEquals(-1276957590, employee.hashCode());
    }
}