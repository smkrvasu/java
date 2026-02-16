package com.smkrvasu.memoryleak;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeak {
    private static final Map<Integer, byte[]> CACHE = new HashMap<>();

    // Add VM args -Xmx64m -XX:+HeapDumpOnOutOfMemoryError
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            CACHE.put(i++, new byte[1024 * 1024]);
            System.out.println("Added object " + i);
            Thread.sleep(100);
        }
    }
}