package View;

import Controller.MoviePageController;
import Model.Movie;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MoviePage extends View{
    private MoviePageController moviePageController;
    private ImageIcon moviePoster;
    private JPanel titelPanel, rigthPanel, leftPanel, centerPanel, imageLeftCenter, infoCenterCenter, resumeRigthCenter, BorderLayoutPanel;
    private JLabel titel, rigthFill, leftFill, movieLabel, genreLabel, yearLabel, ratingLabel, resumeTitelLabel;
    private JButton close, play, minList;
    private JTextArea resumeArea;

    public MoviePage(MoviePageController moviePageController, Movie movie){
        this.moviePageController = moviePageController;
        buildPage(movie);
    }

    public void buildPage(Movie movie) {
    //BorderLayout NORTH
        titelPanel = new JPanel();
        titel = new JLabel(movie.getName());
        titel.setFont(new Font("Serif", Font.BOLD, 40));
        titelPanel.add(titel);

    //BorderLayout WEST
        rigthPanel = new JPanel();
        close = new JButton("X");
        close.addActionListener(e -> moviePageController.goBackActionListener());
        close.setFont(new Font("Serif", Font.BOLD, 30));
        close.setContentAreaFilled(false);              // knappen bliver transperent
        close.setBorder(new EmptyBorder(20, 20, 0, 0));
        rigthPanel.add(close);

        rigthFill = new JLabel("                                  ");
        rigthPanel.add(rigthFill);

    //BorderLayout EAST
        leftPanel = new JPanel();
        leftFill = new JLabel("                                               ");
        leftPanel.add(leftFill);

    //BorderLayout Center
        centerPanel = new JPanel();

        //Billede Left-Center
        imageLeftCenter = new JPanel();
        imageLeftCenter.setBorder(new EmptyBorder(15, 15, 0, 15));
        moviePoster = new ImageIcon(new ImageIcon(movie.getPicture()).getImage().getScaledInstance(250, 400, Image.SCALE_DEFAULT));
        movieLabel = new JLabel(moviePoster);
        movieLabel.setIcon(moviePoster);
        imageLeftCenter.add(movieLabel);
        imageLeftCenter.setBorder(new EmptyBorder(40, 40, 40, 40));
        imageLeftCenter.setLayout(new BoxLayout(imageLeftCenter, BoxLayout.PAGE_AXIS));

        //Info Center-Center
        infoCenterCenter = new JPanel();
            // Play button
            play  = new JButton("Play");
            play.setSize(800, 60); // size virker ikke
            play.setContentAreaFilled(false);
            play.addActionListener(e -> moviePageController.playActionListener());
            infoCenterCenter.add(play);

            infoCenterCenter.add(new JLabel(" "));

            // minList button
            if (moviePageController.getCurrentProfile().getMyList().contains(movie)) {
                minList = new JButton("Fjern fra min liste");
                minList.setSize(150, 60);
                minList.setContentAreaFilled(false);
                minList.addActionListener(e -> moviePageController.removeFromMyListActionListener(movie));
                infoCenterCenter.add(minList);
            } else {
                minList = new JButton("Tilføj til min liste");
                minList.addActionListener(e -> moviePageController.addToMyListActionListerner(movie));
                minList.setSize(80, 60);
                minList.setContentAreaFilled(false);
                infoCenterCenter.add(minList);
            }
        // adder alle mediets genre til en string, så den kan bliver brugt af "genreLabel"
        String genre = "";
        for (int i = 0; i < movie.getGenre().length; i++) {
            if (i != 0) {
                genre += ", ";
            }
            genre += movie.getGenre()[i];
        }

        genreLabel = new JLabel("Genre: " + genre);
        genreLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        yearLabel = new JLabel("Udgivelsesår: " + movie.getYear());
        yearLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        ratingLabel = new JLabel("Rating: " + movie.getRating());
        ratingLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        infoCenterCenter.add(new JLabel(" "));
        infoCenterCenter.add(genreLabel);
        infoCenterCenter.add(yearLabel);
        infoCenterCenter.add(ratingLabel);
        infoCenterCenter.setBorder(new EmptyBorder(0, 90, 20, 0));
        infoCenterCenter.setLayout(new BoxLayout(infoCenterCenter, BoxLayout.PAGE_AXIS));

        //Resume Rigth Center
        resumeRigthCenter = new JPanel();
        resumeTitelLabel = new JLabel("Resume: ");
        resumeTitelLabel.setFont(new Font("Serif", Font.BOLD, 20));

        resumeArea = new JTextArea();
        resumeArea.setText(movie.getName() + " er en de 100 bedste film i verden (ifølge én liste fra imdb), derfor har GreenStream filmen her til din underholdning. ");
        resumeArea.setLineWrap(true);
        resumeArea.setWrapStyleWord(true);
        resumeArea.setEditable(false);
        resumeArea.setBounds(0,05,280,280);
        resumeArea.setBorder(new EmptyBorder(0, 90, 20, 0));

        resumeRigthCenter.add(resumeTitelLabel);
        resumeRigthCenter.add(resumeArea);
        resumeRigthCenter.setBorder(new EmptyBorder(40, 80, 40, 40));
        resumeRigthCenter.setLayout(new BoxLayout(resumeRigthCenter, BoxLayout.PAGE_AXIS));

    //Sammensætning af alle tre centerPanel
        centerPanel.add(imageLeftCenter);
        centerPanel.add(infoCenterCenter);
        centerPanel.add(resumeRigthCenter);

        //Backgrund farve
        titelPanel.setBackground(darkerGreen);
        resumeArea.setBackground(limeGreen);
        imageLeftCenter.setBackground(limeGreen);
        infoCenterCenter.setBackground(limeGreen);
        resumeRigthCenter.setBackground(limeGreen);
        rigthPanel.setBackground(limeGreen);
        centerPanel.setBackground(limeGreen);
        leftPanel.setBackground(limeGreen);
        panel.setBackground(limeGreen);

    //Sammensætning af Borderlayout
        BorderLayoutPanel = new JPanel(new BorderLayout());

        BorderLayoutPanel.add(titelPanel, BorderLayout.NORTH);
        BorderLayoutPanel.add(rigthPanel, BorderLayout.WEST);
        BorderLayoutPanel.add(centerPanel, BorderLayout.CENTER);
        BorderLayoutPanel.add(leftPanel, BorderLayout.EAST);

        panel.add(BorderLayoutPanel);
    }
}
