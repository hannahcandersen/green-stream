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
         JTextField searchTextField = new JTextField();
         JButton searchB = new JButton("Søg");
         searchTextField.setPreferredSize(new Dimension(500, 40));
         searchB.setBorder(new EmptyBorder(12, 30, 11, 30));
         //searchTextField.setBorder(BorderFactory.createMatteBorder(                 -1, -1, -1, -1, icon));

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

         JPanel col = new JPanel();

         // holder styr på hvor mange film der er tilføjet til panelet
         int counter = 0;

         // hvis listen ikke er tom
         if (mediaList != null && mediaList.size() > 0) {
             // Jpanel med det antal rækker der er nødvendigt for alle kunne vise alle film
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
                             plakat.setContentAreaFilled(false);
                             plakat.setBackground(limeGreen);
                             plakat.setBorder(new EmptyBorder(0, 0, 0, 0));
                             plakat.addActionListener(e -> searchPageController.showMovieActionListener(media));
                         }
                         else {
                             plakat = new JButton(new ImageIcon(mediaList.get(counter).getPicture()));
                             plakat.setContentAreaFilled(false);
                             plakat.setBackground(limeGreen);
                             plakat.setBorder(new EmptyBorder(0, 0, 0, 0));
                             plakat.addActionListener(e -> searchPageController.showSerieActionListener(media));
                         }
                         plakat.setPreferredSize(new Dimension(100, 200));
                         plakat.setBorder(new EmptyBorder(0,0,0,0));
                         //plakat.addActionListener(e -> );
                         // Tilføjer Mediet til rækken
                         row.add(plakat);
                         row.setBorder(new EmptyBorder(10, 0, 10, 0));
                         // Tæller counter op så der er styr på hvor mange film der er tilføjet
                         counter++;
                     }
                 }
                 row.setBackground(backgroundGreen);
                 // Tilføjer rækken til listen af rækker
                 col.add(row);
             }
         }
         // Gør såden at man kan scrolle i listen med rækker
         JScrollPane scrollPane = new JScrollPane(col);
         scrollPane.getVerticalScrollBar().setUnitIncrement(16);
         panel.add(scrollPane);

     }
}
