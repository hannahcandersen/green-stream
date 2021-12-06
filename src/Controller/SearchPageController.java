package Controller;

import Model.Media;
import View.SearchPage;

import java.util.Scanner;

public class SearchPageController {

    private Controller controller;
    private SearchPage searchPage;

    public SearchPageController(Controller controller){
        this.controller = controller;
        searchPage = new SearchPage(null, this);
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public void searchActionlistner(String search){
        controller.getSceneBuilder().loadPage(new SearchPage(controller.getStreamingService().allNameSearch(search), this));

    }

}
