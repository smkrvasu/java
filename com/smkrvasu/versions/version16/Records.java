package com.smkrvasu.versions.version16;

public class Records {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 5);
        System.out.println(rectangle.area());
    }
}

record Rectangle(Integer height, Integer width) {
    public Integer area() {
        return height * width;
    }
}
