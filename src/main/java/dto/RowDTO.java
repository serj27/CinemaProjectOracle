package dto;

import model.Entity;

/**
 * Created by serj27 on 17.07.2016.
 */
public class RowDTO extends Entity<Integer> {

    private int rowNumber;
    private int amountSeats;
    private int hallID;

    public RowDTO() {
    }

    public RowDTO(int rowNumber, int amountSeats, int hallID) {
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
        if (!(o instanceof RowDTO)) return false;

        RowDTO rowsDTO = (RowDTO) o;

        if (getRowNumber() != rowsDTO.getRowNumber()) return false;
        if (getAmountSeats() != rowsDTO.getAmountSeats()) return false;
        return getHallID() == rowsDTO.getHallID();

    }

    @Override
    public int hashCode() {
        int result = getRowNumber();
        result = 31 * result + getAmountSeats();
        result = 31 * result + getHallID();
        return result;
    }

    @Override
    public String toString() {
        return "Rows DTO {" +
                "Row Number = " + getRowNumber() +
                ", Amount Seats = " + getAmountSeats() +
                ", Hall ID = " + getHallID() +
                '}' + super.toString();
    }

}
