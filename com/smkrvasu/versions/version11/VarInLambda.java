package com.smkrvasu.versions.version11;

import java.util.function.BiFunction;

public class VarInLambda {
    public static void main(String[] args) {
        // old
        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> x + y;
        // new
        BiFunction<Integer, Integer, Integer> mul = (var x, var y) -> x * y;

        System.out.println(add.apply(3, 2));
        System.out.println(mul.apply(3, 2));
    }
}
