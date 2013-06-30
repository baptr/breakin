package com.baptr.breakin.input;

import com.baptr.breakin.screen.GameScreen;
import com.baptr.breakin.gfx.Avatar;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.controllers.*;
import com.badlogic.gdx.scenes.scene2d.*;

public class ControllerInputProcessor implements ControllerListener {
    private GameScreen screen;
    private Avatar player;

    public ControllerInputProcessor(GameScreen s) {
        screen = s;
    }
    public void connected(Controller controller) {
        screen.log("Controller connected!");
    }

    public void disconnected(Controller controller) {
        screen.log("Controller disconnected!");
    }

    public boolean buttonDown (Controller controller, int buttonCode) {
        screen.log("Controller down %d", buttonCode);

        return false;
    }

    public boolean buttonUp (Controller controller, int buttonCode) {
        screen.log("Controller up %d", buttonCode);

        return false;
    }

    public boolean axisMoved (Controller controller, int axisCode, float value) {
        if(player != null) {
            if(axisCode == 0) {
                player.setControlX(value);
            } else if(axisCode == 1) {
                player.setControlY(-1*value);
            } else {
                screen.log("Controller axisMoved %d to %f", axisCode, value);
            }
        } else {
            player = screen.getPlayer();
        }

        return false;
    }

    public boolean povMoved (Controller controller, int povCode, PovDirection value) {
        screen.log("Controller povMoved %d to %f", povCode, value);

        return false;
    }

    public boolean xSliderMoved (Controller controller, int sliderCode, boolean value) {
        screen.log("Controller xSliderMoved %d to %f", sliderCode, value);

        return false;
    }

    public boolean ySliderMoved (Controller controller, int sliderCode, boolean value) {
        screen.log("Controller ySliderMoved %d to %f", sliderCode, value);

        return false;
    }

    public boolean accelerometerMoved (Controller controller, int accelerometerCode, Vector3 value) {
        screen.log("Controller accelMoved %d to %f %f %f", accelerometerCode, value.x, value.y, value.z);

        return false;
    }
}
