package com.ximu.leetcode.first.thread;

/**
 * @author derek.wu
 * @date 2020-01-10
 * @since v1.0.0
 */
public class PrintInOrder {

    public static void main(String[] args) {
        Foo foo = new Foo();

    }

    static class Foo {

        private static final Object LOCK           = new Object();

        private boolean             firstFinished  = false;
        private boolean             secondFinished = false;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (LOCK) {
                printFirst.run();
                firstFinished = true;
                LOCK.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (LOCK) {
                while (!firstFinished) {
                    LOCK.wait();
                }
                printSecond.run();
                secondFinished = true;
                LOCK.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (LOCK) {
                while (!secondFinished) {
                    LOCK.wait();
                }
                printThird.run();
            }
        }
    }
}
