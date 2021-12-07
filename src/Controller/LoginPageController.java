package Controller;

import Model.Profile;
import Model.StreamingService;
import View.AddProfilePage;
import View.LoginPage;
import View.MainPage;

public class LoginPageController {

    private LoginPage loginPage;
    private Controller controller;

    public LoginPageController(Controller controller) {

        this.controller = controller;
        loginPage = controller.getLoginPage();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void addProfileActionListener() {
        controller.getSceneBuilder().loadPage(new AddProfilePage(0, "Brugernavn", controller.getAddProfilePageController()));
        System.out.println("add profile");
    }

    public void goToMainPageActionListener(int profileNumber) {
        controller.getStreamingService().setCurrentProfileNumber(profileNumber);
        controller.makeMenuBar();
        controller.getSceneBuilder().loadPage(new MainPage());
        System.out.println("gå til main page");
    }

}
