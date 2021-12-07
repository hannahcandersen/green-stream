package Controller;

import View.MoviePage;
import View.SearchPage;
import View.SeriesPage;
import Model.*;

/**
 * SearchPage's controller der indeholder searchPage's ActionListeners
 */
public class SearchPageController {

    // Controlleren der har adgang til alle de andre view's controllers
    private Controller controller;

    /**
     * Instantiere controlleren
     * @param controller - Controlleren der har adgang til alle de andre view's controllers
     */
    public SearchPageController(Controller controller){
        this.controller = controller;
    }

    /**
     * Bygger SearchPage med listen af de film der indeholdet ordet der er blevet søgt på
     * @param search - Ordet der er blevet søgt på
     */
    public void searchActionlistner(String search){
        controller.getSceneBuilder().loadPage(new SearchPage(controller.getStreamingService().allNameSearch(search), this));
    }

    public void showSerieActionListener(Media media) {
        controller.getSceneBuilder().loadPage(new SeriesPage(controller.getSeriesPageController(), (Serie)media));
    }

    public void showMovieActionListener(Media media) {
        controller.getSceneBuilder().loadPage(new MoviePage(controller.getMoviePageController(), (Movie)media));
    }
}
