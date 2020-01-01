package hu.jst.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="users_register")
public class UserRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String userName;
    private String firstName;
    private String lastName;
    private String cityOfBirth;
    private LocalDate dateOfBirth;
    private int budget;

    private UserRegister() {}

    public UserRegister(String userName, String firstName, String lastName, String cityOfBirth, LocalDate dateOfBirth, int budget) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cityOfBirth = cityOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.budget = budget;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cityOfBirth='" + cityOfBirth + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", budget=" + budget +
                '}';
    }
}
