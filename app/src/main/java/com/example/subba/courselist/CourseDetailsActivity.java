package com.example.subba.courselist;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.TextView;
import static com.example.subba.courselist.MainActivity.KEY_HEADLINE;
import static com.example.subba.courselist.MainActivity.KEY_DETAILS;


public class CourseDetailsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_details);

        String headline = "";
        String details = "";

        Intent intent = getIntent();
        if (null != intent) {
            headline = intent.getStringExtra(KEY_HEADLINE);
            details = intent.getStringExtra(KEY_DETAILS);
        }

        TextView headlineTxt = (TextView) findViewById(R.id.headlines);
        headlineTxt.setText(headline);



        TextView descriptionTxt = (TextView) findViewById(R.id.description);
        descriptionTxt.setText(details);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
