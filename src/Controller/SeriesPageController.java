package Controller;

import View.SeriesPage;

public class SeriesPageController {

    private Controller controller;
    private SeriesPage seriesPage;

    public SeriesPageController(Controller controller) {
        this.controller = controller;
        this.seriesPage = new SeriesPage();
    }

    public SeriesPage getSeriesPage() {
        return seriesPage;
    }
}
