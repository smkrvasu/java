package com.smkrvasu.versions.version8.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectDemo {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeUtil.getEmployees();

        // Collect IDs into a Set
        getIdsSet(employees);
        // Collect employees into Map<ID, Name>
        getIdNameMap(employees);
        // Collect names into comma-separated string
        getCommaSeparatedNames(employees);
        // Collect employees into Map<Name, Age>
        getNameAndAge(employees);
        // Collect salaries into TreeSet
        getTreeSetSalary(employees);
        // Collect employees into LinkedList
        getLinkedEmployees(employees);
        // Collect employees into Map<FirstLetter, List<Employee>>
        getFirstLetterMap(employees);
        // Collect salaries into monthly salary list (salary ÷ 12)
        getMonthlySalary(employees);
        // Collect employees into Map<Boolean, List<Employee>> (salary > 50k)
        getPartitionBySalary(employees, 50000.0);
        // Collect employees into Map<ID, Employee>
        getEmployeeIdMap(employees);
        // Collect names into SortedSet
        getSortedNames(employees);
        // Collect employees into Map<Gender, TotalSalary>
        getTotSalaryByGender(employees);
        // Collect employees into Map<Gender, Count>
        getCountByGender(employees);
    }

    private static Map<String, Long> getCountByGender(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }

    private static Map<String, Double> getTotSalaryByGender(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.summingDouble(Employee::getSalary)));
    }

    private static Set<String> getSortedNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private static Map<Integer, Employee> getEmployeeIdMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
    }

    private static Map<Boolean, List<Employee>> getPartitionBySalary(List<Employee> employees, double v) {
        return employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > v));
    }

    private static List<Double> getMonthlySalary(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.getSalary() / 12)
                .toList();
    }

    private static Map<Character, List<Employee>> getFirstLetterMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.getName().charAt(0)));
    }

    private static LinkedList<Employee> getLinkedEmployees(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private static TreeSet<Double> getTreeSetSalary(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private static Map<String, Integer> getNameAndAge(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getAge));
    }

    private static String getCommaSeparatedNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
    }

    private static Map<Integer, String> getIdNameMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(Employee::getEmpId, Employee::getName));
    }

    private static Set<Integer> getIdsSet(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getEmpId)
                .collect(Collectors.toSet());
    }
}
