package gdx.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Title extends Sprite { // LABEL SPRTITLE
    public Title(int nW, int nH, int nX, int nY, String sFileName){
        super(new Texture(Gdx.files.internal(sFileName)));
        setPosition(nX, nY);
        setSize(nW, nH);
        setFlip(false, true);
    }
}
