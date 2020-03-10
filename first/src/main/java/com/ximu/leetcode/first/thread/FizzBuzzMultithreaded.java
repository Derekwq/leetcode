package com.ximu.leetcode.first.thread;

import java.util.concurrent.Semaphore;

/**
 * @author derek.wu
 * @date 2020-01-12
 * @since v1.0.0
 */
public class FizzBuzzMultithreaded {

    public static void main(String[] args) {
        final FizzBuzz fizzBuzz = new FizzBuzz(20);
        IntConsumer intConsumer = new IntConsumer() {

            void accept(int x) {
                super.accept(x);
                System.out.print(", ");
            }
        };
        Thread A = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread B = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread C = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread D = new Thread(() -> {
            try {
                fizzBuzz.number(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        A.start();
        B.start();
        C.start();
        D.start();
    }
}

/**
 * 提交，超时
 */
class FizzBuzz {

    private final int n;

    private Semaphore fizzSp = new Semaphore(0);
    private Semaphore buzzSp = new Semaphore(0);
    private Semaphore fbSp   = new Semaphore(0);
    private Semaphore numSp  = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    /**
     * 可以被 3 整除
     * printFizz.run() outputs "fizz".
     * 
     * @param printFizz
     * @throws InterruptedException
     */
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                fizzSp.acquire();
                printFizz.run();
                numSp.release();
            }
        }
    }

    /**
     * 可以被 5 整除
     * printBuzz.run() outputs "buzz".
     * 
     * @param printBuzz
     * @throws InterruptedException
     */
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                buzzSp.acquire();
                printBuzz.run();
                numSp.release();
            }
        }
    }

    /**
     * 可以同时被 3 和 5 整除，输出 "fizzbuzz"。
     * printFizzBuzz.run() outputs "fizzbuzz".
     * 
     * @param printFizzBuzz
     * @throws InterruptedException
     */
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 == 0) {
                fbSp.acquire();
                printFizzBuzz.run();
                numSp.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            numSp.acquire();
            if (i % 3 == 0 && i % 5 != 0) {
                fizzSp.release();
            } else if (i % 5 == 0 && i % 3 != 0) {
                buzzSp.release();
            } else if (i % 3 == 0 && i % 5 == 0) {
                fbSp.release();
            } else {
                printNumber.accept(i);
                numSp.release();
            }
        }
    }
}
