package com.wontonst.blindswordmaster.model;

/**
 * Created by AaronHarris on 2/8/14.
 */
public class CommandVerifier {
    private PlayerModel player;

    public void attackActionDetected(CombatState c){
        player.combatActionDetected(c);
    }
    public void moveActionDetected(MoveState m){
        player.moveActionDetected(m);
    }
}
