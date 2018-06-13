package gdx.game.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.game.GamMenu;
import gdx.game.Objects.Button;

public class ScrMenu implements Screen {
    SpriteBatch batch;
    Texture txBackground;
    Sprite sprBackground;
    GamMenu main;
    Button btnStart;

    public ScrMenu(GamMenu _main) {
        main = _main;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        txBackground = new Texture("False_Advertising-Start.jpg");
        sprBackground = new Sprite(txBackground);
        sprBackground.setSize(800,500 );
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

    @Override
    public void dispose() {

    }
}
