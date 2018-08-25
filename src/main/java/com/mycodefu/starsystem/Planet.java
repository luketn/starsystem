package com.mycodefu.starsystem;

import java.awt.*;
import java.util.Random;

public class Planet extends Body {
    private final String name;
    private final Color planetColor;
    private final int diameter;
    private final boolean rings;
    private final Color ringColor;
    private final Star star;
    private final int distanceFromStar;

    private double angle;

    private static final Random random = new Random();

    private Planet(String name, Color planetColor, int diameter, boolean rings, Color ringColor, Star star, int distanceFromStar, double angle) {
        super(planetColor, diameter, calculateX(star, distanceFromStar, angle), calculateY(star, distanceFromStar, angle));
        this.name = name;
        this.planetColor = planetColor;
        this.diameter = diameter;
        this.rings = rings;
        this.ringColor = ringColor;
        this.star = star;
        this.distanceFromStar = distanceFromStar;
        this.angle = angle;
    }

    public String getName() {
        return name;
    }

    public Color getPlanetColor() {
        return planetColor;
    }

    public boolean hasRings() {
        return rings;
    }

    public Color getRingColor() {
        return ringColor;
    }

    public double getAngle() {
        return angle;
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
        Color ringColor = new Color(100 + random.nextInt(155), 100 + random.nextInt(155), 100 + random.nextInt(155));

        random.nextBoolean();

        String name = RandomNameGenerator.generateName();

        return new Planet(name, planetColor, planetDiameter, random.nextBoolean(), ringColor, star, distanceFromStar, angle);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        if (rings) {
            int startX = this.x - diameter / 2 - 5;
            int startY = this.y - diameter / 2 - 5;
            Color color = ringColor;
            for (int i = 0; i < 5; i++) {
                color = color.darker();
                g.setColor(color);

                g.drawOval(startX - i, startY - i, diameter + 10 + i * 2, diameter + 10 + i * 2);
            }
        }
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
