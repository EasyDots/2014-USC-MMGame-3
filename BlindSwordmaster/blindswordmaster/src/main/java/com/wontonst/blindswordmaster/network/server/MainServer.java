package com.wontonst.blindswordmaster.network.server;

import com.wontonst.blindswordmaster.game.GameState;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roy Zheng on 2/8/14.
 */
public class MainServer {
public static String HOST = "54.83.1.170";
    public static int PORT = 8998;

    ServerSocket serverSocket;

    List<ServerSocketManager> awaiting_clients = new ArrayList<ServerSocketManager>();
    List<ServerSocketManager> playing_clients = new ArrayList<ServerSocketManager>();
    List<GameState> games = new ArrayList<GameState>();

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
                        if (awaiting_clients.size() <= 2) {
                            GameState gs = new GameState(awaiting_clients.get(0), awaiting_clients.get(1));
                            gs.start();
                            games.add(gs);
                            playing_clients.add(awaiting_clients.remove(0));
                            playing_clients.add(awaiting_clients.remove(0));
                        }
                    }
                }
            })).start();
        } catch (Exception ex) {
        }
    }

    public static void main(String[] args) {
        new MainServer();
        System.out.println("Server started...");
    }
}
