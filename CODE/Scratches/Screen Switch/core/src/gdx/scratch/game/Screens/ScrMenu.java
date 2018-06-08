package gdx.scratch.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.scratch.game.Main;

public class ScrMenu implements Screen {
    SpriteBatch batch;
    Texture tBackground;
    Sprite sprBackground;
    Main main;
    Button btnStart;
    // Stage stage;


    public ScrMenu(Main _main) {
        main = _main;
    }
    @Override
    public void show() {
        batch = new SpriteBatch();
        tBackground = new Texture("startmenu.jpg");
        sprBackground = new Sprite(tBackground);
        btnStart = new Button(200, 100, Gdx.graphics.getWidth()/2-100, Gdx.graphics.getHeight()/2-50, "playbutton.png");
    }

    @Override
    public void render(float delta) {
        isTouch();
        batch.begin();
        sprBackground.draw(batch);
        btnStart.draw(batch);
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

    public void isTouch() {
        if(Gdx.input.isButtonPressed((Input.Keys.LEFT))){
            if(btnStart.isHit(btnStart.getX(), btnStart.getY(), btnStart.getWidth(), btnStart.getHeight())){
                System.out.println("Hit start");
                main.updateState(1);
            }
        }
    }
    public void dispose() {
        batch.dispose();
        tBackground.dispose();
    }
}
