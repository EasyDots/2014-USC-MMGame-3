package com.wontonst.blindswordmaster.game.model;

import com.wontonst.blindswordmaster.game.GameComponent;
import com.wontonst.blindswordmaster.game.constants.MoveConstant;

/**
 * Created by Roy Zheng on 2/8/14.
 */
public class MoveState extends PlayerState{
    enum State {
        MOVING, DONE
    }

    State state;
    MoveConstant constant;

    MoveState(MoveConstant c) {
        this.constant = c;
        this.counter = c.ACTION_TIME;
        this.state = State.MOVING;
    }
}
