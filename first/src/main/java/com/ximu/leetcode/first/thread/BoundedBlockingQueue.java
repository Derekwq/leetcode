package com.ximu.leetcode.first.thread;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author derek.wu
 * @date 2020-03-05
 * @since v1.0.0
 */
public class BoundedBlockingQueue {

    private volatile int        capacity;
    private LinkedList<Integer> table;
    private AtomicInteger       size         = new AtomicInteger(0);

    private ReentrantLock       lock         = new ReentrantLock();
    private Condition           enqCondition = lock.newCondition();
    private Condition           deqCondition = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        table = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (size.get() >= capacity) {
                enqCondition.await();
            }
            table.addFirst(element);
            size.incrementAndGet();
            deqCondition.signal();
        } finally {
            lock.unlock();
        }

    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size.get() == 0) {
                deqCondition.await();
            }
            int ele = table.getLast();
            table.removeLast();
            size.decrementAndGet();
            enqCondition.signal();
            return ele;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return size.get();
        } finally {
            lock.unlock();
        }
    }
}
