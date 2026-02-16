package com.smkrvasu.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExecutor {
    public static void main(String[] args) {

        // try-with-resources closes the executor and waits for tasks to finish
        try (ExecutorService vExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            int threadCount = 10_000;
            for (int i = 0; i < threadCount; i++) {
                vExecutor.submit(() -> {
                    try {
                        System.out.println(Thread.currentThread());
                        Thread.sleep(1000); // non-pinning with virtual threads
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }
}
