package Controller;

import View.MoviePage;

public class MoviePageController {

    private Controller controller;
    private MoviePage moviePage;

    public MoviePageController(Controller controller) {
        this.controller = controller;
        this.moviePage = new MoviePage();
    }

    public MoviePage getMoviePage() {
        return moviePage;
    }
}
