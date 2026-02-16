package com.smkrvasu.thread.locks;

/**
 * Demonstrates using a synchronized BLOCK to protect a critical section
 * when multiple threads update a shared counter.
 */
public class SynchronizedBlock {

    public static void main(String[] args) throws InterruptedException {
        SafeCounter safeCounter = new SafeCounter();

        // Each thread will increment the shared counter 5 times
        Runnable incrementTask = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    safeCounter.increaseCount();
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

        System.out.println("Final count = " + safeCounter.getCount());
    }
}

class SafeCounter {
    // Shared mutable state — must be protected by the same lock on every access
    private int count = 0;
    // Private lock
    private final Object lock = new Object();

    /**
     * Increments the counter safely.
     * The synchronized block ensures:
     * 1) Mutual exclusion — only one thread updates 'value' at a time.
     * 2) Visibility — updates are visible to subsequent threads entering the lock.
     */
    public void increaseCount() {
        // Minimal critical section
        synchronized (lock) {
            count++;
            System.out.println(Thread.currentThread().getName() + " -> " + count);
        }
    }

    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }
}