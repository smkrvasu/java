package com.smkrvasu.versions.version17;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class PRNGDemo {
    public static void main(String[] args) {
        RandomGeneratorFactory<RandomGenerator> factory = RandomGeneratorFactory.of("L64X128MixRandom");
        RandomGenerator random = factory.create();

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }
    }
}
