import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class GameClient {

    private JFrame frame = new JFrame("Welcome to Five-in-a-row");
    private JLabel messageLabel = new JLabel("...");

    private Square[] board = new Square[225]; // 15 columns x 15 rows
    private Square square;
    private ImageIcon disc;
    private ImageIcon opponentDisc;

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String name;
    String response;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameClient(String serverAddress) throws Exception {

        socket = new Socket(serverAddress, 8100);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        messageLabel.setBackground(Color.lightGray);
        frame.getContentPane().add(messageLabel, BorderLayout.SOUTH);

        JPanel boardPanel = new JPanel();
        boardPanel.setBackground(Color.blue);

        boardPanel.setLayout(new GridLayout(15, 15, 3, 3)); // 15 columns x 15 rows
        for (int i = 0; i < board.length; i++) {
            final int j = i;
            board[i] = new Square();
            board[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    square = board[j];
                    out.println("MOVE " + j);
                }
            });
            boardPanel.add(board[i]);
        }
        frame.getContentPane().add(boardPanel, BorderLayout.CENTER);
    }

    public void play() throws Exception {
        try {
            String response;
            response = in.readLine();

            if (response.startsWith("WELCOME")) {
                String mark = response.substring(8);
                if (mark.equals("RED")) {
                    disc = new ImageIcon(Objects.requireNonNull(getClass().getResource("redDisc.png")));
                    opponentDisc = new ImageIcon(Objects.requireNonNull(getClass().getResource("yellowDisc.png")));
                } else {
                    disc = new ImageIcon(Objects.requireNonNull(getClass().getResource("yellowDisc.png")));
                    opponentDisc = new ImageIcon(Objects.requireNonNull(getClass().getResource("redDisc.png")));
                }

                frame.setTitle("Five-in-a-row: " + name + " is the color " + mark + ".");
            }

            while (true) {
                response = in.readLine();
                if(response.startsWith("exit")){
                    break;
                }else if (response.startsWith("VALID_MOVE")) {
                    messageLabel.setText("Valid Move, Opponent's Turn, Please Wait...");
                    square = board[Integer.parseInt(response.substring(10).trim())];
                    square.setIcon(disc);
                    square.repaint();
                    System.out.println("Valid move made.");

                } else if (response.startsWith("OPPONENT_MOVED")) {
                    int loc = Integer.parseInt(response.substring(15).trim());
                    board[loc].setIcon(opponentDisc);
                    board[loc].repaint();
                    messageLabel.setText("Opponent Moved. Your Turn Again!");
                    System.out.println("Opponent Moved.");

                } else if (response.startsWith("VICTORY")) {
                    JOptionPane.showMessageDialog(frame, "Congratulations, you WON!!!");
                    System.out.println("Player Won.");
                    break;

                } else if (response.startsWith("DEFEAT")) {
                    JOptionPane.showMessageDialog(frame, "Sorry, You LOST!!");
                    System.out.println("Player Lost.");
                    break;

                } else if (response.startsWith("TIE")) {
                    JOptionPane.showMessageDialog(frame, "You TIED with your Opponent!!");
                    System.out.println("Players Tied.");
                    break;

                } else if (response.startsWith("MESSAGE")) {
                    messageLabel.setText(response.substring(8));
                    System.out.println("Message");

                } else if (response.startsWith("OTHER_PLAYER_LEFT")) {
                    JOptionPane.showMessageDialog(frame, "Other Player left");
                    System.out.println("Other Player Exited.");
                    break;
                }
            }
            out.println("QUIT");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
            frame.dispose();
        }
    }

    private boolean playAgain() {
        int response = JOptionPane.showConfirmDialog(frame, "Want to play again?", "GAME OVER", JOptionPane.YES_NO_OPTION);
        frame.dispose();
        return response == JOptionPane.YES_OPTION;
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            GameClient c = new GameClient("localhost");
            Scanner s = new Scanner(System.in);
            System.out.println("Please enter your name: ");
            c.setName(s.nextLine());
            System.out.println("--- Game Command Log --- ");
            c.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            c.frame.setSize(720, 720);
            c.frame.setVisible(true);
            c.frame.setResizable(false);
            c.play();

            if (!c.playAgain()) {
                break;
            }
        }
    }
}

