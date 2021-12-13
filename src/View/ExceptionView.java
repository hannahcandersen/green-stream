package View;

import javax.swing.*;
import java.awt.*;

/**
 * Den side repræsenterer pop op vinduerne, der popper op ved et exception
 */
public class ExceptionView {
    String exceptionMessage;

    /**
     *
     * @param exception
     */
    public ExceptionView(String exception) {
        this.exceptionMessage = exception;
        buildPage();
    }

    /**
     * Bygger pop op vindiet
     */
    private void buildPage() {
        JFrame exceptionFrame = new JFrame("Fejlbesked");
        exceptionFrame.setSize(600, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(151, 180, 121));
        exceptionFrame.add(panel);

        JLabel label = new JLabel();
        label.setText(exceptionMessage);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        panel.add(label);

        exceptionFrame.setLocationRelativeTo(null);
        exceptionFrame.setVisible(true);
        exceptionFrame.toFront();
    }

}
