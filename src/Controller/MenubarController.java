package Controller;

import Model.Movie;
import Model.StreamingService;
import View.*;

import javax.swing.*;

public class MenubarController {

    private Controller controller;
    private Menubar menubar;

    public MenubarController(Controller controller) {
        this.controller = controller;

        //menubar = new Menubar(controller.getStreamingService().getGenreList(), controller.getStreamingService().getCurrentProfile().getPicture(), this);
        // til test
        //menubar = new Menubar(controller.getStreamingService().getGenreList(), "Green", this);
    }

    public Menubar getMenubar() {
        System.out.println(controller.getStreamingService().getCurrentProfile().getPicture());
        return new Menubar(controller.getStreamingService().getGenreList(), controller.getStreamingService().getCurrentProfile().getPicture(), this);
    }

    public void myListActionListener() {
        // gå til mylist
        controller.getSceneBuilder().loadPage(controller.getMyListPageController().getMyListPage());
    }

    public void movieActionListener() {
        // gå til film siden
    }

    public void serieActionListener() {
        // gå til serie siden
    }

    public void genreActionListener(String genre) {
        // gå til genre siden
        //sceneBuilder.loadPage(searchPage);
    }

    public void searchActionListener(){
        // gå til search siden
        controller.getSceneBuilder().loadPage(controller.getSearchPageController().getSearchPage());
    }

    public void profileActionListener() {
        // gå til LoginPage
        controller.getSceneBuilder().loadPage(new LoginPage(controller.getLoginPageController(), controller.getStreamingService().getProfiles(), controller.getStreamingService().getCurrentLength()));
    }
}
