package com.baptr.breakin.domain;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.baptr.breakin.gfx.Entity;
import com.baptr.breakin.gfx.Defense;

/* A ring of defenses, at some radius, with some number of defenses */
public class Ring extends Entity {
    private Array<Defense> members;

    public Ring(float radius, int count, TextureAtlas atlas) {
        members = new Array<Defense>(count);
        Vector2 radial = new Vector2(0, radius);

        float rStep = 360.0f / count;

        for(int i = 0; i < count; i++) {
            radial.setAngle(rStep * i);
            members.add(new Defense(radial.x, radial.y, atlas));
        }
    }

    @Override
    public void update(float delta) {
        for(Defense d : members) {
            d.update(delta);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        for(Defense d : members) {
            d.draw(batch);
        }
    }
}


