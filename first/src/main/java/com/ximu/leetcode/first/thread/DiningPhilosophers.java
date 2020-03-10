package com.ximu.leetcode.first.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 哲学家进餐问题
 * 
 * @author derek.wu
 * @date 2020-03-05
 * @since v1.0.0
 */
public class DiningPhilosophers {

    private ReentrantLock[] locks;
    private Semaphore       limit = new Semaphore(4);

    public DiningPhilosophers() {
        locks = new ReentrantLock[5];
        for (int i = 0; i < 5; i++) {
            locks[i] = new ReentrantLock();
        }

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
                           Runnable putLeftFork, Runnable putRightFork)
        throws InterruptedException {

        int leftFork = (philosopher + 1) % 5;
        int rightFork = philosopher;

        limit.acquire();

        locks[leftFork].lock();
        locks[rightFork].lock();

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();

        locks[leftFork].unlock();
        locks[rightFork].unlock();

        limit.release();
    }
}
