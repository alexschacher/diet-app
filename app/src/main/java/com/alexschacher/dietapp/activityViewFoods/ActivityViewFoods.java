package com.alexschacher.dietapp.activityViewFoods;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.alexschacher.dietapp.AppViewModel;
import com.alexschacher.dietapp.activityAddFood.ActivityAddFood;
import com.alexschacher.dietapp.database.Food;
import com.alexschacher.dietapp.R;

import java.util.List;

public class ActivityViewFoods extends AppCompatActivity {

    private Food[] foods;
    private AppViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_foods);
        getSupportActionBar().setTitle("My Foods");

        viewModel = ViewModelProviders.of(this).get(AppViewModel.class);
        viewModel.getAllFoods().observe(this, new Observer<List<Food>>() {
            @Override
            public void onChanged(@Nullable List<Food> foods) {
                //adapter.setFoods(foods);
            }
        });

        ListAdapter listAdapter = new ListAdapterViewFoods(this, foods);
        ListView foodListView = (ListView) findViewById(R.id.foodListView);
        foodListView.setAdapter(listAdapter);
        foodListView.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    // Do stuff when clicked.
                }
            }
        );
    }


    public void gotoAddFoodActivity(View view) {
        Intent intent = new Intent(this, ActivityAddFood.class);
        startActivity(intent);
    }
}
