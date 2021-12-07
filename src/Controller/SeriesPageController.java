package Controller;

import Model.Movie;
import Model.Profile;
import Model.Serie;
import View.MoviePage;
import View.SeriesPage;

public class SeriesPageController {

    private Controller controller;
    private SeriesPage seriesPage;

    public SeriesPageController(Controller controller) {
        this.controller = controller;
    }

    public Profile getCurrentProfile() {
        return controller.getStreamingService().getCurrentProfile();
    }

    public void addToMyListActionListerner(Serie serie) {
        controller.getStreamingService().getCurrentProfile().addToMyList(serie);
        controller.getSceneBuilder().loadPage(new SeriesPage(this, serie));
    }

    public void removeFromMyListActionListener(Serie serie) {
        controller.getStreamingService().getCurrentProfile().removeFromMyList(serie);
        controller.getSceneBuilder().loadPage(new SeriesPage(this, serie));
    }

}
