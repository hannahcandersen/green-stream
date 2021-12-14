package Model;

/**
 * Denne klasse er en subklasse af Media.
 * Film klassen kan ikke noget der adskiller sig fra medie klassen.
 */
public class Movie extends Media {
    /**
     * Paramerende for filmene
     * @param name - Mediets navn
     * @param year - Mediets udgiveklses år
     * @param genre - Mediets genre
     * @param rating - Hvad IMDb har rated mediet som
     * @param picture - Mediets poster
     */
    public Movie(String name, String year, String[] genre, double rating, String picture) {
        super(name, year, genre, rating, picture);
    }
}
