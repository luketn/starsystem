package com.mycodefu.starsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StarSystem extends JPanel implements ActionListener {
    private final Star star;
    private final List<Planet> planets;
    private final Timer movementTimer;

    public StarSystem(Rectangle bounds) {
        this.setBounds(bounds);
        this.star = Star.random(this.getBounds());
        this.planets = createPlanets(star, 5);
        this.movementTimer = createPlanetMovementTimer();
        this.movementTimer.start();
    }

    private Timer createPlanetMovementTimer() {
        Timer movementTimer = new Timer(5, this);
        movementTimer.setInitialDelay(500);
        return movementTimer;
    }

    private ArrayList<Planet> createPlanets(Star star, int maxPlanets) {
        ArrayList<Planet> planets = new ArrayList<Planet>();
        Random random = new Random();
        int numberOfPlanets = random.nextInt(maxPlanets) + 1;
        for (int i = 1; i < numberOfPlanets; i++) {
            planets.add(Planet.random(star, i));
        }
        return planets;
    }

    @Override
    protected void paintComponent(Graphics g) {
        drawSolarSystem(g);
    }

    private void drawSolarSystem(Graphics g) {
        if (g != null) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            star.draw(g);
            for (Planet planet : planets) {
                planet.draw(g);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (Planet planet : planets) {
            planet.rotate(0.001d);
        }
        this.repaint();
    }
}
