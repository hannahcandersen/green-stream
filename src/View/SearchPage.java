package View;

import java.awt.*;

import Controller.SearchPageController;
import Model.Media;
import Model.Movie;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

/**
 * Denne klasse er en subklasse af View klassen.
 * Den repræsenterer siden man søger i
 */
public class SearchPage extends View {
    private ArrayList<Media> mediaList; // Listen er tom, før der bliver sat film/serier ind
    private SearchPageController searchPageController;
    private JPanel mainPanel, col, row;
    private JTextField searchTextField;
    private JButton searchButton, plakat;

    /**
     * Instantiere controlleren og bygger siden
     * @param mediaList - Listen af film og serier der skal vises, hvis der ikke er søgt på noget er den tom
     * @param searchPageController - Sidens controller
     */
     public SearchPage(ArrayList<Media> mediaList, SearchPageController searchPageController) {
         this.mediaList = mediaList;
         this.searchPageController = searchPageController;
         menubarVisible = true;
         makeSearchPage();
     }

    /**
     * Bygger sidens visuelle indhold
     */
    private void makeSearchPage() {
    // Opretter mainPanel
        mainPanel = new JPanel();
        // Søge feltet og knappen
        searchTextField = new JTextField();
        searchTextField.setPreferredSize(new Dimension(500, 40));
        searchTextField.setSize(20, 5);
        searchButton = new JButton("Søg");
        searchButton.setBorder(new EmptyBorder(12, 30, 11, 30));
        searchButton.addActionListener(e -> searchPageController.searchActionlistner(searchTextField.getText()));
        searchButton.setSize(5, 5);

    // Tilføjer søgefeltet til en container der kun holder søgefelt og knap.
        mainPanel.setSize(30, 10);
        mainPanel.add(searchTextField, BorderLayout.CENTER);
        mainPanel.add(searchButton, BorderLayout.EAST);
        mainPanel.setBackground(backgroundGreen);

    // Tilføjer nu containeren til et panel, så containeren med søge feltet og knappen kommer i midten af vinduet.
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(mainPanel, BorderLayout.CENTER);

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
                             plakat.addActionListener(e -> searchPageController.showMovieActionListener(media));
                         } else {
                             plakat = new JButton(new ImageIcon(getClass().getResource(mediaList.get(counter).getPicture())));
                             plakat.setContentAreaFilled(false);
                             plakat.setBackground(limeGreen);
                             plakat.setBorder(new EmptyBorder(0, 0, 0, 0));
                             plakat.addActionListener(e -> searchPageController.showSerieActionListener(media));
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
                 // Tilføjer rækken til listen af rækker
                 col.add(row);
             }
         }

        // Laver scroll panen
        JScrollPane scrollPane = new JScrollPane(col);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        panel.add(scrollPane);
     }
}
