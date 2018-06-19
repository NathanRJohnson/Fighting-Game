package gdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import gdx.game.Menu.GamMenu;
import gdx.game.Objects.SprFighter;

public class ScrPlay implements Screen, InputProcessor {
    SpriteBatch batch;
    Texture txPlatform;
    Texture txSpace;
    SprFighter spfSamurai;
    SprFighter spfBlackBelt;
    Sprite sprPlatform;
    Vector2 v2Gravity, v2Normal;
    GamMenu gamMenu;

    public ScrPlay(GamMenu _gamMenu){gamMenu = _gamMenu;}
    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();
        txPlatform = new Texture("Rock_Platform.png");
        txSpace = new Texture("Dusty_bg.png");
        spfSamurai = new SprFighter("Ronin.png", 70, 170, 100, 100, 1);
        spfBlackBelt = new SprFighter("Fighter_Man.png", 440, 170, 100, 100, 2);
        sprPlatform = new Sprite(txPlatform);
        v2Gravity = new Vector2(0, -1);
        v2Normal  = new Vector2(0, 1);
        System.out.println("Play Screen");
    }

    @Override
    public void render(float delta) {
        spfBlackBelt.applyForce(v2Gravity);
        spfSamurai.applyForce(v2Gravity);
        if (spfBlackBelt.v2Location.y <= 181 && spfBlackBelt.v2Location.x > 45 && spfBlackBelt.v2Location.x < 530) {

            spfBlackBelt.applyForce(v2Normal);
            spfBlackBelt.v2Location.y = 180;
        }
        if (spfSamurai.v2Location.y <= 181 && spfSamurai.v2Location.x > 15 && spfSamurai.v2Location.x < 530) {

            spfSamurai.applyForce(v2Normal);
            spfSamurai.v2Location.y = 180;
        }
        spfSamurai.move();
        spfBlackBelt.move();
        batch.begin();
        batch.draw(txSpace, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(sprPlatform, 45, 10, 550, 200);
        //sprPlatform.draw(batch);
        batch.draw(spfSamurai, spfSamurai.v2Location.x, spfSamurai.v2Location.y, spfSamurai.getWidth(), spfSamurai.getHeight());
        batch.draw(spfBlackBelt, spfBlackBelt.v2Location.x, spfBlackBelt.v2Location.y, spfBlackBelt.getWidth(), spfBlackBelt.getHeight());
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        spfSamurai.getTexture().dispose();
        spfBlackBelt.getTexture().dispose();
        sprPlatform.getTexture().dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
