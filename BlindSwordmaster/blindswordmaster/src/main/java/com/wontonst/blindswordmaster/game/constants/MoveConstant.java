package com.wontonst.blindswordmaster.game.constants;

import com.wontonst.blindswordmaster.sound.GameSound;

/**
 * Created by roycr_000 on 2/8/14.
 */
public enum MoveConstant {
    IDLE(0, "MIDL", null), FORWARD_STEP(.4, "F", GameSound.MOVE_FORWARD), BACKWARD_STEP(.4, "B",GameSound.MOVE_FORWARD), FORWARD_RUN(.4, "FF", null), BACKFLIP(.4, "BB", null);

    MoveConstant(double action_time, String msg, GameSound gs) {
        this.ACTION_TIME = action_time;
        this.S_MSG = msg;
        this.GAME_SOUND = gs;
    }

    public double ACTION_TIME;
    public GameSound GAME_SOUND;
    public String S_MSG;

    public MoveConstant sMsgToMoveConstant(String smsg) {
        for (MoveConstant c : MoveConstant.values()) {
            if (c.S_MSG == smsg) {
                return c;
            }
        }
        return null;
    }
}