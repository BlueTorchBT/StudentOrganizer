package com.example.studentorganizercec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CECdate> cecDates = new ArrayList<CECdate>(10);

    public class CECdate {
        private int year;
        private int month;
        private int day;
        private int cycle;

        public CECdate(int y, int m, int d, int c){
            setYear(y);
            setMonth(m);
            setDay(d);
            setCycle(c);
        }

        int getYear(){ return year; }
        int getMonth(){ return month; }
        int getDay(){ return day; }
        int getCycle(){ return cycle; }
        void setYear(int year){ this.year = year; }
        void setMonth(int month){ this.month = month; }
        void setDay(int day){ this.day = day; }
        void setCycle(int cycle){ this.cycle = cycle; }
    }

    public void populatececDates(){
        // these dates were extracted from our school/provincial calendar
        // I used data collected by a fellow teacher, Mathieu Trembley
        addcecDates(new CECdate(2019,10,28,3));
        addcecDates(new CECdate(2019,10,29,4));
        addcecDates(new CECdate(2019,10,30,5));
        addcecDates(new CECdate(2019,10,31,6));
        addcecDates(new CECdate(2019,11,1,7));
        addcecDates(new CECdate(2019,11,4,8));
        addcecDates(new CECdate(2019,11,5,1));
        addcecDates(new CECdate(2019,11,6,2));
        addcecDates(new CECdate(2019,11,7,3));
        addcecDates(new CECdate(2019,11,8,4));
        addcecDates(new CECdate(2019,11,12,5));
        addcecDates(new CECdate(2019,11,13,6));
        addcecDates(new CECdate(2019,11,14,7));
        addcecDates(new CECdate(2019,11,18,8));
        addcecDates(new CECdate(2019,11,19,1));
        addcecDates(new CECdate(2019,11,20,2));
        addcecDates(new CECdate(2019,11,21,3));
        addcecDates(new CECdate(2019,11,22,4));
        addcecDates(new CECdate(2019,11,25,5));
        addcecDates(new CECdate(2019,11,26,6));
        addcecDates(new CECdate(2019,11,27,7));
        addcecDates(new CECdate(2019,11,28,8));
        addcecDates(new CECdate(2019,11,29,1));
        addcecDates(new CECdate(2019,12,2,2));
        addcecDates(new CECdate(2019,12,3,3));
        addcecDates(new CECdate(2019,12,4,4));
        addcecDates(new CECdate(2019,12,5,5));
        addcecDates(new CECdate(2019,12,6,6));
        addcecDates(new CECdate(2019,12,9,7));
        addcecDates(new CECdate(2019,12,10,8));
        addcecDates(new CECdate(2019,12,11,1));
        addcecDates(new CECdate(2019,12,12,2));
        addcecDates(new CECdate(2019,12,13,3));
        addcecDates(new CECdate(2019,12,16,4));
        addcecDates(new CECdate(2019,12,17,5));
        addcecDates(new CECdate(2019,12,18,6));
        addcecDates(new CECdate(2019,12,19,7));
        addcecDates(new CECdate(2019,12,20,8));
        addcecDates(new CECdate(2020,1,6,1));
        addcecDates(new CECdate(2020,1,7,2));
        addcecDates(new CECdate(2020,1,8,3));
        addcecDates(new CECdate(2020,1,9,4));
        addcecDates(new CECdate(2020,1,10,5));
        addcecDates(new CECdate(2020,1,13,6));
        addcecDates(new CECdate(2020,1,14,7));
        addcecDates(new CECdate(2020,1,15,8));
        addcecDates(new CECdate(2020,1,16,1));
        addcecDates(new CECdate(2020,1,17,2));
        addcecDates(new CECdate(2020,1,20,3));
        addcecDates(new CECdate(2020,1,21,4));
        addcecDates(new CECdate(2020,1,22,5));
        addcecDates(new CECdate(2020,1,23,6));
        addcecDates(new CECdate(2020,1,24,7));
        addcecDates(new CECdate(2020,1,27,8));
        addcecDates(new CECdate(2020,1,28,1));
        addcecDates(new CECdate(2020,1,29,2));
        addcecDates(new CECdate(2020,1,30,3));
    }

    public void addcecDates(CECdate c) {
        this.cecDates.add(c);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        populatececDates();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
