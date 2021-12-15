package Controller;

import Model.Media;
import Model.Movie;
import Model.Serie;
import View.MainPage;
import View.MoviePage;
import View.SeriesPage;

/**
 * Klassen der har metoderne der bliver brugt i MainPage's actionListeners
 */
public class MainPageController {

    private Controller controller;

    /**
     * Konstruktør for MainPageController der instantiere controller
     * @param controller - Hoved Controlleren
     */
    public MainPageController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Metoden der går til mediets side, enten MoviePage eller SeriesPage alt efter om det er en film eller serie
     * @param pictureName - mediet's plakat's filvej
     */
    public void showMediaActionListener(String pictureName) {

        Media media = controller.getStreamingService().findMediaFromPicture(pictureName);

        if (media instanceof Movie) {
            controller.getSceneBuilder().loadPage(new MoviePage(controller.getMoviePageController(), (Movie)media));
        }
        else if (media instanceof Serie) {
            controller.getSceneBuilder().loadPage(new SeriesPage(controller.getSeriesPageController(), (Serie)media));
        }
    }
}
