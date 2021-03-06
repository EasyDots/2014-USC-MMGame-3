package com.wontonst.blindswordmaster.network.client;

import android.util.Log;

import com.wontonst.blindswordmaster.game.constants.CombatConstant;
import com.wontonst.blindswordmaster.game.constants.MoveConstant;
import com.wontonst.blindswordmaster.game.model.PlayerModel;
import com.wontonst.blindswordmaster.network.GameMessage;
import com.wontonst.blindswordmaster.network.SocketManagerBase;
import com.wontonst.blindswordmaster.network.server.MainServer;
import com.wontonst.blindswordmaster.sound.GameSound;
import com.wontonst.blindswordmaster.sound.SoundManager;
import com.wontonst.blindswordmaster.vibrate.GameVibration;
import com.wontonst.blindswordmaster.vibrate.VibrateManager;

import java.net.Socket;

/**
 * Created by Roy Zheng on 2/8/14.
 */
public class ClientSocketManager extends SocketManagerBase {

    PlayerModel model;
    SoundManager sound;
    VibrateManager vibrator;

    public ClientSocketManager(PlayerModel model, SoundManager sound, VibrateManager vibrate) {
        this.model = model;
        this.sound = sound;
        this.vibrator = vibrate;
    }

    public void connect() {
        final ClientSocketManager me = this;
        (new Thread(new Runnable() {
            @Override
            public void run() {
                int portNumber = MainServer.PORT;

                try {
                    me.socket = new Socket(MainServer.HOST, portNumber);
                    me.connectRoutine();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        })).start();
    }

    @Override
    protected void handleMessage(String msg) {
        if (msg == GameMessage.HIT) {
            sound.playSoundOnce(GameSound.HIT);
        } else if (msg == GameMessage.DEAD) {
            vibrator.doVibrate(GameVibration.END_GAME);
        } else if (msg == GameMessage.VICTORY) {
            vibrator.doVibrate(GameVibration.END_GAME);
        } else {
            CombatConstant cc = CombatConstant.sMsgToCombatConstant(msg);
            if (cc != null) {
                if(cc.GAME_SOUND != null)
                    sound.playSoundOnce(cc.GAME_SOUND);
            } else {
                MoveConstant mc = MoveConstant.sMsgToMoveConstant(msg);
                if(mc != null && mc.GAME_SOUND != null)
                    sound.playSoundOnce(mc.GAME_SOUND);
            }
            vibrator.doVibrate(GameVibration.HIT);
        }
    }
}