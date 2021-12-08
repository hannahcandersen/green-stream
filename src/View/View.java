package View;

import Controller.Controller;
import Model.Media;
import Model.Movie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

import Controller.*;

/**
 * View klassen som alle sider nedarver fra, bortset fra menubaren
 */
public class View extends JPanel {
    // Feltet der bestemmer om siden har en menubar eller ej
    protected boolean menubarVisible = false;
    
    // Det JPanel som alle sider sætter deres indhold på
    protected JPanel panel = new JPanel();

    // Vores grundfarver
    protected final Color backgroundGreen = new Color(236, 242, 223);
    protected final Color limeGreen = new Color(196,224,177);
    protected final Color darkerGreen = new Color(151, 180, 121);



    // Getter metode for om menubaren er synlig
    public boolean isMenubarVisible() {
        return menubarVisible;
    }

    // Getter metode for panelet som alt indhold er på
    public JPanel getPanel() {
        return panel;
    }

/*
    public JScrollPane scrollPane(ArrayList<Media> mediaList) {

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

                        // Hvis mediet er en film findes filmens plakat, ellers er det en serie og dennes plakat findes
                        if (mediaList.get(counter) instanceof Movie) {
                            plakat = new JButton(new ImageIcon("resources/filmplakater/" + mediaList.get(counter).getPicture()));
                            //plakat.addActionListener(e -> controller.showSerieActionListener());
                        }
                        else {
                            plakat = new JButton(new ImageIcon("resources/Serierforsider/" + mediaList.get(counter).getPicture()));
                        }
                        plakat.setPreferredSize(new Dimension(100, 200));
                        plakat.setBorder(new EmptyBorder(0,0,0,0));
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
        return new JScrollPane(col);
    }
*/
}
