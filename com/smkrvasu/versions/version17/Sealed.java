package com.smkrvasu.versions.version17;

public class Sealed {
    public static void main(String[] args) {
        new Shape();
        new Circle();
        new Square();
        new Rectangle();
    }
}

sealed class Shape permits Circle, Square, Rectangle {
    Shape() {
        System.out.println("Shape");
    }
}

final class Circle extends Shape {
    Circle() {
        System.out.println("Circle");
    }
}

final class Square extends Shape {
    Square() {
        System.out.println("Square");
    }
}

non-sealed class Rectangle extends Shape {
    Rectangle() {
        System.out.println("Rectangle");
    }
}