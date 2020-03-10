package com.ximu.leetcode.first.thread;

/**
 * Problem 1115: 交替打印 FooBar
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 * 
 * @author derek.wu
 * @date 2020-01-10
 * @since v1.0.0
 */
public class PrintFoobarAlternately {

    static class FooBar {

        private int     n;
        private boolean isFoo = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (!isFoo) {
                    Thread.yield();
                }
                printFoo.run();
                isFoo = false;
            }

        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (isFoo) {
                    Thread.yield();
                }
                printBar.run();
                isFoo = true;
            }
        }
    }
}
