package ru.evant.racegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import ru.evant.racegame.util.Assets;
import ru.evant.racegame.view.GameScreen;

public class Main extends Game {

    private Screen gameScreen;
    private Assets assets;

    @Override
    public void create() {
        assets = new Assets();
        gameScreen = new GameScreen();
		setScreen(gameScreen);
    }
}
