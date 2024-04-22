package com.leetu.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class LeetUIDraw {
    public static void rect(Graphics g, Color color, int x, int y, int w, int h) {
        g.setColor(color);
        g.fillRect(x, y, w, h);
    }

    public static void text(Graphics g, String text, Color color, Font font, int x, int y) {
        g.setColor(color);
        g.setFont(font);
        g.drawString(text, x, y);
    }
}
