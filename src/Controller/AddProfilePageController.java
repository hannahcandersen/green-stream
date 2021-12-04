package Controller;

import Model.StreamingService;
import View.LoginPage;

public class AddProfilePageController {
    private SceneBuilder sceneBuilder;
    private LoginPage loginPage;
    private StreamingService streamingService;

    public AddProfilePageController(SceneBuilder sceneBuilder, LoginPage loginPage, StreamingService streamingService) {
        this.sceneBuilder = sceneBuilder;
        this.loginPage = loginPage;
        this.streamingService = streamingService;
    }

    public void addProfileActionListener() {
        
    }
}
