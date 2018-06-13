package gdx.scratch;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    Texture txHealthBar, txVersus, txBarColor1, txBarColor2;
    Sprite sprHealthBar1, sprHealthBar2;

    int nWidth1 = 225, nWidth2 = -225;

    @Override
    public void create() {
        batch = new SpriteBatch();
        txHealthBar = new Texture("Health_Bar.png");
        txVersus = new Texture("VS.jpg");
        txBarColor1 = new Texture("Bar_Color.png");
        txBarColor2 = new Texture("Bar_Color.png");
        sprHealthBar1 = new Sprite(txHealthBar);
        sprHealthBar2 = new Sprite(txHealthBar);


    }

    @Override
    public void render() {
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
        batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
        sprHealthBar1.getTexture().dispose();
    }
}
