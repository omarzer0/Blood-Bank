package com.azapps.bloodbankipda3.data;

public class CalenderSaver {
    private int year;
    private int month;
    private int day;
    private String stDateOfBirth;

    public CalenderSaver(int year, int month, int day) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getStDateOfBirth() {
        return stDateOfBirth;
    }

    public void setStDateOfBirth(String stDateOfBirth) {
        this.stDateOfBirth = stDateOfBirth;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
