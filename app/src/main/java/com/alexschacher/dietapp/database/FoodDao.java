package com.alexschacher.dietapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface FoodDao {

    @Insert
    public void insert(Food food);

    @Update
    public void update(Food food);

    @Delete
    public void delete(Food food);

    @Query("DELETE FROM food_table")
    public void deleteAll();

    @Query("SELECT * FROM food_table ORDER BY name ASC")
    public LiveData<List<Food>> getAll();
}
