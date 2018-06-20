package gdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import gdx.game.Menu.GamMenu;
import gdx.game.Objects.Title;

public class ScrBckgd implements Screen,InputProcessor {
    SpriteBatch batch;
    Texture txBg;
    Sprite sprBg;
    Title ttlGame;
    OrthographicCamera oc;
    Vector2 vMouse;
    GamMenu gamMenu;

    public ScrBckgd(GamMenu _gamMenu){gamMenu = _gamMenu;}
    @Override
    public void show() {
        //ortho
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        Gdx.input.setInputProcessor(this);
        //vector
        vMouse = new Vector2(0, 0);
        //Texture
        txBg = new Texture("backgroundselection.jpg");
        //sprite
        batch = new SpriteBatch();
        sprBg = new Sprite(txBg);
        sprBg.setSize(800, 500);
        sprBg.setFlip(false, true);
        //title
        ttlGame = new Title(400, 400, Gdx.graphics.getWidth() / 2 - 188, Gdx.graphics.getHeight() / 2 - 350, "title.png");

    }


    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
        batch.begin();
        sprBg.draw(batch);
        ttlGame.draw(batch);
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
        txBg.dispose();
        batch.dispose();
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
