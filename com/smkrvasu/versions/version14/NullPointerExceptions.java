package com.smkrvasu.versions.version14;

public class NullPointerExceptions {

    public static void main(String[] args) {
        String street = new Employee().getPersonal().getAddress().street;
    }
}

class Employee {
    Personal personal;

    public Personal getPersonal() {
        return personal;
    }
}

class Personal {
    Address address;

    public Address getAddress() {
        return address;
    }
}

class Address {
    String street;
}