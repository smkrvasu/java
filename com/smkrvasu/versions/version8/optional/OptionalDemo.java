package com.smkrvasu.versions.version8.optional;

import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        Optional<String> name = names.stream()
                .filter(s -> s.startsWith("C"))
                .findFirst();
        System.out.println(name.orElse("not found"));
    }
}
