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

    /**
     * Vi har på startsiden valgt nogle overskrifter at vise film under, f.eks. Netop Tilføjet.
     * under disse overskrifter viser vi seks film.
     */
    public MainPage(){
        menubarVisible = true;
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        main("Netop Tilføjet", new ImageIcon("resources/filmplakater/ET.jpg"),
                new ImageIcon("resources/filmplakater/Jaws.jpg"),
                new ImageIcon("resources/Serierforsider/24.jpg"),
                new ImageIcon("resources/Serierforsider/Daredevil.jpg"),
                new ImageIcon("resources/Serierforsider/Luke Cage.jpg"),
                new ImageIcon("resources/Serierforsider/Billions.jpg"));

        main("Populære", new ImageIcon("resources/filmplakater/Taxi Driver.jpg"),
                new ImageIcon("resources/filmplakater/Jurassic Park.jpg"),
                new ImageIcon("resources/filmplakater/West Side Story.jpg"),
                new ImageIcon("resources/Serierforsider/Jessica Jones.jpg"),
                new ImageIcon("resources/Serierforsider/Big Little Lies.jpg"),
                new ImageIcon("resources/filmplakater/Singin' In The Rain.jpg"));

    }
    public void main(String head, ImageIcon icon0, ImageIcon icon1, ImageIcon icon2, ImageIcon icon3,
                     ImageIcon icon4, ImageIcon icon5){

        mainPanel = new JPanel();

        //Netop Tilføje List
        JLabel header = new JLabel(head);
        header.setFont(new Font("Serif", Font.BOLD, 20));
        header.setBorder(new EmptyBorder(0, 250, 0, 0));
        
        poster = icon0;
        this.titel = new JButton(poster);
        mainPanel.add(this.titel);

        poster = icon1;
        this.titel = new JButton(poster);
        mainPanel.add(this.titel);

        poster = icon2;
        this.titel = new JButton(poster);
        mainPanel.add(this.titel);

        poster = icon3;
        this.titel = new JButton(poster);
        mainPanel.add(this.titel);

        poster = icon4;
        this.titel = new JButton(poster);
        mainPanel.add(this.titel);

        poster = icon5;
        this.titel = new JButton(poster);
        mainPanel.add(this.titel);

        JPanel themePanel = new JPanel(new BorderLayout());
        themePanel.add(header, BorderLayout.NORTH);
        themePanel.add(mainPanel, BorderLayout.CENTER);
        
        panel.setBorder(new EmptyBorder(40, 0, 0, 0));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(themePanel);
        panel.add(themePanel);
    }


}

