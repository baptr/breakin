package com.baptr.breakin.screen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.controllers.Controllers;

import com.baptr.breakin.BreakIn;
import com.baptr.breakin.input.*;
import com.baptr.breakin.screen.AbstractScreen;
import com.baptr.breakin.gfx.*;
import com.baptr.breakin.entity.Entity.*;

public class GameScreen extends AbstractScreen {
    protected Color bgColor = new Color(0f, 0f, 0.5f, 1f);

    protected Avatar paddle;
    protected Array<Entity> entities;

    protected PathMarker pathMarker;

    protected static final int INITIAL_DEFENSE_CAPACITY = 64;
    
    public GameScreen(BreakIn game, String mapName) {
        super(game);
        camera.translate(Gdx.graphics.getWidth()/-2, Gdx.graphics.getHeight()/-2, 0);
        camera.update();
        input.addProcessor(new GameInputProcessor(camera, this));
        input.addProcessor(new CameraInputProcessor(camera));
        Controllers.addListener(new ControllerInputProcessor(this));
        assetManager.finishLoading();

        paddle = new Avatar(15, -64, getAtlas());
        entities = new Array<Entity>(false, INITIAL_DEFENSE_CAPACITY + 2);
        entities.add(paddle);
        pathMarker = new PathMarker(getAtlas().findRegion("gamescreen/marker"));
        GameUI ui = new GameUI(this, stage);
    }

    public PathMarker getPathMarker() {
        return pathMarker;
    }

    public Avatar getPlayer() {
        return paddle;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        camera.update();

        for(Entity e : entities) {
            e.update(delta);
        }
        entities.sort();
    }

    public void render(float delta) {
        this.update(delta);

        Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        
        for(Entity e : entities) {
            e.draw(batch);
        }

        batch.end();
        stage.draw();
    }
}
