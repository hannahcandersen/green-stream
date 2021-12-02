package Controller;

import Model.StreamingService;
import View.View;
import View.Menubar;

import javax.swing.*;
import java.awt.*;

public class SceneBuilder {

    JFrame frame;
    JPanel contentPane;
    StreamingService streamingService = StreamingService.getInstance();
    private final Color limeGreen = new Color(121, 186, 17);
    private final Color backgroundGreen = new Color(196,224,177);
    //Menubar menubarClass = new Menubar(limeGreen, streamingService.getGenreList(), streamingService.getCurrentProfile().getPicture());
    Menubar menubarClass = new Menubar(limeGreen, streamingService.getGenreList(), "Green");
    private final Dimension ScreenDim = Toolkit.getDefaultToolkit().getScreenSize();
    JMenuBar menuBar;

    public SceneBuilder(JFrame frame) {
        this.frame = frame;
        frame.setSize(ScreenDim.width, ScreenDim.height);
        Container container = frame.getContentPane();
        contentPane = new JPanel();
        contentPane.setBackground(backgroundGreen);
        container.add(contentPane);

        menuBar = menubarClass.makeMenu();
    }

    public void loadPage(View page) {

        frame.add(page.getPanel());

        if (page.isMenubarVisible()) {
            frame.setJMenuBar(menuBar);
        }
        else {
            frame.setJMenuBar(null);
        }
        frame.setVisible(true);
    }

}
