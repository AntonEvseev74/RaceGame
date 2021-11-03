package ru.evant.racegame.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.evant.racegame.model.Car;

public class GameScreen implements Screen {
    public static float dt; // delta time

    private SpriteBatch batch;

    private TextureAtlas textureAtlas;

    private Car car;
    private float baseSizeCar = 1f; // базовый размер картинки машинки(в данном случае ширина)

    private OrthographicCamera camera;

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        car = new Car(textureAtlas.findRegion("car"), 0, 0, baseSizeCar, baseSizeCar * 2);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        dt = delta;

        batch.setProjectionMatrix(camera.combined);
        //!
        batch.begin();
        car.draw(batch);
        batch.end();
        //!
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height / width; // Соотношение сторон
        camera = new OrthographicCamera(20f, 20f * aspectRatio);
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
        batch.dispose();
    }
}
