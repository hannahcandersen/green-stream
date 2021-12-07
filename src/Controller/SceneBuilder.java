package Controller;

import View.View;

import javax.swing.*;
import java.awt.*;

/**
 * Klassen der har vores Frame og skifter indholdet på siden
 */
public class SceneBuilder {

    // Det eneste Frame
    private JFrame theOnlyFrame;

    // Menubaren
    private JMenuBar menuBar;

    // Skærmens dimenstioner, højde og bredte
    private final Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();

    public SceneBuilder(JFrame frame) {
        // Får framet som parameter når Scenebuilder bliver instantieret i Controlleren
        theOnlyFrame = frame;
        // Sætter framets størrelse til skærmens størrelse
        theOnlyFrame.setSize(screenDim.width, screenDim.height);
        // Gør sådan at programmet stopper når man trykket på kryds
        theOnlyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Instanitere menubaren når den skal bruges, dvs første gang vi går ind på mainPage
    public void makeMenuBar(JMenuBar menubar) {
        this.menuBar = menubar;
    }

    /**
     * Metoden der skifter sidens indhold ud med page indhold
     * @param page - siden der skal vises
     */
    public void loadPage(View page) {

        // Fjerner alt fra framet
        theOnlyFrame.getContentPane().removeAll();
        // Sætter det nye indhold på siden
        theOnlyFrame.getContentPane().add(page.getPanel(), BorderLayout.CENTER);

        // Hvis menubaren skal være synlig sættes denne på framet ellers sættes den til null
        if (page.isMenubarVisible()) {
            theOnlyFrame.setJMenuBar(menuBar);
        }
        else {
            theOnlyFrame.setJMenuBar(null);
        }

        // sætter framet til at være synligt
        theOnlyFrame.setVisible(true);
    }

}
