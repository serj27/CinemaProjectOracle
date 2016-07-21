package dto;

import model.Entity;

/**
 * Created by serj27 on 17.07.2016.
 */
public class TicketsDTO extends Entity<Integer> {

    private int userID;
    private int sessionID;
    private int rowNumber;
    private int seatNumber;
    private boolean isSold;

    public TicketsDTO() {
    }

    public TicketsDTO(int userID, int sessionID, int rowNumber, int seatNumber, boolean isSold) {
        this.userID = userID;
        this.sessionID = sessionID;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.isSold = isSold;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TicketsDTO that = (TicketsDTO) o;

        if (userID != that.userID) return false;
        if (sessionID != that.sessionID) return false;
        if (rowNumber != that.rowNumber) return false;
        if (seatNumber != that.seatNumber) return false;
        return isSold == that.isSold;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + userID;
        result = 31 * result + sessionID;
        result = 31 * result + rowNumber;
        result = 31 * result + seatNumber;
        result = 31 * result + (isSold ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tickets DTO {" +
                "User ID = " + userID +
                ", Session ID = " + sessionID +
                ", Row Number = " + rowNumber +
                ", Seat Number = " + seatNumber +
                ",  Sold = " + isSold +
                "} " + super.toString();
    }
}
