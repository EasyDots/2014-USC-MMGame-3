package com.wontonst.blindswordmaster.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by roycr_000 on 2/8/14.
 */
public class MainServer {

    ServerSocket serverSocket;

    public MainServer() {
        int portNumber = 8998;

        try {
            this.serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        } catch (Exception ex) {
        }
    }

}
