package Model;

import java.util.ArrayList;

public class StreamingService {

    // singleton
    private static final StreamingService streamingService = new StreamingService();

    private ArrayList<Movie> movies;
    private ArrayList<Serie> series;
    private Profile[] profiles;
    private int currentProfileNumber;

    /**
     *
     */
    private StreamingService() {
        this.movies = new ArrayList<>();
        this.series = new ArrayList<>();
        this.profiles = new Profile[4];

    }

    public static StreamingService getInstance() {
        return streamingService;
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

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addSerie(Serie serie) {
        series.add(serie);
    }

    // til test
    public void listAllMovies() {
        System.out.println("Listing all movies");
        for (Movie m: movies) {
            System.out.println(m.name);
        }
    }

    // til test
    public void listAllSeries() {
        System.out.println("Listing all series");
        for (Serie m: series) {
            System.out.println(m.name);
        }
    }

}
