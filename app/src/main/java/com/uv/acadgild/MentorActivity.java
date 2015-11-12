package com.uv.acadgild;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MentorActivity extends AppCompatActivity {

    TextView courseMentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor);
        courseMentor = (TextView) findViewById(R.id.courseMentor);
        String value = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String mentorName = extras.getString("mentorName");
            String courseName = extras.getString("courseName");
            value = courseName + " is handled by " + mentorName;
        }
        courseMentor.setText(value);

    }

}
