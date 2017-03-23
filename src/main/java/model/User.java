package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class User {

    public static String FIRST_NAME_KEY = "firstName";

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    };


    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private AccessLevel accessLevel;
    private String email;
    private String passwordHash;
    private String profilePhoto;
    private String statusOnWall;
    private String city;
//    UNIQUE (email)

    public String getFirstNameAndLastName(){

        return firstName + " " + lastName;

    };
}
