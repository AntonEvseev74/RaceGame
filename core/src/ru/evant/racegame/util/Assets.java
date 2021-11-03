package ru.evant.racegame.util;

// Класс управляет загрузкой атласа картинок

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {
    private String pathAtlas = "atlas.atlas";
    private AssetManager manager;

    public Assets(AssetManager manager) {
        this.manager = manager;
        manager.load(pathAtlas, TextureAtlas.class);
        manager.finishLoading();
    }

    public AssetManager getManager() {
        return manager;
    }

    public void dispose() {
        manager.dispose();
    }
}
