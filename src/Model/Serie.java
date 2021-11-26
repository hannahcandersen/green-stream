package Model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Serie extends Media {
    private int seasons;
    private ArrayList<Integer> episodes;
    private int endYear;

    public Serie(String name, int startYear, String[] genre, double rating, String picture, int seasons, ArrayList<Integer> episodes, int endYear){
        super(name, startYear, genre, rating, picture);
        this.seasons = seasons;
        this.episodes = episodes;
        this.endYear = endYear;
    }

    public int getSeasons() {
        return seasons;
    }

    public ArrayList<Integer> getEpisodes() {
        return episodes;
    }

    public int getSEndYear() {
        return endYear;
    }

}
