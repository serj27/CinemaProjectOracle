package dto;

import model.Entity;

/**
 * Created by serj27 on 17.07.2016.
 */
public class HallDTO extends Entity<Integer> {

    private String hallName;

    public HallDTO(){}

    public HallDTO(String hallName) {
        setHallName(hallName);
    }

    public String getHallName(){return hallName;}

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HallDTO)) return false;
        if (!super.equals(o)) return false;

        HallDTO hallDTO = (HallDTO) o;

        return getHallName() != null ? getHallName().equals(hallDTO.getHallName()) : hallDTO.getHallName() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getHallName() != null ? getHallName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Hall DTO {" +
                "Hall Name = '" + getHallName() + '\'' +
                '}' + super.toString();
    }

}
