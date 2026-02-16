package com.smkrvasu.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlatformThreadFixed {

    public static void main(String[] args) throws InterruptedException {
        int poolSize = Math.min(100, Runtime.getRuntime().availableProcessors() * 4);
        ExecutorService pool = Executors.newFixedThreadPool(poolSize);
        int threadCount = 10_000;
        CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            pool.execute(() -> {
                try {
                    System.out.println(Thread.currentThread());
                    Thread.sleep(1000); // blocks OS threads during sleep
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // restore interrupt status
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
        pool.shutdown();
    }
}
