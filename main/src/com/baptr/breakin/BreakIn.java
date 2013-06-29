package com.baptr.breakin;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import com.baptr.breakin.screen.*;
import com.baptr.breakin.gfx.*;

public class BreakIn extends Game {

    public static final String LOG = BreakIn.class.getSimpleName();

    FPSLogger fpsLogger;
    private static final boolean CHECK_FPS = false;

    private boolean showSplash = false;

    public AssetManager manager;
    
    public BreakIn() {
        this(false);
    }

    public BreakIn(boolean showSplash) {
        super();
        this.showSplash = showSplash;
    }

    @Override
    public void create() {
    	fpsLogger =  new FPSLogger();
        manager = new AssetManager();
        
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        Gdx.app.log(BreakIn.LOG, "Version 0.1 starting");
        Gdx.graphics.setVSync(false);

        manager.finishLoading();

        setScreen(new GameScreen(this, "demu.tmx"));
    }

    @Override
    public void render() {
    	super.render();
    	if(CHECK_FPS) fpsLogger.log();
    }

    @Override
    public void resize(int width, int height) {
    	super.resize(width, height);
    }

    @Override
    public void pause() {
    	super.pause();
    }

    @Override
    public void resume() {
    	super.resume();
    }

    @Override
    public void dispose() {
    	super.dispose();
    }

    @Override
    public void setScreen(Screen screen) {
            super.setScreen(screen);
            Gdx.app.log(BreakIn.LOG, screen.getClass().getSimpleName());
    }
    
    public SplashScreen GetSplashScreen() {
    	return new SplashScreen(this);
    }
}

