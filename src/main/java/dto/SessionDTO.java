package dto;

import model.Entity;

import java.time.LocalDate;

/**
 * Created by serj27 on 17.07.2016.
 */
public class SessionDTO extends Entity<Integer> {

    private int movieID;
    private int hallID;
    private double price;
    private LocalDate startSession;

    public SessionDTO() {
    }

    public SessionDTO(int movieID, int hallID, double price, LocalDate startSession) {
        this.movieID = movieID;
        this.hallID = hallID;
        this.price = price;
        this.startSession = startSession;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getHallID() {
        return hallID;
    }

    public void setHallID(int hallID) {
        this.hallID = hallID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStartSession() {
        return startSession;
    }

    public void setStartSession(LocalDate startSession) {
        this.startSession = startSession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SessionDTO that = (SessionDTO) o;

        return movieID == that.movieID && hallID == that.hallID && Double.compare(that.price, price) == 0 && startSession.equals(that.startSession);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + movieID;
        result = 31 * result + hallID;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + startSession.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Session DTO {" +
                "Movie ID = " + movieID +
                ", Hall ID = " + hallID +
                ", Price = " + price +
                ", Start Session = " + startSession +
                "} " + super.toString();
    }
}
