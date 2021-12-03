package Controller;

import Model.Movie;
import Model.Reader;
import Model.StreamingService;
import View.*;

import javax.swing.*;

public class Controller {

    private StreamingService streamingService;
    private Reader reader;
    private SceneBuilder sceneBuilder;
    private MenubarController menubarController;


    private SearchPage searchPage = new SearchPage(null);
    private LoginPage loginPage = new LoginPage();
    private MoviePage moviePage = new MoviePage();
    private SeriesPage seriesPage = new SeriesPage();
    private MyListPage myListPage = new MyListPage();

    public Controller() {

        JFrame frame = new JFrame();

        streamingService = StreamingService.getInstance();
        reader = new Reader(streamingService);

        sceneBuilder = new SceneBuilder(frame);

        menubarController = new MenubarController(sceneBuilder, searchPage, loginPage, moviePage,
                seriesPage, myListPage, streamingService);

        sceneBuilder.makeMenuBar(menubarController.getMenubar().makeMenu());

        SearchPage searchPage = new SearchPage(streamingService.getMovies());
        sceneBuilder.loadPage(searchPage);

        //LoginPage loginPage = new LoginPage();
        //sceneBuilder.loadPage(loginPage);
    }



}
