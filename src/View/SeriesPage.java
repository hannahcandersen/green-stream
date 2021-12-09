package View;

import Controller.SeriesPageController;
import Model.Serie;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class SeriesPage extends View implements ItemListener {
    private ImageIcon seriePoster;
    private SeriesPageController seriesPageController;
    private JPanel titelPanel, rigthPanel, leftPanel, centerPanel, imageLeftCenter, infoCenterCenter, resumeRigthCenter, BorderLayoutPanel;
    private JLabel titel, rigthFill, leftFill, serieLabel, seasontext, episodetext, genreLabel, yearLabel, ratingLabel, resumeTitelLabel;
    private JButton close, play, minList;
    static JComboBox valgSeason, valgEpisode;

    Serie serie;

    public SeriesPage(SeriesPageController seriesPageController, Serie serie){
        this.seriesPageController = seriesPageController;
        this.serie = serie;
        buildPage();
    }

    public void buildPage() {
        //BorderLayout NORTH
        titelPanel = new JPanel();
        titel = new JLabel(serie.getName());
        titel.setFont(new Font("Serif", Font.BOLD, 40));
        titelPanel.add(titel);

        //BorderLayout WEST
        rigthPanel = new JPanel();
        close = new JButton("X");
        close.addActionListener(e -> seriesPageController.goBackActionListener());
        close.setFont(new Font("Serif", Font.BOLD, 30));
        close.setContentAreaFilled(false);              // knappen bliver transperent
        close.setBorder(new EmptyBorder(20, 20, 0, 0));
        rigthPanel.add(close);

        rigthFill = new JLabel("                                       ");
        rigthPanel.add(rigthFill);

        //BorderLayout EAST
        leftPanel = new JPanel();
        leftFill = new JLabel("                                                    ");
        leftPanel.add(leftFill);

        //BorderLayout Center
        centerPanel = new JPanel();

        //Billede/vælg Left Center
        imageLeftCenter = new JPanel();
        imageLeftCenter.setBorder(new EmptyBorder(15, 15, 0, 15));
        seriePoster = new ImageIcon(new ImageIcon(serie.getPicture()).getImage().getScaledInstance(250, 400, Image.SCALE_DEFAULT));
        serieLabel = new JLabel(seriePoster);
        serieLabel.setIcon(seriePoster);


        Integer[] s = new Integer[serie.getSeasons()];
        for (int i = 0; i < serie.getSeasons(); i++) {
            s[i] = (i + 1);
        }


        Integer[] epi = new Integer[serie.getEpisodes().get(0)];
        for (int i = 0; i < serie.getEpisodes().get(0); i++) {
            epi[i] = (i + 1);
        }


        // season combobox
        //String Seasons[] = {"Season 1", "Season 2", "Season 3", "Season 4"};
        valgSeason = new JComboBox(s);
        valgSeason.setSize(30, 60);
        valgSeason.addItemListener(this);
        seasontext = new JLabel("Vælg sæson ");
        valgSeason.setMaximumRowCount(5);
        //seasontext.setForeground(Color.red);

        // episode combobox
        //String[] episode = {"Episode 1", "Episode 2", "Episode 3", "Episode 4", "Episode 5", "Episode 6"};

        valgEpisode = new JComboBox(epi);
        valgEpisode.setSize(30, 60);
        valgEpisode.addItemListener(this);
        valgEpisode.setMaximumRowCount(5);
        episodetext = new JLabel("Vælg episode");
        //episodetext.setForeground(Color.red);

        centerPanel.setBorder(new EmptyBorder(15, 15, 0, 15));

        //centerPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
        //centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));

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
        //play.setBorder(new EmptyBorder(20, 20, 0, 20));
        infoCenterCenter.add(play);

        // minList button
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

        String genre = "";
        for (int i = 0; i < serie.getGenre().length; i++) {
            if (i != 0) {
                genre += ", ";
            }
            genre += serie.getGenre()[i];
        }

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
        infoCenterCenter.setLayout(new BoxLayout(infoCenterCenter, BoxLayout.PAGE_AXIS));

        //Resume Rigth Center
        resumeRigthCenter = new JPanel();
        resumeTitelLabel = new JLabel("Resume: ");
        resumeTitelLabel.setFont(new Font("Serif", Font.BOLD, 20));

        resumeRigthCenter.add(resumeTitelLabel);
        resumeRigthCenter.add(new JLabel("______________________________________"));
        resumeRigthCenter.add(new JLabel("______________________________________"));
        resumeRigthCenter.add(new JLabel("______________________________________"));
        resumeRigthCenter.add(new JLabel("______________________________________"));
        resumeRigthCenter.add(new JLabel("______________________________________"));
        resumeRigthCenter.add(new JLabel("______________________________________"));
        resumeRigthCenter.setBorder(new EmptyBorder(40, 40, 40, 40));
        resumeRigthCenter.setLayout(new BoxLayout(resumeRigthCenter, BoxLayout.PAGE_AXIS));

        // kombiner alle tre centerPanel
        centerPanel.add(imageLeftCenter);
        centerPanel.add(infoCenterCenter);
        centerPanel.add(resumeRigthCenter);

        // Backgrund farve
        titelPanel.setBackground(darkerGreen);
        imageLeftCenter.setBackground(limeGreen);
        infoCenterCenter.setBackground(limeGreen);
        resumeRigthCenter.setBackground(limeGreen);
        rigthPanel.setBackground(limeGreen);
        centerPanel.setBackground(limeGreen);
        leftPanel.setBackground(limeGreen);
        panel.setBackground(limeGreen);

        // Opsæt Borderlayout
        BorderLayoutPanel = new JPanel(new BorderLayout());

        BorderLayoutPanel.add(titelPanel, BorderLayout.NORTH);
        BorderLayoutPanel.add(rigthPanel, BorderLayout.WEST);
        BorderLayoutPanel.add(centerPanel, BorderLayout.CENTER);
        BorderLayoutPanel.add(leftPanel, BorderLayout.EAST);

        panel.add(BorderLayoutPanel);
    }

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
