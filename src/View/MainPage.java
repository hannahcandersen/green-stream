package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainPage extends View {
    private JPanel mainPanel;
    private ImageIcon poster;
    private JLabel titel;

    public MainPage(){
        menubarVisible = true;
        panel.setLayout(new BorderLayout());
        main();
        // for test
        //String[] genre = new String[1];
        //menubarClass = new Menubar(limeGreen, frame, genre, "Green");
    }

    public void main(){

        mainPanel = new JPanel();

        poster = new ImageIcon("resources/filmplakater/ET.jpg");
        this.titel = new JLabel(poster);
        mainPanel.add(this.titel);

        poster = new ImageIcon("resources/filmplakater/Jaws.jpg");
        this.titel = new JLabel(poster);
        mainPanel.add(this.titel);

        poster = new ImageIcon("resources/Serierforsider/24.jpg");
        this.titel = new JLabel(poster);
        mainPanel.add(this.titel);

        poster = new ImageIcon("resources/Serierforsider/Daredevil.jpg");
        this.titel = new JLabel(poster);
        mainPanel.add(this.titel);

        panel.setBorder(new EmptyBorder(40, 0, 0, 0));
        panel.add(mainPanel, BorderLayout.CENTER);
    }
}

