package com.example.studentorganizercec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    String fileName = "schedule";
    private List<CECdate> cecDates = new ArrayList<CECdate>(10);

    public int nextCycle(int c){
        if(c==8) return 1;
        return c + 1;
    }

    public int prevCycle(int c){
        if(c==1) return 8;
        return c - 1;
    }

    public void addcecDates(CECdate c) {
        this.cecDates.add(c);
    }

    public void populatececDates(){
        // these dates were extracted from our school/provincial calendar
        // I used data collected by a fellow teacher, Mathieu Trembley
        addcecDates(new CECdate(2019,10,23,1));
        addcecDates(new CECdate(2019,10,24,2));
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

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the Toolbar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        int id = mi.getItemId();
        switch(id) {
            case R.id.action_1_schedule:
                Log.d("Toolbar", "Option 1");
                break;
            case R.id.action_2_course_list:
                Intent intent_class_list = new Intent(this, ClassListActivity.class);
                startActivity(intent_class_list);
                break;
            case R.id.action_3_add_course:
                Intent intent_add_course = new Intent(this, AddCourseActivity.class);
                startActivity(intent_add_course);
                break;
            case R.id.action_about:
                Toast.makeText(this, "Curt Crane",
                        Toast.LENGTH_LONG).show();

        }
        return true ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(myToolbar);



        File aFile = new File(getFilesDir(), fileName);
        if(!aFile.exists() ){ // if false, the file does not exists!
            Intent intentAddCourse= new Intent(this, AddCourseActivity.class);
            startActivity(intentAddCourse);
        }


        populatececDates();
        final TextView tv = findViewById(R.id.main_activity_tv_cycleday);

        Date date = new Date();
        LocalDateTime local = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        int year  = local.getYear();
        int month = local.getMonthValue();
        int day   = local.getDayOfMonth();
        int hour = local.getHour();
        int minute = local.getMinute();

        String ttt = Integer.toString(year) + Integer.toString(month) + Integer.toString(day);
        Toast.makeText(getApplicationContext(), ttt,
                Toast.LENGTH_LONG).show();

        int cycle = 0;
        for (CECdate cec : cecDates) {
            if(year == cec.getYear() && month == cec.getMonth() && day == cec.getDay()){
                cycle = cec.getCycle();
            }
        }

        if(hour >= 15){
            tv.setText(Integer.toString(nextCycle(cycle)));
        } else {
            tv.setText(Integer.toString(cycle));
        }

    }
}
