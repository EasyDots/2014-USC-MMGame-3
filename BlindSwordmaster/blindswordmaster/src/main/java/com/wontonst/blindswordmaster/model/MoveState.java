package com.wontonst.blindswordmaster.model;

import com.wontonst.blindswordmaster.game.GameComponent;

/**
 * Created by Roy Zheng on 2/8/14.
 */
public class MoveState implements GameComponent {
    enum State {
        MOVING, DONE
    }

    State state;
    MoveConstant constant;
    double counter;

    MoveState(MoveConstant c) {
        this.constant = c;
        this.counter = c.ACTION_TIME;
        this.state = State.MOVING;
    }

    @Override
    public void update(double fDelta) {
        counter -= fDelta;
        if (counter <= 0)
    }
}
