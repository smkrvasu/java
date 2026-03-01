package com.smkrvasu.versions.version22;

import java.util.stream.IntStream;

public class UnnamedVariables {
    public static void main(String[] args) {
        IntStream.range(0, 5)
                .forEach(_ -> System.out.println("done"));
    }
}
