package com.example.subba.courselist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CourseListAdapter adapter;

    public static final String KEY_HEADLINE="course_headline";
    public static final String KEY_DETAILS="course_details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CourseListAdapter(this, getData());
        ListView list = (ListView) findViewById(R.id.courseList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long offset) {
                CourseItem item = (CourseItem) adapter.getItem(position);

                Intent intent = new Intent(getApplicationContext(), CourseDetailsActivity.class);
                intent.putExtra(KEY_HEADLINE, item.getHeadline());
                intent.putExtra(KEY_DETAILS, item.getDetails());

                startActivity(intent);
            }
        });
    }

    private ArrayList<CourseItem> getData() {
        ArrayList<CourseItem> coursesList = new ArrayList<CourseItem>();
        String[] headlines = getResources().getStringArray(R.array.course_headlines);
        String[] details = getResources().getStringArray(R.array.course_details);

        for (int i = 0; i < headlines.length; i++) {
            CourseItem item = new CourseItem();
            item.setHeadline(headlines[i]);
            item.setDetails(details[i]);
            coursesList.add(item);
        }
        return coursesList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
