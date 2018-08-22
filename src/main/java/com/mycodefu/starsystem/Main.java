package com.mycodefu.starsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JPanel implements ActionListener {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Star System");
        jFrame.add(new Main());
        jFrame.setFocusable(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        drawSolarSystem(g);
    }

    private void drawSolarSystem(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        drawStar(g, 50, 80);

        Timer timer = new Timer(30, this);
        timer.setInitialDelay(500);
        timer.start();
    }

    private void drawStar(Graphics g, int minDiameter, int maxDiameter) {
        Random random = new Random();

        double whiteness = random.nextDouble();
        int blue = (int) (255d * whiteness);
        int green = (int) (Color.ORANGE.getGreen() + 55d * whiteness);
        Color starColor = new Color(Color.ORANGE.getRed(), green, blue);
        g.setColor(starColor);

        int diameter = random.nextInt(maxDiameter - minDiameter) + minDiameter;

        g.fillOval(this.getWidth() / 2 - diameter / 2, this.getHeight() / 2 - diameter / 2, diameter, diameter);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
