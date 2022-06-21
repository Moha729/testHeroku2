package com.example.testheroku2.Model;

import java.util.Date;

public class DateConverter {

    private String theDate;
    private Date theDateConverted;

    public DateConverter() {
    }

    public DateConverter(String theDate, Date theDateConverted) {
        this.theDate = theDate;
        this.theDateConverted = theDateConverted;
    }

    public String getTheDate() {
        return theDate;
    }

    public void setTheDate(String theDate) {
        this.theDate = theDate;
    }

    public Date getTheDateConverted() {
        return theDateConverted;
    }

    public void setTheDateConverted(Date theDateConverted) {
        this.theDateConverted = theDateConverted;
    }
}
