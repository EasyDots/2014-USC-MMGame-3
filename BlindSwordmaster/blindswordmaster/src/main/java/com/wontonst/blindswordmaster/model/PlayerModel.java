package com.wontonst.blindswordmaster.model;

/**
 * Created by RoyZheng on 2/8/14.
 */
public class PlayerModel {

    CombatState m_combatState = CombatState.IDLE;
    MoveState m_moveState = MoveState.IDLE;
    OverrideState m_overrideState = OverrideState.NONE;

    private double position;

    public CombatState getAttackState(){
        return this.m_combatState;
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

    public void combatActionDetected(CombatState c){
        m_combatState = c;
    }
    public void moveActionDetected(MoveState m){
        m_moveState = m;
    }
}
