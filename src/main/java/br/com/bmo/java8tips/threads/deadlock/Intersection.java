package br.com.bmo.java8tips.threads.deadlock;

public class Intersection {
    private Object roadA = new Object();
    private Object roadB = new Object();

    public void takeRoadA() {
        synchronized (roadA) {
            System.out.println("Road A is locked by: " + Thread.currentThread().getName());
            synchronized (roadB) {
                System.out.println("train is passing by through road a");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void takeRoadB() {
        synchronized (roadA) {
            System.out.println("Road B is locked by: " + Thread.currentThread().getName());
            synchronized (roadB) {
                System.out.println("train is passing by through road b");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
