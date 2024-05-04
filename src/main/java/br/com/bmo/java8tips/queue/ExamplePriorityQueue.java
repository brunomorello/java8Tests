package br.com.bmo.java8tips.queue;

import br.com.bmo.java8tips.generics.Person;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ExamplePriorityQueue {
    public static void main(String[] args) {

        // FIFO O(1)
        Queue<String> q1 = new LinkedList<>();
        q1.add("Adam");
        q1.add("Kevin");
        q1.add("Joe");
        q1.add("Keira");

        System.out.println("Check item: " + q1.peek());

        while (!q1.isEmpty())
            System.out.println(q1.remove());

        System.out.println("============");

        Queue<Person> queue = new PriorityQueue<>();

        queue.add(new Person(12, "Adam"));
        queue.add(new Person(45, "João"));
        queue.add(new Person(22, "Kevin"));
        queue.add(new Person(37, "Joe"));

        while(queue.peek() != null) {
            System.out.println(queue.poll());
        }
    }
}
