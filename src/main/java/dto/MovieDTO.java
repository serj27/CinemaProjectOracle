package dto;

import model.Entity;

import java.time.LocalDate;

/**
 * Created by serj27 on 02.06.2016.
 */
public class MovieDTO extends Entity<Integer> {

    private String title;
    private String description;
    private int duration;
    private LocalDate rentStart;
    private LocalDate rentEnd;
    private String genre;
    private int rating;

    public MovieDTO() {
    }

    public MovieDTO(String title, String description, int duration, LocalDate rentStart, LocalDate rentEnd, String genre, int rating) {
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

    public LocalDate getRentStart() {
        return rentStart;
    }

    public void setRentStart(LocalDate rentStart) {
        this.rentStart = rentStart;
    }

    public LocalDate getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(LocalDate rentEnd) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieDTO)) return false;
        if (!super.equals(o)) return false;

        MovieDTO movieDTO = (MovieDTO) o;

        if (getDuration() != movieDTO.getDuration()) return false;
        if (getRating() != movieDTO.getRating()) return false;
        if (getTitle() != null ? !getTitle().equals(movieDTO.getTitle()) : movieDTO.getTitle() != null) return false;
        if (getDescription() != null ? !getDescription().equals(movieDTO.getDescription()) : movieDTO.getDescription() != null)
            return false;
        if (getRentStart() != null ? !getRentStart().equals(movieDTO.getRentStart()) : movieDTO.getRentStart() != null)
            return false;
        if (getRentEnd() != null ? !getRentEnd().equals(movieDTO.getRentEnd()) : movieDTO.getRentEnd() != null)
            return false;
        return getGenre() != null ? getGenre().equals(movieDTO.getGenre()) : movieDTO.getGenre() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + getDuration();
        result = 31 * result + (getRentStart() != null ? getRentStart().hashCode() : 0);
        result = 31 * result + (getRentEnd() != null ? getRentEnd().hashCode() : 0);
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        result = 31 * result + getRating();
        return result;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "Title = '" + title + '\'' +
                ", Description = '" + description + '\'' +
                ", Duration = " + duration +
                ", Rent Start = " + rentStart +
                ", Rent End = " + rentEnd +
                ", Genre = '" + genre + '\'' +
                ", Rating = " + rating +
                "} " + super.toString();
    }
}
