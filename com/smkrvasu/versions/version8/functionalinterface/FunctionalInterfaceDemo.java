package com.smkrvasu.versions.version8.functionalinterface;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.function.Function;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        Supplier<List<Apple>> supplier = () -> {
            List<Apple> apples = new ArrayList<>();
            apples.add(new Apple("Red", 150.0, "Sweet", "Crispy"));
            apples.add(new Apple("Green", 130.0, "Sour", "Crunchy"));
            apples.add(new Apple("Red", 180.0, "Sweet", "Juicy"));
            apples.add(new Apple("Yellow", 160.0, "Sweet", "Soft"));
            return apples;
        };

        Predicate<Apple> isRed = apple -> "Red".equals(apple.getColor());
        Predicate<Apple> isHeavy = apple -> apple.getWeight() >= 150;
        Predicate<Apple> isJuicy = apple -> "Juicy".equals(apple.getTexture());

        Function<Apple, String> describe = apple ->
                apple.getColor() + " apple, " +
                        apple.getWeight() + "g, " +
                        apple.getTaste() + ", " +
                        apple.getTexture();

        List<Apple> apples = supplier.get();
        apples.stream()
                .filter(isRed.and(isHeavy).and(isJuicy.negate()))
                .map(describe)
                .forEach(System.out::println);
    }
}

class Apple {
    private String color;
    private Double weight;
    private String taste;
    private String texture;

    public Apple(String color, Double weight, String taste, String texture) {
        this.color = color;
        this.weight = weight;
        this.taste = taste;
        this.texture = texture;
    }

    public String getColor() {
        return color;
    }

    public Double getWeight() {
        return weight;
    }

    public String getTaste() {
        return taste;
    }

    public String getTexture() {
        return texture;
    }
}