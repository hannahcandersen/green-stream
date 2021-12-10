package View;

import Controller.LoginPageController;
import Model.Profile;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

/**
 * Denne klasse er en subklasse af View klassen. Den repræsenterer siden som kan viser listen a brugere
 */
public class LoginPage extends View{
    private LoginPageController loginPageController;
    private int currentLength;
    Profile[] profiles;
    private JPanel topPanel, bottomPanel;
    private JLabel logoLabel;
    private JButton plusButton, userButton;
    private ImageIcon logo, plusIcon, userIcon;

    /**
     * Instantiere controlleren og bygger siden
     * @param loginPageController - Sidens controller
     * @param profiles - Listen af de addede profiler
     * @param currentLength - Længden af listen over profiler
     */
    public LoginPage(LoginPageController loginPageController, Profile[] profiles, int currentLength) {
        this.loginPageController = loginPageController;
        this.profiles = profiles;
        this.currentLength = currentLength;
        buildLoginPage();
    }

    /**
     * Bygger sidens visuelle indhold
     */
    private void buildLoginPage() {
    // Opretter topPanel
        topPanel = new JPanel();
        logo = new ImageIcon(("Pictures/Logo.png"));
        logoLabel = new JLabel(logo);
        topPanel.add(logoLabel);
        topPanel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

    // Opretter bottomPanel
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 700)));

        // Viser profilerne
        for (int i = 0; i < currentLength; i++){
            addProfilePicture(profiles[i].getPicture(), profiles[i].getName(), i);
        }

        // Sætter plusButton ind, hvis der ikke er over 4 profiler
        if (currentLength < 4) {
            plusIcon = new ImageIcon(("Pictures/Plus.png"));
            plusButton = new JButton(plusIcon);
            plusButton.setIcon(plusIcon);
            plusButton.setBorder(new EmptyBorder(0, 0, 0, 0));
            bottomPanel.add(plusButton);
            bottomPanel.revalidate();
            plusButton.addActionListener(e -> loginPageController.addProfileActionListener());
        }

    // Sætter Brackgrund color
        bottomPanel.setBackground(limeGreen);
        topPanel.setBackground(limeGreen);

    // Sammensætter til et panel
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(topPanel);
        panel.add(bottomPanel);
    }

    /**
     * Henter dataen fra profilerne fra listen af "profiles"
     * @param profilePicture - Henter og viser billederne til profilerne
     * @param name - Henter og viser navnene til profilerne
     * @param profileNumber - Giver hver profil et nummer
     */
    private void addProfilePicture(String profilePicture, String name, int profileNumber){
        userIcon = new ImageIcon(profilePicture);
        userButton = new JButton(userIcon);
        userButton.setContentAreaFilled(false);
        userButton.setBackground(limeGreen);
        userButton.setIcon(userIcon);
        userButton.setBorder(new EmptyBorder(0,0,0,0));
        userButton.setText(name);
        userButton.setHorizontalTextPosition(JButton.CENTER);
        userButton.setVerticalTextPosition(JButton.CENTER);
        userButton.addActionListener(e -> loginPageController.goToMainPageActionListener(profileNumber));

        bottomPanel.add(userButton);
        bottomPanel.revalidate();
    }
}
