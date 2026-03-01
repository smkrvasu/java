package com.smkrvasu.versions.version21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreads {
    public static void main(String[] args) {
        try (ExecutorService e = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_000; i++) {
                e.submit(() -> {
                    Thread.sleep(10);
                    return "done";
                });
            }
        }// auto joins
    }
}
