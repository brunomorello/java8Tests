package br.com.bmo.java8tips.interviews;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class SmallestKLengthSubseq {
    public static String smallestSubsequence(String s, int k, char letter, int repetition) {

        ArrayDeque<Character> deque = new ArrayDeque<>();
        int qntCharsFound = 0;

        char[] strArr = s.toCharArray();
        for (char c : strArr) {
            if (letter == c) qntCharsFound++;
        }

        for (char c : strArr) {
            while (!deque.isEmpty() && deque.peek() > c && (s.length() + deque.size() > k) && (deque.peek() != letter || qntCharsFound > repetition)) {
                if (deque.pop() == letter) qntCharsFound++;
            }

            if (deque.size() < k) {
                if (letter == c) {
                    deque.push(c);
                    qntCharsFound--;
                } else if (k - deque.size() > qntCharsFound) {
                    deque.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder(deque.size());
        while (!deque.isEmpty())
            sb.append(deque.pollLast());

        return sb.toString();
    }
}
