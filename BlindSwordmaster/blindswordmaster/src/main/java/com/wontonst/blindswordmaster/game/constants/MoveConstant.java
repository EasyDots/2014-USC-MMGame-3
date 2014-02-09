package com.wontonst.blindswordmaster.game.constants;

/**
 * Created by roycr_000 on 2/8/14.
 */
public enum MoveConstant {
    IDLE(0,"MIDL"), FORWARD_STEP(.4,"F"), BACKWARD_STEP(.4,"B"), FORWARD_RUN(.4,"FF"), BACKFLIP(.4,"BB");

    MoveConstant(double action_time, String msg){
        this.ACTION_TIME = action_time;
        this.S_MSG = msg;
    }
   public double ACTION_TIME;
   public String S_MSG;
}