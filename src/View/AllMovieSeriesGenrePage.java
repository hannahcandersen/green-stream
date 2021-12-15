package View;

import Controller.AllMovieSeriesGenrePageController;
import Model.Media;
import Model.Movie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

/**
 * Denne klasse er en subklasse af View klassen.
 * Den repræsenterer siden som kan viser film, serier og genre i de forskellige mediere
 */
public class AllMovieSeriesGenrePage extends View {
    private AllMovieSeriesGenrePageController allMovieSeriesGenrePageController;
    private String[] genreList;
    private String genre;
    private String category;
    private ArrayList<Media> mediaList;
    private String pageTitle;
    static JComboBox comboBox;
    private JPanel topPanel, col, row;
    private JLabel headline;
    private JButton plakat;

    /**
     * Instantiere controlleren og bygger siden
     * @param genreList - Er en liste af de forskellige genre
     * @param genre - Skriver den valgte genre i topPanel
     * @param category - Skriver det valgte medie i topPanel
     * @param mediaList - Inde holder alle medierne
     * @param pageTitle - Titelen på siden
     * @param allMovieSeriesGenrePageController - Sidens controller
     */
    public AllMovieSeriesGenrePage(String[] genreList, String genre, String category, ArrayList<Media> mediaList, String pageTitle, AllMovieSeriesGenrePageController allMovieSeriesGenrePageController) {
        this.genreList = genreList;
        this.genre = genre;
        this.category = category;
        this.allMovieSeriesGenrePageController = allMovieSeriesGenrePageController;
        this.pageTitle = pageTitle;
        this.mediaList = mediaList;
        menubarVisible = true;
        buildPage(mediaList);
    }

    /**
     * Bygger sidens visuelle indhold
     * @param mediaList - Listen af film og serier der skal vises
     */
    public void buildPage(ArrayList<Media> mediaList) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    // Laver et JPanel "topPanel"
        topPanel = new JPanel(new FlowLayout());
        topPanel.setSize(1000, 10);

        // Laver drop down menu og tilføjer til topPanel
        comboBox = new JComboBox();
        comboBox.setEditable(true); // Viser det valgte i comboBoxen

            // Hvis man er på film/serie siden, tilføjes alle genrer til comboBoxen
            if (pageTitle.equals("Film") || pageTitle.equals("Serier")) {
                // Laver sidens overskrift og tilføjer til topPanel
                headline = new JLabel(category);
                headline.setFont(headline.getFont().deriveFont(Font.BOLD, 50));
                topPanel.add(headline);

                // Opsætning af det visuelle i comboBoxen
                if (genre.equals("")) {
                    comboBox.setSelectedItem("Vælg genre");
                } else {
                    comboBox.setSelectedItem(genre);
                }

                for (String genreName : genreList) {
                    comboBox.addItem(genreName);
                }

                // Item listeners til comboBoxen, så der kan skifte til den rigtige side ud fra medieret
                comboBox.addItemListener(e -> {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        String selectedGenre = (String) comboBox.getSelectedItem();
                        if (category.equals("Film")) {
                            allMovieSeriesGenrePageController.showGenreOfMoviesActionListener(selectedGenre);
                        }
                        if (category.equals("Serier")) {
                            allMovieSeriesGenrePageController.showGenreOfSeriesActionListener(selectedGenre);
                        }
                    }
                });
            // Hvis man gå ind på genrer siden
            } else {
                // ComboBoxens kategorier
                comboBox.addItem("Film og serier");
                comboBox.addItem("Film");
                comboBox.addItem("Serier");

                // Laver sidens overskrift og tilføjer til topPanel
                headline = new JLabel(genre);
                headline.setFont(headline.getFont().deriveFont(Font.BOLD, 50));
                topPanel.add(headline);
                comboBox.setSelectedItem(category);

                // Item listeners til comboBoxen, så der kan skifte til den rigtige side ud fra medieret
                comboBox.addItemListener(e -> {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        String selectedCategory = (String) comboBox.getSelectedItem();
                        if (selectedCategory.equals("Film og serier")) {
                            allMovieSeriesGenrePageController.genreActionListener(genre, selectedCategory);
                        }
                        if (selectedCategory.equals("Film")) {
                            allMovieSeriesGenrePageController.showMoviesOfGenreActionListener(genre, selectedCategory);
                        }
                        if (selectedCategory.equals("Serier")) {
                            allMovieSeriesGenrePageController.showSeriesOfGenreActionListener(genre, selectedCategory);
                        }
                    }
                });
            }

            // Tilføjer comboBox til topPanel
            comboBox.setBackground(backgroundGreen);
            comboBox.setEditable(false);
            topPanel.add(comboBox);

        // Tilføjer topPanel til panel
            topPanel.setBackground(backgroundGreen);
            panel.add(topPanel, BorderLayout.CENTER);

            col = new JPanel();
            int counter = 0;   // Holder styr på hvor mange film der er tilføjet til panelet

            // Hvis listen ikke er tom
        if (mediaList != null && mediaList.size() > 0) {
        // Jpanel med det antal rækker der er nødvendigt til at kunne vise filmen
        col = new JPanel(new GridLayout((mediaList.size() / 6 + 1),1));

            // Går igennem alle rækkerne
            for (int i = 0; i <= mediaList.size() / 6; i++) {
                row = new JPanel(new GridLayout(1, 6));  // JPanel med 6 pladser
                // Går igennem de 6 pladser på rækken
                for (int j = 0; j < 6; j++) {
                    // Hvis der stadig er flere film/serie tilbage at vise
                    if (counter < mediaList.size()) {
                        plakat = new JButton();
                        Media media = mediaList.get(counter);
                        // Finder mediets plakat om det er movie/serie
                        if (mediaList.get(counter) instanceof Movie) {
                            plakat = new JButton(new ImageIcon(getClass().getResource(mediaList.get(counter).getPicture())));
                            plakat.setContentAreaFilled(false);
                            plakat.setBackground(limeGreen);
                            plakat.setBorder(new EmptyBorder(0, 0, 0, 0));
                            plakat.addActionListener(e -> allMovieSeriesGenrePageController.showMovieActionListener(media));
                        } else {
                            plakat = new JButton(new ImageIcon(getClass().getResource(mediaList.get(counter).getPicture())));
                            plakat.setContentAreaFilled(false);
                            plakat.setBackground(limeGreen);
                            plakat.setBorder(new EmptyBorder(0, 0, 0, 0));
                            plakat.addActionListener(e -> allMovieSeriesGenrePageController.showSerieActionListener(media));
                        }
                        plakat.setPreferredSize(new Dimension(100, 200));
                        plakat.setBorder(new EmptyBorder(0,0,0,0));

                        // Tilføjer Mediet til rækken
                        row.add(plakat);
                        row.setBorder(new EmptyBorder(10, 0, 10, 0));
                        counter++;
                    }
                }
                    row.setBackground(backgroundGreen);
                    row.setBorder(new EmptyBorder(10, 0, 10, 0));

                    // Tilføjer rækken til listen af rækker
                    col.add(row);
            }
        }
            // Laver scroll panen
            JScrollPane scrollPane = new JScrollPane(col);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);
            scrollPane.setBackground(backgroundGreen);
            panel.add(scrollPane);

    }
}