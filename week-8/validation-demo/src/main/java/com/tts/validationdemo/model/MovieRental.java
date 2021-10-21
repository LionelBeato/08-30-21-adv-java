package com.tts.validationdemo.model;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class MovieRental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=2, max=30)
    private String customerFirstName;
    @Size(min=2, max=30)
    private String customerLastName;
    @Email
    private String emailAddress;
    @CreditCardNumber
    private String creditCardNumber;
    @Digits(integer=3, fraction = 2)
    private double cost;
    @PastOrPresent
    private LocalDate rentalDate;

    public MovieRental() {
    }

    public MovieRental(String customerFirstName, String customerLastName, String emailAddress, String creditCardNumber, double cost, LocalDate rentalDate) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.emailAddress = emailAddress;
        this.creditCardNumber = creditCardNumber;
        this.cost = cost;
        this.rentalDate = rentalDate;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    @Override
    public String toString() {
        return "MovieRental{" +
                "id=" + id +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", cost=" + cost +
                ", rentalDate=" + rentalDate +
                '}';
    }
}
