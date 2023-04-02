package Lab6;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    //create all buttons (Load, Exit, etc.)
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);

    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
    private void saveGame(ActionEvent e){

    }
    private void loadGame(ActionEvent e){

    }
    private void resetGame(ActionEvent e){
        frame.canvas.clear();
    }
}
