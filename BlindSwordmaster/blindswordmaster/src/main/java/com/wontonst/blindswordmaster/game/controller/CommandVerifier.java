package com.wontonst.blindswordmaster.game.controller;

import com.wontonst.blindswordmaster.game.constants.CombatConstant;
import com.wontonst.blindswordmaster.game.constants.MoveConstant;
import com.wontonst.blindswordmaster.game.constants.OverrideConstant;
import com.wontonst.blindswordmaster.game.model.PlayerModel;

/**
 * Created by AaronHarris on 2/8/14.
 */
public class CommandVerifier {
    private PlayerModel player;
    // TODO: Add Socket

    public void combatActionDetected(CombatConstant c){
        if (player.m_combatState == CombatConstant.IDLE && player.m_overrideState == OverrideConstant.NONE)
            player.combatAction(c);

    }

    public void moveActionDetected(MoveConstant m){
        if (player.m_moveState == MoveConstant.IDLE)
            player.moveAction(m);
    }

    public void overrideActionDetected(OverrideConstant o) {
        player.overrideAction(o);
    }
}
