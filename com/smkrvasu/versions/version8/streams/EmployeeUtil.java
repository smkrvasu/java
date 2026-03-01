package com.smkrvasu.versions.version8.streams;

import java.util.Arrays;
import java.util.List;

public class EmployeeUtil {
    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(101, "Vasanth", "vasanth@x.com", "IT", 30, "Male", 30000.0),
                new Employee(102, "Raj", "raj@x.com", "HR", 42, "Female", 40000.0),
                // dup id + email
                new Employee(101, "Vasanth2", "vasanth@x.com", "IT", 35, "Male", 35000.0),
                new Employee(103, "Priya", "priya@x.com", "FIN", 26, "Female", 42000.0),
                // dup id + email
                new Employee(102, "Raj2", "raj@x.com", "HR", 25, "Male", 27000.0)
        );
    }
}