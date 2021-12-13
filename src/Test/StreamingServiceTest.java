package Test;
import Model.*;

import Model.StreamingService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import junit.framework.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class StreamingServiceTest {

    @Test
    public void testFirstMovieName() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Movie movie = (Movie) streamingService.getMovies().get(0);

        // expected value
        String expected = "The Godfather";
        // actual value
        String actual = movie.getName();
        // assert that they are equal
        assertEquals(expected, actual);

    }

    @Test
    public void testFirstMovieYear() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Movie movie = (Movie) streamingService.getMovies().get(0);

        // expected value
        String expected = "1972";
        // actual value
        String actual = movie.getYear();
        // assert that they are equal
        assertEquals(expected, actual);

    }

    @Test
    public void testFirstMovieGenre() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Movie movie = (Movie) streamingService.getMovies().get(0);

        // expected value
        String[] expected = {"Crime", "Drama"};
        // actual value
        String[] actual = movie.getGenre();
        // assert that they are equal
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testFirstMovieRating() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Movie movie = (Movie) streamingService.getMovies().get(0);

        // expected value
        double expected = 9.2;
        // actual value
        double actual = movie.getRating();
        // assert that they are equal
        assertEquals(expected, actual, 0);

    }


    @Test
    public void testLastMovieName() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Movie movie = (Movie) streamingService.getMovies().get(99);

        // expected value
        String expected = "Yankee Doodle Dandy";
        // actual value
        String actual = movie.getName();
        // assert that they are equal
        assertEquals(expected, actual);

    }

    @Test
    public void testLastMovieYear() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Movie movie = (Movie) streamingService.getMovies().get(99);

        // expected value
        String expected = "1942";
        // actual value
        String actual = movie.getYear();
        // assert that they are equal
        assertEquals(expected, actual);

    }

    @Test
    public void testLastMovieGenre() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Movie movie = (Movie) streamingService.getMovies().get(99);

        // expected value
        String[] expected = {"Biography", "Drama", "Musical"};
        // actual value
        String[] actual = movie.getGenre();
        // assert that they are equal
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testLastMovieRating() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Movie movie = (Movie) streamingService.getMovies().get(99);

        // expected value
        double expected = 7.7;
        // actual value
        double actual = movie.getRating();
        // assert that they are equal
        assertEquals(expected, actual, 0);

    }


    @Test
    public void testFirstSeriesName() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Serie serie = (Serie) streamingService.getSeries().get(0);

        // expected value
        String expected = "Twin Peaks";
        // actual value
        String actual = serie.getName();
        // assert that they are equal
        assertEquals(expected, actual);

    }

    @Test
    public void testFirstSeriesYear() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Serie serie = (Serie) streamingService.getSeries().get(0);
        // expected value
        String expected = "1990-1991";
        // actual value
        String actual = serie.getYear();
        // assert that they are equal
        assertEquals(expected, actual);

    }

    @Test
    public void testFirstSeriesGenre() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Serie serie = (Serie) streamingService.getSeries().get(0);
        // expected value
        String[] expected = {"Crime", "Drama", "Mystery"};
        // actual value
        String[] actual = serie.getGenre();
        // assert that they are equal
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testFirstSeriesRating() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Serie serie = (Serie) streamingService.getSeries().get(0);
        // expected value
        double expected = 8.8;
        // actual value
        double actual = serie.getRating();
        // assert that they are equal
        assertEquals(expected, actual, 0);

    }

    @Test
    public void testFirstSeriesSeasons() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Serie serie = (Serie) streamingService.getSeries().get(0);
        // expected value
        int expected = 2;
        // actual value
        double actual = serie.getSeasons();
        // assert that they are equal
        assertEquals(expected, actual);

    }

    @Test
    public void testFirstSeriesEpisodes() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Serie serie = (Serie) streamingService.getSeries().get(0);
        // expected value
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(8);
        expected.add(22);

        // actual value
        ArrayList<Integer> actual = serie.getEpisodes();
        // assert that they are equal
        assertEquals(expected, actual);

    }


    @Test
    public void testLastSeriesName() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Serie serie = (Serie)streamingService.getSeries().get(99);

        // expected value
        String expected = "Dexter";
        // actual value
        String actual = serie.getName();
        // assert that they are equal
        assertEquals(expected, actual);

    }

    @Test
    public void testLastSeriesYear() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Serie serie = (Serie)streamingService.getSeries().get(99);
        // expected value
        String expected = "2006-2013";
        // actual value
        String actual = serie.getYear();
        // assert that they are equal
        assertEquals(expected, actual);

    }

    @Test
    public void testLastSeriesGenre() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Serie serie = (Serie)streamingService.getSeries().get(99);
        // expected value
        String[] expected = {"Crime", "Drama", "Mystery"};
        // actual value
        String[] actual = serie.getGenre();
        // assert that they are equal
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testLastSeriesRating() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Serie serie = (Serie)streamingService.getSeries().get(99);
        // expected value
        double expected = 8.7;
        // actual value
        double actual = serie.getRating();
        // assert that they are equal
        assertEquals(expected, actual, 0);

    }

    @Test
    public void testLastSeriesSeasons() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Serie serie = (Serie)streamingService.getSeries().get(99);
        // expected value
        int expected = 8;
        // actual value
        double actual = serie.getSeasons();
        // assert that they are equal
        assertEquals(expected, actual);

    }

    @Test
    public void testLastSeriesEpisodes() {

        // setup
        StreamingService streamingService = StreamingService.getInstance();
        Reader r = new Reader(streamingService);
        r.fillCollectionsSuccesFull();

        Serie serie = (Serie)streamingService.getSeries().get(99);
        // expected value
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(12);
        expected.add(12);
        expected.add(12);
        expected.add(12);
        expected.add(12);
        expected.add(12);
        expected.add(12);
        expected.add(12);

        // actual value
        ArrayList<Integer> actual = serie.getEpisodes();
        // assert that they are equal
        assertEquals(expected, actual);

    }

}

