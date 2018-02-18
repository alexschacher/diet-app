package com.alexschacher.dietapp.activityAddFood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alexschacher.dietapp.R;

public class ActivityAddFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        getSupportActionBar().setTitle("Edit Item");
    }
}
