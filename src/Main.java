import Model.Reader;
import Model.StreamingService;

import javax.swing.*;
import javax.swing.text.View;
import View.SearchPage;

import Controller.SceneBuilder;
import Model.StreamingService;

public class Main {
    public static void main(String[] args) {
        StreamingService streamingService = StreamingService.getInstance();
        Reader reader = new Reader(streamingService);
        JFrame theOnlyFrame = new JFrame("GreenStream");
        SceneBuilder sceneBuilder = new SceneBuilder(theOnlyFrame);

        // test
        SearchPage searchPage = new SearchPage();
        sceneBuilder.loadPage(searchPage);
    }
}
