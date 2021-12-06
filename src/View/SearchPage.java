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
    private JTextField searchTextField;
    private JButton searchB;
    private Container container;

    private ArrayList<Media> mediaList;

    private SearchPageController searchPageController;

     public SearchPage(ArrayList<Media> mediaList, SearchPageController searchPageController) {
         this.mediaList = mediaList;
         makeSearchPage();
         this.searchPageController = searchPageController;

     }

     private void makeSearchPage() {

         // Da den skal kunne vise menubaren selvom man er i søgefeltet.
         menubarVisible = true;
         searchTextField = new JTextField(20);
         searchB = new JButton("Søg");
         // Bruger borderlayout da vi ønsker at kunne have søgefeltet i midten.
         panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
         container = new JPanel();
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


         JPanel col = new JPanel();

         int counter = 0;

         if (mediaList != null && mediaList.size() > 0) {
             col = new JPanel(new GridLayout((mediaList.size() / 6 + 1),1));
             System.out.println(mediaList.size());
             System.out.println((mediaList.size() / 6 + 1));
             for (int i = 0; i <= mediaList.size() / 6; i++) {
                 JPanel row = new JPanel(new GridLayout(1, 6));
                 for (int j = 0; j < 6; j++) {

                     if (counter < mediaList.size()) {
                         JButton plakat = new JButton();
                         if (mediaList.get(counter) instanceof Movie) {
                             plakat = new JButton(new ImageIcon("resources/filmplakater/" + mediaList.get(counter).getPicture()));
                         }
                         else {
                             plakat = new JButton(new ImageIcon("resources/Serierforsider/" + mediaList.get(counter).getPicture()));
                         }
                         plakat.setPreferredSize(new Dimension(100, 200));
                         plakat.setBorder(new EmptyBorder(0,0,0,0));
                         row.add(plakat);
                         counter++;
                     }
                 }
                 row.setBackground(backgroundGreen);
                 col.add(row);
             }
         }
         JScrollPane scrollPane = new JScrollPane(col);
         panel.add(scrollPane);


     }
    }
