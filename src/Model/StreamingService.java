package Model;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Dette er den klasse der samler de andre. Det er en singelton da der ikke skal kunne oprettes flere instanser af
 * streaming tjenesten.
 */
public class StreamingService {

    // singleton
    private static final StreamingService streamingService = new StreamingService();

    private ArrayList<Media> movies;
    private ArrayList<Media> series;
    private Profile[] profiles;
    private int currentProfileNumber;
    private int currentLength = 0;
    private final String[] genreList = {"Crime", "Drama", "Biography", "History", "Sport", "Romance", "War", "Mystery", "Adventure", "Family", "Fantasy", "Thriller", "Horror", "Film-Noir", "Musical", "Action", "Sci-fi", "Comedy", "Western", "Music", "Animation", "Documentary", "Talk-show"};

    /**
     * Streaming tjenesten har en list med film, en med serier og så en array med profiler, da man højst må
     * oprette fire profiler.
     */

    private StreamingService() {
        this.movies = new ArrayList<>();
        this.series = new ArrayList<>();
        this.profiles = new Profile[4];
    }

    public static StreamingService getInstance() {
        return streamingService;
    }

    public Profile[] getProfiles() {
        return profiles;
    }

    public int getCurrentLength() {
        return currentLength;
    }

    public ArrayList<Media> allGenreSearch(String genre) {
        ArrayList<Media> mediaReturn = new ArrayList<Media>();
        mediaReturn.addAll(genreSearch(genre, movies));
        mediaReturn.addAll(genreSearch(genre, series));
        return mediaReturn;
    }

    public ArrayList<Media> movieGenreSearch(String genre) {
        return genreSearch(genre, movies);
    }

    public ArrayList<Media> seriesGenreSearch(String genre) {
        return genreSearch(genre, series);
    }

    public ArrayList<Media> allNameSearch(String genre) {
        ArrayList<Media> mediaReturn = new ArrayList<Media>();
        mediaReturn.addAll(nameSearch(genre, movies));
        mediaReturn.addAll(nameSearch(genre, series));
        return mediaReturn;
    }

    public ArrayList<Media> movieNameSearch(String genre) {
        return nameSearch(genre, movies);
    }

    public ArrayList<Media> seriesNameSearch(String genre) {
        return nameSearch(genre, series);
    }

    private ArrayList<Media> genreSearch(String genre, ArrayList<Media> media) {
        ArrayList<Media> mediaReturn = new ArrayList<>();
        for (Media m: media) {
            for (String g : m.getGenre()) {

                if (g.equals(genre)) {
                    mediaReturn.add(m);
                    //System.out.println(g);
                }
            }
        }

        return mediaReturn;
    }

    private ArrayList<Media> nameSearch(String name, ArrayList<Media> media) {
        ArrayList<Media> mediaReturn = new ArrayList<>();
        for (Media m: media) {

            if (m.getName().toLowerCase().contains(name.toLowerCase())) {
                //System.out.println(m.getName());
                mediaReturn.add(m);
            }
        }
        return mediaReturn;
    }

    // tilføjer en profil til arrayet af profiler hvis der er plads
    public void addProfile(Profile profile) {
        if (currentLength < 5) {
            profiles[currentLength] = profile;
            currentLength++;
            System.out.println("profile added");
        }
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

    public String[] getGenreList() {
        return genreList;
    }


    public Profile getCurrentProfile() {
        return profiles[currentProfileNumber];
    }

    // til test
    public void listAllMovies() {
        System.out.println("Listing all movies");
        for (Media m: movies) {
            System.out.println(m.name);
        }
    }

    // til test
    public void listAllSeries() {
        System.out.println("Listing all series");
        for (Media m: series) {
            System.out.println(m.name);
        }
    }

    public ArrayList<Media> getMovies() {
        return movies;
    }

}
