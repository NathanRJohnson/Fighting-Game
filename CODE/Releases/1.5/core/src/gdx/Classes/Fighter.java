package gdx.Classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Fighter extends Sprite {
    int nPlayer;
    public PVector vLocation, vVelocity, vAcceleration;
    double dMaxFall;
    double dCeiling = 230; //Maximum Jump Height

    public Fighter(String sFile, int nX, int nY, int nW, int nH, int _nPlayer) {
        super(new Texture(sFile));
        vLocation = new PVector(nX, nY);
        vVelocity = new PVector(0, 0);
        vAcceleration = new PVector(0, 0);

        dMaxFall = 5;
        setSize(nW, nH);
        setPosition(nX,nY);
        setFlip(true, false);
        nPlayer = _nPlayer;
    }

    public void move(Fighter f) {
        vVelocity.add(vAcceleration);
        vLocation.add(vVelocity);
        vAcceleration.mult(0);

        if (nPlayer == 1) {
            if (Gdx.input.isKeyPressed(Input.Keys.A))
                vLocation.x -= 3f;

            if (Gdx.input.isKeyPressed(Input.Keys.D))
                vLocation.x += 5f;

            if( vLocation.y < dCeiling) {
                if (Gdx.input.isKeyPressed(Input.Keys.W))
                    vVelocity.y = 10f;

            }
        }
        if (nPlayer == 2) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
                vLocation.x -= 5f;

            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
                vLocation.x += 3f;
            if( vLocation.y < dCeiling) {
                if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                    vVelocity.y = 10f;
                }
            }
        }
    }
    public void applyForce (PVector vForce){
        PVector f = vForce.get();
        vAcceleration.add(f);

    }
}