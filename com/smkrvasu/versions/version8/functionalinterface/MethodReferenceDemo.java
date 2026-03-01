package com.smkrvasu.versions.version8.functionalinterface;

import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        StringProcessor processor = String::trim;
        names.forEach(s -> System.out.println(processor.process(s)));
    }
}
