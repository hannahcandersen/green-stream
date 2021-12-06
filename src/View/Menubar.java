package View;

import Controller.MenubarController;
import Controller.SceneBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Menubar {

    private final Color limeGreen = new Color(121, 186, 17);
    private final Color backgroundGreen = new Color(196,224,177);
    private JMenuBar menuBar = new JMenuBar();

    private ImageIcon logo = new ImageIcon("Pictures/Logo.png");
    private ImageIcon burgerMenu = new ImageIcon("Pictures/Burgermenu.png");
    private ImageIcon searchIcon = new ImageIcon("Pictures/Search.png");
    private ImageIcon profileIcon;

    private final Dimension dimensionSmall = new Dimension(70,60);
    private final Dimension dimensionLarge = new Dimension(100, 100);
    private String[] genreList;

    private MenubarController menubarController;

    public Menubar(String[] genreList, String profilePicture, MenubarController menubarController) {
        this.genreList = genreList;
        this.profileIcon = new ImageIcon(profilePicture);
        this.menubarController = menubarController;
    }

    public JMenuBar makeMenu() {

        JMenu menu = new JMenu("");
        menuBar.add(menu, BorderLayout.LINE_START);
        burgerMenu = scaleImage(100, 100, burgerMenu);
        menu.setIcon(burgerMenu);
        menu.setPreferredSize(dimensionLarge);

        JMenuItem myList = new JMenuItem("Min Liste");
        menu.add(myList);
        myList.addActionListener(e -> menubarController.myListActionListener());

        JMenuItem movie = new JMenuItem("Film");
        menu.add(movie);
        movie.addActionListener(e -> menubarController.movieActionListener());

        JMenuItem serie = new JMenuItem("Serie");
        menu.add(serie);
        serie.addActionListener(e -> menubarController.serieActionListener());

        JMenu genre = new JMenu("genre");
        menu.add(genre);

        for (String genreName : genreList) {
            JMenuItem genreItem = new JMenuItem(genreName);
            genre.add(genreItem);
            genreItem.addActionListener(e -> menubarController.genreActionListener(genreName));
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        menuBar.add(panel);
        panel.setBackground(limeGreen);

        logo = scaleImage(300, 100, logo);
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setPreferredSize(dimensionLarge);
        panel.add(logoLabel, BorderLayout.CENTER);

        JPanel right = new JPanel();
        right.setLayout(new BorderLayout());
        right.setBackground(limeGreen);
        panel.add(right, BorderLayout.LINE_END);

        JButton searchButton = new JButton("");
        searchIcon = scaleImage(50, 50, searchIcon);
        searchButton.setPreferredSize(dimensionSmall);
        searchButton.setIcon(searchIcon);
        searchButton.setBorder(new EmptyBorder(0,0,0,0));
        right.add(searchButton, BorderLayout.LINE_START);
        searchButton.addActionListener(e -> menubarController.searchActionListener());

        JButton profileButton  = new JButton("");
        profileIcon = scaleImage(50, 80, profileIcon);
        profileButton.setIcon(profileIcon);
        profileButton.setPreferredSize(dimensionSmall);
        profileButton.setBorder(new EmptyBorder(0,0,0,0));
        right.add(profileButton, BorderLayout.LINE_END);
        profileButton.addActionListener(e -> {menubarController.profileActionListener();});

        return menuBar;
    }

    private ImageIcon scaleImage(int width, int height, ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }


}
