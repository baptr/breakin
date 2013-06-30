package com.baptr.breakin.gfx;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Bullet extends Entity {
    private Vector2 v;
    private float speed = 100f;

    public Bullet(float x, float y, Vector2 direction, TextureRegion region) {
        super(region, x, y);
        v = direction.cpy().nor().scl(speed);
    }

    @Override
    public void update(float delta) {
        Vector2 mov = v.cpy().scl(delta);

        setPosition(getX() + mov.x, getY() - mov.y);
    }

}
