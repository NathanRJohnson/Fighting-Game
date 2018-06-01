package gdx.scratch.attack;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.awt.print.Printable;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	//Texture txBB, txBL;
	public Fighter spfBlackBelt, spfBadLogic;
	Texture txSpace, txHitBox;
	double dHealth1 = 1000000, dHealth2 = 10000000;
	//HitBox Testers------
	public Sprite sprPunchBox1, sprPunchBox2;
	//---------------------

	@Override
	public void create () {
		batch = new SpriteBatch();
	//	txBB = new Texture("Fighting_Man.png");
	//	txBL = new Texture("badlogic.jpg");
		txHitBox = new Texture("HitBox.png");
		txSpace = new Texture("Space_BG.jpg");
		spfBadLogic = new Fighter("Ronin.png", 0,30,100,100,1);
		spfBlackBelt = new Fighter("Fighter_Man.png", 370,30,100,100,2);
		sprPunchBox1 = new Sprite(txHitBox);
		sprPunchBox2 = new Sprite(txHitBox);
	}

	@Override
	public void render () {
		//basicAttack();



		if (dHealth1 < 0.0)
			System.out.println("Player 2 wins");

		if (dHealth2 < 0.0)
			System.out.println("Player 1 wins");

		spfBadLogic.move();
		spfBlackBelt.move();
		batch.begin();
		batch.draw(txSpace,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch.draw(spfBlackBelt, spfBlackBelt.vLocation.x, spfBlackBelt.vLocation.y, spfBlackBelt.getWidth(), spfBlackBelt.getHeight());
		batch.draw(spfBadLogic, spfBadLogic.vLocation.x, spfBadLogic.vLocation.y, spfBadLogic.getWidth(), spfBadLogic.getHeight());
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			if (basicAttack(spfBadLogic,spfBlackBelt) == true)
				dHealth2 -= 10;

		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			if (basicAttack(spfBlackBelt,spfBadLogic) == true)
				dHealth1 -= 10;
		}
		batch.end();
	}
	public boolean basicAttack(Fighter spfPlayer, Fighter spfEnemy) {
		//System.out.println(fEnemy.vLocation.x +" " +fEnemy.getWidth());
		//System.out.println(spfPlayer.vLocation.x);
		//System.out.println();
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
