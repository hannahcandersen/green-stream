package View;

import Controller.AddProfilePageController;
import Model.Profile;

import javax.swing.*;
import java.awt.*;

public class AddProfilePage extends View {
    private JButton add;
    private JButton back;
    private JComboBox comboBox;
    private ImageIcon choosenColour;
    private JLabel color;

    private AddProfilePageController addProfilePageController;

    public AddProfilePage(int colorIndex, String username, AddProfilePageController addProfilePageController){

        this.addProfilePageController = addProfilePageController;
        buildPage(colorIndex, username);

    }

    public void buildPage(int colorIndex, String usernameString) {
        panel.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        JPanel colorPane = new JPanel(new FlowLayout());

        String blue = "Blue";
        String green = "Green";
        String yellow = "Yellow";
        String pink = "Pink";

        String comboBoxItems[] ={blue, green, yellow, pink};
        comboBox = new JComboBox(comboBoxItems);
        comboBox.setSelectedIndex(colorIndex);
        colorPane.add(comboBox);

        choosenColour = new ImageIcon("Pictures/" + comboBoxItems[colorIndex] + ".png");
        this.color = new JLabel(choosenColour);
        colorPane.add(this.color);

        JTextField username = new JTextField(usernameString, 20);
        username.setSize(200, 20);
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(username);
        usernamePanel.setSize(400,40);
        usernamePanel.setBackground(limeGreen);

        comboBox.addActionListener(e -> addProfilePageController.chooseColor(comboBox.getSelectedIndex(), username.getText()));

        JPanel buttonPane = new JPanel(new FlowLayout());
        buttonPane.setSize(200,100);
        buttonPane.setBackground(limeGreen);
        add = new JButton("Tilføj");
        back = new JButton("Tilbage");
        buttonPane.add(back);
        buttonPane.add(add);

        add.addActionListener(e -> addProfilePageController.addProfileActionListener(new Profile(username.getText(), "Pictures/"+ comboBoxItems[comboBox.getSelectedIndex()] + ".png")));
        back.addActionListener(e -> addProfilePageController.goBack());

        //mainPanel.add(colorPane);
        mainPanel.add(usernamePanel);
        mainPanel.add(buttonPane);

        colorPane.setBackground(limeGreen);

        panel.add(colorPane, BorderLayout.NORTH);
        panel.add(mainPanel, BorderLayout.CENTER);

    }

}
