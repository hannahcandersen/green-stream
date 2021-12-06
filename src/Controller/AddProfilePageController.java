package Controller;

import Model.Profile;
import Model.StreamingService;
import View.AddProfilePage;
import View.LoginPage;

public class AddProfilePageController {

    private AddProfilePage addProfilePage;
    private Controller controller;

    public AddProfilePageController(Controller controller) {
        this.controller = controller;
        addProfilePage = new AddProfilePage(0, "Brugernavn", this);
    }

    public AddProfilePage getAddProfilePage() {
        return addProfilePage;
    }

    public void addProfileActionListener(Profile profile) {
        //if (!profile.getName().equals(""))
        controller.getStreamingService().addProfile(profile);
        controller.getSceneBuilder().loadPage(new LoginPage(controller.getLoginPageController(), controller.getStreamingService().getProfiles(), controller.getStreamingService().getCurrentLength()));
    }

    public void goBack() {
        controller.getSceneBuilder().loadPage(new LoginPage(controller.getLoginPageController(), controller.getStreamingService().getProfiles(), controller.getStreamingService().getCurrentLength()));
    }

    public void chooseColor(int color, String username) {
        controller.getSceneBuilder().loadPage(new AddProfilePage(color, username, this));
    }
}
