package Controller;

import View.MyListPage;

public class MyListPageController {

    private Controller controller;
    private MyListPage myListPage;

    public MyListPageController(Controller controller) {
        this.controller = controller;
        myListPage = new MyListPage();
    }

    public MyListPage getMyListPage() {
        return myListPage;
    }
}
