package Model;

import java.util.ArrayList;

/**
 * Den abstrakte klasse til film og serier.
 */
public abstract class Media {
    protected String name;
    protected String year;
    protected String[] genre;
    protected double rating;
    protected String picture;
    protected boolean addedToMyList;

    /**
     *
     * @param name
     * @param year
     * @param genre
     * @param rating
     * @param picture
     */
    public Media(String name, String year, String[] genre, double rating, String picture) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
        this.picture = picture;
    }

    public void Play() {

    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String[] getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public String getPicture() {
        return picture;
    }

    public boolean addToMyList() {
        return addedToMyList;
    }

}


