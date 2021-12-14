package Model;

/**
 * Den abstrakte klasse til film og serier.
 */
public abstract class Media {
    protected String name;
    protected String year;
    protected String[] genre;
    protected double rating;
    protected String picture;

    /**
     * Paramerende for medierne
     * @param name - Mediets navn
     * @param year - Mediets udgiveklses år
     * @param genre - Mediets genre
     * @param rating - Hvad IMDb har rated mediet som
     * @param picture - Mediets poster
     */
    public Media(String name, String year, String[] genre, double rating, String picture) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
        this.picture = picture;
    }

    /**
     * Klassen retunere mediets navn
     * @return mediets navn
     */
    public String getName() {
        return name;
    }

    /**
     * Klassen retunere mediets udgiveklses år
     * @return mediets udgiveklses år
     */
    public String getYear() {
        return year;
    }

    /***
     * Klassen retunere mediets genre
     * @return mediets genre
     */
    public String[] getGenre() {
        return genre;
    }

    /**
     * Klassen retunere mediets rating
     * @return mediets rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Klassen retunere mediets poster
     * @return mediets poster
     */
    public String getPicture() {
        return picture;
    }
}


