package com.smkrvasu.versions.version8.streams;

import java.util.List;

public class MatchDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeUtil.getEmployees();

        // Check if all IDs > 0
        checkAllIdGreaterThan(employees, 0);
        // Check if any employee earns >100,000
        checkAnyEarnsMoreThan(employees, 100_000);
        // Check if all employees are older than 25
        checkAllOlderThan(employees, 30);
        // Check if no employee earns <20,000
        checkNoneEarnsLessThan(employees, 20_000);
        // Check if any employee’s name contains "I"
        checkNameContains(employees, "I");
        // Check if none of the names contain "Z"
        checkNoNameContains(employees, "Z");
        // Check if all employees earn >25,000
        checkAllEarnsMoreThan(employees, 25_000);
        // Check if none are older than 40
        checkNoneOlderThan(employees, 40);
        // Check if any employee’s age is prime
        checkAnyAgeIsPrime(employees);
        // Check if all names are uppercase
        checkAllUpperCaseNames(employees);
        // Check if none earn exactly 75,000
        checkNoneEarnsExact(employees, 75_000);
        // Check if any salary equals median salary
        checkAnyEarnsMoreThanMedian(employees);
    }

    private static boolean checkAnyEarnsMoreThanMedian(List<Employee> employees) {
        List<Double> list = employees.stream()
                .map(Employee::getSalary)
                .sorted()
                .toList();
        double median;
        if (list.size() % 2 == 0) {
            median = list.get(list.size() / 2 - 1) + list.get(list.size() / 2) / 2.0;
        } else
            median = list.get(list.size() / 2);

        return employees.stream()
                .anyMatch(e -> e.getSalary() > median);
    }

    private static boolean checkNoneEarnsExact(List<Employee> employees, int i) {
        return employees.stream()
                .noneMatch(e -> e.getSalary() == i);
    }

    private static boolean checkAllUpperCaseNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .allMatch(n -> n.equals(n.toUpperCase()));
    }

    private static boolean checkAnyAgeIsPrime(List<Employee> employees) {
        return employees.stream()
                .anyMatch(e -> isPrime(e.getAge()));
    }

    private static boolean isPrime(final Integer num) {
        if (num <= 1)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static boolean checkNoneOlderThan(List<Employee> employees, int i) {
        return employees.stream()
                .noneMatch(e -> e.getAge() > 40);
    }

    private static boolean checkAllEarnsMoreThan(List<Employee> employees, int i) {
        return employees.stream()
                .allMatch(e -> e.getSalary() > i);
    }

    private static boolean checkNoNameContains(List<Employee> employees, String z) {
        return employees.stream()
                .noneMatch(e -> e.getName().contains(z));
    }

    private static boolean checkNameContains(List<Employee> employees, String i) {
        return employees.stream()
                .anyMatch(e -> e.getName().contains(i));
    }

    private static boolean checkNoneEarnsLessThan(List<Employee> employees, int i) {
        return employees.stream()
                .noneMatch(e -> e.getSalary() < i);
    }

    private static boolean checkAllOlderThan(List<Employee> employees, int i) {
        return employees.stream()
                .allMatch(e -> e.getAge() > i);
    }

    private static boolean checkAnyEarnsMoreThan(List<Employee> employees, int i) {
        return employees.stream()
                .anyMatch(e -> e.getSalary() > i);
    }

    private static boolean checkAllIdGreaterThan(List<Employee> employees, int i) {
        return employees.stream()
                .allMatch(e -> e.getEmpId() > 0);
    }
}
