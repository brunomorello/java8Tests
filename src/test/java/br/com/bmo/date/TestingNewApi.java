package br.com.bmo.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TestingNewApi {
	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		String todayFormatted = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(todayFormatted);
		
		// or you can do
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(formatter.format(today));
		
		LocalDate futureDate = LocalDate.of(2099, Month.JANUARY, 25);
		System.out.println(futureDate);
		
		Period periodUntil = today.until(futureDate);
		System.out.println("Period using LocalDate.until is " + periodUntil);
		
		Period periodBt = Period.between(today, futureDate);
		System.out.println("Period using Period.between " + periodBt);
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println(currentDateTime);
		
	}
}
