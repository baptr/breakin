package com.baptr.breakin.gfx;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class Defense extends Unit {
    private Vector2 radial;
    private float angle;
    public Defense(float x, float y, TextureAtlas atlas) {
        super(x, y, atlas, "Characters/Sheep/sheep1");
        xOffset = -getRegionWidth()/2;
        yOffset = -getRegionHeight()/2;
        radial = new Vector2(x, y);
        speed = 32;
        angle = radial.angle();
    }

    public void update(float delta) {
        angle = (angle + speed * delta) % 360;
        radial.setAngle(angle);
        setPosition(radial.x, radial.y);
    }
}
