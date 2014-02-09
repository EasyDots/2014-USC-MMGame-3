package com.wontonst.blindswordmaster.game.controller;

import com.wontonst.blindswordmaster.game.constants.CombatConstant;
import com.wontonst.blindswordmaster.game.constants.MoveConstant;
import com.wontonst.blindswordmaster.game.constants.OverrideConstant;
import com.wontonst.blindswordmaster.game.model.PlayerModel;
import com.wontonst.blindswordmaster.network.SocketManagerBase;
import com.wontonst.blindswordmaster.network.client.ClientSocketManager;

/**
 * Created by AaronHarris on 2/8/14.
 */
public class CommandVerifier {

    private PlayerModel player;
    SocketManagerBase socket;

    public CommandVerifier(PlayerModel model, SocketManagerBase socket) {
        this.player = model;
        this.socket = socket;
    }

    public void combatActionDetected(CombatConstant c) {
        if (player.getCombatState().getState() == CombatConstant.IDLE &&
                player.getOverrideState().getState() == OverrideConstant.NONE) {
            player.combatAction(c);
            socket.write(c.S_MSG);
        }
    }

    public void moveActionDetected(MoveConstant m) {
        if (player.getMoveState().getState() == MoveConstant.IDLE &&
                player.getOverrideState().getState() == OverrideConstant.NONE) {
            player.moveAction(m);
            socket.write(m.S_MSG);
        }
    }

    public void overrideActionDetected(OverrideConstant o) {
        player.overrideAction(o);
    }
}
