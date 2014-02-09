package com.wontonst.blindswordmaster.game.controller;

import android.content.Context;

import com.wontonst.blindswordmaster.game.model.PlayerModel;
import com.wontonst.blindswordmaster.gesture.Gesture3DDetector;
import com.wontonst.blindswordmaster.network.client.ClientSocketManager;

/**
 * Created by Roy Zheng on 2/9/14.
 */
public class ClientHelper {

    PlayerModel player;

    public ClientHelper() {

    }

    public void startGame(Context ctx) {
        this.player = new PlayerModel();
        ClientSocketManager sock = new ClientSocketManager();
        CommandVerifier verifier = new CommandVerifier(this.player, sock);
        Gesture3DDetector listener = new Gesture3DDetector(ctx, verifier);
        sock.connect();
        sock.startThread();
    }


}
