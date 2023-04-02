package Lab6;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        Double lineProbability[]={1.0,2.0,3.0,4.0,5.0};
        linesCombo = new JComboBox(lineProbability);
        JButton createGame = new JButton("Create Game");
        //create the rest of the components

        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesCombo);
        add(createGame);
        createGame.addActionListener(this::createGame);

    }


    private void createGame(ActionEvent e){
        frame.getDrawingPanel().createBoard();
    }
}

