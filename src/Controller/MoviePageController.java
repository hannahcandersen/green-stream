package Controller;

import Model.Profile;
import View.ExceptionView;
import View.MainPage;
import View.MoviePage;
import Model.*;

/**
 * Klassen der har metoderne der bliver brugt i MoviePage's actionListeners
 */
public class MoviePageController {

    private Controller controller;

    /**
     * Konstruktør for MoviePageController der instantiere controller
     * @param controller - Hoved Controlleren
     */
    public MoviePageController(Controller controller) {
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
     * Metoden der tilføjer en film til MyList og ændre indholdet på siden MoviePage
     * så man nu i stedet kan fjerne fra sin liste
     * @param movie - Den film der skal tilføjes til myList
     */
    public void addToMyListActionListerner(Movie movie) {
        controller.getStreamingService().getCurrentProfile().addToMyList(movie);
        controller.getSceneBuilder().loadPage(new MoviePage(this, movie));
    }

    /**
     * Metoden der fjerner en film fra MyList og ændre indholdet på siden MoviePage
     * så man nu i stedet kan tilføje til sin liste
     * @param movie - Den film der skal tilføjes til myList
     */
    public void removeFromMyListActionListener(Movie movie) {
        controller.getStreamingService().getCurrentProfile().removeFromMyList(movie);
        controller.getSceneBuilder().loadPage(new MoviePage(this, movie));
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
