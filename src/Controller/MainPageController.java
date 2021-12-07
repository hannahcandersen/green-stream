package Controller;

import Model.Media;
import Model.Movie;
import Model.Serie;
import View.MainPage;
import View.MoviePage;
import View.SeriesPage;

public class MainPageController {

    private Controller controller;

    public MainPageController(Controller controller) {
        this.controller = controller;
    }

    public void showSerieActionListener(Media media) {
        controller.getSceneBuilder().loadPage(new SeriesPage(controller.getSeriesPageController(), (Serie)media));
    }

    public void showMovieActionListener(Media media) {
        controller.getSceneBuilder().loadPage(new MoviePage(controller.getMoviePageController(), (Movie)media));
    }
}
