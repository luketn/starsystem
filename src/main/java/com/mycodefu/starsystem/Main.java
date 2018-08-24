package com.mycodefu.starsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main implements KeyListener {
    final JFrame jFrame;
    StarSystem comp;

    public Main() {
        this.jFrame = new JFrame("Star System");
        jFrame.setFocusable(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.addKeyListener(this);
    }

    private void createStarSystem() {
        if (comp != null) {
            jFrame.remove(comp);
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        comp = new StarSystem(new Rectangle(0, 0, screenSize.width, screenSize.height));
        jFrame.add(comp);
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
