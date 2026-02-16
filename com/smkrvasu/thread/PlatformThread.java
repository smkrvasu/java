package com.smkrvasu.thread;

public class PlatformThread {

    public static void main(String[] args) {
        int threadCount = 10_000;
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread());
                    Thread.sleep(1000); // blocks OS threads during sleep
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // restore interrupt status
                }
            }).start();
        }
        // No wait for all to finish
    }
}