package View;

import Controller.AddProfilePageController;
import Model.Profile;

import javax.swing.*;
import java.awt.*;

/**
 * Denne klasse er en subklasse af View klassen.
 * Den repræsenterer siden som kan tilføje brugere til listen af brugere
 */
public class AddProfilePage extends View {
    private AddProfilePageController addProfilePageController;
    private JPanel mainPanel, colorPane, usernamePanel, buttonPane;
    private JButton add, back;
    private JLabel color;
    private JComboBox comboBox;
    private ImageIcon choosenColour;
    private JTextField username;
    String blue = "Blå";
    String green = "Grøn";
    String yellow = "Gul";
    String orange = "Orange";
    String pink = "Pink";
    String red = "Rød";

    /**
     * Instantiere controlleren og bygger siden
     * @param colorIndex - Indekset der bestemmer hvilken farve der står på comboboksen
     * @param username - Navnet der står i tekstfeltet, som default er det "Brugernavn"
     * @param addProfilePageController - Sidens controller
     */
    public AddProfilePage(int colorIndex, String username, AddProfilePageController addProfilePageController){
        this.addProfilePageController = addProfilePageController;
        buildAddProfilePage(colorIndex, username);
    }

    /**
     * Bygger sidens visuelle indhold
     * @param colorIndex - Indekset der bestemmer hvilken farve der står på comboboksen
     * @param usernameString - Navnet der står i tekstfeltet, som default er det "Brugernavn"
     */
    public void buildAddProfilePage(int colorIndex, String usernameString) {
    // Opretter colorPane
        // comboBox og det tilhørende billede
        colorPane = new JPanel(new FlowLayout());
        String comboBoxItems[] ={blue, green, yellow, orange, pink, red};
        comboBox = new JComboBox(comboBoxItems);
        comboBox.setSelectedIndex(colorIndex);
        comboBox.addActionListener(e -> addProfilePageController.chooseColorActionListener(comboBox.getSelectedIndex(), username.getText()));
        choosenColour = new ImageIcon(getClass().getResource("/" + comboBoxItems[colorIndex] + ".png"));
        color = new JLabel(choosenColour);

        colorPane.add(comboBox);
        colorPane.add(color);

    // Opretter usernamePanel
        // Tekstfelt
        usernamePanel = new JPanel();
        username = new JTextField(usernameString, 20);
        username.setSize(200, 20);

        usernamePanel.add(username);
        usernamePanel.setSize(400,40);

    // Opretter buttonPane
        // Knapperne
        buttonPane = new JPanel(new FlowLayout());
        add = new JButton("Tilføj");
        add.addActionListener(e -> addProfilePageController.addProfileActionListener(new Profile(username.getText(), "/"+ comboBoxItems[comboBox.getSelectedIndex()] + ".png")));
        back = new JButton("Tilbage");
        back.addActionListener(e -> addProfilePageController.goBackActionListener());

        buttonPane.setSize(200,100);
        buttonPane.add(back);
        buttonPane.add(add);

    // Opretter mainPanel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        mainPanel.add(usernamePanel);
        mainPanel.add(buttonPane);

    // Sætter Backgrund color
        colorPane.setBackground(limeGreen);
        usernamePanel.setBackground(limeGreen);
        buttonPane.setBackground(limeGreen);

    // Sammensætter til et panel
        panel.setLayout(new BorderLayout());
        panel.add(colorPane, BorderLayout.NORTH);
        panel.add(mainPanel, BorderLayout.CENTER);
    }
}
