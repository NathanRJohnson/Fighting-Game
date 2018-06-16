package gdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import gdx.game.Menu.GamMenu;
import gdx.game.Objects.Button;
import gdx.game.Objects.Title;

public class ScrMenu implements Screen,InputProcessor {
    SpriteBatch batch;
    Texture txBg;
    Sprite sprBg;
    GamMenu gammenu;
    Button btnStart, btnBg, btnScratch;
    OrthographicCamera oc;
    Vector2 vMouse;
    Title ttlStart;

    public ScrMenu(GamMenu _gammenu){gammenu = _gammenu;}
    @Override
    public void show() {
        //Ortho
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        Gdx.input.setInputProcessor(this);
        //Texture
        txBg = new Texture("startmenu2.jpg");
        //Sprites
        batch = new SpriteBatch();
        sprBg = new Sprite(txBg);
        sprBg.setFlip(false,true);
        sprBg.setSize(800, 500);
        //Buttons
        btnBg = new Button(250, 150, Gdx.graphics.getWidth() / 2 - 120, Gdx.graphics.getHeight() / 2, "bgbutton2.png");
        btnScratch = new Button(50,50, 0, 0 , "scratchbutton.png");
        btnStart = new Button(250, 150, Gdx.graphics.getWidth() / 2 - 120, Gdx.graphics.getHeight() / 2 - 100, "startbutton5.png");
        //Vectors
        vMouse = new Vector2(0, 0);
        //Title
        ttlStart = new Title(400, 400, Gdx.graphics.getWidth() / 2 - 188, Gdx.graphics.getHeight() / 2 - 350, "title.png");
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
        batch.begin();
        sprBg.draw(batch);
        btnStart.draw(batch);
        btnBg.draw(batch);
        ttlStart.draw(batch);
        btnScratch.draw(batch);
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
        if (button == Input.Buttons.LEFT) {
            if (isHit(screenX, screenY, btnStart)) {
                System.out.println("Hit start");
                gammenu.updateScreen(1);
            }
            if (isHit(screenX, screenY, btnBg)) {
                System.out.println("Hit Bg");
                gammenu.updateScreen(2);
            }
            if(isHit(screenX, screenY, btnScratch)){
                System.out.println("Hit Scratch");
                gammenu.updateScreen(3);
            }
        }
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
    public boolean isHit(int nX, int nY, Sprite sprBtn) {
        if (nX > sprBtn.getX() && nX < sprBtn.getX() + sprBtn.getWidth() && nY > sprBtn.getY() && nY < sprBtn.getY() + sprBtn.getHeight()) {
            return true;
        } else {
            return false;
        }
    }
}