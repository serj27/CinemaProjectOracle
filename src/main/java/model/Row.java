package model;

/**
 * Created by serj27 on 17.07.2016.
 */
public class Row extends Entity<Integer> {
    private int rowNumber;
    private int amountSeats;
    private int hallID;

    public Row() {
    }

    public Row(int rowNumber, int amountSeats, int hallID) {
        this.rowNumber = rowNumber;
        this.amountSeats = amountSeats;
        this.hallID = hallID;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getAmountSeats() {
        return amountSeats;
    }

    public void setAmountSeats(int amountSeats) {
        this.amountSeats = amountSeats;
    }

    public int getHallID() {
        return hallID;
    }

    public void setHallID(int hallID) {
        this.hallID = hallID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Row row = (Row) o;

        if (rowNumber != row.rowNumber) return false;
        if (amountSeats != row.amountSeats) return false;
        return hallID == row.hallID;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + rowNumber;
        result = 31 * result + amountSeats;
        result = 31 * result + hallID;
        return result;
    }

    @Override
    public String toString() {
        return "Row {" +
                "Row Number = " + rowNumber +
                ", Amount Seats = " + amountSeats +
                ", Hall ID = " + hallID +
                "} " + super.toString();
    }
}
