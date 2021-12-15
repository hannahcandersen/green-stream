package View;

import javax.swing.*;
import java.awt.*;

/**
 * View klassen som alle sider nedarver fra, bortset fra menubaren og ExceptionView
 */
public abstract class View {
    protected boolean menubarVisible = false;

    protected JPanel panel = new JPanel();


    // Vores grundfarver
    protected final Color backgroundGreen = new Color(236, 242, 223);
    protected final Color limeGreen = new Color(196,224,177);
    protected final Color darkerGreen = new Color(151, 180, 121);

    /**
     * Getter metode for om menubaren er synlig
     * @return menubaren er synlig
     */
    public boolean isMenubarVisible() {
        return menubarVisible;
    }

    /**
     * Getter metode for panelet som alt indhold er på
     * @return panelet med indhold
     */
    public JPanel getPanel() {
        return panel;
    }
}
