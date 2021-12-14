package Model;

import java.util.ArrayList;

/**
 * Dette er den klasse der samler de andre. Det er en singelton,
 * da der ikke skal kunne oprettes flere instanser af i streaming tjenesten.
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
     * Streaming tjenesten har tre lister:
     * en list med film,
     * en med serier
     * et array med profiler (da man højst må oprette fire profiler.
     */
    private StreamingService() {
        this.movies = new ArrayList<>();
        this.series = new ArrayList<>();
        this.profiles = new Profile[4];
    }

    public static StreamingService getInstance() {
        return streamingService;
    }

    /**
     * Klassen retunere arrray'et af profiler
     * @return arrray'et af profiler
     */
    public Profile[] getProfiles() {
        return profiles;
    }

    /**
     * Klassen retunere antallet af bruger
     * @return antallet af bruger
     */
    public int getCurrentLength() {
        return currentLength;
    }

    /**
     * Liste der indeholder alle film og serier for hver genre
     * @param genre - En af genrene
     * @return liste af alle mediaerne for hver genre
     */
    public ArrayList<Media> allGenreSearch(String genre) {
        ArrayList<Media> mediaReturn = new ArrayList<Media>();
        mediaReturn.addAll(genreSearch(genre, movies));
        mediaReturn.addAll(genreSearch(genre, series));
        return mediaReturn;
    }

    /**
     * Liste der indeholder alle film for hver af genrene
     * @param genre - En af genrene
     * @return liste af alle film for hver genre
     */
    public ArrayList<Media> movieGenreSearch(String genre) {
        return genreSearch(genre, movies);
    }

    /**
     * Liste der indeholder alle serier for hver af genrene
     * @param genre - En af genrene
     * @return liste af alle serier for hver genre
     */
    public ArrayList<Media> seriesGenreSearch(String genre) {
        return genreSearch(genre, series);
    }

    /**
     * Liste der indeholder alle film og serier's navne
     * @param genre - En af genrene
     * @return liste af alle mediaernes navne
     */
    public ArrayList<Media> allNameSearch(String genre) {
        ArrayList<Media> mediaReturn = nameSearch(genre, movies);
        mediaReturn.addAll(nameSearch(genre, series));
        return mediaReturn;
    }

    /**
     * Konstruktøren retunere listen med genrene
     * @param genre - En af genrene
     * @param media - listen af medierne
     * @return listen med genrene
     */
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

    /**
     * tjekker om søgningen indeholder navnet
     * @param name - bruger indput
     * @param media - liste af film og serier
     * @return resultaterne i navnet
     */
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

    /**
     * Konstruktøren retunere posteren til filmens titel
     * @param picture - henter billederne
     * @return posteren til filmens titel
     */
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

    /**
     * Tilføjer profil til prifil liste, hvis der ikke er mere end 4 profiler
     * @param profile - listen af profiler
     */
    public void addProfile(Profile profile) {
        if (currentLength < 5) {
            profiles[currentLength] = profile;
            currentLength++;
            // System.out.println("profile added");
        }
    }

    /**
     * Konstruktøren tilføjer en film til film listen
     * @param movie - ny film
     */
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    /**
     * Konstruktøren tilføjer en serie til serie listen
     * @param serie - ny serie
     */
    public void addSerie(Serie serie) {
        series.add(serie);
    }

    /**
     * Konstruktøren retunere en liste af genre
     * @return listen af genre
     */
    public String[] getGenreList() {
        return genreList;
    }

    /**
     * Lader en vælge bruger nummeret fra array'et
     * @param currentProfileNumber nummeret for en brugerne i listen
     */
    public void setCurrentProfileNumber(int currentProfileNumber) {
        this.currentProfileNumber = currentProfileNumber;
    }

    /**
     * Konstruktøren retunere hvilken bruger der bruges nu
     * @return den valgte bruger
     */
    public Profile getCurrentProfile() {
        return profiles[currentProfileNumber];
    }

    // listAllMovies() er en klasse, vi brugte i starten af projektet til at teste
    /* public void listAllMovies() {
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
    }*/

    // listAllSeries() er en klasse, vi brugte i starten af projektet til at teste
    /* public void listAllSeries() {
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
    } */

    /**
     * Konstruktøren retunere en liste med film
     * @return liste med film
     */
    public ArrayList<Media> getMovies() {
        return movies;
    }

    /**
     * Konstruktøren retunere en liste med serier
     * @return liste med serier
     */
    public ArrayList<Media> getSeries() { return series; }
}
