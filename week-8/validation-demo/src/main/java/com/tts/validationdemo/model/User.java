package com.tts.validationdemo.model;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @NotNull(message = "username cannot be null")
    @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

//    @AssertFalse
//    @AssertTrue
//    private boolean isWorking;

//    @Max()
//    @Size(min=18, max=99)
//    @Min(value = 18, message = "You need to be at least 18 years old")
//    private int age;
//
//    @CreditCardNumber(message = "Please input a valid credit card number")
//    private long creditCardNumber;

//    @Past
//    @PastOrPresent
//    @Future


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
