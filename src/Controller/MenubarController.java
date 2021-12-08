package Controller;
import View.*;

/**
 * MenuBar's controller der indeholder menubarens actionListeners
 */
public class MenubarController {

    // Controlleren der har adgang til alle de andre view's controllers
    private Controller controller;

    /**
     * Instantierer controlleren
     * @param controller - controlleren der har adgang til alle de andre view's controllers
     */
    public MenubarController(Controller controller) {
        this.controller = controller;
    }

    // Instantierer menubaren når den skal bruges
    public Menubar getMenubar() {
        return new Menubar(controller.getStreamingService().getGenreList(), controller.getStreamingService().getCurrentProfile().getPicture(), this);
    }

    // Alle menubarens actionListeners

    public void myListActionListener() {
        // gå til mylist
        controller.getSceneBuilder().loadPage(new MyListPage(controller.getStreamingService().getCurrentProfile().getMyList(), controller.getMyListPageController()));
    }

    public void movieActionListener() {
        // gå til film siden
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), controller.getStreamingService().getMovies(), "Film", controller.getAllMovieSeriesGenrePageController()));
    }

    public void serieActionListener() {
        // gå til serie siden
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), controller.getStreamingService().getSeries(), "Serier", controller.getAllMovieSeriesGenrePageController()));

    }

    public void genreActionListener(String genre) {
        // gå til genre siden
    }

    public void searchActionListener(){
        // gå til search siden
        controller.getSceneBuilder().loadPage(new SearchPage(null, controller.getSearchPageController()));
    }

    public void profileActionListener() {
        // gå til LoginPage
        controller.getSceneBuilder().loadPage(new LoginPage(controller.getLoginPageController(), controller.getStreamingService().getProfiles(), controller.getStreamingService().getCurrentLength()));
    }
}
