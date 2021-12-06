package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {

    private StreamingService streamingService = StreamingService.getInstance();
    private Reader reader = new Reader(streamingService);

    // Controllers
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

    private LoginPage loginPage;
    public Controller() {

        JFrame frame = new JFrame();
        sceneBuilder = new SceneBuilder(frame);

        loginPageController = new LoginPageController(this);
        addProfilePageController = new AddProfilePageController(this);
        menubarController = new MenubarController(this);
        mainPageController = new MainPageController(this);
        searchPageController = new SearchPageController(this);
        myListPageController = new MyListPageController(this);
        seriesPageController = new SeriesPageController(this);
        moviePageController = new MoviePageController(this);
        allMovieSeriesGenrePageController = new AllMovieSeriesGenrePageController(this);

        loginPage = new LoginPage(loginPageController, streamingService.getProfiles(), streamingService.getCurrentLength());
        sceneBuilder.loadPage(loginPage);
        //ArrayList<Media> media = streamingService.allNameSearch("cat");

       //SeriesPage seriesPage = new SeriesPage();
       //sceneBuilder.loadPage(seriesPage);

    }

    public void makeMenuBar() {
        sceneBuilder.makeMenuBar(menubarController.getMenubar().makeMenu());
    }

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
