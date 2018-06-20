package gdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
    boolean isAttack;
    //-----------------------
    //Health bar scratch----------
    Texture txHealthBar, txVersus, txBarColor1, txBarColor2;
    Sprite sprHealthBar1, sprHealthBar2;
    int nWidth1 = 225, nWidth2 = -225;
    //-----------------------
    //Animation Vars--------------------------
    boolean isRight;
    int nPunchState = 1;
    //---------------
    Texture txSheet;
    Animation araniBlackBelt[];
    TextureRegion trTemp;
    Sprite sprBlackBelt;
    int fW, fH, fSx, fSy;
    int nFrame, nPos;
    int nX = 100;
    boolean P1HasWon, P2HasWon;
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
        txP1Wins = new Texture("P1Win.png");
        txP2Wins = new Texture("P2Win.png");
        spfSamurai = new SprFighter("Ronin.png", 70, 170, 100, 100, 1);
        spfBlackBelt = new SprFighter("Fighter_Man.png", 440, 170, 100, 100, 2);

        //Gravity--------------------------------
        v2Gravity = new Vector2(0, -1);
        v2Normal = new Vector2(0, 1);
        //----------------------------------------
        //Health Bar Scratch Stuff -----------------------
        txHealthBar = new Texture("Health_Bar.png");
        txVersus = new Texture("VS.jpg");
        txBarColor1 = new Texture("Bar_Color.png");
        txBarColor2 = new Texture("Bar_Color.png");
        sprHealthBar1 = new Sprite(txHealthBar);
        sprHealthBar2 = new Sprite(txHealthBar);

        //--------------------------------------------
        //Animation Scratch Stuff ---------------------------------------
        Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();
        txSheet = new Texture("BlackBelt_SS.png");
        nFrame = 0;
        nPos = 0;
        araniBlackBelt = new Animation[8];
        fW = txSheet.getWidth() / 3;
        fH = txSheet.getHeight() / 8;
        for (int i = 0; i < 8; i++) {
            Sprite[] arSprDude = new Sprite[3];
            for (int j = 0; j < 3; j++) {
                fSx = j * fW;
                fSy = i * fH;
                sprBlackBelt = new Sprite(txSheet, fSx, fSy, fW, fH);
                //sprDude.setFlip(false, true);
                sprBlackBelt.setSize(200, 300);
                arSprDude[j] = new Sprite(sprBlackBelt);
            }
            araniBlackBelt[i] = new Animation(3f, arSprDude);

        }
        //--------------------------------------------------------------
    }

    @Override
    public void render(float delta) {
        if (spfBlackBelt.v2Location.x > spfSamurai.v2Location.x)
            isRight = false;
        if (spfBlackBelt.v2Location.x < spfSamurai.v2Location.x)
            isRight = true;
        //basicAttack();
        dPunchDelay1 += 0.1;
        dPunchDelay2 += 0.1;
        dSlappedTimer1 += 0.1;
        dSlappedTimer2 += 0.1;
        if (dSlappedTimer1 < 1)
            spfSamurai.v2Location.x += nKnockback;
        if (dSlappedTimer2 < 1)
            spfBlackBelt.v2Location.x += nKnockback;
        //
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

        if (spfSamurai.v2Location.y < -150) {
            P1HasWon = true;
            nWidth1 = 0;
        }
        if (spfBlackBelt.v2Location.y < -150) {
            P2HasWon = true;
            nWidth2 = 0;
        }
        spfSamurai.move(dSlappedTimer1);
        spfBlackBelt.move(dSlappedTimer2);

        //Animation Stuff-----------------------------------------------------------------------
        trTemp = (TextureRegion) araniBlackBelt[nPos].getKeyFrame(nFrame, false);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && spfBlackBelt.canMove) {
            nX = nX -= 1;
            if (spfBlackBelt.v2Location.x > spfSamurai.v2Location.x)
                nPos = 3;
            if (spfBlackBelt.v2Location.x < spfSamurai.v2Location.x)
                nPos = 1;
            nFrame++;
            if (nFrame > 9) {
                nFrame = 0;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && spfBlackBelt.canMove) {
            nX = nX += 1;
            if (spfBlackBelt.v2Location.x < spfSamurai.v2Location.x)
                nPos = 0;
            if (spfBlackBelt.v2Location.x > spfSamurai.v2Location.x)
                nPos = 2;
            nFrame++;
            if (nFrame > 9) {
                nFrame = 0;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            if (nPunchState == 1) {
                if (isRight == false)
                    nPos = 4;
                if (isRight == true)
                    nPos = 5;
                if (nFrame > 12) {
                    nPunchState = -1;
                    if (isRight == false)
                        nPos = 2;
                    if (isRight == true)
                        nPos = 0;
                }
                nFrame++;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            //nPos = 7;
            if (nFrame > 5) {
                if (isRight == false)
                    nPos = 7;
                if (isRight == true)
                    nPos = 6;
                nFrame = 6;
            }
            nFrame++;
        }

        if (!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            nFrame = 0;
            if (isRight)
                nPos = 0;
            if (!isRight)
                nPos = 2;
            //System.out.println(nFrame);
            nPunchState = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            nSecretToggle = 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.X)){
            nSecretToggle = 2;
        }
        //-------------------------------------------------------------------------------

        batch.begin();
        if(nSecretToggle == 1) {
            batch.draw(txDust, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.draw(txRockPlatform, 45, 10, 550, 200);
        }
        if(nSecretToggle == 2) {
            batch.draw(txSpace, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.draw(txSpacePlatform, 45, 10, 550, 200);
        }
        sprBlackBelt.setTexture(trTemp.getTexture());
        batch.draw(spfSamurai, spfSamurai.v2Location.x, spfSamurai.v2Location.y, spfSamurai.getWidth(), spfSamurai.getHeight());
        //Health Bar Scratch Stuff -----------------------
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
        //--------------------------------------------------
        batch.draw(trTemp, spfBlackBelt.v2Location.x, spfBlackBelt.v2Location.y, spfBlackBelt.getWidth(), spfBlackBelt.getHeight());
        if (P2HasWon && !P1HasWon)
            batch.draw(txP1Wins,170,100,300,300);
        if (P1HasWon && !P2HasWon)
            batch.draw(txP2Wins,170,100,300,300);
        batch.end();

        //Punching----------------------------------------------------------------------------------------
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && dPunchDelay1 > 2 && dSlappedTimer2 > 2) { //BlackBelt
            if (basicAttack(spfSamurai, spfBlackBelt)) {
                if (spfSamurai.isBlocking == true) {
                    fHealth2 += spfBlackBelt.BasicDamage / 2;
                    nWidth2 -= 11;
                    nKnockback /= 2;
                } else {
                    fHealth2 += spfBlackBelt.BasicDamage;
                    nWidth1 -= 22;
                }
                System.out.println("Player 2 health: " + fHealth2);
                dPunchDelay1 = 0;
                dSlappedTimer1 = 0;

                if (fHealth2 >= 0) {
                    System.out.println("Player 1 wins");
                    P1HasWon = true;
                    nWidth1 = 0;
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && dPunchDelay2 > 2 && dSlappedTimer1 > 2) {
            if (basicAttack(spfBlackBelt, spfSamurai)) {
                if (spfBlackBelt.isBlocking == true) {
                    fHealth1 -= spfSamurai.BasicDamage / 2;
                    nWidth2 += 11;
                    nKnockback /= 2;
                } else {
                    fHealth1 -= spfSamurai.BasicDamage;
                    nWidth2 += 22;
                }
                System.out.println("Player 1 health: " + fHealth1);
                dPunchDelay2 = 0;
                dSlappedTimer2 = 0;
                if (fHealth1 <= 0) {
                    System.out.println("Player 2 wins");
                    P2HasWon = true;
                    nWidth2 = 0;
                }
            }
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
