package Model;

import java.util.*;

public class MinListe {

    private List<Medie> minListe;
    public MinListe(){
        this.minListe = new ArrayList<>();
    }
    public void addMedie(Medie m){
        minListe.add(m);
    }
}
