package br.com.bmo.java8tips.interviews;

public class SwapNumbers {

    public static void main(String[] args) {
        SwapNumbers swapNumbers = new SwapNumbers();
        swapNumbers.swap(32, 131);
    }
    public void swap(int x, int y) {

        System.out.println(String.format("First num is %d and second num is %d", x, y));

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println(String.format("After swap first num is %d and second num is %d", x, y));
    }
}
