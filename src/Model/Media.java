package Model;

public abstract class Media {
    protected String name;
    protected String year;
    protected String[] genre;
    protected double rating;
    protected String billede;
    protected boolean TilføjetTilMinListe;

    public void Medie(String name, String year, String[] genre, double rating, String billede) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
        this.billede = billede;
    }

    public Media(String name, String year, String[] genre, double rating, String picture) {
    }

    public void Afspille() {

    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String[] getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public String getBillede() {
        return billede;
    }

    public boolean isTilføjetTilMinListe() {
        return TilføjetTilMinListe;
    }

}


