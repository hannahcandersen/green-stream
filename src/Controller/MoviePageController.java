package Controller;

import Model.Profile;
import View.MainPage;
import View.MoviePage;
import Model.*;

public class MoviePageController {

    private Controller controller;

    public MoviePageController(Controller controller) {
        this.controller = controller;
    }

    public Profile getCurrentProfile() {
        return controller.getStreamingService().getCurrentProfile();
    }

    public void addToMyListActionListerner(Movie movie) {
        System.out.println("add");
        controller.getStreamingService().getCurrentProfile().addToMyList(movie);
        controller.getSceneBuilder().loadPage(new MoviePage(this, movie));
    }

    public void removeFromMyListActionListener(Movie movie) {
        controller.getStreamingService().getCurrentProfile().removeFromMyList(movie);
        controller.getSceneBuilder().loadPage(new MoviePage(this, movie));
    }

    public void goBackActionListener() {
        controller.getSceneBuilder().loadPage(new MainPage());
    }
}
