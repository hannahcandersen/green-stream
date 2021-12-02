package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Menubar {
    private final Color backgroundGreen;
    private JFrame frame;
    private JMenuBar menuBar;
    private ImageIcon logo = new ImageIcon("Pictures/Logo.png");
    private ImageIcon burgerMenu = new ImageIcon("Pictures/Burgermenu.png");
    private ImageIcon searchIcon = new ImageIcon("Pictures/Search.png");
    private ImageIcon profileIcon;
    private final Dimension dimensionSmall = new Dimension(70,60);
    private final Dimension dimensionLarge = new Dimension(100, 100);
    private String[] genreList;

    public Menubar(Color backgroundGreen, JFrame frame, String[] genreList, String profilePicture) {
        this.backgroundGreen = backgroundGreen;
        this.frame = frame;
        menuBar = new JMenuBar();
        this.genreList = genreList;
        this.profileIcon = new ImageIcon(("Pictures/" + profilePicture + ".png"));

    }

    public JMenuBar makeMenu() {
        frame.setJMenuBar(menuBar);

        JMenu menu = new JMenu("");
        menuBar.add(menu, BorderLayout.LINE_START);
        burgerMenu = scaleImage(100, 100, burgerMenu);
        menu.setIcon(burgerMenu);
        menu.setPreferredSize(dimensionLarge);

        JMenuItem minListe = new JMenuItem("Min Liste");
        menu.add(minListe);

        JMenuItem film = new JMenuItem("Film");
        menu.add(film);

        JMenuItem serie = new JMenuItem("Serie");
        menu.add(serie);

        JMenu genre = new JMenu("genre");
        menu.add(genre);

        for (String genreName : genreList) {
            JMenuItem genreItem = new JMenuItem(genreName);
            genre.add(genreItem);
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        menuBar.add(panel);
        panel.setBackground(backgroundGreen);

        logo = scaleImage(300, 100, logo);
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setPreferredSize(dimensionLarge);
        panel.add(logoLabel, BorderLayout.CENTER);

        JPanel right = new JPanel();
        right.setLayout(new BorderLayout());
        right.setBackground(backgroundGreen);
        panel.add(right, BorderLayout.LINE_END);

        JButton searchButton = new JButton("");
        searchIcon = scaleImage(50, 50, searchIcon);
        searchButton.setPreferredSize(dimensionSmall);
        searchButton.setIcon(searchIcon);
        searchButton.setBorder(new EmptyBorder(0,0,0,0));
        right.add(searchButton, BorderLayout.LINE_START);

        JButton profileButton  = new JButton("");
        profileIcon = scaleImage(50, 80, profileIcon);
        profileButton.setIcon(profileIcon);
        profileButton.setPreferredSize(dimensionSmall);
        profileButton.setBorder(new EmptyBorder(0,0,0,0));
        right.add(profileButton, BorderLayout.LINE_END);

        return menuBar;
    }

    private ImageIcon scaleImage(int width, int height, ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

}
