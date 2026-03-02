package com.smkrvasu.collections;

import java.util.Comparator;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class ComparatorMap {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A", 3, "B", 1, "C", 2, "D", 5);

        // key
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (existingVal, newVal) -> existingVal,
                        LinkedHashMap::new));

        // value
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (existingVal, newVal) -> existingVal,
                        LinkedHashMap::new));

        // lambda
        map.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (existingVal, newVal) -> existingVal,
                        LinkedHashMap::new));

        // comparator
        map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (existingVal, newVal) -> existingVal,
                        LinkedHashMap::new));

        // descending
        map.entrySet().stream()
                .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (existingVal, newVal) -> existingVal,
                        LinkedHashMap::new));
        map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getKey).reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (existingVal, newVal) -> existingVal,
                        LinkedHashMap::new));
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (existingVal, newVal) -> existingVal,
                        LinkedHashMap::new));
    }
}
