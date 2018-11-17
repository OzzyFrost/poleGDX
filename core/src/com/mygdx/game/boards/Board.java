package com.mygdx.game.boards;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.Letter;
import com.mygdx.game.Textures;

public class Board {
    Letter[] hiddenWord;
    int hiddenWordLength = 0;
    float x;
    float y;

    public Board(float x, float y) {
        this.x = x;
        this.y = y;
        hiddenWord = new Letter[25];
    }

    public void render(Batch batch) {
        for (int i = 0; i < hiddenWordLength; i++) {
            batch.draw(Textures.getFont32(), x + i * 32, y, 0, 0, 32, 32, 1, 1, 0,
                    (int) hiddenWord[i].getPos().x, (int) hiddenWord[i].getPos().y,
                    32, 32, false, false);
        }

        for (int i = 0; i < hiddenWordLength; i++) {
            if (!hiddenWord[i].isOpen()) {
                batch.draw(Textures.getFont32(), x + i * 32, y, 0, 0, 32, 32, 1, 1, 0,
                        7*32, 7*32,
                        32, 32, false, false);
            }
        }

    }

    public void setHiddenWord(String s) {
        hiddenWordLength = s.length();
        for (int i = 0; i < hiddenWordLength; i++) {
            hiddenWord[i] = new Letter(s.charAt(i));
        }
        System.out.println(hiddenWord[0].getPos().x + " " + hiddenWord[0].getPos().y);
    }

    public void clearHiddenWord() {
        hiddenWordLength = 0;
    }

    public void openChar(char c) {
        for (int i = 0; i < hiddenWordLength; i++) {
            if (hiddenWord[i].getValue() == c) {
                hiddenWord[i].setOpen(true);
            }
        }
    }

    public boolean theWordSolved() {
        boolean b = true;
        for (int i = 0; i < hiddenWordLength; i++) {
            if (hiddenWord[i].isOpen() == false) {
                b = false;
            }
        }
        return b;
    }

    public int numberOfChar(char c) {
        int number = 0;
        for (int i = 0; i < hiddenWordLength; i++) {
            if ((hiddenWord[i].getValue() == c) && (hiddenWord[i].isOpen() == false)) {
                number++;
            }
        }
        return number;
    }

}
