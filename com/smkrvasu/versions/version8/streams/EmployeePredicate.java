package com.smkrvasu.versions.version8.streams;

import java.util.function.Predicate;

public class EmployeePredicate {
    public static Predicate<Employee> salaryLessThan(double salary) {
        return e -> e.getSalary() < salary;
    }

    public static Predicate<Employee> youngerThan(int age) {
        return e -> e.getAge() < age;
    }

    public static Predicate<Employee> olderThan(int age) {
        return e -> e.getAge() > age;
    }

    public static Predicate<Employee> genderEquals(String gen) {
        return e -> e.getGender().equals(gen);
    }

    public static Predicate<? super Employee> ageBetween(int min, int max) {
        return e -> e.getAge() > min && e.getAge() < max;
    }
}
