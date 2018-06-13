package gdx.game;

import com.badlogic.gdx.Game;
import gdx.game.Screens.ScrMenu;
import gdx.game.Screens.ScrGame;

public class GamMenu extends Game {
	ScrMenu scrMenu;
	ScrGame scrPlay;
	int nScreen;

	public void updateState(int _nScreen){
		nScreen = _nScreen;
		if(nScreen == 0){
			setScreen(scrMenu);
		}else if(nScreen == 1){
			setScreen(scrPlay);
		}
	}
	@Override
	public void create () {
		//  this.setScreen(new ScrMenu(this));
		nScreen = 0;
		scrMenu = new ScrMenu(this);
		scrPlay = new ScrGame(this);
		updateState(0);
	}

	@Override
	public void render () {
		super.render();
	}

	@Override

	public void pause() {

	}
	@Override
	public void resume() {

	}
	@Override
	public void resize(int width, int height) {

	}
	@Override
	public void dispose() {
		super.dispose();
	}

}
