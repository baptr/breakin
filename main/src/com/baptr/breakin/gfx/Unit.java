package com.baptr.breakin.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.baptr.breakin.BreakIn;
import com.baptr.breakin.entity.Entity.*;

public class Unit extends Entity {

    float speed = 100;
    Vector2 v;
    Vector2 dest;
    Facing facing;
    public UnitType unitType = UnitType.BASIC;;
    
    public Unit(float x, float y, TextureAtlas atlas, String ... animations) {
        super(x, y, atlas, animations);
        v = new Vector2();
        dest = new Vector2();
    }

    public Unit(TextureRegion region, float x, float y) {
        super(region, x, y);
        v = new Vector2();
        dest = new Vector2();
    }
    
    @Override
    public void update(float delta) {
        super.update(delta);

        //this.setPosition(moveToX, moveToY);
         
    }

    public boolean isMoving() {
        return false;
    }

    enum Facing {
        UP, DOWN, NORTH, SOUTH, EAST, WEST;
    }
}
