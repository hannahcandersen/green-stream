package Controller;

import Model.Media;
import Model.Movie;
import Model.Serie;
import View.AllMovieSeriesGenrePage;
import View.MoviePage;
import View.SeriesPage;

import java.util.ArrayList;

/**
 * Klassen der har metoderne der bliver brugt i AllMovieSeriesGenrePage's actionListeners
 */
public class AllMovieSeriesGenrePageController {

    private Controller controller;

    /**
     * Konstruktør for AllMovieSeriesGenrePageController der instantiere controller
     * @param controller - Hoved Controlleren
     */
    public AllMovieSeriesGenrePageController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Metoden der går får siden til at gå til SeriesPage
     * @param media - den Serie man gerne vil ind på
     */
    public void showSerieActionListener(Media media) {
        controller.getSceneBuilder().loadPage(new SeriesPage(controller.getSeriesPageController(), (Serie)media));
    }

    /**
     * Metoden der går får siden til at gå til MoviePage
     * @param media - den film man gerne vil ind på
     */
    public void showMovieActionListener(Media media) {
        controller.getSceneBuilder().loadPage(new MoviePage(controller.getMoviePageController(), (Movie)media));
    }

    /**
     * Metoden der får siden til at gå til AllMovieSeriesGenrePage med film og kun viser en bestemt genre
     * @param genre - den genre der er valgt i comboboksen
     */
    public void showGenreOfMoviesActionListener(String genre){
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), genre, "Film", controller.getStreamingService().movieGenreSearch(genre), "Film", controller.getAllMovieSeriesGenrePageController()));
    }

    /**
     * Metoden der får siden til at gå til AllMovieSeriesGenrePage med serier og kun viser en bestemt genre
     * @param genre - den genre der er valgt
     */
    public void showGenreOfSeriesActionListener(String genre){
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), genre, "Serier", controller.getStreamingService().seriesGenreSearch(genre), "Serier", controller.getAllMovieSeriesGenrePageController()));
    }

    /**
     * Metoden der får siden til at gå til AllMovieSeriesGenrePage med genre den valgte kategori
     * @param genre - den genre der er valgt
     * @param category - den kategori der er valgt.
     */
    public void genreActionListener(String genre, String category) {
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), genre, "Film og serier", controller.getStreamingService().allGenreSearch(genre), genre, controller.getAllMovieSeriesGenrePageController()));
    }

    /**
     * Metoden der får siden til at gå til AllMovieSeriesGenrePage med film og den valgte kategori
     * @param genre - den genre der er valgt
     * @param category - den kategori der er valgt.
     */
    public void showMoviesOfGenreActionListener(String genre, String category){
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), genre, category, controller.getStreamingService().movieGenreSearch(genre), genre, controller.getAllMovieSeriesGenrePageController()));
    }

    /**
     * Metoden der får siden til at gå til AllMovieSeriesGenrePage med serier og den valgte kategori
     * @param genre - den genre der er valgt
     * @param category - den kategori der er valgt.
     */
    public void showSeriesOfGenreActionListener(String genre, String category){
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), genre, category, controller.getStreamingService().seriesGenreSearch(genre), genre, controller.getAllMovieSeriesGenrePageController()));
    }
}
