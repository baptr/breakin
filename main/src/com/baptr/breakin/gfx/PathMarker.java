package com.baptr.breakin.gfx;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.Array;

public class PathMarker extends Sprite {

    private FloatArray worldX;
    private FloatArray worldY;

    private int pathLength;

    private static final int INITIAL_PATH_CAPACITY = 32;

    public PathMarker(TextureRegion gfx) {
        super(gfx);
        worldX = new FloatArray(true, INITIAL_PATH_CAPACITY);
        worldY = new FloatArray(true, INITIAL_PATH_CAPACITY);
        pathLength = 0;
    }

    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }
}
