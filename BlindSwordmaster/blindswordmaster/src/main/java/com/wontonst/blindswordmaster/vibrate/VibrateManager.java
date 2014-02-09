package com.wontonst.blindswordmaster.vibrate;

import android.content.Context;
import android.os.Vibrator;
import java.util.HashMap;

/**
 * Created by Aaron Harris on 2/9/14.
 */
public class VibrateManager {
    Context c;
    Vibrator v;
    private boolean hasVib;
    private static final long[] blockPattern = {0, 200, 50, 200};
    private static final long[] hitPattern = {0, 50, 20, 50, 20, 50, 20, 50, 20, 50, 20, 50, 20};
    private static final long[] startGamePattern = {0, 500};
    private static final long[] endGamePattern = {0, 400, 100, 200};



    private static HashMap<GameVibration, long[]> vibrationMap;

    public VibrateManager(Context c) {
        this.c = c;
        v = (Vibrator) c.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void doVibrate(GameVibration vib) {
        if (vibrationMap == null) {
            load();
        }
        if (v != null) {
            v.vibrate(vibrationMap.get(vib), -1);
        }
    }

    private void load() {
        vibrationMap = new HashMap<GameVibration, long[]>(7);
        vibrationMap.put(GameVibration.BLOCK, blockPattern);
        vibrationMap.put(GameVibration.HIT, hitPattern);
        vibrationMap.put(GameVibration.START_GAME, startGamePattern);
        vibrationMap.put(GameVibration.END_GAME, endGamePattern);
    }
}
