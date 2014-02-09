package com.wontonst.blindswordmaster.game.model;

import com.wontonst.blindswordmaster.game.GameComponent;
import com.wontonst.blindswordmaster.game.constants.OverrideConstant;

/**
 * Created by Roy Zheng on 2/9/14.
 */
public class OverrideState extends PlayerState {

    OverrideConstant constant;

    public OverrideState(OverrideConstant constant, double duration) {
        this.constant = constant;
        this.counter = duration;
    }

    public OverrideState(OverrideConstant constant) {
        this.constant = constant;
        this.counter = Double.MAX_VALUE;
    }

    public OverrideConstant getState() {
        return this.constant;
    }
}
