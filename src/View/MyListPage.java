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
     * Instantiere felterne og bygger siden
     * @param myList - Listen af medierne der er på myList
     * @param myListPageController - MyListPage's controller
     */
    public MyListPage(ArrayList<Media> myList, MyListPageController myListPageController) {
        this.myList = myList;
        this.myListPageController = myListPageController;

        buildPage(myList);
    }

    private  void buildPage(ArrayList<Media> myList) {
        // Sætter menubaren til at være synlig
        menubarVisible = true;

        // Tilføjer et tekstfelt
        JLabel text = new JLabel("Min Liste");
        text.setFont(text.getFont().deriveFont(Font.BOLD, 50));
        panel.add(text);

        // tilføjer et scrollPane med listen af medier i mylist til panelet
        panel.add(scrollPane(myList));

    }
}
