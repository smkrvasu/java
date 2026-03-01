package com.smkrvasu.versions.version10;

import java.util.List;

public class LocalVar {
    public static void main(String[] args) {
        var message = "Hello, Java!";
        System.out.println(message);

        var names = List.of("Alice", "Bob", "Charlie");
        for (var name : names) {
            System.out.println(name.toUpperCase());
        }
    }
}
