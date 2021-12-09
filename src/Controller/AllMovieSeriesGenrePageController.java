package Controller;

import Model.Media;
import Model.Movie;
import Model.Serie;
import View.AllMovieSeriesGenrePage;
import View.MoviePage;
import View.SeriesPage;

import java.util.ArrayList;

public class AllMovieSeriesGenrePageController {

    private AllMovieSeriesGenrePage allMovieSeriesGenrePage;
    private Controller controller;

    public AllMovieSeriesGenrePageController(Controller controller) {
        this.controller = controller;
    }

    public void showSerieActionListener(Media media) {
        controller.getSceneBuilder().loadPage(new SeriesPage(controller.getSeriesPageController(), (Serie)media));
    }

    public void showMovieActionListener(Media media) {
        controller.getSceneBuilder().loadPage(new MoviePage(controller.getMoviePageController(), (Movie)media));
    }

    public void showGenreOfMoviesActionListener(String genre){
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), genre, controller.getStreamingService().movieGenreSearch(genre), "Film", controller.getAllMovieSeriesGenrePageController()));
    }

    public void showGenreOfSeriesActionListener(String genre){
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), genre, controller.getStreamingService().seriesGenreSearch(genre), "Serier", controller.getAllMovieSeriesGenrePageController()));
    }
    public void genreActionListener(String genre) {
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), genre, controller.getStreamingService().allGenreSearch(genre), genre, controller.getAllMovieSeriesGenrePageController()));
    }
    public void showMoviesOfGenreActionListener(String genre){
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), genre, controller.getStreamingService().movieGenreSearch(genre), genre, controller.getAllMovieSeriesGenrePageController()));
    }
    public void showSeriesOfGenreActionListener(String genre){
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), genre, controller.getStreamingService().seriesGenreSearch(genre), genre, controller.getAllMovieSeriesGenrePageController()));
    }
}
