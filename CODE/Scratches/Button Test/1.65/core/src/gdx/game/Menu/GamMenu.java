package gdx.game.Menu;


import com.badlogic.gdx.Game;
import gdx.game.Screens.ScrBckgd;
import gdx.game.Screens.ScrStartMenu;


public class GamMenu extends Game {
    ScrStartMenu scrStartMenu;
    ScrBckgd scrbckgd;
    int nScreen;

    //0 for ScrMenu, 1 for ScrBckgd
    public void updateScreen(int _nScreen) {
        nScreen = _nScreen;
        if (nScreen == 0) {
            setScreen(scrStartMenu);
        } else if (nScreen == 1) {
            setScreen(scrbckgd);
        }
    }

    @Override
    public void create() {
        nScreen = 0;
        scrStartMenu = new ScrStartMenu(this);
        scrbckgd = new ScrBckgd(this);
        updateScreen(0);
    }

    @Override
    public void render() {
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