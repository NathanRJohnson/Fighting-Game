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

public class ScrBckgd implements Screen, InputProcessor {
    Texture tBckground;
    Sprite sprBckground;
    SpriteBatch batch;
    GamMenu gammenu;
    Title ttlStart;
    OrthographicCamera oc;
    Vector2 vMouse;

    public ScrBckgd(GamMenu _gammenu){ gammenu = _gammenu;}

    @Override
    public void show() {
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        tBckground = new Texture("backgroundselection.jpg");
        sprBckground = new Sprite(tBckground);
        ttlStart = new Title(200, 200, Gdx.graphics.getWidth()/2-90, Gdx.graphics.getHeight()/2-300, "title.png");
        Gdx.input.setInputProcessor(this);
        System.out.println("BACKGROUND");
        sprBckground.setSize(800, 500);
        sprBckground.setFlip(false,true);
        vMouse = new Vector2(0, 0);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
        batch.begin();
        sprBckground.draw(batch);
        ttlStart.draw(batch);
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
    tBckground.dispose();
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
