package View;

import Controller.LoginPageController;
import Model.Profile;
import Model.StreamingService;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class LoginPage extends View{

    private JPanel bottomPanel = new JPanel();

    private LoginPageController loginPageController;
    Profile[] profiles;

    public LoginPage(LoginPageController loginPageController) {
        this.loginPageController = loginPageController;
        this.profiles = loginPageController.getStreamingService().getProfiles();

        //panel.setBackground(Color.RED);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // Opretter topLabel med logo i midten og tilføjer til contentPane
        ImageIcon logo = new ImageIcon(("Pictures/Logo.png"));
        JPanel topPanel = new JPanel();
        topPanel.setBackground(backgroundGreen);
        JLabel logoLabel = new JLabel(logo);
        topPanel.add(logoLabel);
        topPanel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        //topPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        panel.add(topPanel);

        // Opretter bottomPanel og tilføjer til contentPane
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(backgroundGreen);
        bottomPanel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 700)));
        panel.add(bottomPanel);

        // Sætter plusButton ind i bottomPanel
        ImageIcon plusIcon = new ImageIcon(("Pictures/Plus.png"));
        JButton plusButton = new JButton(plusIcon);
        plusButton.addActionListener(e -> loginPageController.addProfile());
        plusButton.setIcon(plusIcon);
        plusButton.setBorder(new EmptyBorder(0,0,0,0));
        bottomPanel.add(plusButton);
        bottomPanel.revalidate();

    }


}
