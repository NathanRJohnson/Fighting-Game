package gdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.game.Menu.GamMenu;
import gdx.game.Objects.SprFighter;

public class ScrScratchCmbt implements Screen, InputProcessor {
    GamMenu gamMenu;
    SpriteBatch batch;
    public SprFighter spfBlackBelt, spfBadLogic;
    //CMBT scratch-----------------------------
    Texture txSpace;
    double dPunchDelay1 = 2, dPunchDelay2 = 2;
    float fHealth1 = 100, fHealth2 = -100;


    //KnockBack--------------;
    public double dSlappedTimer1 = 1, dSlappedTimer2 = 1;

    //-----------------------
    public ScrScratchCmbt(GamMenu _gamMenu) {
        gamMenu = _gamMenu;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();

        txSpace = new Texture("Space_BG.jpg");
        spfBadLogic = new SprFighter("Ronin.png", 0, 30, 100, 100, 1);
        spfBlackBelt = new SprFighter("Fighter_Man.png", 370, 30, 100, 100, 2);

        System.out.println("Block Scratch");

    }

    @Override
    public void render(float delta) {

        //basicAttack();
        dPunchDelay1 += 0.1;
        dPunchDelay2 += 0.1;
        dSlappedTimer1 += 0.1;
        dSlappedTimer2 += 0.1;
        if (dSlappedTimer1 < 1)
            spfBadLogic.v2Location.x -= 8;
        if (dSlappedTimer2 < 1)
            spfBlackBelt.v2Location.x += 8;
        spfBadLogic.move(dSlappedTimer1);
        spfBlackBelt.move(dSlappedTimer2);

        batch.begin();
        batch.draw(txSpace, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(spfBlackBelt, spfBlackBelt.v2Location.x, spfBlackBelt.v2Location.y, spfBlackBelt.getWidth(), spfBlackBelt.getHeight());
        batch.draw(spfBadLogic, spfBadLogic.v2Location.x, spfBadLogic.v2Location.y, spfBadLogic.getWidth(), spfBadLogic.getHeight());
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && dPunchDelay1 > 2) { //BlackBelt
            if (basicAttack(spfBadLogic, spfBlackBelt)) {
                if (spfBadLogic.isBlocking == true) {
                    fHealth2 += spfBlackBelt.BasicDamage / 2;
                } else {
                    fHealth2 += spfBlackBelt.BasicDamage;
                }
                System.out.println("Player 2 health: " + fHealth2);
                dPunchDelay1 = 0;
                dSlappedTimer1 = 0;
                if (fHealth2 > 0)
                    System.out.println("Player 1 wins");
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && dPunchDelay2 > 2) {
            if (basicAttack(spfBlackBelt, spfBadLogic)) {
                if (spfBlackBelt.isBlocking == true) {
                    fHealth1 -= spfBadLogic.BasicDamage / 2;
                } else {
                    fHealth1 -= spfBadLogic.BasicDamage;
                }
                System.out.println("Player 1 health: " + fHealth1);
                dPunchDelay2 = 0;
                dSlappedTimer2 = 0;

                if (fHealth1 < 0)
                    System.out.println("Player 2 wins");
            }
        }


        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            spfBadLogic.v2Location.x += 20f;
        }

    }

    public boolean basicAttack(SprFighter spfPlayer, SprFighter spfEnemy) {
        if (spfPlayer.v2Location.x > spfEnemy.v2Location.x) {
            if (spfPlayer.v2Location.x < spfEnemy.v2Location.x + spfEnemy.getWidth()) {
                System.out.println("Get punched lefty");
                return true;
            }
        }
        if (spfPlayer.v2Location.x < spfEnemy.v2Location.x) {
            if (spfPlayer.v2Location.x > spfEnemy.v2Location.x - spfEnemy.getWidth()) {
                System.out.println("Get punched righty");
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
