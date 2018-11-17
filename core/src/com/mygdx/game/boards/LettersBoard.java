package com.mygdx.game.boards;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Letter;
import com.mygdx.game.Textures;

public class LettersBoard {
    private float x;
    private float y;
    private int h;
    private Letter[] letters;
    private boolean enable = false;

    public LettersBoard(float x, float y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
        letters = new Letter[h * 8];
        for (int i = 0; i < Letter.getChars().length(); i++) {
            letters[i] = new Letter(Letter.getChars().charAt(i));
        }
    }

    public void render(Batch batch) {
        batch.draw(Textures.getFont32(), x, y, 0, 0, 8 * 32, h * 32, 1, 1, 0,
                0, 0, 8 * 32, h * 32, false, false);

        for (int i = 0; i < Letter.getChars().length(); i++) {
            if (letters[i].isOpen()) {
                batch.draw(Textures.getFont32(), x + letters[i].getPos().x,
                        y + (32 * 7 - letters[i].getPos().y), 0, 0, 32, 32,
                        1, 1, 0, 6 * 32, 7 * 32,
                        32, 32, false, false);
            }

        }

    }

    public int getIndex(Vector2 vec) {
        return Letter.getIndex(vec.x - x, vec.y - y);
    }

    public boolean isPress(Vector2 vec) {
        if ((vec.x > x) && (vec.x < x + 256) && (vec.y > y) && (vec.y < y + h * 32)) {
            return true;
        }
        return false;
    }

    public void openLetter(int index) {
        letters[index].setOpen(true);
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
