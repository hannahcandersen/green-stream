package Model;

import java.util.*;

public class MyList {

    private List<Media> minListe;
    public MyList(){
        this.minListe = new ArrayList<>();
    }
    public void addMedie(Media m){
        minListe.add(m);
    }
}
