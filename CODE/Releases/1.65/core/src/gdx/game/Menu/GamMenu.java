package gdx.game.Menu;


import com.badlogic.gdx.Game;
import gdx.game.Screens.*;

public class GamMenu extends Game {
    ScrPlay scrPlay;
    ScrMenu scrMenu;
    ScrBckgd scrBckgd;
    ScrScratch scrScratch;
    ScrScratchAnimation scrScratchAnimation;
    ScrScratchBasicA scrScratchBasicA;
    ScrScratchBlock scrScratchBlock;
    ScrScratchHealth scrScratchHealth;
    int nScreen;


    // 0 start menu, 1 play screen, 2 play background
    public void updateScreen(int _nScreen) {
        nScreen = _nScreen;
        if (nScreen == 0) {
            setScreen(scrMenu);
        } else if (nScreen == 1) {
            setScreen(scrPlay);
        }else if(nScreen ==2){
            setScreen(scrBckgd);
        }else if(nScreen==3){
            setScreen(scrScratch);
        }else if(nScreen ==10){
            setScreen(scrScratchAnimation);

        }else if(nScreen ==11){
            setScreen(scrScratchBasicA);

        }else if(nScreen ==12){
            setScreen(scrScratchBlock);

        }else if(nScreen ==13){
            setScreen(scrScratchHealth);

        }
    }

    @Override
    public void create() {
        nScreen = 0;
        scrMenu = new ScrMenu(this);
        scrPlay = new ScrPlay(this);
        scrBckgd = new ScrBckgd(this);
        scrScratch = new ScrScratch(this);
        scrScratchAnimation = new ScrScratchAnimation(this);
        scrScratchBasicA = new ScrScratchBasicA(this);
        scrScratchBlock = new ScrScratchBlock(this);
        scrScratchHealth = new ScrScratchHealth(this);
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
