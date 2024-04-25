package br.com.bmo.java8tips.threads;

import br.com.bmo.java8tips.threads.deadlock.Intersection;
import br.com.bmo.java8tips.threads.deadlock.TrainA;
import br.com.bmo.java8tips.threads.deadlock.TrainB;

public class DeadLockSimulator {
    public static void main(String[] args) throws InterruptedException {
        Intersection intersection = new Intersection();
        Thread trainA = new Thread(new TrainA(intersection));
        Thread trainB = new Thread(new TrainB(intersection));

        trainA.start();
        trainA.join(2);
        trainB.start();
    }
}
