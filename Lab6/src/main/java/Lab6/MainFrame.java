package Lab6;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    public DrawingPanel drawingPanel;
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);


        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, CENTER); //this is BorderLayout.CENTER
        add(configPanel,BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        //invoke the layout manager
        pack();
    }


    public DrawingPanel getDrawingPanel() {
        return canvas;
    }
}