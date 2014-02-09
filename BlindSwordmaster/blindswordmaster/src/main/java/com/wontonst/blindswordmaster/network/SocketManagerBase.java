package com.wontonst.blindswordmaster.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by roycr_000 on 2/8/14.
 */
public abstract class SocketManagerBase implements Runnable {

    protected PrintWriter out;
    protected BufferedReader in;
    protected Socket socket;
    protected Thread thisthread;

    protected void connectRoutine() throws IOException {
        this.out = new PrintWriter(this.socket.getOutputStream(), true);
        this.in = new BufferedReader(
                new InputStreamReader(this.socket.getInputStream()));
    }

    public String read() {
        String t = null;
        try {
            t = in.readLine();
        } catch (Exception x) {
            x.printStackTrace();
        }
        return t;
    }

    public void startThread() {
        this.thisthread = new Thread(this);
        this.thisthread.start();
    }

    public void run() {
        while (true) {
            this.handleMessage(this.read());
        }
    }

    protected abstract void handleMessage(String msg);

    public void write(String str) {
        out.print(str);
    }
}
