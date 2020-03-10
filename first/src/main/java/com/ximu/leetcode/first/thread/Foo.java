package com.ximu.leetcode.first.thread;

/**
 * @author derek.wu
 * @date 2020-02-28
 * @since v1.0.0
 */
public class Foo {

    private static final Object LOCK      = new Object();
    private boolean             isOneDone = false;
    private boolean             isTwoDone = false;

    public Foo() {

    }

    public void first(Runnable printFirst) {
        synchronized (LOCK) {
            printFirst.run();
            isOneDone = true;
        }
    }

    public void second(Runnable printSecond) {
        synchronized (LOCK) {

        }
    }
}
