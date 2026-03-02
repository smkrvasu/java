package com.smkrvasu.versions.version8.streams;

import java.util.List;

public class MapDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeUtil.getEmployees();

        // Extract list of names
        mapEmployeeNames(employees);
        // Create list of ages doubled
        mapDoubledEmployeeAge(employees);
        // Convert employees into "Name - Salary" strings
        mapNameAndSalary(employees);
        // Create list of name lengths
        mapNameLengths(employees);
        // Map employees to "ID:Name:Age"
        mapIdNameAge(employees);
        // Transform salaries into annual bonus = salary × 0.1
        mapBonus(employees);
        // Create list of initials
        mapInitials(employees);
        // Map employees to boolean list: salary > 60,000
        mapSalaryGreaterThan(employees, 60000.0);
        // Transform employees into "Name (Age years old)"
        mapEmployeeNameAge(employees);
        // Map employees to year of birth (assuming 2026)
        mapYearOfBirth(employees);
        // Create strings like "Employee ABC earns 50000"
        mapNameAndEarnings(employees);
        // Map employees to boolean: age is even
        mapEvenAge(employees);
        // Map employees to lowercase names
        mapLowerCaseNames(employees);
        // Map employees to "Name earns Salary per year"
        mapNameAndSalaryPerYear(employees);
        // Map employees to age category: Young/Mid/Senior
        mapAgeCategory(employees);
        // Map employees to boolean: salary above group average
        mapSalaryAboveAvg(employees);
        // Map employees to (Name, Salary) pairs
        mapNameAndSalaryPair(employees);
    }

    private static List<String> mapNameAndSalaryPair(List<Employee> employees) {
        return employees.stream()
                .map(e -> String.format("(%s, %.0f)", e.getName(), e.getSalary()))
                .toList();
    }

    private static List<Boolean> mapSalaryAboveAvg(List<Employee> employees) {
        double average = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        return employees.stream()
                .map(e -> e.getSalary() > average)
                .toList();
    }

    private static List<String> mapAgeCategory(List<Employee> employees) {
        return employees.stream()
                .map(e -> {
                    if (e.getAge() < 30)
                        return "Young";
                    else if (e.getAge() < 50)
                        return "Mid";
                    else
                        return "Senior";
                })
                .toList();
    }

    private static List<String> mapNameAndSalaryPerYear(List<Employee> employees) {
        return employees.stream()
                .map(e -> String.format("%s earns %.0f per year", e.getName(), e.getSalary() * 12))
                .toList();
    }

    private static List<String> mapLowerCaseNames(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.getName().toLowerCase())
                .toList();
    }

    private static List<Boolean> mapEvenAge(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.getAge() % 2 == 0)
                .toList();
    }

    private static List<String> mapNameAndEarnings(List<Employee> employees) {
        return employees.stream()
                .map(e -> String.format("Employee %s earns %.0f", e.getName(), e.getSalary()))
                .toList();
    }

    private static List<Integer> mapYearOfBirth(List<Employee> employees) {
        return employees.stream()
                .map(e -> 2026 - e.getAge())
                .toList();
    }

    private static List<String> mapEmployeeNameAge(List<Employee> employees) {
        return employees.stream()
                .map(e -> String.format("%s (%d years old)", e.getName(), e.getAge()))
                .toList();
    }

    private static List<Boolean> mapSalaryGreaterThan(List<Employee> employees, double v) {
        return employees.stream()
                .map(e -> e.getSalary() > v)
                .toList();
    }

    private static List<String> mapInitials(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.getName().substring(0, 1))
                .toList();
    }

    private static List<Double> mapBonus(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.getSalary() * 0.1)
                .toList();
    }

    private static List<String> mapIdNameAge(List<Employee> employees) {
        return employees.stream()
                .map(e -> String.join(":", String.valueOf(e.getEmpId()), e.getName(), String.valueOf(e.getAge())))
                .toList();
    }

    private static List<Integer> mapNameLengths(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.getName().length())
                .toList();
    }

    private static List<String> mapNameAndSalary(List<Employee> employees) {
        return employees.stream()
                .map(e -> new StringBuilder(e.getName()).append(" - ").append(e.getSalary()).toString())
                .toList();
    }

    private static List<Integer> mapDoubledEmployeeAge(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.getAge() * 2)
                .toList();
    }

    private static List<String> mapEmployeeNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .toList();
    }
}
