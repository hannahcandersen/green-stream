package View;

import Controller.MenubarController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Denne klasse ræpresentere menubaren som skal være i toppen af siden. Menubaren indeholder vores logo,
 * en burgermenu, en søgeknap og til sidst brugerens valgte profil billede.
 */
public class Menubar {
    
    // Farven på menubaren
    private final Color limeGreen = new Color(196,224,177);

    // Alle billeder der skal bruges i menubaren
    private ImageIcon logo = new ImageIcon(getClass().getResource("/Logo.png"));
    private ImageIcon burgerMenu = new ImageIcon(getClass().getResource("/Burgermenu.png"));
    private ImageIcon searchIcon = new ImageIcon(getClass().getResource("/Search.png"));
    private ImageIcon profileIcon;

    // Listen med genre
    private String[] genreList;

    // Instantierer en JMenuBar
    private JMenuBar menuBar = new JMenuBar();

    // MenuBarens controller
    private MenubarController menubarController;

    /**
     * Instantierer felter der skal bruges
     * @param genreList - Listen med genre
     * @param profilePicture - Profilbilledet (træet) for den bruger der er logget ind
     * @param menubarController - menubarens controller
     */
    public Menubar(String[] genreList, String profilePicture, MenubarController menubarController) {
        this.genreList = genreList;
        this.profileIcon = new ImageIcon(getClass().getResource(profilePicture));
        this.menubarController = menubarController;
    }

    // Metoden der laver menubaren
    public JMenuBar makeMenu() {

        JMenu menu = new JMenu("");
        menuBar.add(menu, BorderLayout.LINE_START);
        burgerMenu = scaleImage(100, 100, burgerMenu);
        menu.setIcon(burgerMenu);
        menu.setContentAreaFilled(false);
        menu.setBackground(limeGreen);
        menu.setPreferredSize(new Dimension(100, 100));

        JMenuItem myList = new JMenuItem("Min Liste");
        myList.setContentAreaFilled(false);
        myList.setBackground(limeGreen);
        menu.add(myList);
        myList.addActionListener(e -> menubarController.myListActionListener());

        JMenuItem movie = new JMenuItem("Film");
        movie.setContentAreaFilled(false);
        movie.setBackground(limeGreen);
        menu.add(movie);
        movie.addActionListener(e -> menubarController.movieActionListener());

        JMenuItem serie = new JMenuItem("Serier");
        serie.setContentAreaFilled(false);
        serie.setBackground(limeGreen);
        menu.add(serie);
        serie.addActionListener(e -> menubarController.serieActionListener());

        JMenu genre = new JMenu("Genrer");
        genre.setContentAreaFilled(false);
        genre.setBackground(limeGreen);
        menu.add(genre);

        for (String genreName : genreList) {
            JMenuItem genreItem = new JMenuItem(genreName);
            genreItem.setContentAreaFilled(false);
            genreItem.setBackground(limeGreen);
            genre.add(genreItem);
            genreItem.addActionListener(e -> menubarController.genreActionListener(genreName));
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        menuBar.add(panel);
        panel.setBackground(limeGreen);

        logo = scaleImage(300, 100, logo);
        JButton logoButton = new JButton(logo);
        logoButton.setContentAreaFilled(false);
        logoButton.addActionListener(e -> menubarController.goToMainPageActionListener());
        logoButton.setBackground(limeGreen);
        logoButton.setBorder(new EmptyBorder(0,0,0,0));
        logoButton.setSize(new Dimension(100, 100));
        panel.add(logoButton, BorderLayout.CENTER);

        JPanel right = new JPanel();
        right.setLayout(new BorderLayout());
        right.setBackground(limeGreen);
        panel.add(right, BorderLayout.LINE_END);

        JButton searchButton = new JButton("");
        searchIcon = scaleImage(50, 50, searchIcon);
        searchButton.setContentAreaFilled(false);
        searchButton.setBackground(limeGreen);
        searchButton.setPreferredSize(new Dimension(70,60));
        searchButton.setIcon(searchIcon);
        searchButton.setBorder(new EmptyBorder(0,0,0,0));
        right.add(searchButton, BorderLayout.LINE_START);
        searchButton.addActionListener(e -> menubarController.searchActionListener());

        JButton profileButton  = new JButton("");
        profileIcon = scaleImage(50, 80, profileIcon);
        profileButton.setContentAreaFilled(false);
        profileButton.setBackground(limeGreen);
        profileButton.setIcon(profileIcon);
        profileButton.setPreferredSize(new Dimension(70,60));
        profileButton.setBorder(new EmptyBorder(0,0,0,0));
        right.add(profileButton, BorderLayout.LINE_END);
        profileButton.addActionListener(e -> {menubarController.profileActionListener();});

        return menuBar;
    }

    // Ændre størrelsen på billedet
    private ImageIcon scaleImage(int width, int height, ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }


}
