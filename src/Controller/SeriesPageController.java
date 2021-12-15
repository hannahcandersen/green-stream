package Controller;

import Model.Profile;
import Model.Serie;
import View.ExceptionView;
import View.MainPage;
import View.SeriesPage;

/**
 * Klassen der har metoderne der bliver brugt i SeriePage's actionListeners
 */
public class SeriesPageController {

    private Controller controller;

    /**
     * Konstruktør for SeriesPageController der instantiere controller
     * @param controller - Hoved Controlleren
     */
    public SeriesPageController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Metoden der finder den nuværende profil der er i brug
     * @return - den nuværende profil der er i brug af typen Profile
     */
    public Profile getCurrentProfile() {
        return controller.getStreamingService().getCurrentProfile();
    }

    /**
     * Metoden der tilføjer en serie til MyList og ændre indholdet på siden SeriesPage
     * så man nu i stedet kan fjerne fra sin liste
     * @param serie - Den serie der skal tilføjes til myList
     */
    public void addToMyListActionListerner(Serie serie) {
        controller.getStreamingService().getCurrentProfile().addToMyList(serie);
        controller.getSceneBuilder().loadPage(new SeriesPage(this, serie));
    }

    /**
     * Metoden der fjerner en serie fra MyList og ændre indholdet på siden SeriesPage
     * så man nu i stedet kan tilføje til sin liste
     * @param serie - Den serie der skal tilføjes til myList
     */
    public void removeFromMyListActionListener(Serie serie) {
        controller.getStreamingService().getCurrentProfile().removeFromMyList(serie);
        controller.getSceneBuilder().loadPage(new SeriesPage(this, serie));
    }

    /**
     * Metoden der får siden til at gå tilbage til MainPage
     */
    public void goBackActionListener() {
        controller.getSceneBuilder().loadPage(new MainPage(controller.getMainPageController()));
    }

    /**
     * Metoden der "afspiller" mediet, men som i virkeligheden viset et ExceptionView med
     * indholdet "Virker ikke, gå til Netflix i stedet for"
     */
    public void playActionListener() {
        new ExceptionView("Virker ikke, gå til Netflix i stedet for");
    }
}
