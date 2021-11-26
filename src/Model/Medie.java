package Model;

public abstract class Medie {
    protected String navn;
    protected int startAarstal;
    protected String genre;
    protected double rating;
    protected String billede;
    protected boolean TilføjetTilMinListe;

    public Medie(String navn, int startAarstal, String genre, double rating, String billede) {
        this.navn = navn;
        this.startAarstal = startAarstal;
        this.genre = genre;
        this.rating = rating;
        this.billede = billede;
    }

    public void Afspille() {

    }

    // alle getter metoder
    public String getNavn() {
        return navn;
    }

    public int getStartAarstal() {
        return startAarstal;
    }

    public String getGenre() {
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


