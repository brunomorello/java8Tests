package br.com.bmo.java8tips.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ExampleArrayDeque {
    public static void main(String[] args) {

        // FIFO O(1)
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(10);
        queue.add(100);
        queue.add(1000);

        while (!queue.isEmpty())
            System.out.println(queue.poll());

        System.out.println("============");

        // LIFO O(1)
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(10);
        stack.push(100);
        stack.push(1000);

        while (!stack.isEmpty())
            System.out.println(stack.poll());
    }
}
