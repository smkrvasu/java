package com.smkrvasu.versions.version8.streams;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GroupingDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeUtil.getEmployees();

        // Group employees by gender
        groupByGender(employees);
        // Group employees by age bracket (<30, 30–40, >40)
        groupByAgeBracket(employees);
        // Group employees by first letter of name
        groupByFirstLetter(employees);
        // Group employees by salary range (<40k, 40–70k, >70k)
        groupBySalaryRange(employees);
        // Group employees by even/odd ID
        groupByOddEvenId(employees);
        // Group employees by whether name contains a vowel
        groupHavingVowelsInName(employees);
        // Group employees by even/odd age
        groupByOddEvenAge(employees);
        // Group employees by salary range and count each group
        groupBySalaryRangeCount(employees);
        // Group employees by gender and average age
        groupByGenderAndAvgAge(employees);
        // Group employees by salary above/below average
        groupBySalaryAvg(employees);
    }

    private static Map<String, List<Employee>> groupBySalaryAvg(List<Employee> employees) {
        double avg = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.getSalary() > avg ? "AboveAvg" : "BelowAvg"));
    }

    private static Map<String, Double> groupByGenderAndAvgAge(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
    }

    private static Map<String, Long> groupBySalaryRangeCount(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> {
                    Double salary = e.getSalary();
                    if (salary < 40_000)
                        return "<40k";
                    else if (salary <= 70_000)
                        return "40-70k";
                    else
                        return ">70k";
                }, Collectors.counting()));
    }

    private static Map<String, List<Employee>> groupByOddEvenAge(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.getAge() % 2 == 0 ? "Even" : "Odd"));
    }

    private static Map<String, List<Employee>> groupHavingVowelsInName(List<Employee> employees) {
        Pattern vowels = Pattern.compile("[AEIOUaeiou]");
        return employees.stream()
                .collect(Collectors.groupingBy(e -> vowels.matcher(e.getName()).find() ? "hasVowel" : "noVowel"));
    }

    private static Map<String, List<Employee>> groupByOddEvenId(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.getEmpId() % 2 == 0 ? "Even" : "Odd"));
    }

    private static Map<String, List<Employee>> groupBySalaryRange(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> {
                    if (e.getSalary() < 40_000)
                        return "<40k";
                    else if (e.getSalary() <= 70_000)
                        return "40-70k";
                    else
                        return ">70k";
                }));
    }

    private static Map<Character, List<Employee>> groupByFirstLetter(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.getName().charAt(0)));
    }

    private static Map<String, List<Employee>> groupByAgeBracket(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> {
                    if (e.getAge() < 30)
                        return "<30";
                    else if (e.getAge() <= 40)
                        return "30-40";
                    else
                        return ">40";
                }));
    }

    private static Map<String, List<Employee>> groupByGender(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender));
    }
}
