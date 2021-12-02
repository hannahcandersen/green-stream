package Model;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

// reader
public class Reader {

    StreamingService streamingService;

    public Reader(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    public void fillCollections() {
        fillMovies();
        fillSeries();
    }

    public void fillMovies() {
        try {
            // finder filen
            File movieFile = new File("resources/film.txt");

            // opretter scanner med filens info
            Scanner scanner = new Scanner(movieFile);

            while (scanner.hasNextLine()) {
                // linjen med filmen og alle filmens info på
                String line = scanner.nextLine();

                // arraylist med filmens info
                String[] arrayInfoMovie = line.split(";");

                // seriens info fra arraylisten med filmens info til variable med filmens info
                String movieName = arrayInfoMovie[0];
                String movieYear = arrayInfoMovie[1].substring(1);
                String movieGenreString = arrayInfoMovie[2].substring(1);
                String[] movieGenres = movieGenreString.split(",");
                double movieRating = Double.parseDouble(arrayInfoMovie[3].substring(1).replace(',','.'));
                String moviePicture = movieName + ".jpg";

                // indsætter filmen i streamingService
                Movie movie = new Movie(movieName, movieYear, movieGenres, movieRating, moviePicture);
                streamingService.addMovie(movie);
            }
            scanner.close();
        // tilføj flere catch statements
        // et generisk catch statement der fanger alle fejl og udskriver fejl i terminalen
        } catch (Exception e) {
            System.out.println("Der skete en fejl");
            System.out.println(e.getMessage());
        }
    }

    public void fillSeries() {
        try {
            // finder filen
            File seriesFile = new File("resources/serier.txt");

            // opretter en scanner med filens info
            Scanner scanner = new Scanner(seriesFile);

            while (scanner.hasNextLine()) {
                // linjen med filmen og alle filmens info på
                String line = scanner.nextLine();

                // arraylist med filmens info
                String[] arrayInfoSeries = line.split(";");

                // seriens info fra arraylisten med filmens info til variable med filmens info
                String seriesName = arrayInfoSeries[0];
                String serieYears = arrayInfoSeries[1].substring(1);
                String serieGenreString = arrayInfoSeries[2].substring(1);
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
                String seriePicture = seriesName + ".jpg";

                // indsætter en serie i streamingService
                Serie serie = new Serie(seriesName, serieYears, serieGenres, serieRating, seriePicture, serieSeasons, serieEpisodes);
                streamingService.addSerie(serie);
            }
            scanner.close();
        // tilføj flere catch statements
        // et genereisk catch statement der fanger alle fejl og udskriver fejl i terminalen
        } catch (Exception e) {

            System.out.println("Der skete en fejl");
            System.out.println(e.getMessage());
        }
    }


}
