package gdx.scratch.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.scratch.game.Main;

public class ScrPlay implements Screen {
    Texture tBackground, tPooh;
    Sprite sprBackground, sprPooh;
    SpriteBatch batch;
    Main main;
    Button  btnBack;

    public ScrPlay(Main _main) { main = _main;}

    @Override
    public void show() {
        tBackground = new Texture("background.jpg");
        tPooh = new Texture("pooh.png");
        sprPooh = new Sprite(tPooh);
        sprBackground = new Sprite(tBackground);
        batch = new SpriteBatch();
        sprPooh.setPosition(Gdx.graphics.getWidth()/2-5 - sprPooh.getWidth()/2, Gdx.graphics.getHeight()/2-sprPooh.getHeight()/2+50);
        btnBack = new Button(100,100, Gdx.graphics.getWidth()/2-325, Gdx.graphics.getHeight()/2-250, "backbutton.png");
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isButtonPressed((Input.Keys.LEFT))){
            System.out.println(Gdx.input.getX());
            System.out.println(Gdx.graphics.getHeight()-Gdx.input.getY()+ "AH");
        }
        isTouch();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            sprPooh.translateX(-5f);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            sprPooh.translateX(5f);
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            sprPooh.translateY(5f);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            sprPooh.translateY(-5f);
        batch.begin();
        sprBackground.draw(batch);
        batch.draw(sprPooh, sprPooh.getX(), sprPooh.getY(), 160, 180);
        btnBack.draw(batch);
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
            if(btnBack.isHit(btnBack.getX(), btnBack.getY(), btnBack.getWidth(), btnBack.getHeight())){
                System.out.println("Hit back");
                main.updateState(0);
            }
        }
    }
    public void dispose() {
        batch.dispose();
        tPooh.dispose();
        tBackground.dispose();
    }
}
