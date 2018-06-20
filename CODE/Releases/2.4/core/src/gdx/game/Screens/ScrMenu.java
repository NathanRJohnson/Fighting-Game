package gdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import gdx.game.Menu.GamMenu;
import gdx.game.Objects.Button;
import gdx.game.Objects.Title;

public class ScrMenu implements Screen, InputProcessor {
    SpriteBatch batch;
    Texture txBg, txInfoBox;
    Sprite sprBg, sprInfoBox;
    Button btnStart, btnBg, btnScratch, btnInstruc, btnPlayers;
    OrthographicCamera oc;
    Vector2 vMouse;
    Title ttlStart;
    GamMenu gamMenu;
    Sound sndButtonClick;


    public ScrMenu(GamMenu _gamMenu) {
        gamMenu = _gamMenu;
    }

    @Override
    public void show() {
        //Sound effects
        sndButtonClick = Gdx.audio.newSound(Gdx.files.internal("clicksound.wav"));
        //Ortho
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        Gdx.input.setInputProcessor(this);
        //Texture
        txInfoBox = new Texture("Info.png");
        txBg = new Texture("startmenu2.jpg");
        //Sprites
        batch = new SpriteBatch();
        sprBg = new Sprite(txBg);
        sprBg.setFlip(false, true);
        sprBg.setSize(800, 500);
        sprInfoBox = new Sprite(txInfoBox);
        sprInfoBox.setFlip(false, true);
        sprInfoBox.setSize(75, 75);
        sprInfoBox.setPosition(Gdx.graphics.getWidth() / 2 + 245, 0);
        //Buttons
        btnBg = new Button(250, 150, Gdx.graphics.getWidth() / 2 - 120, Gdx.graphics.getHeight() / 2, "bgbutton2.png");
        btnScratch = new Button(50, 50, 0, 0, "scratchbutton.png");
        btnInstruc = new Button(50, 50, Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 + 150, "instruction.png");
        btnPlayers = new Button(50, 50, Gdx.graphics.getWidth() / 2 + 60, Gdx.graphics.getHeight() / 2 + 150, "player.png");
        btnStart = new Button(250, 150, Gdx.graphics.getWidth() / 2 - 120, Gdx.graphics.getHeight() / 2 - 100, "startbutton5.png");
        //Vectors
        vMouse = new Vector2(0, 0);
        //Title
        ttlStart = new Title(400, 400, Gdx.graphics.getWidth() / 2 - 188, Gdx.graphics.getHeight() / 2 - 350, "title.png");
        //extra
        System.out.println("Main Screen");

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
        btnInstruc.draw(batch);
        btnPlayers.draw(batch);
        sprInfoBox.draw(batch);
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
                ButtonClickSound();
                System.out.println("Hit start");
                gamMenu.updateScreen(1);
            }
            if (isHit(screenX, screenY, btnBg)) {
                ButtonClickSound();
                System.out.println("Hit Bg");
                gamMenu.updateScreen(2);
            }
            if (isHit(screenX, screenY, btnScratch)) {
                ButtonClickSound();
                System.out.println("Hit Scratch");
                gamMenu.updateScreen(3);
            }
            if (isHit(screenX, screenY, btnInstruc)) {
                ButtonClickSound();
                System.out.println("Hit Instructions");
                gamMenu.updateScreen(4);
            }
            if (isHit(screenX, screenY, btnPlayers)) {
                ButtonClickSound();
                System.out.println("Hit Player Screen");
                gamMenu.updateScreen(5);
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

    public void ButtonClickSound() {
        long id = sndButtonClick.play();
        sndButtonClick.setVolume(id, 1.0f);
    }
}
