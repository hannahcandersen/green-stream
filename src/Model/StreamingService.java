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
    private final String[] genreList = {"Crime", "Drama", "Biography", "History", "Sport", "Romance", "War",
            "Mystery", "Adventure", "Family", "Fantasy", "Thriller", "Horror", "Film-Noir", "Musical", "Action",
            "Sci-fi", "Comedy", "Western", "Music", "Animation", "Documentary", "Talk-show"};

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
        ArrayList<Media> mediaReturn = nameSearch(genre, movies);
        mediaReturn.addAll(nameSearch(genre, series));
        return mediaReturn;
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

    public Media findMediaFromPicture(String picture) {
        for (Media m: movies) {
            if (picture.equals(m.getPicture())) {
                return m;
            }
        }
        for (Media m: series) {
            if (picture.equals(m.getPicture())) {
                return m;
            }
        }
        return null;
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

    public void setCurrentProfileNumber(int currentProfileNumber) {
        this.currentProfileNumber = currentProfileNumber;
    }

    public Profile getCurrentProfile() {
        return profiles[currentProfileNumber];
    }

    // til test
    public void listAllMovies() {
        System.out.println("Listing all movies");
        for (Media m: movies) {
            System.out.println("name: " + m.getName());
            System.out.println("picture: " + m.getPicture());
            System.out.print("genre: ");
            for (String s: m.getGenre()) {
                System.out.print(s + ", ");
            }
            System.out.println();
            System.out.println("year: " + m.getYear());
            System.out.println("rating: " + m.getRating());
        }
    }

    // til test
    public void listAllSeries() {
        System.out.println("\nListing all series");
        for (Media m: series) {
            System.out.println("name: " + m.getName());
            System.out.println("picture: " + m.getPicture());
            System.out.print("genre: ");
            for (String s: m.getGenre()) {
                System.out.print(s + ", ");
            }
            System.out.println();
            System.out.println("year: " + m.getYear());
            System.out.println("rating: " + m.getRating());
            System.out.println("seasons: " + ((Serie) m).getSeasons());
            System.out.print("episodes: ");
            for (Integer s: ((Serie) m).getEpisodes()) {
                System.out.print(s + ", ");
            }
        }
    }

    public ArrayList<Media> getMovies() {
        return movies;
    }

    public ArrayList<Media> getSeries() { return series; }

}
