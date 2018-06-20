package gdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.game.Menu.GamMenu;
import gdx.game.Objects.SprFighter;
import gdx.game.Objects.Title;

public class ScrPlayers implements Screen, InputProcessor {
    Texture txBg, txSamurai, txBlackBelt;
    Sprite sprBg, sprSamurai, sprBlackBelt;
    SprFighter spfBlackBelt, spfSamurai;
    Title ttlStart;
    SpriteBatch batch;
    GamMenu gamMenu;
    OrthographicCamera oc;

    public ScrPlayers(GamMenu _gamMenu) {
        gamMenu = _gamMenu;
    }

    @Override
    public void show() {
        //Texture
        txSamurai = new Texture("samurai2.png");
        txBlackBelt = new Texture("blackbelt2.png");
        txBg = new Texture("background3.jpg");
        //Sprite
        batch = new SpriteBatch();
        sprBg = new Sprite(txBg);
        sprBg.setSize(800, 500);
        sprBg.setFlip(false, true);
        spfSamurai = new SprFighter("Ronin.png", Gdx.graphics.getWidth() / 2 - 300, Gdx.graphics.getHeight() / 2 - 75, 250, 250, 1);
        spfBlackBelt = new SprFighter("Fighter_Man.png", Gdx.graphics.getWidth() / 2 + 50, Gdx.graphics.getHeight() / 2 - 75, 250, 250, 2);
        spfSamurai.setFlip(false, true);
        spfBlackBelt.setFlip(true, true);
        sprSamurai = new Sprite(txSamurai);
        sprSamurai.setPosition(Gdx.graphics.getWidth() / 2 - 275, Gdx.graphics.getHeight() / 2 + 25);
        sprSamurai.setFlip(false, true);
        sprSamurai.setSize(250, 250);
        sprBlackBelt = new Sprite(txBlackBelt);
        sprBlackBelt.setSize(200, 200);
        sprBlackBelt.setFlip(false, true);
        sprBlackBelt.setPosition(Gdx.graphics.getWidth() / 2 + 74, Gdx.graphics.getHeight() / 2 + 60);
        //ortho
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        Gdx.input.setInputProcessor(this);
        //Title
        ttlStart = new Title(400, 400, Gdx.graphics.getWidth() / 2 - 188, Gdx.graphics.getHeight() / 2 - 350, "title.png");
        System.out.println("Players Screen");
    }


    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
        batch.begin();
        sprBg.draw(batch);
        ttlStart.draw(batch);
        spfBlackBelt.draw(batch);
        spfSamurai.draw(batch);
        sprSamurai.draw(batch);
        sprBlackBelt.draw(batch);
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
