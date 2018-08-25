package com.mycodefu.starsystem;

public class RandomNameGeneratorTest {

    @org.junit.Test
    public void generateName() {
        for (int i = 0; i < 2000; i++) {
            System.out.println(RandomNameGenerator.generateName());
        }
    }
}