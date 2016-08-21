package model;

import java.time.LocalDate;

/**
 * Created by serj27 on 02.06.2016.
 */
public class Users extends Entity<Integer>{

    private String login;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private Gender gender;
    private LocalDate birthday;
    private Role role;

    public Users() {
    }

    public Users(String login, String password, String firstName, String secondName, String email, Gender gender, Role role, LocalDate birthday) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.gender = gender;
        this.role = role;
        this.birthday = birthday;
    }

    public enum Gender { MALE, FEMALE;}
    public enum Role {ADMIN, CASHIER, USER, GUEST;}

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
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Users users = (Users) o;

        if (!login.equals(users.login)) return false;
        if (!password.equals(users.password)) return false;
        if (!firstName.equals(users.firstName)) return false;
        if (!secondName.equals(users.secondName)) return false;
        if (!email.equals(users.email)) return false;
        if (gender != users.gender) return false;
        if (!birthday.equals(users.birthday)) return false;
        return role == users.role;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDTO: ");
        sb.append("id = ").append(getId());
        sb.append(", firstName = '").append(firstName).append("\'");
        sb.append(", secondName = '").append(secondName).append("\'");
        sb.append(", login = '").append(login).append("\'");
        sb.append(", password = '").append(password).append("\'");
        sb.append(", email = '").append(email).append("\'");
        sb.append(", gender = '").append(gender).append("\'");
        sb.append(", role = '").append(role);
        return sb.toString();
    }
}
