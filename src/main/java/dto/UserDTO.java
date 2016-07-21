package dto;

import model.Entity;

import java.time.LocalDate;

/**
 * Created by serj27 on 02.06.2016.
 */
public class UserDTO extends Entity<Integer> {

    private String login;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private Gender gender;
    private LocalDate birthday;
    private Role role;

    public UserDTO() {
    }

    public UserDTO(String login, String password, String firstName, String secondName, String email, Gender gender, LocalDate birthday, Role role) {
        setLogin(login);
        setPassword(password);
        setFirstName(firstName);
        setSecondName(secondName);
        setEmail(email);
        setGender(gender);
        setBirthday(birthday);
        setRole(role);
    }

    public enum Gender{
        MALE, FAMALE;
    }

    public enum Role{
        ADMIN, CASHIER, USER, GUEST;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        if (!super.equals(o)) return false;

        UserDTO usersDTO = (UserDTO) o;

        if (getLogin() != null ? !getLogin().equals(usersDTO.getLogin()) : usersDTO.getLogin() != null) return false;
        if (getPassword() != null ? !getPassword().equals(usersDTO.getPassword()) : usersDTO.getPassword() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(usersDTO.getFirstName()) : usersDTO.getFirstName() != null)
            return false;
        if (getSecondName() != null ? !getSecondName().equals(usersDTO.getSecondName()) : usersDTO.getSecondName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(usersDTO.getEmail()) : usersDTO.getEmail() != null) return false;
        if (getGender() != usersDTO.getGender()) return false;
        if (getBirthday() != null ? !getBirthday().equals(usersDTO.getBirthday()) : usersDTO.getBirthday() != null)
            return false;
        return getRole() == usersDTO.getRole();

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getSecondName() != null ? getSecondName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "Login = '" + getLogin() +
                ", Password = '" + getPassword() +
                ", First name = '" + getFirstName() +
                ", Second name = '" + getSecondName() +
                ", Email = '" + getEmail() +
                ", Gender = " + getGender() +
                ", Birthday = " + getBirthday() +
                ", Role = " + getRole() +
                '}' + super.toString();
    }
}
