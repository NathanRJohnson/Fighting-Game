package gdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.game.Menu.GamMenu;
import gdx.game.Objects.SprScratchFighter;
import gdx.game.Objects.PVector;

public class ScrScratchBasicA implements Screen, InputProcessor {
    GamMenu gammenu;
    SpriteBatch batch;
    public SprScratchFighter spfBlackBelt, spfBadLogic;
    Texture txSpace, txHitBox;
    double dPunchDelay1 = 2, dPunchDelay2 = 2;
    float fHealth1 = 100, fHealth2 = -100;
    //HitBox Testers------
    boolean isAttack = false;
    //---------------------

    //KnockBack--------------;
    public double dSlappedTimer1 = 1, dSlappedTimer2 = 1;
    int nKnockback;
    //-----------------------

    public ScrScratchBasicA(GamMenu _gammenu) {gammenu = _gammenu;}
    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        System.out.println("Scratch Basic Attack");
        batch = new SpriteBatch();

        txHitBox = new Texture("HitBox.png");
        txSpace = new Texture("Disstrackting.jpg");
        spfBadLogic = new SprScratchFighter("Ronin.png", 0, 30, 100, 100, 1);
        spfBlackBelt = new SprScratchFighter("Fighter_Man.png", 370, 30, 100, 100, 2);
    }

    @Override
    public void render(float delta) {

        dPunchDelay1 += 0.1;
        dPunchDelay2 += 0.1;
        dSlappedTimer1 += 0.1;
        dSlappedTimer2 += 0.1;
        if (dSlappedTimer1 < 1) {
            spfBadLogic.vLocation.x += nKnockback;
        }
        if (dSlappedTimer2 < 1) {
            spfBlackBelt.vLocation.x += nKnockback;
        }

        spfBadLogic.move(dSlappedTimer1);
        spfBlackBelt.move(dSlappedTimer2);

        batch.begin();
        batch.draw(txSpace, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(spfBlackBelt, spfBlackBelt.vLocation.x, spfBlackBelt.vLocation.y, spfBlackBelt.getWidth(), spfBlackBelt.getHeight());
        batch.draw(spfBadLogic, spfBadLogic.vLocation.x, spfBadLogic.vLocation.y, spfBadLogic.getWidth(), spfBadLogic.getHeight());
        batch.end();


        if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && dPunchDelay1 > 3 && dSlappedTimer2 > 2) { //BlackBelt
            spfBlackBelt.canMove = false;

            basicAttack(spfBadLogic, spfBlackBelt);
            if (isAttack == true) {
                fHealth2 += 10;
                dSlappedTimer1 = 0;
                dPunchDelay1 = 0;
                if (fHealth2 > 0)
                    System.out.println("Player 1 wins");
            }

        } else if (dSlappedTimer2 > 4) {
            spfBlackBelt.canMove = true;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && dPunchDelay2 > 3 && dSlappedTimer1 > 2) {
            basicAttack(spfBlackBelt, spfBadLogic);
            spfBadLogic.canMove = false;

            if (isAttack == true) {
                fHealth1 -= 10;
                dPunchDelay2 = 0;
                dSlappedTimer2 = 0;

                if (fHealth1 < 0)
                    System.out.println("Player 2 wins");
            }
        } else if (dSlappedTimer1 > 4) {
            spfBadLogic.canMove = true;
        }


        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            spfBadLogic.vLocation.x += 20f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.E)) {
            spfBadLogic.vLocation.x -= 20f;
        }
    }
    public void basicAttack(SprScratchFighter spfPlayer, SprScratchFighter spfEnemy) {
        if (spfPlayer.vLocation.x > spfEnemy.vLocation.x) {
            if (spfPlayer.vLocation.x < spfEnemy.vLocation.x + spfEnemy.getWidth()) {
                nKnockback = 8;

                System.out.println("Get punched lefty");
                isAttack = true;
            } else isAttack = false;
        }
        if (spfPlayer.vLocation.x < spfEnemy.vLocation.x) {
            if (spfPlayer.vLocation.x > spfEnemy.vLocation.x - spfEnemy.getWidth()) {
                nKnockback = -8;
                System.out.println("Get punched righty");
                isAttack = true;
            } else isAttack = false;
        }
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
