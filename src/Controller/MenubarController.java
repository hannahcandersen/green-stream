package Controller;

import View.LoginPage;
import View.SearchPage;

import javax.swing.*;

public class MenubarController {

    SearchPage searchPage = new SearchPage(null);
    LoginPage loginPage = new LoginPage();

    public MenubarController() {

    }

    public void myListActionListener() {
        // gå til mylist
    }

    public void movieActionListener() {
        // gå til film siden
    }

    public void serieActionListener() {
        // gå til serie siden
    }

    public void genreActionListener(String genre) {
        // gå til genre siden

        System.out.println("gå til seachpage");
        //sceneBuilder.loadPage(searchPage);
        System.out.println("gå til seachpage");
    }

    public void searchActionListener(){
        // gå til search siden
        //sceneBuilder.loadPage(searchPage);
        System.out.println("gå til seachpage");
    }

    public void profileActionListener() {
        // gå til LoginPage
        //sceneBuilder.loadPage(loginPage);
        System.out.println("gå til loginpage");
    }
}
