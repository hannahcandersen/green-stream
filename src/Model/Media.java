package Model;

import java.util.ArrayList;

/**
 * Denne er den abstrakte til film og serier. Feltet addedToMyList er et boolean felt der fortæller
 * om en film eller serie er blevet tilføjet til Min Liste.
 */
public abstract class Media {
    protected String name;
    protected String year;
    protected String[] genre;
    protected double rating;
    protected String picture;
    protected boolean addedToMyList;

    public Media(String name, String year, String genre, double rating, String picture) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.picture= picture;
        this.addedToMyList = false;
    }

    public void play() {

    }

    public String getNavn() {
        return name;
    }

    public String getStartAarstal() {
        return year;
    }

    public String[] getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public String getBillede() {
        return picture;
    }

    public boolean isAddedToMyList() {
        return addedToMyList;
    }

}


