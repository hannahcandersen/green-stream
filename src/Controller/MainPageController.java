package Controller;

import View.MainPage;

public class MainPageController {

    private MainPage mainPage;
    private Controller controller;

    public MainPageController(Controller controller) {
        this.controller = controller;
        mainPage = new MainPage();
    }

    public MainPage getMainPage() {
        return mainPage;
    }
}
