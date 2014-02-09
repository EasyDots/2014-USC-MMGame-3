package com.wontonst.blindswordmaster.model;

/**
 * Created by roycr_000 on 2/8/14.
 */
public enum MoveState {
    IDLE(0,"MIDL"), FORWARD_STEP(.4,"F"), BACKWARD_STEP(.4,"B"), FORWARD_RUN(.4,"FF"), BACKFLIP(.4,"BB");

    MoveState(double action_time, String msg){
        this.ACTION_TIME = action_time;
        this.S_MSG = msg;
    }
    double ACTION_TIME;
    String S_MSG;
}