package com.SSF_day13lecture.SSF_day13lecture.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {

    // @NotNull(message = "id must be auto-generated")
    private String id;

    @NotEmpty(message = "First Name is mandatory")
    @Size(min = 3, max = 60, message = "First Name must be between 5 to 60 characters long")
    private String firstName;

    @NotEmpty(message = "Last Name is mandatory")
    @Size(min = 3, max = 60, message = "Last Name must be between 5 to 60 characters long")
    private String lastName;

    @Past(message = "Date of birth must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Min(value = 1000, message = "Minimum salary starts from 1000")
    @Max(value = 20000, message = "Maximum salary must be below 20000")
    private Integer salary;

    @Email(message = "Email input doesn't conform to email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Pattern(regexp = "(8|9)[0-9]{7}$", message = "Please provide a valid phone number that starts with 8 or 9 and at least 7 digits")
    private String phoneNumber;

    @Min(value = 111111, message = "Minimum salary starts from 1500")
    @Max(value = 999999, message = "Maximum salary starts from 50000")
    private Integer postalCode;

    public Person() {
    }

    public Person(String firstName, String lastName, String email, Integer salary, Date dateOfBirth, String phoneNumber,
            Integer postalCode) {
        this.id = UUID.randomUUID().toString().substring(0, 6);
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

}
