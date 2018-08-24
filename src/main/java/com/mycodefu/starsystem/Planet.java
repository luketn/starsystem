package com.mycodefu.starsystem;

import java.awt.*;
import java.util.Random;

public class Planet extends Body {
    private final Star star;
    private final int distanceFromStar;

    private double angle;

    private static final Random random = new Random();

    private Planet(Color planetColor, int diameter, Star star, int distanceFromStar, double angle) {
        super(planetColor, diameter, calculateX(star, distanceFromStar, angle), calculateY(star, distanceFromStar, angle));
        this.star = star;
        this.distanceFromStar = distanceFromStar;
        this.angle = angle;
    }

    private static int calculateX(Star star, int distanceFromStar, double angle) {
        double cos = Math.cos(angle);
        int radius = calculateRadius(star, distanceFromStar);
        return star.getX() + (int) (cos * radius);
    }

    private static int calculateY(Star star, int distanceFromStar, double angle) {
        double sin = Math.sin(angle);
        int radius = calculateRadius(star, distanceFromStar);
        return star.getY() + (int) (sin * radius);
    }

    private static int calculateRadius(Star star, int distanceFromStar) {
        return star.getDiameter() / 2 + distanceFromStar;
    }

    public static Planet random(Star star, int numberOutFromStar) {
        Color planetColor = new Color(100 + random.nextInt(155), 100 + random.nextInt(155), 100 + random.nextInt(155));
        int distanceFromStar = 50 * numberOutFromStar;
        int planetDiameter = 15 + random.nextInt(20);
        double angle = random.nextDouble() * 360d;
        return new Planet(planetColor, planetDiameter, star, distanceFromStar, angle);
    }


    public void rotate(double increment) {
        if (this.angle < (360 - increment)) {
            this.angle = this.angle + increment;
        } else {
            this.angle = 0;
        }
        this.x = calculateX(star, distanceFromStar, angle);
        this.y = calculateY(star, distanceFromStar, angle);
    }
}
