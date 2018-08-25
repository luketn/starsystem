package com.mycodefu.starsystem;

import java.awt.*;
import java.util.Random;

/**
 * A star is a body which is always centered in a bounding rectangle and has:
 * - a range of sizes relative to the bounding rectangle width
 * - a color from orange to white
 */
public class Star extends Body {
    private static Random randomNumbers = new Random();
    private static double minDiameterRatio = 50d/1024d;
    private static double maxDiameterRatio = 80d/1024d;

    private Star(String name, Color color, int diameter, Rectangle bounds) {
        super(name, color, diameter, bounds.width / 2, bounds.height / 2);
    }

    public static Star random(Rectangle bounds) {
        double whiteness = randomNumbers.nextDouble();
        int blue = (int) (255d * whiteness);
        int green = (int) (Color.ORANGE.getGreen() + 55d * whiteness);
        Color starColor = new Color(Color.ORANGE.getRed(), green, blue);

        int maxDiameterInBounds = (int)(maxDiameterRatio * bounds.width);
        int minDiameterInBounds = (int)(minDiameterRatio * bounds.width);
        int diameter = randomNumbers.nextInt(maxDiameterInBounds - minDiameterInBounds) + minDiameterInBounds;

        return new Star(RandomNameGenerator.generateName(), starColor, diameter, bounds);
    }
}
