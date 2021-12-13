package View;

import Controller.MainPageController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainPage extends View {
    MainPageController mainPageController;
    private JPanel posterPanel, categoryPanel, mainPanel;
    private JLabel bigLabel, categoryLable;
    private ImageIcon poster, bigPic;
    private JButton posterButton;
    private JScrollPane scrollPane;

    /**
     * Instantiere controlleren og bygger siden
     * @param mainPageController  - Sidens controller
     */
    public MainPage(MainPageController mainPageController){
        this.mainPageController = mainPageController;
        menubarVisible = true;

        // Add det store reklame billede
        bigPic = new ImageIcon(new ImageIcon("Pictures/inter.png").getImage().getScaledInstance(800, 300, Image.SCALE_DEFAULT));
        bigLabel = new JLabel(bigPic);

    //  Opretter mainPanel
        mainPanel = new JPanel(new GridLayout(5, 1));
        mainPanel.setBorder(new EmptyBorder(40, 0, 0, 0));
        mainPanel.setBackground(backgroundGreen);
        mainPanel.add(bigLabel);

       addMedia();
    }

    /**
     *
     * @param head - Titlen på selve kategorien listen af medierne
     * @param icon0 - Første medie i listen af kategorierne
     * @param icon1 - Andet medie i listen af kategoriern
     * @param icon2 - Tredje medie i listen af kategoriern
     * @param icon3 - Fjerde medie i listen af kategoriern
     * @param icon4 - Femte medie i listen af kategoriern
     * @param icon5 - Sjette medie i listen af kategoriern
     * @param icon6 - Syvende medie i listen af kategoriern
     */
    public void buildMainPage(String head, String icon0, String icon1, String icon2, String icon3, String icon4, String icon5, String icon6){
    // Opretter categoryPanel
        categoryPanel = new JPanel(new BorderLayout());
        //Kategorierne for navne for `head`
        categoryLable = new JLabel(head, SwingConstants.CENTER);
        categoryLable.setFont(new Font("Serif", Font.BOLD, 30));
        categoryLable.setBorder(new EmptyBorder(20, 0, 0, 0));

    // Opretter posterPanel
        posterPanel = new JPanel();
        // Tilføjer posterne til knapper via et Array
        String[] iconArr = {icon0, icon1, icon2, icon3, icon4, icon5, icon6};
        for (String icon: iconArr) {
            poster = new ImageIcon(icon);
            posterButton = new JButton(poster);
            posterButton.setContentAreaFilled(false);
            posterButton.setBackground(limeGreen);
            posterButton.setBorder(new EmptyBorder(0, 0, 0, 0));
            posterButton.addActionListener(e -> mainPageController.showMediaActionListener(icon));
            posterPanel.add(posterButton);
        }
    // Sætter Backgrund color
        posterPanel.setBackground(backgroundGreen);
        categoryLable.setBackground(backgroundGreen);
        categoryPanel.setBackground(backgroundGreen);

    // Sammensætter categoryPanel
        categoryPanel.add(categoryLable, BorderLayout.NORTH);
        categoryPanel.add(posterPanel, BorderLayout.CENTER);

        mainPanel.add(categoryPanel);

    // Sammensætter til et panel
        panel.setLayout(new BorderLayout());
        panel.add(mainPanel);

        // Laver scroll panen
        scrollPane = new JScrollPane(mainPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Sætter hastigheden for hvor hurtig man kan scrolle
        panel.setBackground(backgroundGreen);
        panel.add(scrollPane);
    }

    /**
     * Indeholder daten for alle filmenes/seriernes posters
     */
    public void addMedia(){
        buildMainPage("Populære",
                "resources/filmplakater/Taxi Driver.jpg",
                "resources/filmplakater/Good Will Hunting.jpg",
                "resources/filmplakater/West Side Story.jpg",
                "resources/Serierforsider/Jessica Jones.jpg",
                "resources/Serierforsider/Big Little Lies.jpg",
                "resources/filmplakater/Singin' In The Rain.jpg",
                "resources/Serierforsider/Sex & The City.jpg");

        buildMainPage("Medrivende indhold",
                "resources/filmplakater/Forrest Gump.jpg",
                "resources/filmplakater/Jurassic Park.jpg",
                "resources/filmplakater/Pulp Fiction.jpg",
                "resources/Serierforsider/Ally McBeal.jpg",
                "resources/Serierforsider/Battlestar Galactica.jpg",
                "resources/Serierforsider/GLOW.jpg",
                "resources/Serierforsider/Game Of Thrones.jpg");

        buildMainPage("Netop Tilføjet",
                "resources/filmplakater/ET.jpg",
                "resources/filmplakater/Jaws.jpg",
                "resources/Serierforsider/24.jpg",
                "resources/Serierforsider/Daredevil.jpg",
                "resources/Serierforsider/Luke Cage.jpg",
                "resources/Serierforsider/Billions.jpg",
                "resources/Serierforsider/Sons Of Anarchy.jpg");

        buildMainPage("GreenStream and chill",
                "resources/filmplakater/Casablanca.jpg",
                "resources/filmplakater/Gone With The Wind.jpg",
                "resources/Serierforsider/Pride And Prejudice.jpg",
                "resources/filmplakater/Some Like It Hot.jpg",
                "resources/filmplakater/Titanic.jpg",
                "resources/Serierforsider/Smallville.jpg",
                "resources/filmplakater/Wuthering Heights.jpg");
    }
}

