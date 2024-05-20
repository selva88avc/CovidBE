package com.stackroute.covid.modal;

import java.util.Map;

public class CovidStateAnalytics {
    private String state;
    private int confirmed;

    public CovidStateAnalytics() {
    }

    public CovidStateAnalytics(String state, int confirmed, int deceased, int recovered, int tested, int vaccinated1, int vaccinated2) {
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
