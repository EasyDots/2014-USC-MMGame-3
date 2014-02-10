package com.wontonst.blindswordmaster.game.controller;

import android.content.Context;

import com.wontonst.blindswordmaster.game.model.PlayerModel;
import com.wontonst.blindswordmaster.gesture.Gesture3DDetector;
import com.wontonst.blindswordmaster.network.client.ClientSocketManager;
import com.wontonst.blindswordmaster.sound.SoundManager;
import com.wontonst.blindswordmaster.vibrate.VibrateManager;

/**
 * Created by Roy Zheng on 2/9/14.
 */
public class ClientHelper {

    PlayerModel player;
    SoundManager sound;
    VibrateManager vibrate;
    CommandVerifier verifier;

    public ClientHelper(SoundManager sound, VibrateManager vibrate) {
        this.sound = sound;
        this.vibrate = vibrate;
    }

    public void startGame(Context ctx) {
        this.player = new PlayerModel();
        ClientSocketManager sock = new ClientSocketManager(player, sound, vibrate);
       this.verifier = new CommandVerifier(this.player, sock);
        Gesture3DDetector listener = new Gesture3DDetector(ctx, verifier);
        sock.connect();
        sock.startThread();
    }
    public CommandVerifier getVerifier(){
        return this.verifier;
    }


}
