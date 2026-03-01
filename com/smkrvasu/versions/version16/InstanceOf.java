package com.smkrvasu.versions.version16;

public class InstanceOf {
    public static void main(String[] args) {
        Object obj = "Hello";
        Object obj1 = 1;

        if (obj instanceof String s)
            System.out.println(s);

        if (obj1 instanceof String s)
            System.out.println(s);
    }
}
