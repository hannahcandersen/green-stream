package Model;

import java.util.Scanner;

public class Profil {
    private String name;
    private MinListe minListe;

    public Profil(){
        Scanner sc = new Scanner(System.in);
        this.name = sc.nextLine();
        this.minListe = new MinListe();
    }

}
