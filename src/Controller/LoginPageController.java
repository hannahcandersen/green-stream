package Controller;

import Model.StreamingService;
import View.AddProfilePage;
import View.LoginPage;

public class LoginPageController {

    private AddProfilePage addProfilePage;
    private SceneBuilder sceneBuilder;
    private StreamingService streamingService;

    private LoginPage loginPage;

    public LoginPageController(AddProfilePage addProfilePage, SceneBuilder sceneBuilder, StreamingService streamingService) {
        this.addProfilePage = addProfilePage;
        this.sceneBuilder = sceneBuilder;
        this.streamingService = streamingService;

        loginPage = new LoginPage(this);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public StreamingService getStreamingService() {
        return streamingService;
    }

    public void addProfile() {
        System.out.println("add profile");
    }

}
