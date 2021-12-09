package View;

import Controller.MyListPageController;
import Model.Media;
import Model.Movie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MyListPage extends View{

    // Listen af filmene der er tilføjet til myList
    private ArrayList<Media> myList;

    // MyListPage's controller
    private MyListPageController myListPageController;

    /**
     * Instantierer felterne og bygger siden
     * @param myList - Listen af medierne der er på myList
     * @param myListPageController - MyListPage's controller
     */
    public MyListPage(ArrayList<Media> myList, MyListPageController myListPageController) {
        this.myList = myList;
        this.myListPageController = myListPageController;

        buildPage(myList);
    }

    private  void buildPage(ArrayList<Media> mediaList) {
        // Sætter menubaren til at være synlig
        menubarVisible = true;

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(backgroundGreen);
        panel.add(topPanel);

        // Tilføjer et tekstfelt
        JLabel text = new JLabel("Min Liste");
        text.setFont(text.getFont().deriveFont(Font.BOLD, 50));
        topPanel.add(text, BorderLayout.NORTH);

        if (mediaList != null && mediaList.size() > 0) {

            // tilføjer et scrollPane med listen af medier i mylist til panelet

            JPanel col = new JPanel();

            // holder styr på hvor mange film der er tilføjet til panelet
            int counter = 0;

            // hvis listen ikke er tom
            if (mediaList != null && mediaList.size() > 0) {
                // Jpanel med det antal rækker der er nødvendigt for alle kunne vise alle film
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
                                plakat.setContentAreaFilled(false);
                                plakat.setBackground(limeGreen);
                                plakat.addActionListener(e -> myListPageController.showMovieActionListener(media));
                            }
                            else {
                                plakat = new JButton(new ImageIcon(mediaList.get(counter).getPicture()));
                                plakat.setContentAreaFilled(false);
                                plakat.setBackground(limeGreen);
                                plakat.addActionListener(e -> myListPageController.showSerieActionListener(media));
                            }
                            plakat.setPreferredSize(new Dimension(100, 200));
                            plakat.setBorder(new EmptyBorder(0, 0, 0, 0));
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
            // Gør såden at man kan scrolle i listen med rækker
            JScrollPane scrollPane = new JScrollPane(col);
            panel.add(scrollPane);
        }
        else {
            JPanel emptyListPane = new JPanel();
            emptyListPane.setLayout(new BoxLayout(emptyListPane, BoxLayout.PAGE_AXIS));
            emptyListPane.setSize(500,300);
            JLabel empty = new JLabel("Listen er tom da du ikke har tilføjet en film/serie endnu");
            empty.setFont(new Font("", Font.BOLD, 30));
            emptyListPane.add(empty);



            JLabel whatToDo1 = new JLabel("- Vælg en film eller serie");
            whatToDo1.setFont(new Font("", Font.BOLD, 20));
            JLabel whatToDo2 = new JLabel("- Tryk herefter på knappen 'Tilføj til min liste'");
            whatToDo2.setFont(new Font("", Font.BOLD, 20));
            JLabel whatToDo3 = new JLabel("- Nu er filmen eller serien tilføjet til din liste");
            whatToDo3.setFont(new Font("", Font.BOLD, 20));

            emptyListPane.add(whatToDo1);
            emptyListPane.add(whatToDo2);
            emptyListPane.add(whatToDo3);
            
            emptyListPane.setBackground(backgroundGreen);

            JPanel p = new JPanel();
            p.setBackground(backgroundGreen);
            p.add(emptyListPane);
            
            panel.add(p);



        }
    }
}
