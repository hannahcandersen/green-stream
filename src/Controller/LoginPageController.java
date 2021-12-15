package Controller;

import View.AddProfilePage;
import View.LoginPage;
import View.MainPage;

/**
 * Klassen der har metoderne der bliver brugt i LoginPage's actionListeners
 */
public class LoginPageController {

    private Controller controller;

    /**
     * Konstruktør for LoginPageController der instantiere controller
     * @param controller - Hoved Controlleren
     */
    public LoginPageController(Controller controller) {

        this.controller = controller;
    }

    /**
     * Metoden der får siden til at gå til AddProfilePage
     */
    public void addProfileActionListener() {
        controller.getSceneBuilder().loadPage(new AddProfilePage(0, "Brugernavn", controller.getAddProfilePageController()));
    }

    /**
     * Metoden der får siden til at gå til MainPage, sætter den nyværende profil
     * til profilen der er trykket på, og laver menubaren med denne brugers profil billede.
     * Metoden kan først bruges når der er oprettet en bruger.
     * @param profileNumber - profilens nummer, altså 0 for den første profil der bliver oprettet og
     * 3 for den sidste profil der bliver oprettet.
     */
    public void goToMainPageActionListener(int profileNumber) {
        controller.getStreamingService().setCurrentProfileNumber(profileNumber);
        controller.makeMenuBar();
        controller.getSceneBuilder().loadPage(new MainPage(controller.getMainPageController()));
    }

}
