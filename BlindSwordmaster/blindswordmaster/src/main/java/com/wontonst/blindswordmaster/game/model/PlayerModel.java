package com.wontonst.blindswordmaster.game.model;

import com.wontonst.blindswordmaster.game.constants.CombatConstant;
import com.wontonst.blindswordmaster.game.constants.MoveConstant;
import com.wontonst.blindswordmaster.game.constants.OverrideConstant;

/**
 * Created by RoyZheng on 2/8/14.
 */
public class PlayerModel {

    CombatConstant m_combatState = CombatConstant.IDLE;
    MoveConstant m_moveState = MoveConstant.IDLE;
    OverrideConstant m_overrideState = OverrideConstant.NONE;

    double combatCounter = -1;
    double moveCounter = -1;
    double overrideCounter = -1;

    private double position;
    private double health;

    public CombatConstant getAttackState() {
        return this.m_combatState;
    }

    public MoveConstant getMoveState() {
        return this.m_moveState;
    }

    public OverrideConstant getOverrideState() {
        return this.m_overrideState;
    }

    public double getPosition() {
        return this.position;
    }


    public void combatAction(CombatConstant c) {
        m_combatState = c;

    }

    public void moveAction(MoveConstant m) {
        m_moveState = m;
    }

    public void overrideAction(OverrideConstant o) {
        m_overrideState = o;
    }

    public void receivedDamage(double d) {
        health -= d;
    }

    public CombatConstant updateCombatCounter(double fDelta) {
        if (this.combatCounter > 0) {
            this.combatCounter -= fDelta;
            return this.m_combatState;
        }
        return null;
    }

    public MoveConstant updateMoveCounter(double fDelta) {
        if (this.moveCounter > 0) {
            this.combatCounter -= fDelta;
            return this.m_moveState;
        }
        return null;
    }
}
