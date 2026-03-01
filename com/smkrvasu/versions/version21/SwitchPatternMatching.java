package com.smkrvasu.versions.version21;

import java.util.List;

public class SwitchPatternMatching {
    public static void main(String[] args) {
        System.out.println(formatter(null));
        System.out.println(formatter("Hello"));
        System.out.println(formatter(42));
        System.out.println(formatter(-1));
        System.out.println(formatter(List.of(1)));
        System.out.println(formatter(1L));
    }

    private static String formatter(Object obj) {
        return switch (obj) {
            case null -> "It's null";
            case String s -> "String";
            case Integer i when i > 0 -> "Positive";
            case Integer i -> "Non positive";
            case List<?> l -> "List";
            default -> "Unknown";
        };
    }
}
