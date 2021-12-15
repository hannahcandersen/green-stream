package Controller;

import Model.Media;
import Model.Movie;
import Model.Serie;
import View.MoviePage;
import View.SeriesPage;

/**
 * Klassen der har metoderne der bliver brugt i MyListPage's actionListeners
 */
public class MyListPageController {

    private Controller controller;

    /**
     * Konstruktør for MyListPageController der instantiere controller
     * @param controller - Hoved Controlleren
     */
    public MyListPageController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Metoden der får siden til at gå til SeriesPage
     * @param media - den Serie man gerne vil ind på
     */
    public void showSerieActionListener(Media media) {
        controller.getSceneBuilder().loadPage(new SeriesPage(controller.getSeriesPageController(), (Serie)media));
    }

    /**
     * Metoden der får siden til at gå til MoviePage
     * @param media - den film man gerne vil ind på
     */
    public void showMovieActionListener(Media media) {
        controller.getSceneBuilder().loadPage(new MoviePage(controller.getMoviePageController(), (Movie)media));
    }
}
