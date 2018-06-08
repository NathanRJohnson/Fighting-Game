package gdx.scratch.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
;

public class Button extends Sprite {
    public Button(int nW, int nH, int nX, int nY, String sFileName) {
        super(new Texture(Gdx.files.internal(sFileName)));
        setPosition(nX, nY);
        setSize(nW, nH);
        System.out.println(nY);
        System.out.println(nY + nH);
    }
    public boolean isHit(float fX, float fY, float fW, float fH) { // inspired by daph's code
        if (Gdx.input.getX() > fX && Gdx.input.getX() < fX+fW) {
            if (Gdx.graphics.getHeight()-Gdx.input.getY()> fY && Gdx.graphics.getHeight() - Gdx.input.getY() < fY+fH) {
                return true;
            }

        }

        return false;
    }
}
