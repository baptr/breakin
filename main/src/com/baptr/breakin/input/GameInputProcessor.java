package com.baptr.breakin.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import com.baptr.breakin.BreakIn;
import com.baptr.breakin.gfx.Avatar;
import com.baptr.breakin.screen.GameScreen;

public class GameInputProcessor extends AbstractInputProcessor {

    boolean dragged;
    Vector3 down;
    Vector3 touch;
    Vector3 move;
    GameScreen screen;
    OrthographicCamera camera;

    public static final int DRAG_THRESHOLD = 20;

    public GameInputProcessor(OrthographicCamera camera, GameScreen screen) {
        super();
        this.camera = camera;
        this.screen = screen;
        this.down = new Vector3();
        this.touch = new Vector3();
        this.move = new Vector3();
    }

    @Override
    public boolean keyTyped(char character) {
        switch(character) {
            case '1':
                break;
        }
        
        return true;
    }
    
    @Override
    public boolean keyDown(int keyCode)
    {
        Gdx.app.debug("Input Test", "key down: " + keyCode);
        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        dragged = false;
        down.set(x, y, 0);
        touch.set(x, y, 0);
        camera.unproject(touch);
        return false;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer) {
        if(!dragged && (Math.abs(x - down.x) +
                Math.abs(y-down.y)) >= DRAG_THRESHOLD) {
            dragged = true;
        } else if(!dragged) {
            // Keep camera from moving under DRAG_THRESHOLD
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        if(!dragged && button == 0) {

            return true;
        }
        return false;
    }
    
    @Override
    public boolean mouseMoved(int x, int y) {
        //move.set(x, y, 0);
        //camera.unproject(move);
        return false;
    }
}
