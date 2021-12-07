package Controller;

import Model.Profile;
import View.AddProfilePage;
import View.LoginPage;

/**
 * AddProfilePage's controller der indeholder sidens actionListeners
 */
public class AddProfilePageController {
    
    // Controlleren der har adgang til alle de andre view's controllers
    private Controller controller;

    /**
     * Instantiere controlleren
     * @param controller - controlleren der har adgang til alle de andre view's controllers
     */
    public AddProfilePageController(Controller controller) {
        this.controller = controller;
    }

    // ActionListener som tilføjer en ny profil til listen af profiler og skifter side til loginsiden
    public void addProfileActionListener(Profile profile) {
        // tilføjer profilen til listen af profiler
        controller.getStreamingService().addProfile(profile);
        // Skifter side til loginsiden
        controller.getSceneBuilder().loadPage(new LoginPage(controller.getLoginPageController(), controller.getStreamingService().getProfiles(), controller.getStreamingService().getCurrentLength()));
    }

    // ActionListener som går tilbage til loginsiden uden at tilføje en bruger
    public void goBackActionListener() {
        controller.getSceneBuilder().loadPage(new LoginPage(controller.getLoginPageController(), controller.getStreamingService().getProfiles(), controller.getStreamingService().getCurrentLength()));
    }
    
    // ActionListener der ændre træets farve
    public void chooseColorActionListener(int color, String username) {
        controller.getSceneBuilder().loadPage(new AddProfilePage(color, username, this));
    }
}
