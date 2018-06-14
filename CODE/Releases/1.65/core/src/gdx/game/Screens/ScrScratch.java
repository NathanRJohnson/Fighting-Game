package gdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import gdx.game.Menu.GamMenu;
import gdx.game.Objects.Button;

public class ScrScratch implements Screen,InputProcessor {
    GamMenu gammenu;
    Button btnBasicAttack, btnAnimation,btnBlocking,btnHealth;
    SpriteBatch batch;
    OrthographicCamera oc;
    Vector2 vMouse;

    public ScrScratch(GamMenu _gammenu){gammenu = _gammenu;}

    @Override
    public void show() {
        //ortho
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        Gdx.input.setInputProcessor(this);
        //Vector
        vMouse = new Vector2(0, 0);
        //Sprite
        batch = new SpriteBatch();
        //Buttons
        btnAnimation = new Button(100, 100, Gdx.graphics.getWidth()/2-50, Gdx.graphics.getHeight()/2-150, "animation.png");
        btnBlocking = new Button(100, 100, Gdx.graphics.getWidth()/2+150, Gdx.graphics.getHeight()/2-150, "block.png");
        btnHealth = new Button(100, 100, Gdx.graphics.getWidth()/2-50, Gdx.graphics.getHeight()/2-10,"health bar.png");
        btnBasicAttack = new Button(100, 100, Gdx.graphics.getWidth() / 2-250, Gdx.graphics.getHeight() / 2-150, "Basic Attack.png");
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(oc.combined);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        btnBasicAttack.draw(batch);
        btnHealth.draw(batch);
        btnBlocking.draw(batch);
        btnAnimation.draw(batch);
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
    public boolean touchUp(int screenX, int screenY, int pointer, int button){
                if (button == Input.Buttons.LEFT) {
        if (isHit(screenX, screenY, btnAnimation)) {
            System.out.println("Hit animation");
            gammenu.updateScreen(10);
        }
        if (isHit(screenX, screenY, btnBasicAttack)) {
            System.out.println("Hit basic attack");
            gammenu.updateScreen(11);
        }
        if(isHit(screenX, screenY, btnBlocking)){
            System.out.println("Hit blocking");
            gammenu.updateScreen(12);
        }
        if(isHit(screenX, screenY, btnHealth)){
            System.out.println("hit health");
            gammenu.updateScreen(13);
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
