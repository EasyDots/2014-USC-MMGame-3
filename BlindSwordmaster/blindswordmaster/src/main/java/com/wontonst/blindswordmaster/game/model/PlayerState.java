package com.wontonst.blindswordmaster.game.model;

import com.wontonst.blindswordmaster.game.GameComponent;

/**
 * Created by roycr_000 on 2/9/14.
 */
public class PlayerState implements GameComponent {


    double counter;

    public boolean counterDone(){
        return this.counter <= 0;
    }
    @Override
    public void update(double fDelta) {
        this.counter -= fDelta;
    }
}
