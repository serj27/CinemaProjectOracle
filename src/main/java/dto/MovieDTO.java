package dto;

import model.Entity;

import java.util.Date;

/**
 * Created by serj27 on 02.06.2016.
 */
public class MovieDTO extends Entity<Integer> {

    private String title;
    private String description;
    private int duration;
    private Date rentStart;
    private Date rentEnd;
    private String genre;
    private int rating;

    public MovieDTO() {
    }

    public MovieDTO(String title, String description, int duration, Date rentStart, Date rentEnd, String genre, int rating) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.rentStart = rentStart;
        this.rentEnd = rentEnd;
        this.genre = genre;
        this.rating = rating;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getRentStart() {
        return rentStart;
    }

    public void setRentStart(Date rentStart) {
        this.rentStart = rentStart;
    }

    public Date getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(Date rentEnd) {
        this.rentEnd = rentEnd;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", rentStart=" + rentStart +
                ", rentEnd=" + rentEnd +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                "} " + super.toString();
    }
}
