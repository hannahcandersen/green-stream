package View;

import Controller.MainPageController;
import Model.Media;
import Model.StreamingService;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MainPage extends View {
    private JPanel mainPanel;
    private ImageIcon poster;
    private JButton titel;
    private JPanel endPane;
    private JScrollPane scrollPane;
    private JPanel themePanel;

    MainPageController mainPageController;

    /**
     * Vi har på startsiden valgt nogle overskrifter at vise film under, f.eks. Netop Tilføjet.
     * under disse overskrifter viser vi seks film.
     */
    public MainPage(MainPageController mainPageController){

        this.mainPageController = mainPageController;

        menubarVisible = true;
        panel.setLayout(new BorderLayout());
        this.endPane = new JPanel(new GridLayout(5, 1));
        endPane.setBorder(new EmptyBorder(40, 0, 0, 0));
        endPane.setBackground(backgroundGreen);

        ImageIcon bigPic = new ImageIcon("Pictures/avatar.jpg");


        Image image = bigPic.getImage();
        image = image.getScaledInstance(700, 300,  java.awt.Image.SCALE_SMOOTH);
        bigPic = new ImageIcon(image);

        JLabel bigLabel = new JLabel(bigPic);
        //bigLabel.setSize(500, 100);

        endPane.add(bigLabel);

       addMedia();


        this.scrollPane = new JScrollPane(endPane);
        panel.setBackground(backgroundGreen);
        panel.add(scrollPane);



    }

    public void main(String head, String icon0, String icon1, String icon2, String icon3,
                     String icon4, String icon5, String icon6){

        mainPanel = new JPanel();
        mainPanel.setBackground(backgroundGreen);


        //Netop Tilføje List
        JLabel header = new JLabel(head, SwingConstants.CENTER);
        header.setBackground(backgroundGreen);
        header.setFont(new Font("Serif", Font.BOLD, 30));
        header.setBorder(new EmptyBorder(20, 0, 0, 0));

        
        poster = new ImageIcon(icon0);
        this.titel = new JButton(poster);
        titel.setContentAreaFilled(false);
        titel.setBackground(limeGreen);
        titel.setBorder(new EmptyBorder(0, 0, 0, 0));
        titel.addActionListener(e -> mainPageController.showMediaActionListener(icon0));
        mainPanel.add(this.titel);

        poster = new ImageIcon(icon1);
        this.titel = new JButton(poster);
        titel.setContentAreaFilled(false);
        titel.setBackground(limeGreen);
        titel.setBorder(new EmptyBorder(0, 0, 0, 0));
        titel.addActionListener(e -> mainPageController.showMediaActionListener(icon1));
        mainPanel.add(this.titel);

        poster = new ImageIcon(icon2);
        this.titel = new JButton(poster);
        titel.setContentAreaFilled(false);
        titel.setBackground(limeGreen);
        titel.setBorder(new EmptyBorder(0, 0, 0, 0));
        titel.addActionListener(e -> mainPageController.showMediaActionListener(icon2));
        mainPanel.add(this.titel);

        poster = new ImageIcon(icon3);
        this.titel = new JButton(poster);
        titel.setContentAreaFilled(false);
        titel.setBackground(limeGreen);
        titel.setBorder(new EmptyBorder(0, 0, 0, 0));
        titel.addActionListener(e -> mainPageController.showMediaActionListener(icon3));
        mainPanel.add(this.titel);

        poster = new ImageIcon(icon4);
        this.titel = new JButton(poster);
        titel.setContentAreaFilled(false);
        titel.setBackground(limeGreen);
        titel.setBorder(new EmptyBorder(0, 0, 0, 0));
        titel.addActionListener(e -> mainPageController.showMediaActionListener(icon4));
        mainPanel.add(this.titel);

        poster = new ImageIcon(icon5);
        this.titel = new JButton(poster);
        titel.setContentAreaFilled(false);
        titel.setBackground(limeGreen);
        titel.setBorder(new EmptyBorder(0, 0, 0, 0));
        titel.addActionListener(e -> mainPageController.showMediaActionListener(icon5));
        mainPanel.add(this.titel);

        poster = new ImageIcon(icon6);
        this.titel = new JButton(poster);
        titel.setContentAreaFilled(false);
        titel.setBackground(limeGreen);
        titel.setBorder(new EmptyBorder(0, 0, 0, 0));
        titel.addActionListener(e -> mainPageController.showMediaActionListener(icon6));
        mainPanel.add(this.titel);

        themePanel = new JPanel(new BorderLayout());
        themePanel.setBackground(backgroundGreen);
        themePanel.add(header, BorderLayout.NORTH);
        themePanel.add(mainPanel, BorderLayout.CENTER);

        endPane.add(this.themePanel);

    }

    public void addMedia(){
        main("Populære", "resources/filmplakater/Taxi Driver.jpg",
                "resources/filmplakater/Good Will Hunting.jpg",
                "resources/filmplakater/West Side Story.jpg",
                "resources/Serierforsider/Jessica Jones.jpg",
                "resources/Serierforsider/Big Little Lies.jpg",
                "resources/filmplakater/Singin' In The Rain.jpg",
                "resources/Serierforsider/Sex & The City.jpg");


        main("Forslag til dig", "resources/filmplakater/Forrest Gump.jpg",
                "resources/filmplakater/Jurassic Park.jpg",
                "resources/filmplakater/Pulp Fiction.jpg",
                "resources/Serierforsider/Ally McBeal.jpg",
                "resources/Serierforsider/Battlestar Galactica.jpg",
                "resources/Serierforsider/Glow.jpg",
                "resources/Serierforsider/Game Of Thrones.jpg");


        main("Netop Tilføjet", "resources/filmplakater/ET.jpg",
                "resources/filmplakater/Jaws.jpg",
                "resources/Serierforsider/24.jpg",
                "resources/Serierforsider/Daredevil.jpg",
                "resources/Serierforsider/Luke Cage.jpg",
                "resources/Serierforsider/Billions.jpg",
                "resources/Serierforsider/Sons Of Anarchy.jpg");

        //main("Silkes forslag")
        //main("Hannahs forslag")
        //main("Marvel")
        //main("GreenStream")
    }
}

