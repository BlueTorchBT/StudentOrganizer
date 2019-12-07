package com.example.studentorganizercec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class ChooseScheduleTypeActivity extends AppCompatActivity {

    Button btn4, btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_schedule_type);
        Toast.makeText(getApplicationContext(), "FILE DNE",
                Toast.LENGTH_LONG).show();

        btn4 = (Button)findViewById(R.id.activity_choose_schedule_type_btn_4);
        btn8 = (Button)findViewById(R.id.activity_choose_schedule_type_btn_8);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEnterSchedule4 = new Intent(getApplicationContext(), AddCourseActivity.class);
                startActivity(intentEnterSchedule4);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
