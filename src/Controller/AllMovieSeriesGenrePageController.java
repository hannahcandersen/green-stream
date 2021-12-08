package Controller;

import View.AllMovieSeriesGenrePage;

public class AllMovieSeriesGenrePageController {

    private AllMovieSeriesGenrePage allMovieSeriesGenrePage;
    private Controller controller;

    public AllMovieSeriesGenrePageController(Controller controller) {
        this.controller = controller;
        //allMovieSeriesGenrePage = new AllMovieSeriesGenrePage();
    }

    public AllMovieSeriesGenrePage getAllMovieSeriesGenrePage() {
        return allMovieSeriesGenrePage;
    }
}
