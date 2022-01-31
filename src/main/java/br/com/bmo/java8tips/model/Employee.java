package br.com.bmo.java8tips.model;

import java.util.List;
import java.util.Objects;

public class Employee {

    private String id;
    private String name;
    private Double salary;
    private Manager manager;
    private String location;
    private List<String> favoriteFood;

    public Employee(String id, String name, Double salary, String location) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public List<String> getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(List<String> favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public String getLocation() {
        return location;
    }

    public boolean isHighSalary() {
        return EmployeeUtils.hasHighSalary.test(this.getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", manager=" + (manager != null ? manager.getName() : "") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) && Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary) && Objects.equals(manager, employee.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, manager);
    }
}
