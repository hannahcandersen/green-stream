package Model;

import java.util.Scanner;

public class Profil {
    private String name;
    private MyList myList;

    public Profil(){
        Scanner sc = new Scanner(System.in);
        this.name = sc.nextLine();
        this.myList = new MyList();
    }

}
