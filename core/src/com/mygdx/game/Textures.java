package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Textures {
    private static Texture baraban = new Texture("baraban512.png");
    private static Texture strelka = new Texture("strelka.png");
    private static Texture background = new Texture("background64.png");
    private static Texture font32 = new Texture("font32.png");
    private static Texture yakubovich = new Texture("yakubovich256.png");
    private static Texture words = new Texture("ww.png");

    public static Texture getBaraban() {
        return baraban;
    }

    public static Texture getStrelka() {
        return strelka;
    }

    public static Texture getBackground() { return background; }

    public static Texture getFont32() {
        return font32;
    }

    public static Texture getYakubovich() { return yakubovich; }

    public static Texture getWords() { return words; }
}
