package br.com.bmo.java8tips.model;

import java.time.LocalDate;

public class User {

    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;

    public User(final String firstName, final String lastName, final LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

}
