package ru.evant.racegame.control;

// Класс для управления машинкой

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;

import ru.evant.racegame.view.GameScreen;

public class CarController {
    private Polygon carBounds;

    public CarController(Polygon carBounds) {
        this.carBounds = carBounds;
    }

    float speedCar; // скорость машинки
    float velocitySpeedCar = 0.02f; // скорость скорости машинки
    float speedCarMax = 3f; // максимальная скорость машинки
    public void handle(){
        // управление скоростью
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W))
            speedCar += velocitySpeedCar;
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S))
            speedCar -= velocitySpeedCar;
        else downSpeed();

        speedCar = sliceSpeed();
        ///

        //

        ///

        carBounds.setPosition(carBounds.getX() + MathUtils.cosDeg(carBounds.getRotation() + 90) * speedCar * GameScreen.dt,
                carBounds.getY() + MathUtils.sinDeg(carBounds.getRotation() + 90) * speedCar * GameScreen.dt);
    }

    // уменьшение скорости
    private void downSpeed() {
        if (speedCar > velocitySpeedCar) speedCar -= velocitySpeedCar;
        else if (speedCar < velocitySpeedCar) speedCar += velocitySpeedCar;
        else speedCar = 0f;
    }

    // ограничение скорости
    private float sliceSpeed(){
        if (speedCar > speedCarMax) return speedCarMax;
        if (speedCarMax < -speedCarMax) return -speedCarMax;
        return speedCar;
    }
}
