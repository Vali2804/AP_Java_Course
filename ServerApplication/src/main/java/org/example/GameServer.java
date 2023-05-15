package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {

    public static void main(String[] args) throws Exception {
        try (ServerSocket listener = new ServerSocket(8100)) {
            System.out.println("Connect 5 Game Server is Running");
            System.out.println("Listening on IP Address: " + listener.getInetAddress());
            System.out.println("Listening on Port: " + listener.getLocalSocketAddress());
            System.out.println("Waiting for Connections...");

            while (true) {
                Game game = new Game();
                Game.Player player1 = game.new Player(listener.accept(), "RED");
                System.out.println("Player 1 has connected.");
                Game.Player player2 = game.new Player(listener.accept(), "YELLOW");
                System.out.println("Player 2 has connected.");
                player1.setOpponent(player2);
                player2.setOpponent(player1);
                game.currentPlayer = player1;
                player1.start();
                player2.start();
            }
        }
    }
}

class Game {
    private Player[] board = new Player[15 * 15];
    Player currentPlayer;

    public boolean isWinner() {
        // Check horizontal
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col <= 10; col++) {
                Player player = board[row * 15 + col];
                if (player != null &&
                        player == board[row * 15 + col + 1] &&
                        player == board[row * 15 + col + 2] &&
                        player == board[row * 15 + col + 3] &&
                        player == board[row * 15 + col + 4]) {
                    return true;
                }
            }
        }

        // Check vertical
        for (int col = 0; col < 15; col++) {
            for (int row = 0; row <= 10; row++) {
                Player player = board[row * 15 + col];
                if (player != null &&
                        player == board[(row + 1) * 15 + col] &&
                        player == board[(row + 2) * 15 + col] &&
                        player == board[(row + 3) * 15 + col] &&
                        player == board[(row + 4) * 15 + col]) {
                    return true;
                }
            }
        }

        // Check diagonal (top-left to bottom-right)
        for (int row = 0; row <= 10; row++) {
            for (int col = 0; col <= 10; col++) {
                Player player = board[row * 15 + col];
                if (player != null &&
                        player == board[(row + 1) * 15 + col + 1] &&
                        player == board[(row + 2) * 15 + col + 2] &&
                        player == board[(row + 3) * 15 + col + 3] &&
                        player == board[(row + 4) * 15 + col + 4]) {
                    return true;
                }
            }
        }

        // Check diagonal (top-right to bottom-left)
        for (int row = 0; row <= 10; row++) {
            for (int col = 4; col < 15; col++) {
                Player player = board[row * 15 + col];
                if      (player != null &&
                        player == board[(row + 1) * 15 + col - 1] &&
                        player == board[(row + 2) * 15 + col - 2] &&
                        player == board[(row + 3) * 15 + col - 3] &&
                        player == board[(row + 4) * 15 + col - 4]) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean boardFilledUp() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == null) {
                return false;
            }
        }
        return true;
    }

    public synchronized int moveCheck(int location, Player player) {
        if (player == currentPlayer && board[location] == null) {
            board[location] = currentPlayer;
            currentPlayer = currentPlayer.opponent;
            currentPlayer.opponentMoves(location);
            return location;
        }
        return -1;
    }

    class Player extends Thread {
        String mark;
        Player opponent;
        Socket socket;
        BufferedReader input;
        PrintWriter output;

        public Player(Socket socket, String mark) {
            this.socket = socket;
            this.mark = mark;
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
                output.println("WELCOME " + mark);
                output.println("MESSAGE Waiting for your opponent to connect!");
            } catch (IOException e) {
                System.out.println("Player Left: " + e);
            }
        }

        public void setOpponent(Player opponent) {
            this.opponent = opponent;
        }

        public void opponentMoves(int location) {
            output.println("OPPONENT_MOVED " + location);
            output.println(isWinner() ? "DEFEAT" : boardFilledUp() ? "TIE" : "");
        }

        public void run() {
            try {
                output.println("MESSAGE All players connected");

                if (mark.equals("RED")) {
                    output.println("MESSAGE Your move");
                }

                while (true) {
                    String command = input.readLine();
                    if (command.startsWith("MOVE")) {
                        int location = Integer.parseInt(command.substring(5));
                        int validLocation = moveCheck(location, this);
                        if (validLocation != -1) {
                            output.println("VALID_MOVE " + validLocation);
                            output.println(isWinner() ? "VICTORY" : boardFilledUp() ? "TIE" : "");
                        } else {
                            output.println("MESSAGE Wait your turn");
                        }
                    } else if (command.startsWith("QUIT")) {
                        System.out.println("Player Exited. Game Over.");
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("Player Left: " + e);
            } finally {
                if (opponent != null && opponent.output != null) {
                    opponent.output.println("OTHER_PLAYER_LEFT");
                }
                try {
                    socket.close();
                    System.out.println("Server Side Connection Closed.");
                } catch (IOException e) {
                    System.out.println("Player Left: " + e);
                    System.exit(1);
                }
            }
        }
    }
}

