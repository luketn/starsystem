package com.mycodefu.starsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StarSystem extends JPanel implements ActionListener {

    public static void main(String[] args) {
        final JFrame jFrame = new JFrame("Star System");
        jFrame.setFocusable(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.add(new StarSystem(new Rectangle(0, 0, screenSize.width, screenSize.height)));
    }

    private final Star star;
    private final List<Planet> planets;
    private final Timer movementTimer;

    public StarSystem(Rectangle bounds) {
        this.setBounds(bounds);
        star = Star.random(this.getBounds());
        planets = new ArrayList<Planet>();

        Random random = new Random();
        int numberOfPlanets = random.nextInt(5);
        for (int i = 1; i < numberOfPlanets + 1; i++) {
            Color planetColor = new Color(100 + random.nextInt(155), 100 + random.nextInt(155), 100 + random.nextInt(155));
            int distanceFromStar = 50 * i;
            int planetDiameter = 15 + random.nextInt(20);
            double angle = random.nextDouble() * 360d;
            planets.add(new Planet(planetColor, planetDiameter, star, distanceFromStar, angle));
        }

        movementTimer = new Timer(30, this);
        movementTimer.setInitialDelay(500);
        movementTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        drawSolarSystem(g);
    }

    private void drawSolarSystem(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        star.draw(g);
        for (Planet planet : planets) {
            planet.draw(g);
        }
    }


    public void actionPerformed(ActionEvent e) {
        for (Planet planet : planets) {
            planet.rotate();
        }
        drawSolarSystem(this.getGraphics());
    }
}
