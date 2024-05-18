package br.com.bmo.java8tips.threads;

public class RaceConditionExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            while (counter.getCounter() < 50000) {
                for (int i = 0; i < 50000; i++) {
                    counter.increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter value is: " + counter.getCounter());
    }
}

class Counter {
    private volatile int counter = 0;

    public synchronized void increment() {
//        synchronized (this) {
            counter++;
//        }
    }

    public int getCounter() {
        return counter;
    }
}
