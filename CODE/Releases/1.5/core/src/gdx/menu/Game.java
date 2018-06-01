package gdx.menu;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.Classes.Fighter;
import gdx.Classes.PVector;

//Skadoosh
public class Game extends ApplicationAdapter {
    SpriteBatch batch;
    Texture txPlatform;
    Texture txSpace;
    Fighter fFighter;
    Fighter fBlackBelt;
    Sprite sprPlatform;
    PVector vGravity, vNormal;

    @Override
    public void create() {
        batch = new SpriteBatch();
        txPlatform = new Texture("Platform.png");
            txSpace = new Texture("Space_BG.jpg");
        fFighter = new Fighter("Ronin.png", 70, 170, 100, 100, 1);
        fBlackBelt = new Fighter("Fighter_Man.png", 440, 170, 100, 100, 2);
        sprPlatform = new Sprite(txPlatform);
        vGravity = new PVector(0, -1);
        vNormal  = new PVector(0, 1);

    }

    @Override
    public void render() {
       fBlackBelt.applyForce(vGravity);
       fFighter.applyForce(vGravity);
        if (fBlackBelt.vLocation.y <= 181 && fBlackBelt.vLocation.x > 45 && fBlackBelt.vLocation.x < 530) {

            fBlackBelt.applyForce(vNormal);
            fBlackBelt.vLocation.y = 180;
        }
        if (fFighter.vLocation.y <= 181 && fFighter.vLocation.x > 15 && fFighter.vLocation.x < 530) {

            fFighter.applyForce(vNormal);
            fFighter.vLocation.y = 180;
        }
        fFighter.move();
        fBlackBelt.move();
        batch.begin();
        batch.draw(txSpace, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(sprPlatform, 45, 10, 550, 200);
        batch.draw(fFighter, fFighter.vLocation.x, fFighter.vLocation.y, fFighter.getWidth(), fFighter.getHeight());
        batch.draw(fBlackBelt, fBlackBelt.vLocation.x, fBlackBelt.vLocation.y, fBlackBelt.getWidth(), fBlackBelt.getHeight());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        fFighter.getTexture().dispose();
    }


}
