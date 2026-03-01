package com.smkrvasu.versions.version8.functionalinterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressionDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        StringProcessor processor = s -> s.toUpperCase();
        names.forEach(s -> System.out.println(processor.process(s)));

        // old
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        // new
        names.sort(Comparator.comparingInt(String::length));
    }
}
