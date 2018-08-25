package com.mycodefu.starsystem;

import java.util.Random;

public class RandomNameGenerator {
    private static Random random = new Random();

    private static String[] PREFIXES = {"Ter", "Pot", "Rep", "Tan", "Bar", "Pol", "Pow", "Lok", "Law", "Ple"};
    private static String[] MIDDLES = {"o", "ee", "ou", "a", "i", "er", "at"};
    private static String[] SUFFIXES = {"", "let", "pan", "fin", "et", "set", "jet", "as", "ier"};

    public static String generateName() {
        return PREFIXES[random.nextInt(PREFIXES.length)] +
                MIDDLES[random.nextInt(MIDDLES.length)] +
                SUFFIXES[random.nextInt(SUFFIXES.length)];
    }
}
