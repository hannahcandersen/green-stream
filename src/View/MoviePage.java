package View;

import Controller.MoviePageController;
import Model.Movie;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MoviePage extends View{
        static JButton closeButton;
        private ImageIcon poster;

    private MoviePageController moviePageController;

    public MoviePage(MoviePageController moviePageController, Movie movie){

        this.moviePageController = moviePageController;

        buildPage(movie);
    }

    public void buildPage(Movie movie) {


        FlowLayout ccc = new FlowLayout();
        JPanel closelayout = new JPanel();
        closelayout.setLayout(ccc);
        ccc.setAlignment(FlowLayout.TRAILING);
        closelayout.setComponentOrientation(
                //ComponentOrientation.RIGHT_TO_LEFT);
        ComponentOrientation.LEFT_TO_RIGHT);


        JButton close = new JButton("X");
        close.addActionListener(e -> moviePageController.goBackActionListener());
        close.setForeground(Color.red);
        close.setSize(30, 60);
        close.setBorder(new EmptyBorder(20, 20, 0, 20));
        close.setBackground(new Color(15, 15, 127));
        close.setContentAreaFilled(false);
        closelayout.add(close);
        closelayout.setBackground(new Color(221,23,23));
        closelayout.setLayout(new FlowLayout());


        // left BoxLayout
        JPanel billedeLayout = new JPanel();



        billedeLayout.setBorder(new EmptyBorder(15, 15, 0, 15));

        // filmens poster bliver indsat her
        poster =  new ImageIcon(movie.getPicture());
        JLabel posterLabel = new JLabel(poster);
        billedeLayout.add(posterLabel);

        //billedeLayout.add(new JTable(1, 1));
        billedeLayout.setBorder(new EmptyBorder(40, 40, 40, 40));
        billedeLayout.setLayout(new BoxLayout(billedeLayout, BoxLayout.PAGE_AXIS));

        // center BoxLayout
        JPanel infoLayout = new JPanel();

        // Play button


        if (moviePageController.getCurrentProfile().getMyList().contains(movie)) {
            JButton minList = new JButton("Fjern fra min liste");
            minList.setSize(30, 60);
            //minList.setBorder(new EmptyBorder(5, 20, 5, 20));
            minList.setBackground(new Color(15, 15, 127));
            minList.setContentAreaFilled(false);
            minList.addActionListener(e -> moviePageController.removeFromMyListActionListener(movie));
            infoLayout.add(minList);
        }
        else {
            JButton minList = new JButton("Tilføj til min liste");
            minList.addActionListener(e -> moviePageController.addToMyListActionListerner(movie));
            minList.setSize(30, 60);
            //minList.setBorder(new EmptyBorder(5, 20, 5, 20));
            minList.setBackground(new Color(15, 15, 127));
            minList.setContentAreaFilled(false);
            infoLayout.add(minList);
        }

        String genre = "";
        for (int i = 0; i < movie.getGenre().length; i++) {
            if (i != 0) {
                genre += ", ";
            }
            genre += movie.getGenre()[i];
        }
        infoLayout.add(new JLabel("Genre: " + genre));
        infoLayout.add(new JLabel("Udgivelsesår: " + movie.getYear()));
        infoLayout.add(new JLabel("Rating: " + movie.getRating()));

        infoLayout.setBorder(new EmptyBorder(40, 40, 40, 40));
        infoLayout.setLayout(new BoxLayout(infoLayout, BoxLayout.PAGE_AXIS));

        // rigth BoxLayout
        JPanel resume = new JPanel();
        resume.add(new JLabel("Resume:"));
        resume.add(new JLabel("_______________________"));
        resume.add(new JLabel("_______________________"));
        resume.add(new JLabel("_______________________"));
        resume.add(new JLabel("_______________________"));
        resume.add(new JLabel("_______________________"));
        resume.add(new JLabel("_______________________"));
        resume.setBorder(new EmptyBorder(40, 40, 40, 40));
        resume.setLayout(new BoxLayout(resume, BoxLayout.PAGE_AXIS));


        // add to Borderlayout
        JPanel buttonPanel = new JPanel(new BorderLayout());

        buttonPanel.add(closelayout, BorderLayout.NORTH);
        buttonPanel.add(billedeLayout, BorderLayout.WEST);
        buttonPanel.add(infoLayout, BorderLayout.CENTER);
        buttonPanel.add(resume, BorderLayout.EAST);

        panel.add(buttonPanel);



    }
}
