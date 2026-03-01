package com.smkrvasu.versions.version8.streams;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeUtil.getEmployees();

        // Find sum of salaries
        getSumOfSalary(employees);
        // Find product of ages
        getProductOfAge(employees);
        // Concatenate names with spaces
        getSpacedNames(employees);
        // Find maximum salary
        getMaxSalary(employees);
        // Find minimum age
        getMinAge(employees);
        // Build string of names separated by commas
        getCommaSeparatedNames(employees);
        // Find longest name
        getLongestName(employees);
        // Find shortest name
        getShortestName(employees);
        // Find employee with max salary
        getMaxSalaryEmployee(employees);
        // Compute difference between male and female salaries
        getSalaryDifferenceByGender(employees);
        // Compute difference between highest and lowest salary
        getSalaryDiff(employees);
    }

    private static double getSalaryDiff(List<Employee> employees) {
        DoubleSummaryStatistics stats = employees.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
        return stats.getMax() - stats.getMin();
    }

    private static double getSalaryDifferenceByGender(List<Employee> employees) {
        Double male = employees.stream()
                .filter(e -> e.getGender().equals("Male"))
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        Double female = employees.stream()
                .filter(e -> e.getGender().equals("Female"))
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        return Math.abs(male - female);
    }

    private static Optional<Employee> getMaxSalaryEmployee(List<Employee> employees) {
        return employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
    }

    private static Optional<String> getShortestName(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .reduce((e1, e2) -> e1.length() < e2.length() ? e1 : e2);
    }

    private static Optional<String> getLongestName(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .max(Comparator.comparingInt(String::length));
    }

    private static String getCommaSeparatedNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
    }

    private static int getMinAge(List<Employee> employees) {
        return employees.stream()
                .mapToInt(Employee::getAge)
                .min()
                .orElse(0);
    }

    private static double getMaxSalary(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0.0);
    }

    private static String getSpacedNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(" "));
    }

    private static int getProductOfAge(List<Employee> employees) {
        return employees.stream()
                .mapToInt(Employee::getAge)
                .reduce(1, (a, b) -> a * b);
    }

    private static Double getSumOfSalary(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}
