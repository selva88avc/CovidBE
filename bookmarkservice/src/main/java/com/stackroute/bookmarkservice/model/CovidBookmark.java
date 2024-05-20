package com.stackroute.bookmarkservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class CovidBookmark implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String state;
    private int confirmed;

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CovidBookmark() {
    }

    public CovidBookmark(Integer id,int userId, String state, int confirmed, int deceased, int recovered, int tested, int vaccinated1, int vaccinated2) {
        this.id = id;
        this.userId = userId;
        this.state = state;
        this.confirmed = confirmed;
        this.deceased = deceased;
        this.recovered = recovered;
        this.tested = tested;
        this.vaccinated1 = vaccinated1;
        this.vaccinated2 = vaccinated2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public int getConfirmed() {
        return confirmed;
    }


    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }


    public int getDeceased() {
        return deceased;
    }


    public void setDeceased(int deceased) {
        this.deceased = deceased;
    }


    public int getRecovered() {
        return recovered;
    }


    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }


    public int getTested() {
        return tested;
    }


    public void setTested(int tested) {
        this.tested = tested;
    }


    public int getVaccinated1() {
        return vaccinated1;
    }


    public void setVaccinated1(int vaccinated1) {
        this.vaccinated1 = vaccinated1;
    }


    public int getVaccinated2() {
        return vaccinated2;
    }


    public void setVaccinated2(int vaccinated2) {
        this.vaccinated2 = vaccinated2;
    }

    private int deceased;
    private int recovered;
    private int tested;
    private int vaccinated1;
    private int vaccinated2;
}
