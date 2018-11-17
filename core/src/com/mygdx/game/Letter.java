package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Letter {
    private char value;
    private boolean open;
    private Vector2 pos = new Vector2();
    private static String chars = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ 1234567890-+*:!?%()=,./;      ";

    public Letter(char value) {
        if (chars.indexOf(value) > -1) {
            this.value = value;
        } else {
            this.value = ' ';
        }
        open = false;
    }

    public char getValue() {
        return value;
    }

    public boolean isOpen() {
        return open;
    }

    public Vector2 getPos() {
        pos.x = (chars.indexOf(value) % 8) * 32;
        pos.y = ((chars.indexOf(value) / 8)) * 32;
        return pos;
    }

    public static int getIndex(double x, double y) {
        return (int) (Math.floor((256 - y) / 32) * 8 + Math.floor(x / 32));
    }

    public char getChar(double x, double y) {
        if (getIndex(x, y) < chars.length()) {
            return chars.charAt(getIndex(x, y));
        } else return ' ';
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public static String getChars() {
        return chars;
    }
}
