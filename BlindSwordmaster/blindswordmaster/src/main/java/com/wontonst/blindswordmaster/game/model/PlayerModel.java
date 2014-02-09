package com.wontonst.blindswordmaster.game.model;

import com.wontonst.blindswordmaster.game.GameComponent;
import com.wontonst.blindswordmaster.game.constants.CombatConstant;
import com.wontonst.blindswordmaster.game.constants.MoveConstant;
import com.wontonst.blindswordmaster.game.constants.OverrideConstant;

/**
 * Created by RoyZheng on 2/8/14.
 */
public class PlayerModel implements GameComponent {

    CombatState m_combatState = new CombatState(CombatConstant.IDLE);
    MoveState m_moveState = new MoveState(MoveConstant.IDLE);
    OverrideState m_overrideState = new OverrideState(OverrideConstant.NONE);

    private double position;
    private double health;

    public CombatState getCombatState() {
        return this.m_combatState;
    }

    public MoveState getMoveState() {
        return this.m_moveState;
    }

    public OverrideState getOverrideState() {
        return this.m_overrideState;
    }

    public double getPosition() {
        return this.position;
    }


    public void combatAction(CombatConstant c) {
        synchronized (m_combatState) {
            m_combatState = new CombatState(c);
        }
    }

    public void moveAction(MoveConstant m) {
        synchronized (m_moveState) {
            m_moveState = new MoveState(m);
        }
    }

    public void overrideAction(OverrideConstant o) {
        synchronized (m_overrideState) {
            m_overrideState = new OverrideState(o);
        }
    }

    public void receivedDamage(double d) {
        health -= d;
    }

    @Override
    public void update(double fDelta) {
        synchronized (this.m_combatState) {
            this.m_combatState.update(fDelta);
        }
        synchronized (this.m_moveState) {
            this.m_moveState.update(fDelta);
        }
        synchronized (this.m_overrideState) {
            this.m_overrideState.update(fDelta);
        }
    }
}
