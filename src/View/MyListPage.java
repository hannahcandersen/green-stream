package View;

import Controller.MyListPageController;
import Model.Media;
import Model.Movie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Denne klasse er en subklasse af View klassen.
 * Den repræsenterer siden som kan viser "Min liste"
 */
public class MyListPage extends View{
    private ArrayList<Media> myList; // Listen af filmene der er tilføjet til myList
    private MyListPageController myListPageController;
    private JPanel topPanel, col, row, emptyListPane, tomPanel;
    private JLabel text, empty, whatToDo1, whatToDo2, whatToDo3;
    private JButton plakat;

    /**
     * Instantierer felterne og bygger siden
     * @param myList - Listen af medierne der er på myList
     * @param myListPageController - Sidens controller
     */
    public MyListPage(ArrayList<Media> myList, MyListPageController myListPageController) {
        this.myList = myList;
        this.myListPageController = myListPageController;
        menubarVisible = true; // Sætter menubaren til at være synlig
        buildPage(myList);
    }

    /**
     * Bygger sidens visuelle indhold
     * @param mediaList - Listen af film og serier der skal vises
     */
    private  void buildPage(ArrayList<Media> mediaList) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    // Laver et JPanel "topPanel"
        topPanel = new JPanel();
        topPanel.setBackground(backgroundGreen);

        // Tilføjer et tekstfelt
        text = new JLabel("Min Liste");
        text.setFont(text.getFont().deriveFont(Font.BOLD, 50));
        topPanel.add(text, BorderLayout.NORTH);
        panel.add(topPanel);


        // Hvis listen ikke er tom
        if (mediaList != null && mediaList.size() > 0) {
            col = new JPanel();
            int counter = 0;   // Holder styr på hvor mange film der er tilføjet til panelet

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
                            plakat = new JButton(new ImageIcon(mediaList.get(counter).getPicture()));
                            plakat.setContentAreaFilled(false);
                            plakat.setBackground(limeGreen);
                            plakat.setBorder(new EmptyBorder(0, 0, 0, 0));
                            plakat.addActionListener(e -> myListPageController.showMovieActionListener(media));
                        } else {
                            plakat = new JButton(new ImageIcon(mediaList.get(counter).getPicture()));
                            plakat.setContentAreaFilled(false);
                            plakat.setBackground(limeGreen);
                            plakat.setBorder(new EmptyBorder(0, 0, 0, 0));
                            plakat.addActionListener(e -> myListPageController.showSerieActionListener(media));
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

            // Gør såden at man kan scrolle i listen med rækker
            JScrollPane scrollPane = new JScrollPane(col);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);
            panel.add(scrollPane);
        // Hvis listen er tom vises dette
        } else {
            emptyListPane = new JPanel();
            emptyListPane.setLayout(new BoxLayout(emptyListPane, BoxLayout.PAGE_AXIS));
            emptyListPane.setSize(500,300);
            empty = new JLabel("Listen er tom da du ikke har tilføjet en film/serie endnu");
            empty.setFont(new Font("", Font.BOLD, 30));
            emptyListPane.add(empty);

            whatToDo1 = new JLabel("- Vælg en film eller serie");
            whatToDo1.setFont(new Font("", Font.BOLD, 20));
            whatToDo2 = new JLabel("- Tryk herefter på knappen 'Tilføj til min liste'");
            whatToDo2.setFont(new Font("", Font.BOLD, 20));
            whatToDo3 = new JLabel("- Nu er filmen eller serien tilføjet til din liste");
            whatToDo3.setFont(new Font("", Font.BOLD, 20));

            emptyListPane.add(whatToDo1);
            emptyListPane.add(whatToDo2);
            emptyListPane.add(whatToDo3);
            
            emptyListPane.setBackground(backgroundGreen);

            tomPanel = new JPanel();
            tomPanel.setBackground(backgroundGreen);
            tomPanel.add(emptyListPane);
            
            panel.add(tomPanel);
        }
    }
}
