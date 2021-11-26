package Model;

public class Profile {
    private String name;
    private MyList myList;
    private String picture;

    public Profile(String name, String picture){
        this.name = name;
        this.myList = new MyList();
        this.picture = picture;
    }

    public void setName(String newName){
        this.name = newName;
    }
    public void setPicture(String newPicture){
         this.picture = newPicture;
    }
    public String getName(){
        return name;
    }
    public String getPicture(){
        return picture;
    }


}
