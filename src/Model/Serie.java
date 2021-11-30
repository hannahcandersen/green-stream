package Model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Der hvor serier adskiller sig fra film er ved at serier har sæsoner og afsnit.
 */
public class Serie extends Media {
    private int seasons;
    private ArrayList<Integer> episodes;

    public Serie(String name, String year, String[] genre, double rating, String picture, int seasons, ArrayList<Integer> episodes){
        super(name, year, genre, rating, picture);
        this.seasons = seasons;
        this.episodes = episodes;
    }

    public int getSeasons() {
        return seasons;
    }

    public ArrayList<Integer> getEpisodes() {
        return episodes;
    }


}
