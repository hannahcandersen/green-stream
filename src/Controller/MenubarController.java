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

    /**
     * Instantierer menubaren når den skal bruges
     * @return - en ny Menubar
     */
    public Menubar getMenubar() {
        return new Menubar(controller.getStreamingService().getGenreList(), controller.getStreamingService().getCurrentProfile().getPicture(), this);
    }

    /**
     * Metoden der får siden til at gå til MyListPage
     */
    public void myListActionListener() {
        // gå til mylist
        controller.getSceneBuilder().loadPage(new MyListPage(controller.getStreamingService().getCurrentProfile().getMyList(), controller.getMyListPageController()));
    }

    /**
     * Metoden der får siden til at gå til AllMovieSeriesGenrePage med film
     */
    public void movieActionListener() {
        // gå til film siden
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), "", "Film", controller.getStreamingService().getMovies(), "Film", controller.getAllMovieSeriesGenrePageController()));
    }

    /**
     * Metoden der får siden til at gå til AllMovieSeriesGenrePage med serier
     */
    public void serieActionListener() {
        // gå til serie siden
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), "",  "Serier", controller.getStreamingService().getSeries(), "Serier", controller.getAllMovieSeriesGenrePageController()));
    }

    /**
     * Metoden der får siden til at gå til AllMovieSeriesGenrePage med genre
     */
    public void genreActionListener(String genre) {
        // gå til genre siden
        controller.getSceneBuilder().loadPage(new AllMovieSeriesGenrePage(controller.getStreamingService().getGenreList(), genre, "Film og serier", controller.getStreamingService().allGenreSearch(genre), genre, controller.getAllMovieSeriesGenrePageController()));
    }

    /**
     * Metoden der får siden til at gå til SearchPage
     */
    public void searchActionListener(){
        // gå til search siden
        controller.getSceneBuilder().loadPage(new SearchPage(null, controller.getSearchPageController()));
    }

    /**
     * Metoden der får siden til at gå til LoginPage
     */
    public void profileActionListener() {
        // gå til LoginPage
        controller.getSceneBuilder().loadPage(new LoginPage(controller.getLoginPageController(), controller.getStreamingService().getProfiles(), controller.getStreamingService().getCurrentLength()));
    }

    /**
     * Metoden der får siden til at gå til MainPage
     */
    public void goToMainPageActionListener() {
        controller.getSceneBuilder().loadPage(new MainPage(controller.getMainPageController()));
    }
}
