package br.com.bmo.java8tips.interviews;

public class CheckOpenClosedParenthesis {
    public boolean isValid(final String parenthesisSeq) {
        boolean valid = true;

        for (int i = 0; i < parenthesisSeq.length(); i++) {
            if (parenthesisSeq.charAt(i) == '(') {
                valid = true;
            }
            valid = !valid;

            if (parenthesisSeq.charAt(i) == ')') {
                valid = true;
            }

        }
        return valid;
    }

    public boolean isValidV2(final String parenthesisSeq) {
        int countOpen = 0;
        int countClosed = 0;

        for (int i = 0; i < parenthesisSeq.length(); i++) {
            if (parenthesisSeq.charAt(i) == ')') countOpen++;
            if (parenthesisSeq.charAt(i) == '(') countClosed++;
        }

        return !(countOpen > countClosed || countClosed > countOpen);
    }
}
