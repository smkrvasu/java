package com.smkrvasu.versions.version21;

import java.util.ArrayList;
import java.util.SequencedCollection;

public class SequencedCollections {
    public static void main(String[] args) {
        listDemo();
    }

    private static void listDemo() {
        SequencedCollection<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        System.out.println(names.getFirst());
        System.out.println(names.getLast());
        names.addFirst("David");
        names.addLast("Zara");
        System.out.println(names.removeFirst());
        System.out.println(names.removeLast());
        System.out.println(names.reversed());
    }
}
