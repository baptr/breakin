package com.baptr.breakin.gfx;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import com.baptr.breakin.gfx.*;
import com.baptr.breakin.entity.Entity.UnitType;

public class Avatar extends Unit {

    private String owner = "Local Player";

    public Avatar(float x, float y, TextureAtlas atlas) {
        super(x, y, atlas, "Characters/Frank/Down", "Characters/Frank/East",
                "Characters/Frank/South");
        xOffset = -getRegionWidth()/2;
        yOffset = -2;
        speed = 200;
        this.unitType = UnitType.PLAYER;
    }

    public void setOwner(String name) {
        owner = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setControlVector(Vector2 v) {
       v.set(v);
    }

    public void setControlX(float x) {
        v.x = x;
    }
    
    public void setControlY(float y) {
        v.y = y;
    }

    @Override
    public void update(float delta) {
        setPosition(getX() + v.x * speed * delta, getY() + v.y * speed * delta);
    }

}
