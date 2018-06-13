package gdx.scratch;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture txSheet;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		txSheet = new Texture("BlackBelt_SS");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(txSheet, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		txSheet.dispose();
	}
}
