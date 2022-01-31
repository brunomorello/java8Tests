package br.com.bmo.java8tips.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTimeApi {
    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        System.out.println(nowDate);

        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println(nowDateTime);

        // Date format
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dateTimeFormatter.format(nowDateTime));

        // Days left until future date
        LocalDateTime trip = LocalDateTime.of(2022, Month.FEBRUARY, 27, 15, 00);
        Period dateDiff = Period.between(nowDateTime.toLocalDate(), trip.toLocalDate());

        System.out.println("Time lefting until: " + dateTimeFormatter.format(trip) + " is " + dateDiff.getDays() + " days");

        System.out.println("Date diff 2...");
        Period dateDiff2 = LocalDate.now().until(trip.toLocalDate());
        System.out.println(dateDiff2.plusDays(2).getDays());
    }
}
