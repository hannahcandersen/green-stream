package Model;

import java.util.ArrayList;

public class Serie extends Media {
    private int seasons;
    private ArrayList<Integer> episodes;
    private int endYear;

    public Serie(String name, int startYear, String genre, double rating, String picture, int seasons, ArrayList<Integer> episodes, int endYear){
        super(name, startYear, genre, rating, picture);
        this.seasons = seasons;
        this.episodes = episodes;
        this.endYear = endYear;
    }

    public int getSaesoner() {
        return seasons;
    }

    public ArrayList<Integer> getAfsnit() {
        return episodes;
    }

    public int getSlutAarstal() {
        return endYear;
    }

}
