package Model;

import java.util.*;

/**
 * Dette er den list hver bruger har hvor de kan tilføje film og serier. Man kan også fjerne et medie fra sin liste.
 */
public class MyList {

    private List<Media> myList;

    public MyList(){
        this.myList = new ArrayList<>();
    }

    public void addMedia(Media m){
        myList.add(m);
    }
    public void removeMedia(Media m){
        myList.remove(m);
    }
}
