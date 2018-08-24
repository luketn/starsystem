package com.mycodefu.starsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main implements KeyListener {
    private final JFrame jFrame;
    private StarSystem starSystem;

    private Main() {
        this.jFrame = new JFrame("Star System");
        jFrame.setFocusable(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.addKeyListener(this);
    }

    private void createStarSystem() {
        if (starSystem != null) {
            jFrame.remove(starSystem);
        }
        int width;
        int height;
        if (jFrame.getBounds().width > 0) {
            width = jFrame.getBounds().width;
            height = jFrame.getBounds().height;
        } else {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            width = screenSize.width;
            height = screenSize.height;
        }
        starSystem = new StarSystem(new Rectangle(0, 0, width, height));
        jFrame.add(starSystem);
    }

    private void show() {
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.createStarSystem();
        main.show();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            createStarSystem();
        }
    }
}
