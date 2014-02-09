package com.wontonst.blindswordmaster.network.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roy Zheng on 2/8/14.
 */
public class MainServer {

    public static int PORT = 8998;

    ServerSocket serverSocket;

    List<ServerSocketManager> clients = new ArrayList<ServerSocketManager>();

    public MainServer() {

        try {
            this.serverSocket = new ServerSocket(PORT);
            final ServerSocket selfserver = this.serverSocket;
            (new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        ServerSocketManager connection = new ServerSocketManager();
                        connection.connect(selfserver);
                    }
                }
            })).start();
        } catch (Exception ex) {
        }
    }

}
