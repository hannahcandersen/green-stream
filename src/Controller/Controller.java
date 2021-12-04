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
    private MenubarController menubarController;
    private LoginPageController loginPageController;

    // Views

    private SearchPage searchPage = new SearchPage(null);
    //private LoginPage loginPage = new LoginPage();
    private MoviePage moviePage = new MoviePage();
    private SeriesPage seriesPage = new SeriesPage();
    private MyListPage myListPage = new MyListPage();
    private AddProfilePage addProfilePage;

    public Controller() {

        JFrame frame = new JFrame();
        sceneBuilder = new SceneBuilder(frame);

        loginPageController = new LoginPageController(addProfilePage, sceneBuilder, streamingService);

        menubarController = new MenubarController(sceneBuilder, searchPage, loginPageController.getLoginPage(), moviePage,
                seriesPage, myListPage, streamingService);
        sceneBuilder.makeMenuBar(menubarController.getMenubar().makeMenu());

        // instantiere controllers

        // instantiere views


        //SearchPage searchPage = new SearchPage(streamingService.getMovies());
        //sceneBuilder.loadPage(searchPage);

        //test
        /*
        streamingService.addProfile(new Profile("Silke", "Pictures/Blue.png"));
        streamingService.addProfile(new Profile("Clara", "Pictures/Yellow.png"));
        streamingService.addProfile(new Profile("Hannah", "Pictures/Pink.png"));
        streamingService.addProfile(new Profile("Alexander", "Pictures/Green.png"));

        LoginPage loginPage = new LoginPage(loginPageController);
        sceneBuilder.loadPage(loginPage);
*/
        ArrayList<Media> media = streamingService.allNameSearch("cat");

    }



}
