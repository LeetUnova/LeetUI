package com.leetu.ui;

import java.awt.Color;
import java.awt.Font;

public class LeetUIStyleConfig {
    public Color backgroundColor;
    public Color textColor;
    public Font font;

    public LeetUIStyleConfig(Color backgroundColor, Color textColor, Font font) {
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.font = font;
    }

    public LeetUIStyleConfig(Color backgroundColor, Color textColor) {
        this(backgroundColor, textColor, new Font("Sans-Serif", Font.PLAIN, 20));
    }
}
