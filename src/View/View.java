package View;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    protected boolean menubarVisible = false;
    protected JPanel panel = new JPanel();

    protected final Color backgroundGreen = new Color(236, 242, 223);
    protected final Color limeGreen = new Color(196,224,177);

    public boolean isMenubarVisible() {
        return menubarVisible;
    }

    public JPanel getPanel() {
        return panel;
    }
    
    

}
