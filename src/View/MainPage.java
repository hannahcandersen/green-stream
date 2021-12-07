package View;

import Model.Media;
import Model.StreamingService;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MainPage extends View {
    private JPanel mainPanel;
    private StreamingService streamingService;
    private ImageIcon poster;
    private JButton titel;


    public MainPage(){
        menubarVisible = true;
        panel.setLayout(new GridLayout(2,1));
        makeJustAdded();

        //this.justAdded = new ArrayList<>();
        //this.popular = new ArrayList<>();
        //this.suggested = new ArrayList<>();
        // for test
        //String[] genre = new String[1];
        //menubarClass = new Menubar(limeGreen, frame, genre, "Green");
    }
    public void makeJustAdded(){

        mainPanel = new JPanel();

        //Netop Tilføje List
        JLabel header = new JLabel("Netop Tilføjet");
        header.setFont(new Font("Serif", Font.BOLD, 20));
        
        poster = new ImageIcon("resources/filmplakater/ET.jpg");
        this.titel = new JButton(poster);
        mainPanel.add(this.titel);

        poster = new ImageIcon("resources/filmplakater/Jaws.jpg");
        this.titel = new JButton(poster);
        mainPanel.add(this.titel);

        poster = new ImageIcon("resources/Serierforsider/24.jpg");
        this.titel = new JButton(poster);
        mainPanel.add(this.titel);

        poster = new ImageIcon("resources/Serierforsider/Daredevil.jpg");
        this.titel = new JButton(poster);
        mainPanel.add(this.titel);

        poster = new ImageIcon("resources/Serierforsider/Big Little Lies.jpg");
        this.titel = new JButton(poster);
        mainPanel.add(this.titel);

        poster = new ImageIcon("resources/Serierforsider/Billions.jpg");
        this.titel = new JButton(poster);
        mainPanel.add(this.titel);

        JPanel themePanel = new JPanel(new BorderLayout());
        themePanel.add(header, BorderLayout.NORTH);
        themePanel.add(mainPanel, BorderLayout.CENTER);
        
        panel.setBorder(new EmptyBorder(40, 0, 0, 0));

        panel.add(themePanel);
    }

    public void makePopular(){

    }
    public void main(){

        mainPanel = new JPanel();

    }
}

