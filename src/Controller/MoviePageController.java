package Controller;

import Model.Profile;
import View.ExceptionView;
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
        controller.getStreamingService().getCurrentProfile().addToMyList(movie);
        controller.getSceneBuilder().loadPage(new MoviePage(this, movie));
    }

    public void removeFromMyListActionListener(Movie movie) {
        controller.getStreamingService().getCurrentProfile().removeFromMyList(movie);
        controller.getSceneBuilder().loadPage(new MoviePage(this, movie));
    }

    public void goBackActionListener() {
        controller.getSceneBuilder().loadPage(new MainPage(controller.getMainPageController()));
    }

    public void playActionListener() {
        new ExceptionView("Virker ikke, gå til Netflix i stedet for");
    }
}
