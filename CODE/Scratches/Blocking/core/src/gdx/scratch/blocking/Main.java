package gdx.scratch.blocking;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	public Fighter spfBlackBelt, spfBadLogic;
	Texture txSpace, txHitBox;
	double  dPunchDelay1 = 2, dPunchDelay2 = 2;
	float fHealth1 = 100, fHealth2 = -100;
	//HitBox Testers------
	public Sprite sprPunchBox1, sprPunchBox2;
	float fly = 0;
	//---------------------

	//KnockBack--------------;
	public double dSlappedTimer1 = 1, dSlappedTimer2 = 1;
	//-----------------------
	//Blocking--------------
	//----------------------

	@Override
	public void create () {
		batch = new SpriteBatch();

		txSpace = new Texture("Space_BG.jpg");
		spfBadLogic = new Fighter("Ronin.png", 0,30,100,100,1);
		spfBlackBelt = new Fighter("Fighter_Man.png", 370,30,100,100,2);

	}

	@Override
	public void render () {

		//basicAttack();
		dPunchDelay1 += 0.1;
		dPunchDelay2 += 0.1;
		dSlappedTimer1 += 0.1;
		dSlappedTimer2 += 0.1;
		if (dSlappedTimer1 < 1)
			spfBadLogic.vLocation.x -= 8 ;
		if (dSlappedTimer2 < 1)
			spfBlackBelt.vLocation.x += 8;
		spfBadLogic.move(dSlappedTimer1);
		spfBlackBelt.move(dSlappedTimer2);

		batch.begin();
		batch.draw(txSpace,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch.draw(spfBlackBelt, spfBlackBelt.vLocation.x, spfBlackBelt.vLocation.y, spfBlackBelt.getWidth(), spfBlackBelt.getHeight());
		batch.draw(spfBadLogic, spfBadLogic.vLocation.x, spfBadLogic.vLocation.y, spfBadLogic.getWidth(), spfBadLogic.getHeight());
		batch.end();

		if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && dPunchDelay1 > 2) { //BlackBelt
			if (basicAttack(spfBadLogic,spfBlackBelt)) {
				if (spfBadLogic.isBlocking == true){
					fHealth2 += spfBlackBelt.BasicDamage/2;
				} else {
					fHealth2 += spfBlackBelt.BasicDamage;
				}
				System.out.println("Player 2 health: "+ fHealth2);
				dPunchDelay1 = 0;
				dSlappedTimer1 = 0;
				if (fHealth2 > 0)
					System.out.println("Player 1 wins");
			}
			}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && dPunchDelay2 > 2) {
			if (basicAttack(spfBlackBelt,spfBadLogic)) {
				if (spfBlackBelt.isBlocking == true){
					fHealth1 -= spfBadLogic.BasicDamage/2;
				} else {
					fHealth1 -= spfBadLogic.BasicDamage;
				}
				System.out.println("Player 1 health: "+fHealth1);
					dPunchDelay2 = 0;
					dSlappedTimer2 = 0;

				if (fHealth1 < 0)
					System.out.println("Player 2 wins");
			}
		}


		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			spfBadLogic.vLocation.x += 20f;
		}

	}

	public boolean basicAttack(Fighter spfPlayer, Fighter spfEnemy) {
		if (spfPlayer.vLocation.x > spfEnemy.vLocation.x) {
			if (spfPlayer.vLocation.x < spfEnemy.vLocation.x + spfEnemy.getWidth()) {
				System.out.println("Get punched lefty");
				return true;
			}
		}
		if (spfPlayer.vLocation.x < spfEnemy.vLocation.x) {
			if (spfPlayer.vLocation.x > spfEnemy.vLocation.x - spfEnemy.getWidth()) {
				System.out.println("Get punched righty");
				return true;
			}
		}
		return false;
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
