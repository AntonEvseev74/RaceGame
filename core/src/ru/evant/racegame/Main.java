package ru.evant.racegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import ru.evant.racegame.view.GameScreen;

public class Main extends Game {

    private Screen gameScreen;

    @Override
    public void create() {
        gameScreen = new GameScreen();
		setScreen(gameScreen);
    }
}
