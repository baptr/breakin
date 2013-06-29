package com.baptr.breakin.gfx;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PathMarker extends Entity {

    public PathMarker(TextureAtlas atlas) {
        super(0, 0, atlas, "gamescreen/marker");
        xOffset = -getRegionWidth()/2;
        yOffset = getRegionHeight()/2;
    }

}
