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

    public Profile(String name, String picture){
        this.name = name;
        this.myList = new ArrayList<>();
        this.picture = picture;
    }

    public void setName(String newName){
        this.name = newName;
    }
    public void setPicture(String newPicture){
         this.picture = newPicture;
    }
    public String getName(){
        return name;
    }
    public String getPicture(){
        return picture;
    }

    public void addToMyList(Media media) {
        myList.add(media);
    }

    public ArrayList<Media> getMyList() {
        return myList;
    }

}
