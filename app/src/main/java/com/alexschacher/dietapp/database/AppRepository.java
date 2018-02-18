package com.alexschacher.dietapp.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.alexschacher.dietapp.database.AppDatabase;
import com.alexschacher.dietapp.database.Food;
import com.alexschacher.dietapp.database.FoodDao;

import java.util.List;

public class AppRepository {

    private FoodDao foodDao;
    private LiveData<List<Food>> foods;

    public AppRepository(Application app) {
        AppDatabase db = AppDatabase.getDatabase(app);
        foodDao = db.foodDao();
        foods = foodDao.getAll();
    }

    public LiveData<List<Food>> getAllFoods() {
        return foods;
    }

    public void insert (Food food) {
        new InsertAsyncTask(foodDao).execute(food);
    }

    private static class InsertAsyncTask extends AsyncTask<Food, Void, Void> {

        private FoodDao foodDao;

        InsertAsyncTask(FoodDao foodDao) {
            this.foodDao = foodDao;
        }

        @Override
        protected Void doInBackground(final Food... params) {
            foodDao.insert(params[0]);
            return null;
        }
    }
}
