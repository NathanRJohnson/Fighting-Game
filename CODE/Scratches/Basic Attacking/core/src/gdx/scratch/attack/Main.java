package gdx.scratch.attack;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//So if you attack and hit someone you still move, but if you miss you stop of a second.
public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    public Fighter spfBlackBelt, spfBadLogic;
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

    @Override
    public void create() {
        batch = new SpriteBatch();

        txHitBox = new Texture("HitBox.png");
        txSpace = new Texture("Disstrackting.jpg");
        spfBadLogic = new Fighter("Ronin.png", 0, 30, 100, 100, 1);
        spfBlackBelt = new Fighter("Fighter_Man.png", 370, 30, 100, 100, 2);
    }

    @Override
    public void render() {

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

    public void basicAttack(Fighter spfPlayer, Fighter spfEnemy) {
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
    public void dispose() {
        batch.dispose();
    }
}
