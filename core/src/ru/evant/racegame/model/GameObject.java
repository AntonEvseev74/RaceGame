package ru.evant.racegame.model;

// Родительский класс для игровых объектов

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;

abstract class GameObject {

    private Polygon bounds;
    private Sprite object;

    GameObject(TextureRegion textureRegion, float x, float y, float width, float height) {
        object = new Sprite(textureRegion);
        object.setSize(width, height);
        object.setPosition(x,y);
        object.setOrigin(width / 2f, height / 2f);

        bounds = new Polygon(new float[] {0, 0, width, 0, width, height, 0, height});
        bounds.setPosition(x,y);
        bounds.setOrigin(width / 2f, height / 2f);
    }

    public void draw(SpriteBatch batch) {
        object.setPosition(bounds.getX(), bounds.getY());
        object.setRotation(bounds.getRotation());
        object.draw(batch);
    }

    public Polygon getBounds() {
        return bounds;
    }
}
