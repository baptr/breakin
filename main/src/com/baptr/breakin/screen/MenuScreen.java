package com.baptr.breakin.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import com.baptr.breakin.BreakIn;

public class MenuScreen extends AbstractScreen {

    public MenuScreen(BreakIn ds) {
        super(ds);
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
        
        TextButton startButton = new TextButton("Start Game", getSkin());
        startButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game, "demo.tmx"));
            }
        });

        TextButton exitButton = new TextButton("Exit", getSkin());
        exitButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        
        table.add(startButton).minWidth(100f).row();
        table.row().pad(10f);
        table.add(exitButton).minWidth(100f);
    }
}
