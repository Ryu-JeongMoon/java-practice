package org.designpattern.structure.flyweight._01_before;

public class Character {

    private final char value;

    private final String color;

    private final String fontFamily;

    private final int fontSize;

    public Character(char value, String color, String fontFamily, int fontSize) {
        this.value = value;
        this.color = color;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }
}
