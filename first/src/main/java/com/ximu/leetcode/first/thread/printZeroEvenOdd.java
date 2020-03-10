package com.ximu.leetcode.first.thread;

import java.util.concurrent.Semaphore;

/**
 * @author derek.wu
 * @date 2020-01-10
 * @since v1.0.0
 */
public class printZeroEvenOdd {

    public static void main(String[] args) {
        final ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);
        IntConsumer intConsumer = new IntConsumer();

        Thread A = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread B = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread C = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        A.start();
        B.start();
        C.start();

    }

}

class ZeroEvenOdd {

    private int       n;

    private Semaphore zeroSp = new Semaphore(1);
    private Semaphore oddSp  = new Semaphore(0);
    private Semaphore evenSp = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSp.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                oddSp.release();
            } else {
                evenSp.release();
            }
        }
    }

    /**
     * 奇数
     * 
     * @param printNumber
     * @throws InterruptedException
     */
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSp.acquire();
            printNumber.accept(i);
            zeroSp.release();
        }
    }

    /**
     * 偶数
     * 
     * @param printNumber
     * @throws InterruptedException
     */
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSp.acquire();
            printNumber.accept(i);
            zeroSp.release();
        }
    }
}
