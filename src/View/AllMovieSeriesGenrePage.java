package View;

import Controller.AllMovieSeriesGenrePageController;
import Model.Media;
import Model.Movie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class AllMovieSeriesGenrePage extends View {
    private AllMovieSeriesGenrePageController allMovieSeriesGenrePageController;
    private String[] genreList; // listen med de forskellige genrer
    private String genre;
    private ArrayList<Media> mediaList;
    private String pageTitle; // Titlen på siden - om det er film, serier, eller f.eks. crime
    static JComboBox comboBox;

    public AllMovieSeriesGenrePage(String[] genreList, String genre, ArrayList<Media> mediaList, String pageTitle, AllMovieSeriesGenrePageController allMovieSeriesGenrePageController) {
        this.genreList = genreList;
        this.genre = genre;
        this.allMovieSeriesGenrePageController = allMovieSeriesGenrePageController;
        this.pageTitle = pageTitle;
        this.mediaList = mediaList;

        buildPage(mediaList);
    }

    public void buildPage(ArrayList<Media> mediaList) {
        menubarVisible = true;

        // laver et JPanel "topPanel" øverst
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JPanel topPanel = new JPanel(new GridLayout(1,5));
        topPanel.setSize(300, 10);

        // laver drop down menu og tilføjer til topPanel
        comboBox = new JComboBox();
        comboBox.setEditable(true);
        comboBox.setSelectedItem("Vælg genre");

        // hvis man er på siden for film eller serier, tilføjes alle genrer til drop down
        if (pageTitle.equals("Film") || pageTitle.equals("Serier")) {
            for (String genreName : genreList) {
                comboBox.addItem(genreName);
            }

            // tilføjer item listeners til film og seriers drop down, der får siden til at skifte til den rigtige side
            comboBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedGenre = (String) comboBox.getSelectedItem();
                    if (pageTitle.equals("Film")) {allMovieSeriesGenrePageController.showGenreOfMoviesActionListener(selectedGenre);}
                    if (pageTitle.equals("Serier")) {allMovieSeriesGenrePageController.showGenreOfSeriesActionListener(selectedGenre);}
                }
            });
        }
        // hvis man ikke er på siden for film og serier, er man på siden for genrer. tilføjer drop down til genrer med kategorierne alle, film og serier
        else{
            comboBox.setSelectedItem("Vælg medie");
            comboBox.addItem("Alle");
            comboBox.addItem("Film");
            comboBox.addItem("Serier");

            // tilføjer item listeners til genres drop down, der får siden til at skifte til den rigtige side
            comboBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedCategory = (String) comboBox.getSelectedItem();
                    if (selectedCategory.equals("Alle")) {allMovieSeriesGenrePageController.genreActionListener(genre);}
                    if (selectedCategory.equals("Film")) {allMovieSeriesGenrePageController.showMoviesOfGenreActionListener(genre);}
                    if (selectedCategory.equals("Serier")) {allMovieSeriesGenrePageController.showSeriesOfGenreActionListener(genre);}
                }
            });
        }

        //tilføjer comboBox til panel
        comboBox.setEditable(false);
        topPanel.add(comboBox);

        // laver sidens overskrift og tilføjer til topPanel
        JLabel text = new JLabel(pageTitle);
        text.setFont(text.getFont().deriveFont(Font.BOLD, 50));
        topPanel.add(text);

        //tilføjer topPanel til panel
        topPanel.setBackground(backgroundGreen);
        panel.add(topPanel, BorderLayout.CENTER);

        // laver et scrollPane med listen af media
        JPanel col = new JPanel();

        // holder styr på hvor mange film der er tilføjet til panelet
        int counter = 0;

        // hvis listen ikke er tom
        if (mediaList != null && mediaList.size() > 0) {
            // JPanel med det antal rækker der er nødvendigt for alle kunne vise alle film
            col = new JPanel(new GridLayout((mediaList.size() / 6 + 1), 1));

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
                            plakat.addActionListener(e -> allMovieSeriesGenrePageController.showMovieActionListener(media));
                        } else {
                            plakat = new JButton(new ImageIcon(mediaList.get(counter).getPicture()));
                            plakat.addActionListener(e -> allMovieSeriesGenrePageController.showSerieActionListener(media));
                        }
                        plakat.setPreferredSize(new Dimension(100, 200));
                        plakat.setBorder(new EmptyBorder(0, 0, 0, 0));
                        plakat.setContentAreaFilled(false);

                        // Tilføjer Mediet til rækken
                        row.add(plakat);
                        row.setBorder(new EmptyBorder(10, 0, 10, 0));
                        // Tæller counter op så der er styr på hvor mange film der er tilføjet
                        counter++;
                    }
                }
                row.setBackground(backgroundGreen);
                row.setBorder(new EmptyBorder(10, 0, 10, 0));

                // Tilføjer rækken til listen af rækker
                col.add(row);
            }
        }
        // Gør sådan at man kan scrolle i listen med rækker
        JScrollPane scrollPane = new JScrollPane(col);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBackground(backgroundGreen);
        panel.add(scrollPane);

    }
}


