package Model;

import java.util.ArrayList;

/**
 * Man kan tilføje nye profiler. Hver profil har sit eget navn og et billede.
 * Min Liste, er også forskellig for hver bruger.
 */
public class Profile {
    private String name;
    private ArrayList<Media> myList;
    private String picture;

    /**
     * Brugerens data
     * @param name det valgte navn
     * @param picture det valgte profilbillede
     */
    public Profile(String name, String picture){
        this.name = name;
        this.myList = new ArrayList<>();
        this.picture = picture;
    }

    /**
     * Brugerens vælger sit profilbillede
     * @param newPicture vælger et profilbillede
     */
    public void setPicture(String newPicture){
         this.picture = newPicture;
    }

    /**
     * Konstruktøren retunere brugerens navn
     * @return brugerens navn
     */
    public String getName(){
        return name;
    }

    /**
     * Konstruktøren retunere brugerens profilbillede
     * @return brugerens profilbillede
     */
    public String getPicture(){
        return picture;
    }

    /**
     * Konstruktøren retunere min liste med dens indhold også det nye medie
     * @return min liste med dens indhold også det nye medie
     */
    public void addToMyList(Media media) {
        myList.add(media);
    }

    /**
     * Konstruktøren retunere min liste med dens indhold, men uden det fjernede medie
     * @return min liste med dens indhold, men uden det fjernede medie
     */
    public void removeFromMyList(Media media) {
        myList.remove(media);
    }

    /**
     * Konstruktøren retunere giver brugeren min liste
     * @return giver brugeren min liste
     */
    public ArrayList<Media> getMyList() {
        return myList;
    }
}
