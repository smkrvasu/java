package com.smkrvasu.collections;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

public class ComparatorList {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("John", 80),
                new Student("Adam", 95),
                new Student("Bob", 70)
        );
        //ascending
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        students.sort(Comparator.comparing(Student::getName));
        students.sort(Comparator.comparing((Student s) -> s.getMark()));

        // descending
        students.sort((s1, s2) -> s2.getName().compareTo(s1.getName()));
        students.sort(Comparator.comparingInt(Student::getMark).reversed()); // no auto boxing
        students.sort(Comparator.comparing((Student s) -> s.getMark()).reversed());

        // multi
        students.sort(Comparator.comparing(Student::getMark).reversed() // auto boxing
                .thenComparing(Student::getName));
    }
}

class Student {
    private final String name;
    private final int mark;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }
}
