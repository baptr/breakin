package com.baptr.breakin.gfx;

import java.util.Iterator;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import com.baptr.breakin.gfx.*;
import com.baptr.breakin.entity.Entity.UnitType;

public class Avatar extends Unit {

    private String owner = "Local Player";
    private PathMarker marker;
    private Vector2 aim_in;
    private float aim_r;
    private Vector2 aim;
    private PathMarker aim_marker;
    private Array<Entity> bullets;
    private TextureRegion bullet_region;

    public Avatar(float x, float y, TextureAtlas atlas) {
        super(x, y, atlas, "Characters/Frank/Down", "Characters/Frank/East",
                "Characters/Frank/South");
        xOffset = -getRegionWidth()/2;
        yOffset = -2;
        speed = 600;
        this.unitType = UnitType.PLAYER;
        marker = new PathMarker(atlas);
        marker.setColor(0.25f, 0.25f, 0.25f, 0.5f);
        aim_r = 90f;
        aim = new Vector2(0f,-1f);
        aim_in = new Vector2();
        aim_marker = new PathMarker(atlas);
        bullets = new Array<Entity>(false, 32);
        bullet_region = atlas.findRegion("gamescreen/marker");
    }

    public void setOwner(String name) { owner = name; }
    public String getOwner() { return owner; }

    public void setControlVector(Vector2 v) { v.set(v); }
    public void setControlX(float x) { v.x = x; }
    public void setControlY(float y) { v.y = y; }

    public void setAimVector(Vector2 v) { aim_in.set(v); }
    public void setAimX(float x) { aim_in.x = x; }
    public void setAimY(float y) { aim_in.y = y; }

    @Override
    public void update(float delta) {
        Vector2 newpos = new Vector2(getX() + v.x * speed * delta,
                getY() - v.y * speed * delta);
        Vector2 dir = new Vector2(newpos).nor();
        if( aim_in.len() > 0.25 ) {
            aim.set(aim_in).nor();
            aim_r = 360f - aim.angle() - dir.angle();;
        }
        if( v.len() > 0.05 ) {
            marker.setPosition(getX() + v.x * 15.0f, getY() - v.y * 15.0f);
            newpos.nor().scl(480f);
            setPosition(newpos.x, newpos.y);
            aim.setAngle(360f - aim_r - dir.angle());
        }
        aim_marker.setPosition(getX() + aim.x * 60.0f, getY() - aim.y * 60.0f);
        for(Iterator<Entity> itr = bullets.iterator(); itr.hasNext(); ) {
            Entity b = itr.next();
            b.update(delta);
            if( ! b.onScreen() ) {
                itr.remove();
            }
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        if( v.len() > 0.05 ) {
            marker.draw(batch);
        }
        aim_marker.draw(batch);
        for(Entity e : bullets) {
            e.draw(batch);
        }
    }

    public void fire() {
        Bullet b = new Bullet(getX(), getY(), aim, bullet_region);
        bullets.add(b);
    }

}
