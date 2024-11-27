package br.com.bmo.java8tips.interviews;

import java.util.Random;

public class RandomString {

    private String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String numeric = "0123456789";
    private String alphaNumericString = alpha + numeric + alpha.toLowerCase();

    public String generateWithSize(int size) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(alphaNumericString.charAt(random.nextInt(alphaNumericString.length())));
        }

        return sb.toString();
    }
}
