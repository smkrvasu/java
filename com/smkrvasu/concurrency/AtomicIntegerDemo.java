package com.smkrvasu.concurrency;

import java.util.stream.IntStream;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();
        Thread t1 = new Thread(() -> {
            IntStream.range(0, 5)
                    .forEach(_ -> counter.increaseCount());
        });
        Thread t2 = new Thread(() -> {
            IntStream.range(0, 5)
                    .forEach(_ -> counter.increaseCount());
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupted();
        }
        System.out.println(counter.getCount());
    }
}

class AtomicCounter {
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increaseCount() {
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}