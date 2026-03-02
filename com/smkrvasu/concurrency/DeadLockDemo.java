package com.smkrvasu.concurrency;

public class DeadLockDemo {

    Object a = new Object();
    Object b = new Object();

    public static void main(String[] args) {
        DeadLockDemo demo = new DeadLockDemo();

        Thread t1 = new Thread(() -> {
            synchronized (demo.a) {
                try {
                    Thread.sleep(100);
                    synchronized (demo.b) {
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupted();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (demo.b) {
                try {
                    Thread.sleep(100);
                    synchronized (demo.a) {
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupted();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
