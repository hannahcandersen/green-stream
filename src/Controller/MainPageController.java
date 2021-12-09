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
