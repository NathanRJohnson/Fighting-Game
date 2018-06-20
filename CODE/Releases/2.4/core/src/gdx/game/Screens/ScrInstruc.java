package gdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.game.Menu.GamMenu;
import gdx.game.Objects.Title;

public class ScrInstruc implements Screen, InputProcessor {
    Texture txBg, txInfo;
    Sprite sprBg, sprInfo;
    SpriteBatch batch;
    GamMenu gamMenu;
    OrthographicCamera oc;

    public ScrInstruc(GamMenu _gamMenu) {
        gamMenu = _gamMenu;
    }

    @Override
    public void show() {
        //ortho
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        //Processor
        Gdx.input.setInputProcessor(this);
        //Texture
        txBg = new Texture("instructionalbckgd1.jpg");
        txInfo = new Texture("Instruction Menu.png");
        //Sprites
        sprBg = new Sprite(txBg);
        batch = new SpriteBatch();
        sprBg.setSize(800, 500);
        sprBg.setFlip(false, true);
        sprInfo = new Sprite(txInfo);
        sprInfo.setFlip(false, true);
        sprInfo.setSize(600, 500);
        sprInfo.setPosition(Gdx.graphics.getWidth() / 2 - 300, Gdx.graphics.getHeight() / 2 - 225);
        System.out.println("Instruction Screen");
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
        batch.begin();
        sprBg.draw(batch);
        sprInfo.draw(batch);
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
