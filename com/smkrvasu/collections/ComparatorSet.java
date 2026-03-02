package com.smkrvasu.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class ComparatorSet {
    public static void main(String[] args) {
        Set<Integer> set = Set.of(5, 1, 9, 3, 7);

        // ascending
        // default
        set.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        // method reference
        set.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        // lambda
        set.stream()
                .sorted((a, b) -> a - b)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        // comparator natural order
        set.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        // comparator comparing
        set.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        // comparator explicit lambda
        set.stream()
                .sorted(Comparator.comparing((Integer a) -> a))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        // descending
        set.stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        set.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        set.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        set.stream()
                .sorted(Comparator.comparing((Integer a) -> a).reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
