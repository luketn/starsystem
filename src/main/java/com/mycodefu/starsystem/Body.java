package com.mycodefu.starsystem;

import java.awt.*;

public class Body {
    private String name;
    protected Color color;
    protected int diameter;
    protected int x;
    protected int y;

    public Body(String name, Color color, int diameter, int x, int y) {
        this.name = name;
        this.color = color;
        this.diameter = diameter;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - diameter / 2, y - diameter / 2, diameter, diameter);
    }
}
