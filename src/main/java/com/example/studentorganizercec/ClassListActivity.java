package com.example.studentorganizercec;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ClassListActivity extends ListActivity {

    final String ACTIVITY_NAME = "ClassListActivity";
    final String fileName = "schedule";
    // Define Data
    String[] class_list;
    ArrayList<String> classes;



    private void shouldYouBeHere(){
        // this activity should only be accessible if the schedule file has data
        // shouldYouBeHere will kick them out if they somehow ??? get here with an empty file
        File aFile = new File(getFilesDir(), fileName);
        if(!aFile.exists() || aFile.length() == 0 ){
            Intent intentMainActivity= new Intent(this, MainActivity.class);
            startActivity(intentMainActivity);
        }
    }

    private String[] initializeClassList(ArrayList<String> courses){
        int comma;
        int count = courses.size();
        String[] class_list = new String[count];
        for (int i=0;i<count;i++){
            comma = courses.get(i).indexOf(",");
            class_list[i] = courses.get(i).substring(0 , comma);
        }
        return class_list;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        classes = readFromFile();
        class_list = initializeClassList(classes);
        // setListAdapter replaces the following:
        // setContentView(R.layout.activity_class_list);




        //    Define a new adapter
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,
                R.layout.simple_list_item, class_list);

        //   Assign the adapter/data to ListView
        setListAdapter(mAdapter);

        //   Define the listener interface
        AdapterView.OnItemClickListener mListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText() + " has been selected",
                        Toast.LENGTH_SHORT).show();
            }
        };
        //    Get the ListView and wired the listener
        ListView listView = getListView();
        listView.setOnItemClickListener(mListener);
    }

    private ArrayList<String> readFromFile(){
        // Assistance from https://stackoverflow.com/questions/24291721/
        FileInputStream is;
        BufferedReader reader;
        ArrayList<String> courses = new ArrayList<String>();
        File file = new File(getFilesDir(), fileName);
        if (!file.exists()) {
            // they eed to get out, fix later
            Log.i( file.getName().toString(), "exists true");
        }
        try {
            is = openFileInput(fileName);
            reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine();
            while(line != null){
                Log.d(ACTIVITY_NAME, line);
                line = reader.readLine();
                courses.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return courses;
        }
    }

}
