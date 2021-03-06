package com.wontonst.blindswordmaster.game.constants;

import com.wontonst.blindswordmaster.sound.GameSound;

/**
 * Created by Roy Zheng on 2/8/14.
 */
public enum CombatConstant {
    IDLE(0, 0, 0, "CIDL", null),
    SLASH_LEFT(1.25, 1, .5, "SL", GameSound.LEFT_SLASH), SLASH_RIGHT(1.25, 1, .5, "SR", GameSound.RIGHT_SLASH), SLASH_UP(.9, .75, .5, "SU",null), SLASH_DOWN(.9, .75, .5, "SD",null),
    BLOCK_LEFT(.1, 0, .1, "BL",null), BLOCK_RIGHT(.1, 0, .1, "BR",null), BLOCK_UP(.1, 0, .1, "BU",null), BLOCK_DOWN(.1, 0, .1, "BD",null),
    COUNTER_LEFT(0, 1.25, .7, "CL", GameSound.LEFT_HIT), COUNTER_RIGHT(0, 1.25, .7, "CR",GameSound.RIGHT_HIT), COUNTER_UP(0, 1, .5, "CU",null), COUNTER_DOWN(0, 1, .5, "CD",null);

    CombatConstant(double atk_speed, double dmg, double recovery_time, String msg, GameSound sound) {
        this.ACTION_SPEED = atk_speed;
        this.DAMAGE = dmg;
        this.RECOVERY_TIME = recovery_time;
        this.S_MSG = msg;
    }

    public double ACTION_SPEED;
    public double DAMAGE;
    public double RECOVERY_TIME;
    public GameSound GAME_SOUND;
    public String S_MSG;

    public static CombatConstant sMsgToCombatConstant(String smsg){
        for (CombatConstant c : CombatConstant.values()){
            if(c.S_MSG == smsg){
                return c;
            }
        }
        return null;
    }
}