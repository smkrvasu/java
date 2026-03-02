package com.smkrvasu.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        LockableCounter counter = new LockableCounter();

        // Each thread will increment the shared counter 5 times
        Runnable incrementTask = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    counter.increaseCount();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread worker1 = new Thread(incrementTask, "Worker-1");
        Thread worker2 = new Thread(incrementTask, "Worker-2");

        worker1.start();
        worker2.start();

        // Ensure the main thread waits for workers to finish
        worker1.join();
        worker2.join();

        System.out.println("Final count = " + counter.getCount());
    }
}

class LockableCounter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increaseCount() throws InterruptedException {
        if (lock.tryLock(200, TimeUnit.MILLISECONDS)) {
            try {
                count++;
                System.out.println(Thread.currentThread().getName() + " -> " + count);
            } finally {
                lock.unlock();
            }
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}
