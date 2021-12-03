package Controller;

import Model.Movie;
import Model.StreamingService;
import View.*;

import javax.swing.*;

public class MenubarController {


    SceneBuilder sceneBuilder;
    SearchPage searchPage;
    LoginPage loginPage;
    MoviePage moviePage;
    SeriesPage seriesPage;
    MyListPage myListPage;
    StreamingService streamingService;

    Menubar menubar;


    public MenubarController(SceneBuilder sb, SearchPage searchPage, LoginPage loginPage, MoviePage moviePage,
                             SeriesPage seriesPage, MyListPage myListPage, StreamingService streamingService) {
        this.sceneBuilder = sb;
        this.searchPage = searchPage;
        this.loginPage = loginPage;
        this.moviePage = moviePage;
        this.seriesPage = seriesPage;
        this.myListPage = myListPage;
        this.streamingService = streamingService;


        //menubar = new Menubar(streamingService.getGenreList(), streamingService.getCurrentProfile().getPicture(), this);

        // til test
        menubar = new Menubar(streamingService.getGenreList(), "Green", this);
    }

    public Menubar getMenubar() {
        return menubar;
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
        sceneBuilder.loadPage(searchPage);
        System.out.println("gå til seachpage");
    }

    public void profileActionListener() {
        // gå til LoginPage
        sceneBuilder.loadPage(loginPage);
        //sb.loadPage(this.loginPage);
        System.out.println("gå til loginpage");
    }
}
