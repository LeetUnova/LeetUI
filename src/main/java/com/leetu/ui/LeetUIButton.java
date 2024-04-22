package com.leetu.ui;

import java.awt.Color;
import java.awt.Font;

public class LeetUIButton {
    public String title;
    public int x;
    public int y;
    public int w;
    public int h;
    public LeetUIStyleConfig style;

    public LeetUIButton(String title, Color backgroundColor, int x, int y, int w, int h, Color textColor, Font font) {
        this.title = title;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        style = new LeetUIStyleConfig(backgroundColor, textColor, font);
    }

    public LeetUIButton(String title, int x, int y, int w, int h, LeetUIStyleConfig style) {
        this.title = title;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.style = style;
    }
}
