package com.smkrvasu.core;

import java.util.HashMap;
import java.util.Map;

public class EqualsDemo {
    public static void main(String[] args) {

        // String
        String s1 = new String("sam");
        String s2 = new String("sam");
        System.out.println("s1 == s2? " + (s1 == s2));   // false → different objects
        System.out.println("s1.equals(s2)? " + s1.equals(s2)); // true → same content
        System.out.println();

        // Map
        Map<String, Integer> map = new HashMap<>();
        Integer e1 = map.put("sam", 1);
        Integer e2 = map.put("sam", 2);
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(map.size());
    }
}
