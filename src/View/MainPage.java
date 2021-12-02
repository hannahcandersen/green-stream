package View;

import javax.swing.*;
import java.awt.*;

public class MainPage {
    private JPanel mainPanel;
    private JFrame frame;
    // Vores grundfarver
    private final Color limeGreen = new Color(121, 186, 17);
    private final Color backgroundGreen = new Color(196,224,177);
    private Menubar menubarClass;

    private final Dimension ScreenDim = Toolkit.getDefaultToolkit().getScreenSize();

    public MainPage(){
        frame = new JFrame();

        // for test
        String[] genre = new String[1];
        menubarClass = new Menubar(limeGreen, frame, genre, "Green");
    }
}

