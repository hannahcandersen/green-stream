package View;

import Controller.AllMovieSeriesGenrePageController;
import Model.Media;
import Model.Movie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class AllMovieSeriesGenrePage extends View {

    private AllMovieSeriesGenrePageController allMovieSeriesGenrePageController;
    private String[] genreList; // listen med de forskellige genrer
    private ArrayList<Media> mediaList;
    private String pageTitle; // Titlen på siden - om det er film, serier, eller f.eks. crime

    public AllMovieSeriesGenrePage(String[] genreList, ArrayList<Media> mediaList, String pageTitle, AllMovieSeriesGenrePageController allMovieSeriesGenrePageController) {
        this.genreList = genreList;
        this.allMovieSeriesGenrePageController = allMovieSeriesGenrePageController;
        this.pageTitle = pageTitle;
        this.mediaList = mediaList;

        buildPage(mediaList);
    }

    public void buildPage(ArrayList<Media> mediaList) {
        menubarVisible = true;

        // laver et JPanel "topPanel" øverst
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JPanel topPanel = new JPanel();
        topPanel.setSize(30, 10);

        // laver drop down med genrer og tilføjer til topPanel
        JComboBox comboBox = new JComboBox();
        comboBox.setEditable(true);
        comboBox.setSelectedItem("Choose genre");
        comboBox.setEditable(false);
        for (String genreName : genreList) {
            comboBox.addItem(genreName);
            //genreItem.addActionListener(e -> ;
        }
        topPanel.add(comboBox);

        // laver sidens overskrift og tilføjer til topPanel
        JLabel text = new JLabel(pageTitle);
        text.setFont(text.getFont().deriveFont(Font.BOLD, 50));
        topPanel.add(text);

        topPanel.setBackground(backgroundGreen);
        panel.add(topPanel, BorderLayout.CENTER);


        // tilføjer et scrollPane med listen af media til panelet
        JPanel col = new JPanel();

        // holder styr på hvor mange film der er tilføjet til panelet
        int counter = 0;

        // hvis listen ikke er tom
        if (mediaList != null && mediaList.size() > 0) {
            // JPanel med det antal rækker der er nødvendigt for alle kunne vise alle film
            col = new JPanel(new GridLayout((mediaList.size() / 6 + 1),1));

            // Går igennem alle rækkerne
            for (int i = 0; i <= mediaList.size() / 6; i++) {

                // JPanel med 6 pladser
                JPanel row = new JPanel(new GridLayout(1, 6));

                // Går igennem de 6 pladser på rækken
                for (int j = 0; j < 6; j++) {

                    // Hvis der stadig er flere film tilbage at vise
                    if (counter < mediaList.size()) {
                        JButton plakat = new JButton();

                        Media media = mediaList.get(counter);
                        // Hvis mediet er en film findes filmens plakat, ellers er det en serie og dennes plakat findes
                        if (mediaList.get(counter) instanceof Movie) {
                            plakat = new JButton(new ImageIcon(mediaList.get(counter).getPicture()));
                            //plakat.addActionListener(e -> searchPageController.showMovieActionListener(media));
                        }
                        else {
                            plakat = new JButton(new ImageIcon(mediaList.get(counter).getPicture()));
                            //plakat.addActionListener(e -> searchPageController.showSerieActionListener(media));
                        }
                        plakat.setPreferredSize(new Dimension(100, 200));
                        plakat.setBorder(new EmptyBorder(0,0,0,0));
                        plakat.setContentAreaFilled(false);
                        //plakat.addActionListener(e -> );
                        // Tilføjer Mediet til rækken
                        row.add(plakat);
                        // Tæller counter op så der er styr på hvor mange film der er tilføjet
                        counter++;
                    }
                }
                row.setBackground(backgroundGreen);
                // Tilføjer rækken til listen af rækker
                col.add(row);
            }
        }
        // Gør sådan at man kan scrolle i listen med rækker
        JScrollPane scrollPane = new JScrollPane(col);
        scrollPane.setBackground(backgroundGreen);
        panel.add(scrollPane);

    }
}








