package Model;

import java.util.*;

public class MyList {

    private List<Media> myList;

    public MyList(){
        this.myList = new ArrayList<>();
    }

    public void addMedia(Media m){
        myList.add(m);
    }
}
