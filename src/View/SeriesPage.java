package View;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SeriesPage implements ItemListener {
    static JLabel seasontext, episodetext;
    static JButton playtext;
    static JComboBox valgSeason, valgEpisode;

    public SeriesPage(){
        /*
        // left BoxLayout
        JPanel billedeLayout = new JPanel();

        // season combobox
        SeriesPage ddd = new SeriesPage();
        String Seasons[] = {"Season 1", "Season 2", "Season 3", "Season 4"};
        valgSeason = new JComboBox(Seasons);
        valgSeason.setSize(30, 60);
        valgSeason.addItemListener(ddd);
        seasontext = new JLabel("Select your season ");
        valgSeason.setMaximumRowCount(5);
        seasontext.setForeground(Color.red);

        // episode combobox
        SeriesPage qqq = new SeriesPage();
        String Episode[] = {"Episode 1", "Episode 2", "Episode 3", "Episode 4", "Episode 5", "Episode 6"};
        valgEpisode = new JComboBox(Episode);
        valgEpisode.setSize(30, 60);
        valgEpisode.addItemListener(qqq);
        valgEpisode.setMaximumRowCount(5);
        episodetext = new JLabel("Select your episode ");
        episodetext.setForeground(Color.red);

        billedeLayout.setBorder(new EmptyBorder(15, 15, 0, 15));
        billedeLayout.add(new JTable(1, 1));
        billedeLayout.add(seasontext);
        billedeLayout.add(valgSeason);
        billedeLayout.add(episodetext);
        billedeLayout.add(valgEpisode);
        billedeLayout.setBorder(new EmptyBorder(40, 40, 40, 40));
        billedeLayout.setLayout(new BoxLayout(billedeLayout, BoxLayout.PAGE_AXIS));

        // center BoxLayout
        JPanel infoLayout = new JPanel();

        // Play button
        JButton play = new JButton();
        playtext = new JButton("Play Season 1, Episode 1");
        playtext.setForeground(Color.blue);
        play.add(playtext);
        play.setSize(30, 60);
        play.setBorder(new EmptyBorder(20, 20, 0, 20));
        play.setBackground(new Color(15, 15, 127));
        play.setContentAreaFilled(false);
        infoLayout.add(play);
        JButton minList = new JButton();
        minList.add(new JButton("Tilføj til min liste"));
        minList.setSize(30, 60);
        minList.setBorder(new EmptyBorder(5, 20, 5, 20));
        minList.setBackground(new Color(15, 15, 127));
        minList.setContentAreaFilled(false);
        infoLayout.add(minList);
        infoLayout.add(new JLabel("Genre: ______________"));
        infoLayout.add(new JLabel("Udgivelsesår: _______"));
        infoLayout.add(new JLabel("Rating: _____________"));

        infoLayout.setBorder(new EmptyBorder(40, 40, 40, 40));
        infoLayout.setLayout(new BoxLayout(infoLayout, BoxLayout.PAGE_AXIS));

        // rigth BoxLayout
        JPanel resume = new JPanel();
        resume.add(new JLabel("Resume:"));
        resume.add(new JLabel("_______________________"));
        resume.add(new JLabel("_______________________"));
        resume.add(new JLabel("_______________________"));
        resume.add(new JLabel("_______________________"));
        resume.add(new JLabel("_______________________"));
        resume.add(new JLabel("_______________________"));
        resume.setBorder(new EmptyBorder(40, 40, 40, 40));
        resume.setLayout(new BoxLayout(resume, BoxLayout.PAGE_AXIS));


        // add to Borderlayout
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(billedeLayout, BorderLayout.WEST);
        buttonPanel.add(infoLayout, BorderLayout.CENTER);
        buttonPanel.add(resume, BorderLayout.EAST);

        // Show it
        /*
        mainSeason.setContentPane(buttonPanel);
        mainSeason.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainSeason.setSize(850, 400);
        mainSeason.show();
        mainSeason.setVisible(true);
        */
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == valgSeason) {
            playtext.setText("Play " + valgSeason.getSelectedItem() + ", " + valgEpisode.getSelectedItem());
        }
        if (e.getSource() == valgEpisode) {
            playtext.setText("Play " + valgSeason.getSelectedItem() + ", " + valgEpisode.getSelectedItem());
        }
    }
}  
