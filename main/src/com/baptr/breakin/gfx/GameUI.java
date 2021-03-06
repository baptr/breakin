package com.baptr.breakin.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.graphics.Color;

import com.baptr.breakin.BreakIn;
import com.baptr.breakin.screen.GameScreen;

public class GameUI {
    Table buttons;
    final GameScreen gameScreen;

    static final Color HIT_COLOR = Color.BLUE;

    public GameUI(GameScreen screen, Stage stage) {
        this.gameScreen = screen;
        Skin skin = screen.getSkin();
        buttons = new Table(skin);
        buttons.setFillParent(false);
        buttons.pad(1.0f);

        final Label moveButton = (Label)buttons.add("Move").space(3.0f).getWidget();
        buttons.add("Basic").space(3.0f);
        buttons.add("Fire").space(3.0f);
        buttons.add("Water").space(3.0f);
        buttons.add("Spirit").space(3.0f);

        moveButton.setColor(HIT_COLOR);

        buttons.pack();
        buttons.addListener(new ClickListener() {
            Label lastHit = moveButton;
            public void clicked(InputEvent e, float x, float y) {
                Actor hit = buttons.hit(x, y, true);
                if(hit instanceof Label) {
                    if(lastHit != null) {
                        lastHit.setColor(1,1,1,1);
                    }
                    lastHit = (Label)hit;
                    lastHit.setColor(GameUI.HIT_COLOR);
                    String label = lastHit.getText().toString();
                    Gdx.app.log("GameUI", "" + hit);
                }
            }
        });

        stage.addActor(buttons);
    }
}
