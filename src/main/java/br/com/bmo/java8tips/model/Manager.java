package br.com.bmo.java8tips.model;

public class Manager extends Employee {

    private Employee assistant;

    public Manager(String id, String name, Double salary, String location) {
        super(id, name, salary, location);
    }

    public void setAssistant(Employee assistant) {
        this.assistant = assistant;
    }

    public Employee getAssistant() {
        return assistant;
    }

}
