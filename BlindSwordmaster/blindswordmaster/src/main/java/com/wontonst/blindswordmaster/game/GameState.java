package com.wontonst.blindswordmaster.game;

import com.wontonst.blindswordmaster.game.constants.MoveConstant;
import com.wontonst.blindswordmaster.game.model.MoveState;
import com.wontonst.blindswordmaster.game.model.PlayerModel;
import com.wontonst.blindswordmaster.sound.SoundManager;

/**
 * Created by RoyZheng on 2/8/14.
 */
public class GameState implements GameComponent {


    public static double STEP_SPEED = 1;
    public static double RUN_SPEED = 2.75;
    public static double BACKFLIP_SPEED = 2;
    public static double MIN_PLAYER_DISTANCE = .5;
    public static double MAX_PLAYER_DISTANCE = 5;
    public static double STRIKE_RANGE = 1;

    private SoundManager m_soundManager;
    //Player one faces to the right, Player 2 faces to the left. Moving to the left is moving in negative direction.
    private PlayerModel player1, player2;

    private Thread gameThread;

    boolean m_inGame = false;

    public boolean inGame() {
        return this.m_inGame;
    }

    public GameState() {

    }

    public void update(double dDelta) {
        player1.update(dDelta);
        player2.update(dDelta);

        this.updateMovement(this.player1, dDelta);
        this.updateMovement(this.player2, dDelta);
    }

    private void updateMovement(PlayerModel player, double dDelta) {
        boolean isPlayer1 = player == player1;
        PlayerModel other = isPlayer1 ? player2 : player1;
        int multiplier = isPlayer1 ? 1 : -1;// movement direction helper

        if (player.getMoveState().counterDone()) {
            player.stateChange(new MoveState(MoveConstant.IDLE));
        } else {
            switch (player.getMoveState().getState()) {
                case IDLE:
                    break;
                case FORWARD_STEP:

                case FORWARD_RUN:
                case BACKWARD_STEP:
                case BACKFLIP:
            }
        }
    }

    public void start() {
        final GameState self = this;
        this.gameThread = new Thread(new Runnable() {

            @Override
            public void run() {
                long last_time = System.nanoTime();
                while (self.inGame()) {
                    long curr_time = System.nanoTime();
                    double fdelta = (curr_time - last_time) * 0.000001;
                    self.update(fdelta);
                    last_time = curr_time;
                }
            }
        });
    }
}
