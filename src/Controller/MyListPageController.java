package Controller;

import Model.Media;
import Model.Movie;
import Model.Serie;
import View.MoviePage;
import View.MyListPage;
import View.SeriesPage;

public class MyListPageController {

    private Controller controller;

    public MyListPageController(Controller controller) {
        this.controller = controller;
    }


    public void showSerieActionListener(Media media) {
        controller.getSceneBuilder().loadPage(new SeriesPage(controller.getSeriesPageController(), (Serie)media));
    }

    public void showMovieActionListener(Media media) {
        controller.getSceneBuilder().loadPage(new MoviePage(controller.getMoviePageController(), (Movie)media));
    }
}
