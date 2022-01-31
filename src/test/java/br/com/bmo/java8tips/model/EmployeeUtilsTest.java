package br.com.bmo.java8tips.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeUtilsTest {

    @Test
    void testHasHighSalaryPredicate() {
        double highSalary = 15001.0;
        assertTrue(EmployeeUtils.hasHighSalary.test(highSalary), "Value must be a High Salary");
    }

    @Test
    void testHasNotHighSalaryPredicate() {
        double lowSalary = 1000.0;
        assertFalse(EmployeeUtils.hasHighSalary.test(lowSalary), "Value must NOT be a High Salary");
    }

    @Test
    void testCreateEmployeesSucceed() {

        assertEquals(3, EmployeeUtils.createEmployees().size(), "List must have 3 employees");
        assertTrue(EmployeeUtils.createEmployees() instanceof List);

        EmployeeUtils.createEmployees().stream()
                .peek(employee -> System.out.println(employee.getManager()))
            .forEach(employee -> {
                assertNotNull(employee.getId(), "id must be present");
                assertNotNull(employee.getName(), "name must be present");
                assertNotNull(employee.getSalary(), "salary must be present");
                assertNotNull(employee.getLocation(), "location must be present");
                assertNotNull(employee.getManager(), "manager must be present");

                assertTrue(employee.getManager().getId().equals("EXEC123"));
                assertTrue(employee.getManager().getName().equals("Fulano Executive"));
                assertTrue(employee.getManager().getLocation().equals("Brazil"));
            });
    }
}