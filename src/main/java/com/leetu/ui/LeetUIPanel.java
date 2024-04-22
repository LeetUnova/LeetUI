package com.leetu.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

import javax.swing.JPanel;

public class LeetUIPanel extends JPanel implements MouseListener, MouseMotionListener {
    private Point mousePos = new Point(4, 2);
    private boolean clicked = false;
    private boolean click = false;
    protected Stack<Consumer<Graphics>> screenStack = new Stack<>();

    public LeetUIPanel() {
        screenStack.push((Graphics g) -> {});
    }

    public void loop() {
        while (true)
            repaint();
    }

    public void loop(BooleanSupplier condition) {
        while (condition.getAsBoolean())
            repaint();
    }

    @Override
    public void paint(Graphics g) {
        LeetUIDraw.rect(g, getBackground(), 0, 0, getWidth(), getHeight());
        screenStack.peek().accept(g);
        clicked = click;
    }

    public void addTo(Container frame) {
        frame.add(this);
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
    }

    private boolean button(Graphics g, String title, Color color, int x, int y, int w, int h, Font font, Color textColor) {
        LeetUIDraw.rect(g, color, x, y, w, h);
        LeetUIDraw.text(g, title, textColor, font, x, y + h / 2);
        return mousePos.x < x + w + 7 && mousePos.x > x + 7 && mousePos.y < y + h + 30 && mousePos.y > y + 30 && click && !clicked;
    }

    protected boolean button(Graphics g, LeetUIButton button) {
        return button(g, button.title, button.style.backgroundColor, button.x, button.y, button.w, button.h, button.style.font, button.style.textColor);
    }

    protected void button(Graphics g, LeetUIButton button, Runnable action) {
        if (button(g, button.title, button.style.backgroundColor, button.x, button.y, button.w, button.h, button.style.font, button.style.textColor))
            action.run();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePos.x = e.getX();
        mousePos.y = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        click = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        click = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}