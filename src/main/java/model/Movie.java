package model;

import java.time.LocalDate;

/**
 * Created by serj27 on 02.06.2016.
 */
public class Movie extends Entity<Integer> {
    private String title;
    private String description;
    private int duration;
    private LocalDate rentStart;
    private LocalDate rentEnd;
    private String genre;
    private int rating;

    public Movie() {
    }

    public Movie(String title, String description, int duration, LocalDate rentStart, LocalDate rentEnd, String genre, int rating) {
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

    public void setRentStart(LocalDate rentStart) {this.rentStart = rentStart;}

    public LocalDate getRentEnd() {return rentEnd; }

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
        if (!(o instanceof Movie)) return false;
        if (!super.equals(o)) return false;

        Movie movie = (Movie) o;

        if (getDuration() != movie.getDuration()) return false;
        if (getRating() != movie.getRating()) return false;
        if (getTitle() != null ? !getTitle().equals(movie.getTitle()) : movie.getTitle() != null) return false;
        if (getDescription() != null ? !getDescription().equals(movie.getDescription()) : movie.getDescription() != null)
            return false;
        if (getRentStart() != null ? !getRentStart().equals(movie.getRentStart()) : movie.getRentStart() != null)
            return false;
        if (getRentEnd() != null ? !getRentEnd().equals(movie.getRentEnd()) : movie.getRentEnd() != null) return false;
        return getGenre() != null ? getGenre().equals(movie.getGenre()) : movie.getGenre() == null;

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
        final StringBuilder sb = new StringBuilder("MovieDTO: ");
        sb.append("id = '").append(getId());
        sb.append(", title = '").append(title).append("\'");
        sb.append(", description = '").append(description).append("\'");
        sb.append(", duration = '").append(duration).append("\'");
        sb.append(", rentStart = '").append(rentStart).append("\'");
        sb.append(", rentEnd = '").append(rentEnd).append("\'");
        sb.append(", rating = '").append(rating).append("\'");
        sb.append(", genre = '").append(genre).append("\'");
        return sb.toString();
    }
}

