package Model;

import View.ExceptionView;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Denne klasse læser informationerne om film og serier fra txt filerne film.txt og serier.txt
 */
public class Reader {
    StreamingService streamingService;

    /**
     * Kontruktør for Reader der instantiere streamingService
     * @param streamingService - klassen der holder på arraylisterne med film og serier.
     */
    public Reader(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    /**
     * En boolean metode tjekker om filerne er blevet indlæst uden fejl
     * @return - returnere true hvis filerne er indlæst uden exceptions
     */
    public boolean fillCollectionsSuccesFull() {
        boolean movies = fillMovies();
        boolean series = fillSeries();

        if (movies && series) {
            return  true;
        } else {
            return false;
        }
    }

    /**
     * Metoden der går igennem hele film.txt filen og isætter en Movie med disse
     * informationer i arraylisten i StreamingService
     * @return - returnere true hvis film.txt filen blev læst uden exceptions
     */
    public boolean fillMovies() {
        try {

            // opretter scanner med filens info
            Scanner scanner = new Scanner(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("film.txt")));


            while (scanner.hasNextLine()) {
                // linjen med filmen og alle filmens info på
                String line = scanner.nextLine();

                // arraylist med filmens info
                String[] arrayInfoMovie = line.split(";");

                // filmens info fra arraylisten med filmens info til variable med filmens info
                String movieName = arrayInfoMovie[0];
                String movieYear = arrayInfoMovie[1].substring(1);
                String movieGenreString = arrayInfoMovie[2].substring(1);
                movieGenreString = movieGenreString.replaceAll("\\s+","");
                String[] movieGenres = movieGenreString.split(",");
                double movieRating = Double.parseDouble(arrayInfoMovie[3].substring(1).replace(',','.'));
                String moviePicture = "/filmplakater/" + movieName + ".jpg";

                // indsætter filmen i streamingService
                Movie movie = new Movie(movieName, movieYear, movieGenres, movieRating, moviePicture);
                streamingService.addMovie(movie);

            }
            scanner.close();
            return true;
        // et generisk catch statement der fanger alle fejl og udskriver fejl i terminalen
        } catch (Exception e) {
            new ExceptionView("Der skete en fejl med indlæsningen af film. Prøv at genstarte programmet");

        }
        return false;
    }

    /**
     * Metoden der går igennem hele serier.txt filen og isætter en Serie med disse
     * informationer i arraylisten i StreamingService
     * @return - returnere true hvis serier.txt filen blev læst uden exceptions
     */
    public boolean fillSeries() {
        try {

            // opretter en scanner med filens info
            Scanner scanner = new Scanner(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("serier.txt")));

            while (scanner.hasNextLine()) {
                // linjen med filmen og alle filmens info på
                String line = scanner.nextLine();

                // arraylist med filmens info
                String[] arrayInfoSeries = line.split(";");

                // seriens info fra arraylisten med filmens info til variable med filmens info
                String seriesName = arrayInfoSeries[0];
                String serieYears = arrayInfoSeries[1].substring(1);
                String serieGenreString = arrayInfoSeries[2].substring(1);
                serieGenreString = serieGenreString.replaceAll("\\s+","");
                String[] serieGenres = serieGenreString.split(",");
                double serieRating = Double.parseDouble(arrayInfoSeries[3].substring(1).replace(',','.'));

                // info om sæsoner og episoder
                String seriesSeasonsAndEpisodesLine = arrayInfoSeries[4];
                String[] seriesSeasonsAndEpisodes = seriesSeasonsAndEpisodesLine.split(",");

                // antallet af sæsoner er lig med længden ad arrayet med sæsoner og episoder
                int serieSeasons = seriesSeasonsAndEpisodes.length;

                // de respektive sæsoners antal episoder sættes ind i arrayliste med info om episoder
                ArrayList<Integer> serieEpisodes = new ArrayList<>();
                for (String s : seriesSeasonsAndEpisodes) {
                    String[] splitSeasonsAndEpisodes = s.split("-");
                    serieEpisodes.add(Integer.parseInt(splitSeasonsAndEpisodes[1]));
                }

                // billedefilens navn er det samme som navnet på filen + .jpg
                String seriePicture =  "/Serierforsider/" + seriesName + ".jpg";

                // indsætter en serie i streamingService
                Serie serie = new Serie(seriesName, serieYears, serieGenres, serieRating, seriePicture, serieSeasons, serieEpisodes);
                streamingService.addSerie(serie);
            }
            scanner.close();
            return true;
        // et genereisk catch statement der fanger alle fejl og udskriver fejl i terminalen
        } catch (Exception e) {

            // System.out.println("Der skete en fejl med at indlæse serier fra txt filer");
            new ExceptionView("Der skete en fejl med indlæsningen af serier. Prøv at genstarte programmet");
        }
        return false;
    }
}
