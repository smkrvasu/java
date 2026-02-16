package com.smkrvasu.thread;

public class VirtualThread {

    public static void main(String[] args) {
        for (int i = 0; i < 10_000; i++) {
            Thread.startVirtualThread(() -> {
                try {
                    System.out.println(Thread.currentThread());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
