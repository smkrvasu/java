package com.smkrvasu.thread;

public class PlatformThread {
    public static void main(String[] args) {
        for (int i = 1; i < 10_000; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread());
                    Thread.sleep(1000); // blocks OS thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}