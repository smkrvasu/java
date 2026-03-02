package com.smkrvasu.collections;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // put
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);
        map.put("Dragon", 4);

        // get
        map.get("Apple");

        // remove
        map.remove("Dragon");
        map.remove("Cherry", 4);

        // contains
        map.containsKey("Cherry");
        map.containsValue(1);

        // for
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }

        // for-each
        map.forEach((key, value) -> System.out.println(key + ":" + value));

        // getOrDefault
        map.getOrDefault("Dragon", -1);

        // putIfAbsent - don't replace existing
        map.putIfAbsent("Dragon", 4);

        // compute - recalculate the value
        map.compute("Fig", (key, value) -> value == null ? 5 : value + 1);

        // computeIfAbsent - runs only if key is absent or value is null
        map.computeIfAbsent("Durian", key -> 6);

        // computeIfPresent - runs if key present and value not equals to null
        map.computeIfPresent("Fig", (key, value) -> value + 2);

        System.out.println(map);
    }
}
