package gdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.game.Menu.GamMenu;

public class ScrScratchHealth implements Screen, InputProcessor {

    GamMenu gamMenu;
    SpriteBatch batch;
    Texture txHealthBar, txVersus, txBarColor1, txBarColor2;
    Sprite sprHealthBar1, sprHealthBar2;

    int nWidth1 = 225, nWidth2 = -225;

    public ScrScratchHealth(GamMenu _gamMenu){gamMenu = _gamMenu;}
    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        System.out.println("Scratch Health Bar");
        batch = new SpriteBatch();
        //Health Bar Scratch Stuff -----------------------
        txHealthBar = new Texture("Health_Bar.png");
        txVersus = new Texture("VS.jpg");
        txBarColor1 = new Texture("Bar_Color.png");
        txBarColor2 = new Texture("Bar_Color.png");
        sprHealthBar1 = new Sprite(txHealthBar);
        sprHealthBar2 = new Sprite(txHealthBar);
        //--------------------------------------------
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && nWidth1 >= 0)
            nWidth1 -= 25;
        if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT) && nWidth2 <= 0)
            nWidth2 += 25;
        if (Gdx.input.isKeyPressed(Input.Keys.R)) {
            nWidth1 = 225;
            nWidth2 = -225;
        }
        batch.begin();
        //Health Bar Scratch Stuff -----------------------
        batch.draw(txVersus, 288, 400, 70, 70);
        batch.draw(txBarColor1, 50, 420, nWidth1, 40);
        batch.draw(txBarColor2, 590, 420, nWidth2, 40);

        sprHealthBar1.setPosition(0, 330);
        sprHealthBar1.setSize(300, 200);
        sprHealthBar1.draw(batch);

        sprHealthBar2.setPosition(340, 330);
        sprHealthBar2.setSize(300, 200);
        sprHealthBar2.setFlip(true, false);
        sprHealthBar2.draw(batch);
        //--------------------------------------------------
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
        sprHealthBar1.getTexture().dispose();

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
