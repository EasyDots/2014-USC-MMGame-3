package com.wontonst.blindswordmaster.model;

/**
 * Created by Roy Zheng on 2/8/14.
 */
public enum CombatState {
    IDLE(0, 0, 0),
    LEFT_SLASH(1.25, 1, .5), RIGHT_SLASH(1.25, 1, .5), UPPERCUT(.9, .75, .5), POKE(.9, .75, .5),
    BLOCK_LEFT(.1, 0, .1), BLOCK_RIGHT(.1, 0, .1), BLOCK_UP(.1, 0, .1), BLOCK_POKE(.1, 0, .1),
    COUNTER_LEFT(0, 1.25, .7), COUNTER_RIGHT(0, 1.25, .7), COUNTER_UP(0, 1, .5), COUNTER_POKE(0, 1, .5);

    CombatState(double atk_speed, double dmg, double recovery_time) {
        this.ACTION_SPEED = atk_speed;
        this.DAMAGE = dmg;
        this.RECOVERY_TIME = recovery_time;
    }

    double ACTION_SPEED;
    double DAMAGE;
    double RECOVERY_TIME;
}