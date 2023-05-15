import javax.swing.*;
import java.awt.*;

class Square extends JPanel {
    JLabel label = new JLabel((Icon)null);

    public Square() {
        setBackground(Color.white);
        add(label);
    }

    public void setText(char text) {
        label.setText(text + "");
    }

    public void setIcon(Icon icon) {
        label.setIcon(icon);
    }
}
