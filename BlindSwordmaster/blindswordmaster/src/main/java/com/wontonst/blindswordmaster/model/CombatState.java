package com.wontonst.blindswordmaster.model;

import com.wontonst.blindswordmaster.game.GameComponent;

/**
 * Created by Roy Zheng on 2/8/14.
 */
public class CombatState implements GameComponent {
    enum State {
        ATTACKING,RECOVERING,DONE
    }

    State state;
    CombatConstant constant;
    double counter;

    public CombatState(CombatConstant constant) {
        this.counter = constant.ACTION_SPEED;
        this.state = State.ATTACKING;
    }

    @Override
    public void update(double fDelta) {
        this.counter -= fDelta;
        if (this.counter <= 0) {
            switch (this.state) {
                case ATTACKING:
                    this.state = State.RECOVERING;
                    break;
                case RECOVERING:
                    this.state = State.DONE;
                    break;
            }
        }
    }
}
