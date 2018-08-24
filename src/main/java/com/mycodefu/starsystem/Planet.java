package com.mycodefu.starsystem;

import java.awt.*;

public class Planet extends Body {
    private final Star star;
    private final int distanceFromStar;
    private double angle;

    public Planet(Color planetColor, int diameter, Star star, int distanceFromStar, double angle) {
        super(planetColor, diameter, calculateXPosition(star, distanceFromStar, angle), calculateYPosition(star, distanceFromStar, angle));
        this.star = star;
        this.distanceFromStar = distanceFromStar;
        this.angle = angle;
    }

    private static int calculateXPosition(Star star, int distanceFromStar, double angle) {
        double cos = Math.cos(angle);
        int radius = calculateRadius(star, distanceFromStar);
        return star.getX() + (int)(cos * radius);
    }

    private static int calculateYPosition(Star star, int distanceFromStar, double angle) {
        double sin = Math.sin(angle);
        int radius = calculateRadius(star, distanceFromStar);
        return star.getY() + (int)(sin * radius);
    }

    private static int calculateRadius(Star star, int distanceFromStar) {
        return star.getDiameter() / 2 + distanceFromStar;
    }

    public void rotate() {
        if (this.angle < 359.99d) {
            this.angle = this.angle +0.01d;
        } else {
            this.angle = 0;
        }
        this.x = calculateXPosition(star, distanceFromStar, angle);
        this.y = calculateYPosition(star, distanceFromStar, angle);
    }
}
