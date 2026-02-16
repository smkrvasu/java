package com.smkrvasu.thread.locks;

public class SynchronizedMethod {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Each thread will increment the counter 5 times
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

class Counter {
    private int count = 0;

    /**
     * Synchronized instance method:
     * Locks on 'this', ensuring only one thread executes this method at a time.
     * Also provides happens-before visibility guarantees for 'count'.
     */
    public synchronized void increaseCount() {
        count++;
        System.out.println(Thread.currentThread().getName() + " -> " + count);
    }

    public synchronized int getCount() {
        return count;
    }
}