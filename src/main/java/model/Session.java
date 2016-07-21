package model;

import java.time.LocalDate;

/**
 * Created by serj27 on 17.07.2016.
 */
public class Session extends Entity<Integer> {

    private int movieID;
    private int hallID;
    private double price;
    private LocalDate startSession;

    public Session() {
    }

    public Session(int movieID, int hallID, double price, LocalDate startSession) {
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

        Session session = (Session) o;

        if (movieID != session.movieID) return false;
        if (hallID != session.hallID) return false;
        if (Double.compare(session.price, price) != 0) return false;
        return startSession.equals(session.startSession);

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
        return "Session {" +
                "Movie ID = " + movieID +
                ", Hall ID = " + hallID +
                ", Price = " + price +
                ", Start Session = " + startSession +
                "} " + super.toString();
    }
}
