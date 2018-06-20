package gdx.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class SprFighter extends Sprite {
    int nPlayer;
    public Vector2 v2Location, v2Velocity, v2Acceleration;
   public boolean canMove;
    double dMaxFall;
    double dCeiling = 230; //Maximum Jump Height
    double dDelay;
    public int BasicDamage = 10;

    public SprFighter(String sFile, int nX, int nY, int nW, int nH, int _nPlayer) {
        super(new Texture(sFile));
        v2Location = new Vector2(nX, nY);
        v2Velocity = new Vector2(0, 0);
        v2Acceleration = new Vector2(0, 0);
        canMove = true;
        dMaxFall = 5;
        setSize(nW, nH);
        setPosition(nX, nY);
        nPlayer = _nPlayer;
        if (nPlayer == 1) {
            setFlip(false, false);
        } else {
            setFlip(true, false);
        }
    }

    public void move(double dTime) {
        v2Velocity.add(v2Acceleration);
        v2Location.add(v2Velocity);
        v2Acceleration.setZero();

        if (nPlayer == 1) {
            dDelay += 0.1;
            if (Gdx.input.isKeyPressed(Input.Keys.A) && dTime >= 2 && canMove == true)
                v2Location.x -= 4f;

            if (Gdx.input.isKeyPressed(Input.Keys.D) && dTime >= 2 && canMove == true)
                v2Location.x += 4f;

            if (v2Location.y < dCeiling && dDelay > 3) {
                if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                    dDelay = 0;
                    v2Velocity.y = 10f;
                }
            }
        }

        if (nPlayer == 2) {
            dDelay += 0.1;
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)&& dTime >= 2 && canMove)
                v2Location.x -= 4f;

            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)&& dTime >= 2 && canMove)
                v2Location.x += 4f;

            if (v2Location.y < dCeiling && dDelay > 3) {
                if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                    v2Velocity.y = 10f;
                    dDelay = 0;
                }
            }
        }
    }

    public void applyForce(Vector2 v2Force) {
        Vector2 f = v2Force.cpy();
        v2Acceleration.add(f);

    }
}
