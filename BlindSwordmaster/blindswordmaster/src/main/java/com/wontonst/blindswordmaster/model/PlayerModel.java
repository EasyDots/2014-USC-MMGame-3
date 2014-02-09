package com.wontonst.blindswordmaster.model;

import java.util.List;

/**
 * Created by RoyZheng on 2/8/14.
 */
public class PlayerModel {

    AttackState m_attackState = AttackState.IDLE;
    MoveState m_moveState = MoveState.IDLE;
    OverrideState m_overrideState = OverrideState.NONE;

    private double position;

    public AttackState getAttackState(){
        return this.m_attackState;
    }
    public MoveState getMoveState(){
        return this.m_moveState;
    }
    public OverrideState getOverrideState(){
        return this.m_overrideState;
    }

    public double getPosition(){
        return this.position;
    }

    public void moveActionDetected(){

    }
    public void combatActionDetected(){

    }
}
