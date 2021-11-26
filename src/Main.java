import Model.Reader;
import Model.StreamingService;

public class Main {
    public static void main(String[] args) {
        StreamingService s = StreamingService.getInstance();
        Reader r = new Reader(s);
        r.fillCollections();
        s.listAllMovies();
        s.listAllSeries();
    }
}
