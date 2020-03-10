package com.ximu.leetcode.first.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author derek.wu
 * @date 2020-01-12
 * @since v1.0.0
 */
public class BuildingH2o {

    public static void main(String[] args) {

    }

}

class H2O {

    private Semaphore     hSp     = new Semaphore(2);
    private Semaphore     oSp     = new Semaphore(1);
    private CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {

                                      @Override
                                      public void run() {
                                          hSp.release(2);
                                          oSp.release(1);
                                      }
                                  });

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSp.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSp.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
