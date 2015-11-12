package com.uv.acadgild;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Courses> courses;
    ArrayAdapter<Courses> courseAdapter;

    ListView coursesOffered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initalizeCourses();
        initializeViews();
        setListeners();

    }

    private void setListeners() {
        coursesOffered.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MentorActivity.class);
                Courses course = courses.get(position);
                intent.putExtra("mentorName", course.getMentor());
                intent.putExtra("courseName", course.getCourse());
                startActivity(intent);
            }
        });
    }

    private void initializeViews() {
        coursesOffered = (ListView) findViewById(R.id.coursesOffered);
        courseAdapter = new ArrayAdapter<Courses>(getApplicationContext(), R.layout.course_item, courses) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.course_item, parent, false);
                }
                Courses currentContact = courses.get(position);
                TextView courseName = (TextView) convertView.findViewById(R.id.course);
                TextView mentor = (TextView) convertView.findViewById(R.id.mentor);
                courseName.setText(currentContact.getCourse());
                mentor.setText(currentContact.getMentor());

                return convertView;
            }
        };
        coursesOffered.setAdapter(courseAdapter);

    }

    private void initalizeCourses() {
        courses  = new ArrayList<Courses>(9);
        courses.add(new Courses("Android", "Ranjith"));
        courses.add(new Courses("Front End Web Development", "Krishna"));
        courses.add(new Courses("Full Stack Web Development", "Raghav"));
        courses.add(new Courses("Big Data Development", "Ronald"));
        courses.add(new Courses("Node JS", "Ramya"));
        courses.add(new Courses("Java", "Raji"));
        courses.add(new Courses("Front End Web Development Fundamentals", "Krishna"));
        courses.add(new Courses("Java For Freshers", "Raji"));
        courses.add(new Courses("Big Data and Hadoop Administration", "Ram"));
    }


}
