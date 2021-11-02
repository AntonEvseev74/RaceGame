package ru.evant.racegame.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.evant.racegame.model.Car;

public class GameScreen implements Screen {

    private Texture textureCar;
    private SpriteBatch batch;
    private Car car;

    @Override
    public void show() {
        batch = new SpriteBatch();
        textureCar = new Texture(Gdx.files.internal("car.png"));
        car = new Car(textureCar,0,0,80,150);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        //!
        batch.begin();
            car.draw(batch);
        batch.end();
        //!
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        textureCar.dispose();
        batch.dispose();
    }
}
