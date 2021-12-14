package Model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Denne klasse er en subklasse af Media.
 * Der hvor serier adskiller sig fra film er ved at serier har sæsoner og afsnit.
 */
public class Serie extends Media {
    private int seasons;
    private ArrayList<Integer> episodes;

    /**
     * Paramerende for serierne
     * @param name - Mediets navn
     * @param year - Mediets udgiveklses år
     * @param genre - Mediets genre
     * @param rating - Hvad IMDb har rated mediet som
     * @param picture - Mediets poster
     * @param seasons - Seriens sæsonner
     * @param episodes - Seriens episoder
     */
    public Serie(String name, String year, String[] genre, double rating, String picture, int seasons, ArrayList<Integer> episodes){
        super(name, year, genre, rating, picture);
        this.seasons = seasons;
        this.episodes = episodes;
    }

    /**
     * Klassen retunere mediets sæsoner
     * @return mediets sæsoner
     */
    public int getSeasons() {
        return seasons;
    }

    /**
     * Klassen retunere mediets episoder
     * @return mediets episoner
     */
    public ArrayList<Integer> getEpisodes() {
        return episodes;
    }
}
