package com.stackroute.userprofile.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserProfile {
    @NotNull
    private String username;
    @NotNull
    @Size(min = 8, max = 15)
    private String password;
    @NotNull
    private String FirstName;
    private String LastName;

    public UserProfile() {
    }

    public UserProfile(String username, String password, String firstName, String lastName, String email, String address1, String address2, String city) {
        this.username = username;
        this.password = password;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Address1 = address1;
        Address2 = address2;
        City = city;
    }

    @NotNull
    @Email
    private String Email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    private String Address1;
    private String Address2;
    private String City;
}
