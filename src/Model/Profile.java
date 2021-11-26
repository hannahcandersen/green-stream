package Model;

public class Profile {
    private String navn;
    private MyList minListe;
    private String billede;

    public Profile(String navn, String billede){
        this.navn = navn;
        this.minListe = new MyList();
        this.billede = billede;
    }

    public void setNavn(String newNavn){
        this.navn = newNavn;
    }
    public void setBillede(String newBillede){
         this.billede = newBillede;
    }
    public String getNavn(){
        return navn;
    }
    public String getBillede(){
        return billede;
    }


}
