package View;

import java.awt.*;

import Controller.SearchPageController;
import Model.Media;
import Model.Movie;

import javax.swing.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

/**
 * Denne klasse er en subklasse til View klassen. SearchPage skal have et søgefelt og en søgeknap.
 *  så har den også en container til knappen og søgefeltet.
 */
public class SearchPage extends View {

    // Listen af film og serier der skal vises, hvis der ikke er søgt på noget er den tom.
    private ArrayList<Media> mediaList;

    // SearchPage controller
    private SearchPageController searchPageController;

    /**
     * Instantiere felterne og bygger siden
     * @param mediaList - Listen af film og serier der skal vises, hvis der ikke er søgt på noget er den tom
     * @param searchPageController - SearchPage controller
     */
     public SearchPage(ArrayList<Media> mediaList, SearchPageController searchPageController) {
         this.mediaList = mediaList;
         this.searchPageController = searchPageController;
         makeSearchPage();
     }

     // Bygger sidens visuelle indhold
     private void makeSearchPage() {

         // Da den skal kunne vise menubaren selvom man er i søgefeltet.
         menubarVisible = true;
         JTextField searchTextField = new JTextField(20);
         JButton searchB = new JButton("Søg");

         // Bruger borderlayout da vi ønsker at kunne have søgefeltet i midten.
         panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
         JPanel container = new JPanel();
         searchB.addActionListener(e -> searchPageController.searchActionlistner(searchTextField.getText()));

         searchTextField.setSize(20, 5);
         searchB.setSize(5, 5);

         // Tilføjer vores søgefelt til en container der kun holder søgefelt og knap.
         container.setSize(30, 10);
         container.add(searchTextField, BorderLayout.CENTER);
         container.add(searchB, BorderLayout.EAST);
         container.setBackground(backgroundGreen);

         // Tilføjer nu containeren til et panel, så containeren med søge feltet og knappen kommer i midten af vinduet.
         panel.add(container, BorderLayout.CENTER);

         // tilføjer et scrollPane med listen af media til panelet
         panel.add(scrollPane(mediaList));

     }
    }
