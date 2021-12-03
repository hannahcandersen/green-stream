import Model.Reader;
import Model.StreamingService;

import javax.swing.*;

import View.SearchPage;
import View.LoginPage;

import Controller.SceneBuilder;

public class Main {
    public static void main(String[] args) {
        StreamingService streamingService = StreamingService.getInstance();
        Reader reader = new Reader(streamingService);

        //streamingService.listAllSeries();

        JFrame frame = new JFrame();
        SceneBuilder sceneBuilder = new SceneBuilder(frame);

        // test
        SearchPage searchPage = new SearchPage(streamingService.getMovies());
        sceneBuilder.loadPage(searchPage);

        //LoginPage loginPage = new LoginPage();
        //sceneBuilder.loadPage(loginPage);

    }
}
