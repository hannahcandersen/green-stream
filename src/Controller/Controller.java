package Controller;

import Model.*;
import View.*;

import javax.swing.*;

public class Controller {

    // Der hvor vi gemmer alle film, serier og profiler
    private StreamingService streamingService;

    // Får alle film og serier fra txt filerne til Arraylisterne i streamingservice
    private Reader reader;

    // ALle controllers
    private SceneBuilder sceneBuilder;
    private LoginPageController loginPageController;
    private AddProfilePageController addProfilePageController;
    private MenubarController menubarController;
    private MainPageController mainPageController;
    private SearchPageController searchPageController;
    private MyListPageController myListPageController;
    private SeriesPageController seriesPageController;
    private MoviePageController moviePageController;
    private AllMovieSeriesGenrePageController allMovieSeriesGenrePageController;

    // Den første side der skal vises når programmet starter
    private LoginPage loginPage;

    public Controller() {

        streamingService = StreamingService.getInstance();

        reader = new Reader(streamingService);
        boolean succesfulReading = reader.fillCollectionsSuccesFull();

        // Den eneste frame vi bruger
        JFrame theOnlyFrame = new JFrame();

        // Scenebuilder får denne frame
        sceneBuilder = new SceneBuilder(theOnlyFrame);

        // Alle controllers bliver instantieret
        loginPageController = new LoginPageController(this);
        addProfilePageController = new AddProfilePageController(this);
        menubarController = new MenubarController(this);
        mainPageController = new MainPageController(this);
        searchPageController = new SearchPageController(this);
        myListPageController = new MyListPageController(this);
        seriesPageController = new SeriesPageController(this);
        moviePageController = new MoviePageController(this);
        allMovieSeriesGenrePageController = new AllMovieSeriesGenrePageController(this);

        if (succesfulReading) {
            // Instantierer Loginpage siden den er den første side der skal vises
            loginPage = new LoginPage(loginPageController, streamingService.getProfiles(), streamingService.getCurrentLength());

            // Giver Scenebuilder Loginsiden så den kan komme på vores Frame of blive vist
            sceneBuilder.loadPage(loginPage);
        }


    }

    // Laver menubaren
    public void makeMenuBar() {
        sceneBuilder.makeMenuBar(menubarController.getMenubar().makeMenu());
    }


    // Getter metoder for alle felterne
    public LoginPage getLoginPage() {
        return loginPage;
    }

    public StreamingService getStreamingService() {
        return streamingService;
    }

    public SceneBuilder getSceneBuilder() {
        return sceneBuilder;
    }

    public MenubarController getMenubarController() {
        return menubarController;
    }

    public LoginPageController getLoginPageController() {
        return loginPageController;
    }

    public AddProfilePageController getAddProfilePageController() {
        return addProfilePageController;
    }

    public MainPageController getMainPageController() {
        return mainPageController;
    }

    public SearchPageController getSearchPageController() {
        return searchPageController;
    }

    public MyListPageController getMyListPageController() {
        return myListPageController;
    }

    public SeriesPageController getSeriesPageController() {
        return seriesPageController;
    }

    public MoviePageController getMoviePageController() {
        return moviePageController;
    }

    public AllMovieSeriesGenrePageController getAllMovieSeriesGenrePageController() {
        return allMovieSeriesGenrePageController;
    }


}
