package com.smkrvasu.versions.version8.streams;

import java.util.Objects;

public class Employee {
    private final Integer empId;
    private final String name;
    private final String email;
    private final String dept;
    private final Integer age;
    private final String gender;
    private final Double salary;

    public Employee(Integer empId, String name, String email, String dept, Integer age, String gender, Double salary) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.dept = dept;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(empId, employee.empId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(empId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dept='" + dept + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDept() {
        return dept;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Double getSalary() {
        return salary;
    }

}