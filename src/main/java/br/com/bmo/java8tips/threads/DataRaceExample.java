package br.com.bmo.java8tips.threads;

public class DataRaceExample {
    private static int sharedValue = 0;
    private static final Object lock = new Object();

    public static void main(String... args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
//                synchronized (lock) {
                    sharedValue++;
//                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
//                synchronized (lock) {
                    sharedValue++;
//                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final shared value: " + sharedValue);
    }
}
