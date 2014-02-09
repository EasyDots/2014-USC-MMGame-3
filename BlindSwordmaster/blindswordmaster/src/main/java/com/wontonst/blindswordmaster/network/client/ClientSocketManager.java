package com.wontonst.blindswordmaster.network.client;

import com.wontonst.blindswordmaster.network.SocketManagerBase;
import com.wontonst.blindswordmaster.network.server.MainServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by roycr_000 on 2/8/14.
 */
public class ClientSocketManager extends SocketManagerBase{

    String hostName = "http://wontonst.com";
    public ClientSocketManager() {
    }

    public void connect() {

        int portNumber = MainServer.PORT;

        try {
            this.socket = new Socket(hostName, portNumber);
            this.connectRoutine();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}