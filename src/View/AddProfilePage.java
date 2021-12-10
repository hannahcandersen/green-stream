package View;

import Controller.AddProfilePageController;
import Model.Profile;

import javax.swing.*;
import java.awt.*;

/**
 * Denne klasse er en subklasse af View klassen. Den repræsenterer siden som kan tilføje brugere til listen af brugere
 */
public class AddProfilePage extends View {

    // AddProfilePage's controller
    private AddProfilePageController addProfilePageController;

    /**
     * Instantiere controlleren og bygger siden
     * @param colorIndex - Indekset der bestemmer hvilken farve der står på comboboksen
     * @param username - Navnet der står i tekstfeltet, som default er det "Brugernavn"
     * @param addProfilePageController - sidens controller
     */
    public AddProfilePage(int colorIndex, String username, AddProfilePageController addProfilePageController){
        this.addProfilePageController = addProfilePageController;
        buildPage(colorIndex, username);
    }

    /**
     * Bygger sidens visuelle indhold
     * @param colorIndex - Indekset der bestemmer hvilken farve der står på comboboksen
     * @param usernameString - Navnet der står i tekstfeltet, som default er det "Brugernavn"
     */
    public void buildPage(int colorIndex, String usernameString) {
        panel.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        JPanel colorPane = new JPanel(new FlowLayout());

        String blue = "Blå";
        String green = "Grøn";
        String yellow = "Gul";
        String orange = "Orange";
        String pink = "Pink";
        String red = "Rød";



        String comboBoxItems[] ={blue, green, yellow, orange, pink, red};
        JComboBox comboBox = new JComboBox(comboBoxItems);
        comboBox.setSelectedIndex(colorIndex);
        colorPane.add(comboBox);

        ImageIcon choosenColour = new ImageIcon("Pictures/" + comboBoxItems[colorIndex] + ".png");
        //Image image = userIcon.getImage(); // transform it
        //Image newimg = image.getScaledInstance(240, 350,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        //userIcon = new ImageIcon(newimg);  // transform it back

        JLabel color = new JLabel(choosenColour);
        colorPane.add(color);

        JTextField username = new JTextField(usernameString, 20);
        username.setSize(200, 20);
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(username);
        usernamePanel.setSize(400,40);
        usernamePanel.setBackground(limeGreen);

        comboBox.addActionListener(e -> addProfilePageController.chooseColorActionListener(comboBox.getSelectedIndex(), username.getText()));

        JPanel buttonPane = new JPanel(new FlowLayout());
        buttonPane.setSize(200,100);
        buttonPane.setBackground(limeGreen);
        JButton add = new JButton("Tilføj");
        JButton back = new JButton("Tilbage");
        buttonPane.add(back);
        buttonPane.add(add);

        add.addActionListener(e -> addProfilePageController.addProfileActionListener(new Profile(username.getText(), "Pictures/"+ comboBoxItems[comboBox.getSelectedIndex()] + ".png")));
        back.addActionListener(e -> addProfilePageController.goBackActionListener());

        mainPanel.add(usernamePanel);
        mainPanel.add(buttonPane);

        colorPane.setBackground(limeGreen);

        panel.add(colorPane, BorderLayout.NORTH);
        panel.add(mainPanel, BorderLayout.CENTER);

    }

}
