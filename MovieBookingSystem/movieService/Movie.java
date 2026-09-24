package movieService;

public class Movie {
    private String movieId;
    private String movieName;
    private int duration;

    public Movie(String movieId, String movieName, int duration) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getDuration() {
        return duration;
    }
}
