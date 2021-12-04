package Controller;

import Model.StreamingService;
import View.View;
import View.Menubar;

import javax.swing.*;
import java.awt.*;

public class SceneBuilder {
    JFrame theOnlyFrame;

    private final Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    JMenuBar menuBar;
    protected final Color backgroundGreen = new Color(196,224,177);

    private JPanel contentPane;

    public SceneBuilder(JFrame frame) {

        theOnlyFrame = frame;
        theOnlyFrame.setSize(screenDim.width, screenDim.height);
        theOnlyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //contentPane = new JPanel();
        //contentPane.setPreferredSize(new Dimension(500, 400));
        //contentPane.setSize(new Dimension(500, 400));
        //theOnlyFrame.add(contentPane);
    }

    public void makeMenuBar(JMenuBar menubar) {
        this.menuBar = menubar;
    }

    public void loadPage(View page) {

        theOnlyFrame.getContentPane().removeAll();
        theOnlyFrame.getContentPane().add(page.getPanel(), BorderLayout.CENTER);
        theOnlyFrame.getContentPane().doLayout();

        if (page.isMenubarVisible()) {

            //menuBar = menubarClass.makeMenu();
            theOnlyFrame.setJMenuBar(menuBar);
        }
        else {
            theOnlyFrame.setJMenuBar(null);
        }
        theOnlyFrame.setVisible(true);
    }

}
