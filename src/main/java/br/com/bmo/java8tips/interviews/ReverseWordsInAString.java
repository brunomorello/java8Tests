package br.com.bmo.java8tips.interviews;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        String phrase = "the sky is blue";
        System.out.println(phrase);
        reverseWords(phrase.toCharArray());
    }

    public static void reverseWords(char[] word) {
        int i = 0;
        for (int j = 0; j < word.length; j++) {
            if (word[j] == ' ') {
                reverse(word, i, j - 1);
                i = j + 1;
            }
        }
        reverse(word, i, word.length -1);
        reverse(word, 0, word.length - 1);
        System.out.println(word);
    }

    public static void reverse(char[] word, int i, int j) {
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
    }
}
