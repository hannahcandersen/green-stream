package Controller;

import Model.StreamingService;
import View.View;
import View.Menubar;

import javax.swing.*;
import java.awt.*;

public class SceneBuilder {

    //private static final SceneBuilder sceneBuilder = new SceneBuilder();

    JFrame theOnlyFrame;

    StreamingService streamingService = StreamingService.getInstance();
    private final Color limeGreen = new Color(121, 186, 17);
    private final Color backgroundGreen = new Color(196,224,177);
    //Menubar menubarClass = new Menubar(limeGreen, streamingService.getGenreList(), streamingService.getCurrentProfile().getPicture());
    Menubar menubarClass = new Menubar(limeGreen, streamingService.getGenreList(), "Green");
    private final Dimension ScreenDim = Toolkit.getDefaultToolkit().getScreenSize();
    JMenuBar menuBar;

    public SceneBuilder(JFrame frame) {
        theOnlyFrame = frame;
        theOnlyFrame.setSize(ScreenDim.width, ScreenDim.height);
    }

    public void loadPage(View page) {

        theOnlyFrame.add(page.getPanel());

        if (page.isMenubarVisible()) {

            menuBar = menubarClass.makeMenu();
            theOnlyFrame.setJMenuBar(menuBar);
        }
        else {
            theOnlyFrame.setJMenuBar(null);
        }
        theOnlyFrame.setVisible(true);
    }

}
