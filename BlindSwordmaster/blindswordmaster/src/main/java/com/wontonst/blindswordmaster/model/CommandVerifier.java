package com.wontonst.blindswordmaster.model;

/**
 * Created by AaronHarris on 2/8/14.
 */
public class CommandVerifier {
    private PlayerModel player;
    // TODO: Add Socket

    public void combatActionDetected(CombatConstant c){
        if (player.m_combatState == CombatConstant.IDLE && player.m_overrideState == OverrideState.NONE)
            player.combatAction(c);

    }

    public void moveActionDetected(MoveConstant m){
        if (player.m_moveState == MoveConstant.IDLE)
            player.moveAction(m);
    }

    public void overrideActionDetected(OverrideState o) {
        player.overrideAction(o);
    }
}
