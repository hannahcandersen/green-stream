package Model;

public class Serie extends Medie {
    private int saesoner;
    private int afsnit;
    private int slutAarstal;

    public Serie(String navn, int startAarstal, String genre, double rating, String billede, int saesoner, int afsnit, int slutAarstal){
        super(navn, startAarstal, genre, rating, billede);
        this.saesoner = saesoner;
        this.afsnit = afsnit;
        this.slutAarstal = slutAarstal;
    }

    // alle getter metoder
    public int getSaesoner() {
        return saesoner;
    }

    public int getAfsnit() {
        return afsnit;
    }

    public int getSlutAarstal() {
        return slutAarstal;
    }
}
