package br.com.bmo.java8tips.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Manager manager;

    @BeforeEach
    void setup() {
        manager = new Manager("33", "Ciclano", 100000.0, "Brazil");
        manager.setManager(manager);
        manager.setFavoriteFood(Arrays.asList("cake", "soda"));
    }

    @Test
    void testSetAndGetManagerAssistant() {
        var assistant = new Employee("123", "Fulano", 1500.0, "Brazil");
        manager.setAssistant(assistant);

        assertEquals(assistant, manager.getAssistant(), "Assistant must be equals");
    }

}