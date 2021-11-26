import Model.Reader;
import Model.StreamingService;

public class Main {
    public static void main(String[] args) {
        StreamingService s = new StreamingService();
        Reader r = new Reader(s);
        r.fillCollections();
        s.listAllMovies();
        s.listAllSeries();
    }
}
