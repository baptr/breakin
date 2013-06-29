package com.baptr.breakin.gfx;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import com.baptr.breakin.gfx.*;
import com.baptr.breakin.entity.Entity.UnitType;

public class Avatar extends Unit {

    private String owner = "Local Player";
    private PathMarker marker;
    private PathMarker t_mark;

    public Avatar(float x, float y, TextureAtlas atlas) {
        super(x, y, atlas, "Characters/Frank/Down", "Characters/Frank/East",
                "Characters/Frank/South");
        xOffset = -getRegionWidth()/2;
        yOffset = -2;
        speed = 300;
        this.unitType = UnitType.PLAYER;
        marker = new PathMarker(atlas);
        t_mark = new PathMarker(atlas);
        t_mark.setColor(0.5f, 0.25f, 0.25f, 0.5f);
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
        if( v.len() > 0.05 ) {
            marker.setPosition(getX() + v.x * 15.0f, getY() - v.y * 15.0f);
            Vector2 tang = new Vector2(getY(), getX()).nor();
            Vector2 move = tang.scl(v.dot(tang)*speed*delta);
            Vector2 newpos = new Vector2(getX() + move.x, getY() - move.y);
            newpos.nor().scl(480f);
            setPosition(newpos.x, newpos.y);
            t_mark.setPosition(getX() + tang.x * 15.0f, getY() - tang.y * 15.0f);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        if( v.len() > 0.05 ) {
            marker.draw(batch);
            t_mark.draw(batch);
        }
    }

}
