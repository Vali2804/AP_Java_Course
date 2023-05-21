package org.example;


public class ServerApplication {

    public static void main(String[] args) {
        int port = 8018;
        GameServer server = new GameServer(port);
        server.start();
    }
}
