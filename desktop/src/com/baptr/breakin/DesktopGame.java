package com.baptr.breakin;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.utils.Array;
import com.baptr.breakin.BreakIn;

public class DesktopGame {
    public static void main(String[] args) {
        boolean splash = true;
        if(args.length > 0) {
            splash = false;
        }
        new LwjglApplication(new BreakIn(splash), "Operation: BreakIn", 1920, 1080, true);
    }
}
