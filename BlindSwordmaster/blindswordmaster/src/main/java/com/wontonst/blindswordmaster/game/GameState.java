package com.wontonst.blindswordmaster.game;

import com.wontonst.blindswordmaster.model.PlayerModel;
import com.wontonst.blindswordmaster.sound.SoundManager;

/**
 * Created by RoyZheng on 2/8/14.
 */
public class GameState implements GameComponent {

    private SoundManager m_soundManager;
    private PlayerModel player, enemy;

    private Thread gameThread;

    boolean m_inGame = false;

    public boolean inGame() {
        return this.m_inGame;
    }

    public GameState() {

    }

    public void update(double fdelta) {

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
