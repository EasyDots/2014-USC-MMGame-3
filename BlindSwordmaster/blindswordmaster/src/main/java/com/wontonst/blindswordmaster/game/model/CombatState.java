package com.wontonst.blindswordmaster.game.model;

import com.wontonst.blindswordmaster.game.GameComponent;
import com.wontonst.blindswordmaster.game.constants.CombatConstant;

/**
 * Created by Roy Zheng on 2/8/14.
 */
public class CombatState extends PlayerState implements GameComponent {
    enum State {
        ATTACKING, DONE
    }

    State state;
    CombatConstant constant;

    public CombatState(CombatConstant constant) {
        this.counter = constant.ACTION_SPEED;
        this.state = State.ATTACKING;
    }

    public CombatConstant getState() {
        return this.constant;
    }
}
