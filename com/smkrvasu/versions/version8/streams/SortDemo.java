package com.smkrvasu.versions.version8.streams;

import java.util.Comparator;
import java.util.List;

public class SortDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeUtil.getEmployees();

        // Sort employees by age ascending
        sortByAgeAsc(employees);
        // Sort employees by salary descending
        sortBySalaryDesc(employees);
        // Sort employees first by gender, then by name
        sortByGenderAndName(employees);
        // Sort employees by salary, then by age if equal
        sortBySalaryAndAge(employees);
        // Sort employees by name length
        sortByEmployeeNameLen(employees);
        // Sort employees by ID in reverse order
        sortByEmployeeIdDesc(employees);
        // Sort employees by salary, then by name length if equal
        sortBySalaryAndNameLen(employees);
        // Sort employees by age, but place females before males if equal
        sortByGenderAndAge(employees);
        // Sort employees by salary modulo 10,000
        sortByModSalary(employees, 10000.0);
        // Sort employees by salary, break ties with reverse alphabetical names
        sortBySalaryAndNameDesc(employees);
        // Sort employees by age, but place those earning >50,000 first
        sortByAgeAndSalary(employees, 50000.0);
        // Sort employees by length of gender string
        sortByGenderLen(employees);
        // Sort employees by salary-to-age ratio
        sortBySalaryToAgeRatio(employees);
        // Sort employees by reverse of their name string
        sortByEmployeeNameReverse(employees);
        // Sort employees by age, but place odd IDs first
        sortByAgeAndOddId(employees);
        // Sort employees by ASCII value of first character of name
        sortByEmployeeNameFirst(employees);
    }

    private static List<Employee> sortByEmployeeNameFirst(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(e -> e.getName().charAt(0)))
                .toList();
    }

    private static List<Employee> sortByAgeAndOddId(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingInt((Employee e) -> e.getEmpId() % 2 == 0 ? 1 : 0)
                        .thenComparingInt(Employee::getAge))
                .toList();
    }

    private static List<Employee> sortByEmployeeNameReverse(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(e -> new StringBuilder(e.getName()).reverse().toString()))
                .toList();
    }

    private static List<Employee> sortBySalaryToAgeRatio(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(e -> e.getSalary() / e.getAge()))
                .toList();
    }

    private static List<Employee> sortByGenderLen(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(e -> e.getGender().length()))
                .toList();
    }

    private static List<Employee> sortByAgeAndSalary(List<Employee> employees, double v) {
        return employees.stream()
                .sorted(Comparator.comparing((Employee e) -> e.getSalary() > v ? 0 : 1)
                        .thenComparingDouble(Employee::getAge))
                .toList();
    }

    private static List<Employee> sortBySalaryAndNameDesc(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                        .thenComparing((e1, e2) -> e2.getName().compareTo(e1.getName())))
                .toList();
    }

    private static List<Employee> sortByModSalary(List<Employee> employees, double mod) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(e -> e.getSalary() % mod))
                .toList();
    }

    private static List<Employee> sortByGenderAndAge(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge)
                        .thenComparing(Employee::getGender,
                                Comparator.comparing(g -> g.equalsIgnoreCase("Female") ? 0 : 1)))
                .toList();
    }

    private static List<Employee> sortBySalaryAndNameLen(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                        .thenComparing(e -> e.getName().length()))
                .toList();
    }

    private static List<Employee> sortByEmployeeIdDesc(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getEmpId).reversed())
                .toList();
    }

    private static List<Employee> sortByEmployeeNameLen(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingInt(e -> e.getName().length()))
                .toList();
    }

    private static List<Employee> sortBySalaryAndAge(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)
                        .thenComparingInt(Employee::getAge))
                .toList();
    }

    private static List<Employee> sortByGenderAndName(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getGender)
                        .thenComparing(Employee::getName))
                .toList();
    }

    private static List<Employee> sortBySalaryDesc(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();
    }

    private static List<Employee> sortByAgeAsc(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .toList();
    }
}
