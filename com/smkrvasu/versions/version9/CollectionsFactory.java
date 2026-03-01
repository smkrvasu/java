package com.smkrvasu.versions.version9;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsFactory {
    public static void main(String[] args) {
        Set<String> set = Set.of("foo", "bar", "baz");
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Map<String, Integer> map = Map.of("a", 1, "b", 2, "c", 3);
    }
}
