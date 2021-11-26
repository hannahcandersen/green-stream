package Model;

import java.util.ArrayList;

public class StreamingService {
    private ArrayList<Movie> movies;
    private ArrayList<Serie> series;
    private Profile[] profiles;
    private int currentProfileNumber;

    /**
     *
     * @param movies
     * @param series
     */
    public StreamingService(ArrayList<Movie> movies, ArrayList<Serie> series) {
        this.movies = movies;
        this.series = series;
        this.profiles = new Profile[4];

    }

    public Media Seach() {

        // indtil vi har lavet en søge funktion
        return null;
    }

    // tilføjer en profil til arrayet af profiler hvis der er plads
    public void addProfile() {

    }

    // fjerner en profil fra arrayet af profiler
    public void removeProfile() {

    }
}
