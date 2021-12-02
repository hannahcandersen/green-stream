package Controller;

import Model.Reader;
import Model.StreamingService;

public class Controller {
    private StreamingService streamingService;
    private Reader reader;

    public Controller() {
        streamingService = StreamingService.getInstance();
        reader = new Reader(streamingService);
    }



}
