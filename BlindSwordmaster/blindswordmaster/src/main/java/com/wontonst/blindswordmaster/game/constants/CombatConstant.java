package com.wontonst.blindswordmaster.game.constants;

/**
 * Created by Roy Zheng on 2/8/14.
 */
public enum CombatConstant {
    IDLE(0, 0, 0, "CIDL"),
    SLASH_LEFT(1.25, 1, .5, "SL"), SLASH_RIGHT(1.25, 1, .5, "SR"), SLASH_UP(.9, .75, .5, "SU"), SLASH_DOWN(.9, .75, .5, "SD"),
    BLOCK_LEFT(.1, 0, .1, "BL"), BLOCK_RIGHT(.1, 0, .1, "BR"), BLOCK_UP(.1, 0, .1, "BU"), BLOCK_DOWN(.1, 0, .1, "BD"),
    COUNTER_LEFT(0, 1.25, .7, "CL"), COUNTER_RIGHT(0, 1.25, .7, "CR"), COUNTER_UP(0, 1, .5, "CU"), COUNTER_DOWN(0, 1, .5, "CD");

    CombatConstant(double atk_speed, double dmg, double recovery_time, String msg) {
        this.ACTION_SPEED = atk_speed;
        this.DAMAGE = dmg;
        this.RECOVERY_TIME = recovery_time;
        this.S_MSG = msg;
    }

    public double ACTION_SPEED;
    public double DAMAGE;
    public double RECOVERY_TIME;
    public String S_MSG;
}