package com.wontonst.blindswordmaster.model;

/**
 * Created by RoyZheng on 2/8/14.
 */
public class PlayerModel {

    CombatState m_combatState = CombatState.IDLE;
    MoveState m_moveState = MoveState.IDLE;
    OverrideState m_overrideState = OverrideState.NONE;

    private double position;
    private double health;

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

    public void combatAction(CombatState c){
        m_combatState = c;

    }
    public void moveAction(MoveState m){
        m_moveState = m;
    }

    public void overrideAction(OverrideState o) {
        m_overrideState = o;
    }

    public void receivedDamage(double d) {
        health -= d;
    }
}
