package com.smkrvasu.versions.version8.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class FilterDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeUtil.getEmployees();
        // Find employees with salary > 50,000
        findBySalaryGreaterThan(employees, 50000.0);
        // Get employees whose names start with "A"
        findByEmployeeNameStartsWith(employees, "A");
        // Select employees younger than 30 and earning < 40,000
        findByYoungerThanAndSalaryLessThan(employees, 30, 40000.0);
        // Find employees with salary between 30,000 and 60,000
        findBySalaryBetween(employees, 30000.0, 50000.0);
        // Get employees whose names are longer than 3 characters
        findByEmployeeNameLongerThan(employees, 3);
        // Select employees who are male and older than 28
        findByGenderAndOlderThan(employees, "Male", 28);
        // Find employees whose salary ≠ 50,000
        findBySalaryNotEqualTo(employees, 50000.0);
        // Get employees whose names contain exactly 3 characters
        findByEmployeeNameLength(employees, 3);
        // Select employees who are male and earn more than the average salary
        findByGenderWithAboveAverageSalary(employees, "Male");
        // Find employees whose names end with "C"
        findByEmployeeNameEndsWith(employees, "C");
        // Get employees with salaries that are multiples of 10,000
        findBySalaryMultipleOf(employees, 10000.0);
        // Select employees younger than the average age
        findByYoungerThanAverageAge(employees);
        // Find employees whose names contain at least one vowel
        findByEmployeeNameWithVowel(employees);
        // Get employees with salaries greater than the median salary
        findBySalaryGreaterThanMedian(employees);
        // Select employees older than 25 but younger than 35
        findByAgeBetween(employees, 25, 35);
        // Find employees whose IDs are even numbers
        findByEmployeeIdIsEven(employees);
        // Get employees whose names are palindromes
        findByEmployeeNameIsPalindrome(employees);
    }

    private static List<String> findByEmployeeNameIsPalindrome(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .filter(n -> IntStream.range(0, n.length() / 2)
                        .allMatch(i -> n.charAt(i) == n.indexOf(n.length() - i - 1)))
                .toList();
    }

    private static List<Employee> findByEmployeeIdIsEven(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.getEmpId() % 2 == 0)
                .toList();
    }

    private static List<Employee> findByAgeBetween(List<Employee> employees, int min, int max) {
        return employees.stream()
                .filter(EmployeePredicate.ageBetween(min, max))
                .toList();
    }

    private static List<Employee> findBySalaryGreaterThanMedian(List<Employee> employees) {
        List<Double> sortedSalaries = employees.stream()
                .map(Employee::getSalary)
                .sorted()
                .toList();

        double medianSalary;
        int size = sortedSalaries.size();
        if (size % 2 == 0)
            medianSalary = (sortedSalaries.get(size / 2 - 1) + sortedSalaries.get(size / 2)) / 2.0;
        else
            medianSalary = sortedSalaries.get(size / 2);

        return employees.stream()
                .filter(e -> e.getSalary() > medianSalary)
                .toList();
    }

    private static List<Employee> findByEmployeeNameWithVowel(List<Employee> employees) {
        Pattern vowel = Pattern.compile("AEIOUaeiou");
        return employees.stream()
                .filter(e -> vowel.matcher(e.getName()).find())
                .toList();
    }

    private static List<Employee> findByYoungerThanAverageAge(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.getAge() < getAverageAge(employees))
                .toList();
    }

    private static List<Employee> findBySalaryMultipleOf(List<Employee> employees, double multiple) {
        return employees.stream()
                .filter(e -> e.getSalary() % multiple == 0)
                .toList();
    }

    private static List<Employee> findByEmployeeNameEndsWith(List<Employee> employees, String suffix) {
        return employees.stream()
                .filter(e -> e.getName().endsWith(suffix))
                .toList();
    }

    private static List<Employee> findByGenderWithAboveAverageSalary(List<Employee> employees, String gen) {
        Predicate<Employee> aboveAvgSalary = e -> e.getSalary() > getAverageAge(employees);
        return employees.stream()
                .filter(EmployeePredicate.genderEquals(gen).and(aboveAvgSalary))
                .toList();
    }

    private static double getAverageAge(List<Employee> employees) {
        return employees.stream()
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0.0);
    }

    private static List<Employee> findByEmployeeNameLength(List<Employee> employees, int len) {
        return employees.stream()
                .filter(e -> e.getName().length() == len)
                .toList();
    }

    private static List<Employee> findBySalaryNotEqualTo(List<Employee> employees, double sal) {
        return employees.stream()
                .filter(e -> e.getSalary() != sal)
                .toList();
    }

    private static List<Employee> findByGenderAndOlderThan(List<Employee> employees, String gen, int age) {
        return employees.stream()
                .filter(EmployeePredicate.genderEquals(gen).and(EmployeePredicate.olderThan(age)))
                .toList();
    }

    private static List<Employee> findByEmployeeNameLongerThan(List<Employee> employees, int len) {
        return employees.stream()
                .filter(e -> e.getName().length() > len)
                .toList();
    }

    private static List<Employee> findBySalaryBetween(List<Employee> employees, double min, double max) {
        return employees.stream()
                .filter(e -> e.getSalary() > min && e.getSalary() < max)
                .toList();
    }

    private static List<Employee> findByYoungerThanAndSalaryLessThan(List<Employee> employees, int age, double salary) {
        return employees.stream()
                .filter(EmployeePredicate.youngerThan(age).and(EmployeePredicate.salaryLessThan(salary)))
                .toList();
    }

    private static List<Employee> findByEmployeeNameStartsWith(List<Employee> employees, String prefix) {
        return employees.stream()
                .filter(e -> e.getName().startsWith(prefix))
                .toList();
    }

    private static List<Employee> findBySalaryGreaterThan(List<Employee> employees, Double salary) {
        return employees.stream()
                .filter(e -> e.getSalary() > salary)
                .toList();
    }
}
