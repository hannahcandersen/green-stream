package Model;

import java.util.ArrayList;
/**
 * Film klassen kan ikke noget der adskiller sig fra medie klassen, den har bare en overridet play metode.
 */

public class Movie extends Media {
    public Movie(String name, String year, String[] genre, double rating, String picture) {
        super(name, year, genre[genre.length], rating, picture);
    }

    @Override
    public void play() {
        // lav afspille metode
    }
}
