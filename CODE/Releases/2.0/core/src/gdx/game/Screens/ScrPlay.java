package gdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import gdx.game.Menu.GamMenu;
import gdx.game.Objects.SprFighter;

public class ScrPlay implements Screen, InputProcessor {
    SpriteBatch batch;
    Texture txRockPlatform, txSpacePlatform;
    Texture txDust, txSpace;
    Texture txP1Wins, txP2Wins;
    SprFighter spfSamurai;
    SprFighter spfBlackBelt;
    Vector2 v2Gravity, v2Normal;
    GamMenu gamMenu;
    //CMBT scratch-----------------------------
    int nKnockback;
    double dPunchDelay1 = 2, dPunchDelay2 = 2;
    float fHealth1 = 100, fHealth2 = -100;
    public double dSlappedTimer1 = 1, dSlappedTimer2 = 1;
    //-----------------------

    public int nSecretToggle = 1;
    //----------------------------------------------


    public ScrPlay(GamMenu _gamMenu) {
        gamMenu = _gamMenu;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();
        txRockPlatform = new Texture("Rock_Platform.png");
        txSpacePlatform = new Texture("Space_Platform.png");
        txDust = new Texture("Dusty_bg.png");
        txSpace = new Texture("Space_BG.jpg");
        spfSamurai = new SprFighter("Ronin.png", 70, 170, 100, 100, 1);
        spfBlackBelt = new SprFighter("Fighter_Man.png", 440, 170, 100, 100, 2);

        //Gravity--------------------------------
        v2Gravity = new Vector2(0, -1);
        v2Normal = new Vector2(0, 1);
        //----------------------------------------
    }

    @Override
    public void render(float delta) {
        //basicAttack();
        dPunchDelay1 += 0.1;
        dPunchDelay2 += 0.1;
        dSlappedTimer1 += 0.1;
        dSlappedTimer2 += 0.1;
        if (dSlappedTimer1 < 1)
            spfSamurai.v2Location.x += nKnockback;
        if (dSlappedTimer2 < 1)
            spfBlackBelt.v2Location.x += nKnockback;
        spfBlackBelt.applyForce(v2Gravity);
        spfSamurai.applyForce(v2Gravity);
        if (spfBlackBelt.v2Location.y <= 181 && spfBlackBelt.v2Location.x > 45 && spfBlackBelt.v2Location.x < 530) {

            spfBlackBelt.applyForce(v2Normal);
            spfBlackBelt.v2Location.y = 180;
        }
        if (spfSamurai.v2Location.y <= 181 && spfSamurai.v2Location.x > 15 && spfSamurai.v2Location.x < 530) {

            spfSamurai.applyForce(v2Normal);
            spfSamurai.v2Location.y = 180;
        }

        spfSamurai.move(dSlappedTimer1);
        spfBlackBelt.move(dSlappedTimer2);

        batch.begin();
        if (nSecretToggle == 1) {
            batch.draw(txDust, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.draw(txRockPlatform, 45, 10, 550, 200);
        }
        if (nSecretToggle == 2) {
            batch.draw(txSpace, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.draw(txSpacePlatform, 45, 10, 550, 200);
        }
        batch.draw(spfBlackBelt, spfBlackBelt.v2Location.x, spfBlackBelt.v2Location.y, spfBlackBelt.getWidth(), spfBlackBelt.getHeight());
        batch.draw(spfSamurai, spfSamurai.v2Location.x, spfSamurai.v2Location.y, spfSamurai.getWidth(), spfSamurai.getHeight());

        batch.end();

        //Punching----------------------------------------------------------------------------------------
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && dPunchDelay1 > 2 && dSlappedTimer2 > 2) { //BlackBelt
            if (basicAttack(spfSamurai, spfBlackBelt)) {
                fHealth2 += spfBlackBelt.BasicDamage;
            }
            System.out.println("Player 2 health: " + fHealth2);
            dPunchDelay1 = 0;
            dSlappedTimer1 = 0;

        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && dPunchDelay2 > 2 && dSlappedTimer1 > 2) {
            if (basicAttack(spfBlackBelt, spfSamurai)) {
                fHealth1 -= spfSamurai.BasicDamage;

            }
            System.out.println("Player 1 health: " + fHealth1);
            dPunchDelay2 = 0;
            dSlappedTimer2 = 0;
        }


        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            spfSamurai.v2Location.x += 20f;
        }
        // ----------------------------------------------------------------------------------------
    }

    public boolean basicAttack(SprFighter spfPlayer, SprFighter spfEnemy) {
        if (spfPlayer.v2Location.x > spfEnemy.v2Location.x) {
            if (spfPlayer.v2Location.x < spfEnemy.v2Location.x + spfEnemy.getWidth()) {
                nKnockback = 8;
                return true;
            }
        }
        if (spfPlayer.v2Location.x < spfEnemy.v2Location.x) {
            if (spfPlayer.v2Location.x > spfEnemy.v2Location.x - spfEnemy.getWidth()) {
                nKnockback = -8;
                return true;
            }
        }
        return false;
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
        spfSamurai.getTexture().dispose();
        spfBlackBelt.getTexture().dispose();
        txSpacePlatform.dispose();
        txRockPlatform.dispose();
        txSpace.dispose();
        txDust.dispose();
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
