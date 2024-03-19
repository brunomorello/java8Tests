package br.com.bmo.java8tips.interviews;

public class Palindrome {

    public static boolean isPalindrome(final String input) {
        boolean result = true;
        int length = input.length();

        for (int i = 0; i < length / 2; i++) {
            char charAtInitialPosition = input.charAt(i);
            char chatAtOppositeOfInitialPos = input.charAt(length - i - 1);
            if (charAtInitialPosition != chatAtOppositeOfInitialPos) {
                result = false;
                break;
            }
        }

        return result;
    }
}
