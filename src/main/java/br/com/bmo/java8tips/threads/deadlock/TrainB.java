package br.com.bmo.java8tips.threads.deadlock;

import java.util.Random;

public class TrainB implements Runnable {

    private Intersection intersection;
    private Random random = new Random();

    public TrainB(Intersection intersection) {
        this.intersection = intersection;
    }

    @Override
    public void run() {
        long sleepingTime = random.nextInt(6);
        try {
            Thread.sleep(sleepingTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        intersection.takeRoadB();
    }
}
