package com.example.studentorganizercec;

public class CECdate {

    private int year;
    private int month;
    private int day;
    private int cycle;


    public CECdate() {
        this(1999, 9, 5, 1);
    }

    public CECdate(int y, int m, int d, int c) {
        setYear(y);
        setMonth(m);
        setDay(d);
        setCycle(c);
    }

    int getYear() {
        return year;
    }

    int getMonth() {
        return month;
    }

    int getDay() {
        return day;
    }

    int getCycle() {
        return cycle;
    }

    void setYear(int year) {
        this.year = year;
    }

    void setMonth(int month) {
        this.month = month;
    }

    void setDay(int day) {
        this.day = day;
    }

    void setCycle(int cycle) {
        this.cycle = cycle;
    }

}
