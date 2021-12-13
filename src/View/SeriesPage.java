package View;

import Controller.SeriesPageController;
import Model.Serie;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

/**
 * Denne klasse er en subklasse af View klassen.
 * Den repræsenterer siden ved valg af en serie
 */
public class SeriesPage extends View implements ItemListener {
    private ImageIcon backIcon, seriePoster;
    private SeriesPageController seriesPageController;
    private JPanel topPanel, titelPanel, closePanel, centerPanel, imageLeftCenter, infoCenterCenter, resumeRigthCenter, BorderLayoutPanel;
    private JLabel titel, serieLabel, seasontext, episodetext, genreLabel, yearLabel, ratingLabel, resumeTitelLabel;
    private JButton close, play, minList;
    static JComboBox valgSeason, valgEpisode;
    private JTextArea resumeArea;
    Serie serie;

    /**
     * Instantiere controlleren og bygger siden
     * @param seriesPageController - Sidens controller
     * @param serie - Kan hente dataen fra ´Serie`
     */
    public SeriesPage(SeriesPageController seriesPageController, Serie serie){
        this.seriesPageController = seriesPageController;
        this.serie = serie;
        buildPage();
    }

    public void buildPage() {
    // Opretter topPanel - BorderLayout NORTH
        topPanel = new JPanel(new BorderLayout());
        //Opretter titelPanel
        titelPanel = new JPanel();
        titel = new JLabel(serie.getName());
        titel.setFont(new Font("Serif", Font.BOLD, 40));
        titelPanel.add(titel);
        topPanel.add(titelPanel, BorderLayout.NORTH);

        //Opretter closePanel
        closePanel = new JPanel(new BorderLayout());
        backIcon = new ImageIcon(new ImageIcon("Pictures/back.png").getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
        close = new JButton(backIcon);
        close.addActionListener(e -> seriesPageController.goBackActionListener());
        close.setFont(new Font("Serif", Font.BOLD, 30));
        close.setContentAreaFilled(false);              // knappen bliver transperent
        close.setBorder(new EmptyBorder(20, 20, 0, 0));
        closePanel.add(close, BorderLayout.WEST);

        topPanel.add(closePanel, BorderLayout.SOUTH);

    // BorderLayout Center
        centerPanel = new JPanel();

        // Billede Left Center
        imageLeftCenter = new JPanel();
        imageLeftCenter.setBorder(new EmptyBorder(15, 15, 0, 15));
        seriePoster = new ImageIcon(new ImageIcon(serie.getPicture()).getImage().getScaledInstance(250, 400, Image.SCALE_DEFAULT));
        serieLabel = new JLabel(seriePoster);
        serieLabel.setIcon(seriePoster);
        serieLabel.setBorder(new EmptyBorder(0, 0, 10, 0));

        // Laver et Array med det antal sæsoner serien har
        Integer[] season = new Integer[serie.getSeasons()];
        for (int i = 0; i < serie.getSeasons(); i++) {
            season[i] = (i + 1);
        }

        // Laver et Array med det antal episodes serien har
        Integer[] episode = new Integer[serie.getEpisodes().get(0)];
        for (int i = 0; i < serie.getEpisodes().get(0); i++) {
            episode[i] = (i + 1);
        }

        // Season combobox
        valgSeason = new JComboBox(season);
        valgSeason.setSize(30, 60);
        valgSeason.addItemListener(this);
        seasontext = new JLabel("Vælg sæson ");
        valgSeason.setMaximumRowCount(5);

        // Episode combobox
        valgEpisode = new JComboBox(episode);
        valgEpisode.setSize(30, 60);
        valgEpisode.addItemListener(this);
        valgEpisode.setMaximumRowCount(5);
        episodetext = new JLabel("Vælg episode");
        episodetext.setBorder(new EmptyBorder(5, 0, 0, 0));

    // Sammensætning af imageLeftCenter
        imageLeftCenter.add(serieLabel);
        imageLeftCenter.add(seasontext);
        imageLeftCenter.add(valgSeason);
        imageLeftCenter.add(episodetext);
        imageLeftCenter.add(valgEpisode);
        imageLeftCenter.setBorder(new EmptyBorder(40, 40, 40, 40));
        imageLeftCenter.setLayout(new BoxLayout(imageLeftCenter, BoxLayout.PAGE_AXIS));

    //Info Center Center
        infoCenterCenter = new JPanel();
        // Play button
        play  = new JButton("Play 1, 1");
        play.setSize(800, 60); // size virker ikke
        play.setContentAreaFilled(false);
        play.addActionListener(e -> seriesPageController.playActionListener());
        infoCenterCenter.add(play);
        infoCenterCenter.add(new JLabel(" "));

        // MinList button
        if (seriesPageController.getCurrentProfile().getMyList().contains(serie)) {
            minList = new JButton("Fjern fra min liste");
            minList.setSize(150, 60);
            minList.setContentAreaFilled(false);
            minList.addActionListener(e -> seriesPageController.removeFromMyListActionListener(serie));
            infoCenterCenter.add(minList);
        } else {
            minList = new JButton("Tilføj til min liste");
            minList.addActionListener(e -> seriesPageController.addToMyListActionListerner(serie));
            minList.setSize(80, 60);
            minList.setContentAreaFilled(false);
            infoCenterCenter.add(minList);
        }

        // Adder alle mediets genre til en string, så den kan bliver brugt af "genreLabel"
        String genre = "";
        for (int i = 0; i < serie.getGenre().length; i++) {
            if (i != 0) {
                genre += ", ";
            }
            genre += serie.getGenre()[i];
        }

        // Adder dataen om fra mediet til Labels
        genreLabel = new JLabel("Genre: " + genre);
        genreLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        yearLabel = new JLabel("Udgivelsesår: " + serie.getYear());
        yearLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        ratingLabel = new JLabel("Rating: " + serie.getRating());
        ratingLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        infoCenterCenter.add(new JLabel(" "));
        infoCenterCenter.add(genreLabel);
        infoCenterCenter.add(yearLabel);
        infoCenterCenter.add(ratingLabel);
        infoCenterCenter.setBorder(new EmptyBorder(0, 90, 20, 0));
        infoCenterCenter.setLayout(new BoxLayout(infoCenterCenter, BoxLayout.PAGE_AXIS));

    //Resume Rigth Center
        resumeRigthCenter = new JPanel();
        resumeTitelLabel = new JLabel("Resume: ");
        resumeTitelLabel.setFont(new Font("Serif", Font.BOLD, 20));

        resumeArea = new JTextArea();
        resumeArea.setText(serie.getName() + " er en de 100 bedste serier i verden (ifølge én liste fra imdb), derfor har GreenStream serien her til din underholdning. ");
        resumeArea.setLineWrap(true);
        resumeArea.setWrapStyleWord(true);
        resumeArea.setEditable(false);
        resumeArea.setBackground(limeGreen);
        resumeArea.setBounds(0,05,280,280);
        resumeArea.setBorder(new EmptyBorder(0, 90, 20, 0));

        resumeRigthCenter.add(resumeTitelLabel);
        resumeRigthCenter.add(resumeArea);
        resumeRigthCenter.setBorder(new EmptyBorder(40, 80, 40, 40));
        resumeRigthCenter.setLayout(new BoxLayout(resumeRigthCenter, BoxLayout.PAGE_AXIS));

        // Sammensætning af alle tre centerPanel
        centerPanel.add(imageLeftCenter);
        centerPanel.add(infoCenterCenter);
        centerPanel.add(resumeRigthCenter);

        // Backgrund farve
        titelPanel.setBackground(darkerGreen);
        closePanel.setBackground(limeGreen);
        imageLeftCenter.setBackground(limeGreen);
        infoCenterCenter.setBackground(limeGreen);
        resumeRigthCenter.setBackground(limeGreen);
        centerPanel.setBackground(limeGreen);
        panel.setBackground(limeGreen);

        // Opsæt Borderlayout
        BorderLayoutPanel = new JPanel(new BorderLayout());
        BorderLayoutPanel.add(topPanel, BorderLayout.NORTH);
        BorderLayoutPanel.add(centerPanel, BorderLayout.CENTER);

        panel.add(BorderLayoutPanel);
    }

    /**
     * Tager og ændre siden efter sæson/episode comboboxen er ændret
     * @param e - Ser efter om comboboxen bliver ændret
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == valgSeason) {
            valgEpisode.removeAllItems();
            for (int i = 0; i < serie.getEpisodes().get(((int)valgSeason.getSelectedItem())-1); i++) {
                valgEpisode.addItem((i + 1));
            }
            play.setText("Play " + valgSeason.getSelectedItem() + ", " + valgEpisode.getSelectedItem());
        }

        if (e.getSource() == valgEpisode) {
            play.setText("Play " + valgSeason.getSelectedItem() + ", " + valgEpisode.getSelectedItem());
        }
    }
}  
