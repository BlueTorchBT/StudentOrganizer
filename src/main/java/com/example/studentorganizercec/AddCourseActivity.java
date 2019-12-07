package com.example.studentorganizercec;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class AddCourseActivity extends AppCompatActivity {

    final String ACTIVITY_NAME = "AddCourseActivity";
    final String fileName = "schedule";
    Button btn;
    EditText eCourse, eTeacher, eRoom;
    Spinner sBlock;
    View builderView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_schedule);

        btn = (Button) findViewById(R.id.enter_schedule_activity_btn);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eCourse = (EditText) findViewById(R.id.enter_schedule_activity_et_course);
                eTeacher = (EditText) findViewById(R.id.enter_schedule_activity_et_teacher);
                eRoom = (EditText) findViewById(R.id.enter_schedule_activity_et_room);
                sBlock = (Spinner) findViewById(R.id.enter_schedule_4_activity_spn_block);

                final String c = eCourse.getText().toString();
                final String t = eTeacher.getText().toString();
                final String r = eRoom.getText().toString();
                final String b = sBlock.getSelectedItem().toString();

                // check to ensure that no fields are blank
                if(c.isEmpty()){
                    Toast.makeText(getBaseContext(),R.string.enter_schedule_blank_course, Toast.LENGTH_SHORT).show();
                } else if(c.contains("s")) {
                    Toast.makeText(getBaseContext(), R.string.enter_schedule_commas, Toast.LENGTH_SHORT).show();
                } else if(t.isEmpty()){
                    Toast.makeText(getBaseContext(), R.string.enter_schedule_blank_teacher, Toast.LENGTH_SHORT).show();
                } else if(r.isEmpty()){
                    Toast.makeText(getBaseContext(),R.string.enter_schedule_blank_room, Toast.LENGTH_SHORT).show();
                } else { // if none are blank, add the course

                    Log.d(ACTIVITY_NAME, "Conforming Course Add");
                    AlertDialog.Builder alert = new AlertDialog.Builder(AddCourseActivity.this);

                    alert.setTitle(R.string.add_course_activity_confirm);
                    alert.setMessage(c+"\n"+t+"\n"+r+"\n"+b);

                    // Add the buttons
                    alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // make the course object, and add it to our file
                            CECcourse cec = new CECcourse(c, t, r, b);
                            writeToFile(cec);
                        }
                    });
                    alert.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // alert the user that the course was not added
                            Toast.makeText(getBaseContext(),R.string.add_course_activity_cancelled,Toast.LENGTH_LONG).show();
                        }
                    });

                    // Create the AlertDialog
                    AlertDialog dialog_confirm_add = alert.create();
                    dialog_confirm_add.show();
                }
            }
        });
    }

    private void writeToFile(CECcourse c){
        FileOutputStream outputStream;
        File testResult = new File(getFilesDir(), fileName);
        if (testResult.exists()) {
            Log.i( testResult.getName().toString(), "exists true");
        }
        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(c.toString().getBytes());
            Toast.makeText(getBaseContext(),R.string.enter_schedule_success_add, Toast.LENGTH_SHORT).show();
            outputStream.close();
            eCourse.getText().clear();
            eTeacher.getText().clear();
            eRoom.getText().clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
