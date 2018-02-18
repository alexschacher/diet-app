package com.alexschacher.dietapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.alexschacher.dietapp.database.AppRepository;
import com.alexschacher.dietapp.database.Food;

import java.util.List;

public class AppViewModel extends AndroidViewModel {

    private AppRepository repository;
    private LiveData<List<Food>> foods;

    public AppViewModel (Application app) {
        super(app);
        repository = new AppRepository(app);
        foods = repository.getAllFoods();
    }

    public LiveData<List<Food>> getAllFoods() {
        return foods;
    }

    public void insert(Food food) {
        repository.insert(food);
    }
}
