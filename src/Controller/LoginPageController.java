package Controller;

import View.AddProfilePage;
import View.LoginPage;
import View.MainPage;

public class LoginPageController {

    private Controller controller;

    public LoginPageController(Controller controller) {

        this.controller = controller;
    }

    public void addProfileActionListener() {
        controller.getSceneBuilder().loadPage(new AddProfilePage(0, "Brugernavn", controller.getAddProfilePageController()));
    }

    public void goToMainPageActionListener(int profileNumber) {
        controller.getStreamingService().setCurrentProfileNumber(profileNumber);
        controller.makeMenuBar();
        controller.getSceneBuilder().loadPage(new MainPage(controller.getMainPageController()));
    }

}
