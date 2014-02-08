package com.wontonst.blindswordmaster.model;

/**
 * Created by RoyZheng on 2/8/14.
 */
public class WorldModel {
PlayerModel player, enemy;
    public void playerPerformed(PlayerAction action){

    }
    public void enemyPerformed(PlayerAction action){

    }
    public PlayerModel getPlayer(){
        return this.player;
    }
    public PlayerModel getEnemy(){
        return this.enemy;
    }
}
