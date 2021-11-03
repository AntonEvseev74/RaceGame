package ru.evant.racegame.control;

// Класс для управления машинкой

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;

import ru.evant.racegame.view.GameScreen;

public class CarController {
    private float speedCar; // скорость машинки
    private final float velocitySpeedCar = 10f; // скорость скорости машинки
    private final float speedCarMax = 10f; // максимальная скорость машинки
    private final float rotationSpeedCar = 30f; // скорость поворота машинки, за 1 сек поворот будет происходить на 30 градусов

    private final Polygon carBounds;

    public CarController(Polygon carBounds) {
        this.carBounds = carBounds;
    }

    public void handle() {
        speedCar();// управление скоростью
        turnCar();// управление поворотом машинки
        setCarPosition();// установить позицию машинки
    }

    /* Установить позицию машинки на экране */
    private void setCarPosition() {
        carBounds.setPosition
                (
                        carBounds.getX() + MathUtils.cosDeg(carBounds.getRotation() + 90) * speedCar * GameScreen.dt,
                        carBounds.getY() + MathUtils.sinDeg(carBounds.getRotation() + 90) * speedCar * GameScreen.dt
                );
    }

    /* управление поворотом машинки
     Угол > 0 = влево, Угол < 0 = вправо.
     */
    private void turnCar() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A))
            carBounds.rotate(rotationSpeedCar * speedCar * GameScreen.dt); // Угол > 0 = влево
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D))
            carBounds.rotate(-rotationSpeedCar * speedCar * GameScreen.dt); // Угол < 0 = вправо
    }

    /* управление скоростью
     Скорость > 0 = вперед, Скорость < 0 = назад.
     */
    private void speedCar() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W))
            speedCar += velocitySpeedCar * GameScreen.dt; // Скорость > 0 = вперед
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S))
            speedCar -= velocitySpeedCar * GameScreen.dt; // Скорость < 0 = назад
        else downSpeed();

        speedCar = sliceSpeed();
    }

    /* уменьшение скорости */
    private void downSpeed() {
        if (speedCar > velocitySpeedCar * GameScreen.dt)
            speedCar -= velocitySpeedCar * GameScreen.dt;
        else if (speedCar < velocitySpeedCar * GameScreen.dt)
            speedCar += velocitySpeedCar * GameScreen.dt;
        else speedCar = 0f;
    }

    /* ограничение скорости */
    private float sliceSpeed() {
        if (speedCar > speedCarMax) return speedCarMax;
        return Math.max(speedCar, -speedCarMax);
    }
}
