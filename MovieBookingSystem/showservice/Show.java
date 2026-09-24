package showservice;

import java.time.LocalDateTime;

import movieService.Movie;
import screenservice.Screen;
import theatreService.Theatre;

public class Show {
    private String showId;
    private Movie movie;
    private Theatre theatre;
    private Screen screen;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Show(String showId, Movie movie, Theatre theatre, Screen screen, LocalDateTime startTime) {
        this.showId = showId;
        this.movie = movie;
        this.theatre = theatre;
        this.screen = screen;
        this.startTime = startTime;
        this.endTime = startTime.plusMinutes(movie.getDuration());
    }

    public String getMovieName() {
        return movie.getMovieName();
    }

    // written by me
    // public void getShowdetails(){
    // System.out.println("Show no : " + showId + " Movie Name : " +
    // movie.getMovieName() + " Theatre Name : " + theatre.getname() + " Screen Name
    // : " + screen.getScreenName() + " Start Time : " + startTime.toString() + "
    // End Time : " + endTime.toString());
    // }
    // beautifully written by ai
    public void getShowDetails() {
        System.out.println("========================================");
        System.out.println("              SHOW DETAILS              ");
        System.out.println("========================================");
        System.out.println("Show ID       : " + showId);
        System.out.println("Movie         : " + movie.getMovieName());
        System.out.println("Theatre       : " + theatre.getname());
        System.out.println("Screen        : " + screen.getScreenName());
        System.out.println("Start Time    : " + startTime);
        System.out.println("End Time      : " + endTime);
        System.out.println("========================================");
    }
    public String getShowId(){
        return showId;
    }
    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
