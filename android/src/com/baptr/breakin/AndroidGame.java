package com.baptr.breakin;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.baptr.breakin.BreakIn;

public class AndroidGame extends AndroidApplication {
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new BreakIn(), false);
    }
}
